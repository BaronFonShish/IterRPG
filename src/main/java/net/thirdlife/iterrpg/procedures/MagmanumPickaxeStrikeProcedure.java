package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class MagmanumPickaxeStrikeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, (x + 0.5), (y + 0.5), (z + 0.5), (float) 1.5, Level.ExplosionInteraction.TNT);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 0.5), (z + 0.5), 20, 0.15, 0.15, 0.15, 0.12);
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 120);
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(2, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
	}
}
