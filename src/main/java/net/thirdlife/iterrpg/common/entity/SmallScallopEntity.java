
package net.thirdlife.iterrpg.common.entity;

import net.thirdlife.iterrpg.common.procedures.ScallopSpawnConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.ScallopFriendlyConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.ScallopAiProcedure;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

public class SmallScallopEntity extends Monster {
	public SmallScallopEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(IterRpgModEntities.SMALL_SCALLOP.get(), world);
	}

	public SmallScallopEntity(EntityType<SmallScallopEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.4f);
		xpReward = 1;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new LeapAtTargetGoal(this, (float) 0.4));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 1;
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Guardian.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = SmallScallopEntity.this.getX();
				double y = SmallScallopEntity.this.getY();
				double z = SmallScallopEntity.this.getZ();
				Entity entity = SmallScallopEntity.this;
				Level world = SmallScallopEntity.this.level();
				return super.canUse() && ScallopFriendlyConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SmallScallopEntity.this.getX();
				double y = SmallScallopEntity.this.getY();
				double z = SmallScallopEntity.this.getZ();
				Entity entity = SmallScallopEntity.this;
				Level world = SmallScallopEntity.this.level();
				return super.canContinueToUse() && ScallopFriendlyConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new AvoidEntityGoal<>(this, Axolotl.class, (float) 8, 1, 2));
		this.goalSelector.addGoal(6, new AvoidEntityGoal<>(this, Dolphin.class, (float) 8, 1, 2));
		this.goalSelector.addGoal(7, new RandomSwimmingGoal(this, 1, 40));
		this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.8));
		this.targetSelector.addGoal(9, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = SmallScallopEntity.this.getX();
				double y = SmallScallopEntity.this.getY();
				double z = SmallScallopEntity.this.getZ();
				Entity entity = SmallScallopEntity.this;
				Level world = SmallScallopEntity.this.level();
				return super.canUse() && ScallopFriendlyConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.WATER;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bone_block.break"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.CACTUS))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		ScallopAiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public boolean canBreatheUnderwater() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return true;
	}

	@Override
	public boolean isPushedByFluid() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	public static void init() {
		SpawnPlacements.register(IterRpgModEntities.SMALL_SCALLOP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return ScallopSpawnConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.225);
		builder = builder.add(Attributes.MAX_HEALTH, 6);
		builder = builder.add(Attributes.ARMOR, 2);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
		builder = builder.add(Attributes.FOLLOW_RANGE, 12);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.1);
		return builder;
	}
}
