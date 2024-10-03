package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModParticleTypes;
import net.thirdlife.iterrpg.init.IterRpgModMobEffects;
import net.thirdlife.iterrpg.init.IterRpgModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class IonizedDischargeProcedure {
	public static void execute(LevelAccessor world, Entity entity, double amplifier) {
		if (entity == null)
			return;
		Entity target = null;
		double mobamount = 0;
		double chosen = 0;
		double distance = 0;
		if (!(amplifier == 5)) {
			if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.25, entity.getZ()))).is(BlockTags.create(new ResourceLocation("forge:conductive_blocks")))) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LIGHTNING_BOLT)), (float) ((amplifier + 1) * 1.5));
			} else {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LIGHTNING_BOLT)), (float) ((amplifier + 1) / 2));
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (IterRpgModParticleTypes.LIGHTNING_PARTICLE.get()), (entity.getX()), (entity.getY() + entity.getBbHeight() * 0.48), (entity.getZ()), 16, (entity.getBbWidth() / 3), (entity.getBbHeight() / 4),
						(entity.getBbWidth() / 3), 0.05);
			if (amplifier > 0) {
				if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(IterRpgModItems.STORMCALLER.get())) : false)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(IterRpgModMobEffects.IONIZED.get(), (int) (10 + amplifier), (int) (amplifier - 1), false, false));
				}
			}
		}
	}
}
