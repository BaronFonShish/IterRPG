
package net.thirdlife.iterrpg.common.entity;

import net.thirdlife.iterrpg.common.procedures.HurtTimerDownProcedure;
import net.thirdlife.iterrpg.common.procedures.GoblinsCampRememberProcedure;
import net.thirdlife.iterrpg.common.procedures.GoblinAiProcedure;
import net.thirdlife.iterrpg.common.procedures.CoinTimerProcedure;
import net.thirdlife.iterrpg.init.IterRpgModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

public class GoblinEntity extends Monster {
	public GoblinEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(IterRpgModEntities.GOBLIN.get(), world);
	}

	public GoblinEntity(EntityType<GoblinEntity> type, Level world) {
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
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = GoblinEntity.this.getX();
				double y = GoblinEntity.this.getY();
				double z = GoblinEntity.this.getZ();
				Entity entity = GoblinEntity.this;
				Level world = GoblinEntity.this.level();
				return super.canUse() && CoinTimerProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GoblinEntity.this.getX();
				double y = GoblinEntity.this.getY();
				double z = GoblinEntity.this.getZ();
				Entity entity = GoblinEntity.this;
				Level world = GoblinEntity.this.level();
				return super.canContinueToUse() && CoinTimerProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, DwarfEntity.class, false, false) {
			@Override
			public boolean canUse() {
				double x = GoblinEntity.this.getX();
				double y = GoblinEntity.this.getY();
				double z = GoblinEntity.this.getZ();
				Entity entity = GoblinEntity.this;
				Level world = GoblinEntity.this.level();
				return super.canUse() && CoinTimerProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GoblinEntity.this.getX();
				double y = GoblinEntity.this.getY();
				double z = GoblinEntity.this.getZ();
				Entity entity = GoblinEntity.this;
				Level world = GoblinEntity.this.level();
				return super.canContinueToUse() && CoinTimerProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Villager.class, false, false) {
			@Override
			public boolean canUse() {
				double x = GoblinEntity.this.getX();
				double y = GoblinEntity.this.getY();
				double z = GoblinEntity.this.getZ();
				Entity entity = GoblinEntity.this;
				Level world = GoblinEntity.this.level();
				return super.canUse() && CoinTimerProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = GoblinEntity.this.getX();
				double y = GoblinEntity.this.getY();
				double z = GoblinEntity.this.getZ();
				Entity entity = GoblinEntity.this;
				Level world = GoblinEntity.this.level();
				return super.canContinueToUse() && CoinTimerProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();

		HurtTimerDownProcedure.execute(world, x, y, z, entity);
		return super.hurt(damagesource, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		GoblinsCampRememberProcedure.execute(this.getX(), this.getZ(), this);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		GoblinAiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.275);
		builder = builder.add(Attributes.MAX_HEALTH, 12);
		builder = builder.add(Attributes.ARMOR, 2);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
		builder = builder.add(Attributes.FOLLOW_RANGE, 24);
		return builder;
	}
}
