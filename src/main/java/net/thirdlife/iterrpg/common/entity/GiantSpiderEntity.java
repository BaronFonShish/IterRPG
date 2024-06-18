
package net.thirdlife.iterrpg.common.entity;

import net.thirdlife.iterrpg.common.procedures.SpiderSaturationProcedure;
import net.thirdlife.iterrpg.common.procedures.SpiderPlaceWebProcedure;
import net.thirdlife.iterrpg.common.procedures.SpiderHealthConditionProcedure;
import net.thirdlife.iterrpg.common.procedures.ReleaseSpiderlingsProcedure;
import net.thirdlife.iterrpg.common.procedures.GiantSpiderSpawnConditionProcedure;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

public class GiantSpiderEntity extends Monster {
	public GiantSpiderEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(IterRpgModEntities.GIANT_SPIDER.get(), world);
	}

	public GiantSpiderEntity(EntityType<GiantSpiderEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 8;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, (float) 0.5));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.8));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, Animal.class, false, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, Zombie.class, false, false) {
			@Override
			public boolean canUse() {
				double x = GiantSpiderEntity.this.getX();
				double y = GiantSpiderEntity.this.getY();
				double z = GiantSpiderEntity.this.getZ();
				Entity entity = GiantSpiderEntity.this;
				Level world = GiantSpiderEntity.this.level();
				return super.canUse() && SpiderHealthConditionProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, Husk.class, false, false) {
			@Override
			public boolean canUse() {
				double x = GiantSpiderEntity.this.getX();
				double y = GiantSpiderEntity.this.getY();
				double z = GiantSpiderEntity.this.getZ();
				Entity entity = GiantSpiderEntity.this;
				Level world = GiantSpiderEntity.this.level();
				return super.canUse() && SpiderHealthConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(11, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	@Override
	public double getPassengersRidingOffset() {
		return super.getPassengersRidingOffset() + -0.1;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("iter_rpg:giant_spider_idle"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("iter_rpg:giant_spider_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("iter_rpg:giant_spider_death"));
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		ReleaseSpiderlingsProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		SpiderSaturationProcedure.execute(entity, this);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		SpiderPlaceWebProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
		SpawnPlacements.register(IterRpgModEntities.GIANT_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return GiantSpiderSpawnConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 8);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
		return builder;
	}
}
