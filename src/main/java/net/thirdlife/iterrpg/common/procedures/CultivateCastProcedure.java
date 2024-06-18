package net.thirdlife.iterrpg.common.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class CultivateCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean attack = false;
		boolean hit = false;
		double power = 0;
		double cooldown = 0;
		double mana = 0;
		double amount = 0;
		double offset = 0;
		double dist = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double yheight = 0;
		double splashdmg = 0;
		double push = 0;
		double allow = 0;
		power = WandReturnPowerProcedure.execute(entity);
		dist = 0;
		yheight = y + entity.getBbHeight() * 0.85;
		xdir = entity.getLookAngle().x;
		ydir = entity.getLookAngle().y;
		zdir = entity.getLookAngle().z;
		hit = true;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.step")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.step")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		for (int index0 = 0; index0 < (int) (4 * power * 5); index0++) {
			if (hit) {
				if (world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist)).canOcclude()) {
					hit = false;
				}
				if ((world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).getBlock() instanceof BonemealableBlock) {
					if (world instanceof Level _level) {
						BlockPos _bp = BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist);
						if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
							if (!_level.isClientSide())
								_level.levelEvent(2005, _bp, 0);
						}
					}
					hit = false;
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + xdir * dist), (yheight + ydir * dist), (z + zdir * dist), 2, 0.1, 0.1, 0.1, 0.05);
				dist = dist + 0.2;
			}
		}
	}
}
