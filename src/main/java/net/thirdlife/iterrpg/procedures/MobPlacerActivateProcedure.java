package net.thirdlife.iterrpg.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class MobPlacerActivateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("xcord", (x + 0.5));
		itemstack.getOrCreateTag().putDouble("ycord", (y + 1));
		itemstack.getOrCreateTag().putDouble("zcord", (z + 0.5));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (x + 0.5), (y + 1.1), (z + 0.5), 4, 0.01, 0.01, 0.01, 0.01);
	}
}
