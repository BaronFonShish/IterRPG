
package net.thirdlife.iterrpg.entity;

import net.thirdlife.iterrpg.procedures.ElementalSlowFallingAssignProcedure;
import net.thirdlife.iterrpg.procedures.ElementalFlyConditionProcedure;
import net.thirdlife.iterrpg.procedures.EarthElementalSpawnConditionProcedure;
import net.thirdlife.iterrpg.procedures.EarthElementalAttackProcedure;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
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
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.EnumSet;

public class EarthElementalEntity extends Monster {
	public EarthElementalEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(IterRpgModEntities.EARTH_ELEMENTAL.get(), world);
	}

	public EarthElementalEntity(EntityType<EarthElementalEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 6;
		setNoAi(false);
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (EarthElementalEntity.this.getTarget() != null && !EarthElementalEntity.this.getMoveControl().hasWanted()) {
					double x = EarthElementalEntity.this.getX();
					double y = EarthElementalEntity.this.getY();
					double z = EarthElementalEntity.this.getZ();
					Entity entity = EarthElementalEntity.this;
					Level world = EarthElementalEntity.this.level();
					return ElementalFlyConditionProcedure.execute(entity);
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				double x = EarthElementalEntity.this.getX();
				double y = EarthElementalEntity.this.getY();
				double z = EarthElementalEntity.this.getZ();
				Entity entity = EarthElementalEntity.this;
				Level world = EarthElementalEntity.this.level();
				return ElementalFlyConditionProcedure.execute(entity) && EarthElementalEntity.this.getMoveControl().hasWanted() && EarthElementalEntity.this.getTarget() != null && EarthElementalEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = EarthElementalEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				EarthElementalEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 2);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = EarthElementalEntity.this.getTarget();
				if (EarthElementalEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					EarthElementalEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = EarthElementalEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						EarthElementalEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 2);
					}
				}
			}
		});
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = EarthElementalEntity.this.getRandom();
				double dir_x = EarthElementalEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = EarthElementalEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = EarthElementalEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}

			@Override
			public boolean canUse() {
				double x = EarthElementalEntity.this.getX();
				double y = EarthElementalEntity.this.getY();
				double z = EarthElementalEntity.this.getZ();
				Entity entity = EarthElementalEntity.this;
				Level world = EarthElementalEntity.this.level();
				return super.canUse() && ElementalFlyConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = EarthElementalEntity.this.getX();
				double y = EarthElementalEntity.this.getY();
				double z = EarthElementalEntity.this.getZ();
				Entity entity = EarthElementalEntity.this;
				Level world = EarthElementalEntity.this.level();
				return super.canContinueToUse() && ElementalFlyConditionProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, (float) 6));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea.step"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.moss.place")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.cave_vines.break"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.break"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.CACTUS))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		ElementalSlowFallingAssignProcedure.execute(this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		EarthElementalAttackProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
	}

	public static void init() {
		SpawnPlacements.register(IterRpgModEntities.EARTH_ELEMENTAL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return EarthElementalSpawnConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 6);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.FLYING_SPEED, 0.2);
		return builder;
	}
}
