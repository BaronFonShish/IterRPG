
package net.thirdlife.iterrpg.entity;

import net.thirdlife.iterrpg.procedures.ScallopSpawnProcedure;
import net.thirdlife.iterrpg.procedures.ScallopSpawnConditionProcedure;
import net.thirdlife.iterrpg.procedures.ScallopPearlSnatchProcedure;
import net.thirdlife.iterrpg.procedures.ScallopFriendlyConditionProcedure;
import net.thirdlife.iterrpg.procedures.ScallopDeathProcedure;
import net.thirdlife.iterrpg.procedures.ScallopAiProcedure;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

public class ScallopEntity extends Monster {
	public static final EntityDataAccessor<Boolean> DATA_has_pearl = SynchedEntityData.defineId(ScallopEntity.class, EntityDataSerializers.BOOLEAN);

	public ScallopEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(IterRpgModEntities.SCALLOP.get(), world);
	}

	public ScallopEntity(EntityType<ScallopEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 2;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_has_pearl, false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new LeapAtTargetGoal(this, (float) 0.5));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 2.25;
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Guardian.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = ScallopEntity.this.getX();
				double y = ScallopEntity.this.getY();
				double z = ScallopEntity.this.getZ();
				Entity entity = ScallopEntity.this;
				Level world = ScallopEntity.this.level();
				return super.canUse() && ScallopFriendlyConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = ScallopEntity.this.getX();
				double y = ScallopEntity.this.getY();
				double z = ScallopEntity.this.getZ();
				Entity entity = ScallopEntity.this;
				Level world = ScallopEntity.this.level();
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
				double x = ScallopEntity.this.getX();
				double y = ScallopEntity.this.getY();
				double z = ScallopEntity.this.getZ();
				Entity entity = ScallopEntity.this;
				Level world = ScallopEntity.this.level();
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
	public void die(DamageSource source) {
		super.die(source);
		ScallopDeathProcedure.execute(this.level(), this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		ScallopSpawnProcedure.execute(this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Datahas_pearl", this.entityData.get(DATA_has_pearl));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datahas_pearl"))
			this.entityData.set(DATA_has_pearl, compound.getBoolean("Datahas_pearl"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		ScallopPearlSnatchProcedure.execute(world, entity, sourceentity);
		return retval;
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
		SpawnPlacements.register(IterRpgModEntities.SCALLOP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return ScallopSpawnConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.15);
		builder = builder.add(Attributes.MAX_HEALTH, 16);
		builder = builder.add(Attributes.ARMOR, 8);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
		return builder;
	}
}
