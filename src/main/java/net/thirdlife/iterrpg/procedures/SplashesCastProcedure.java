package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.entity.FireElementalEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class SplashesCastProcedure {
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
		power = WandReturnPowerProcedure.execute(entity);
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.NETHER) {
			power = power * 0.6;
		}
		dist = 0;
		yheight = y + entity.getBbHeight() * 0.85;
		xdir = entity.getLookAngle().x;
		ydir = entity.getLookAngle().y;
		zdir = entity.getLookAngle().z;
		hit = true;
		entity.clearFire();
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.splash")), SoundSource.PLAYERS, (float) 0.5, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.splash")), SoundSource.PLAYERS, (float) 0.5, 1, false);
			}
		}
		for (int index0 = 0; index0 < (int) (4 * power * 6); index0++) {
			if (hit) {
				if (world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist)).canOcclude()) {
					hit = false;
				}
				if ((world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).getBlock() == Blocks.FIRE) {
					world.destroyBlock(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist), false);
				}
				if (((world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).is(BlockTags.create(new ResourceLocation("minecraft:campfires")))
						|| (world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).is(BlockTags.create(new ResourceLocation("minecraft:candles"))))
						&& ((world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp18
								&& (world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).getValue(_getbp18)) == true) {
					{
						BlockPos _pos = BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
					}
				}
				for (int index1 = 0; index1 < 2; index1++) {
					world.addParticle(ParticleTypes.SPLASH, (x + xdir * dist + dist * Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (yheight + ydir * dist + dist * Mth.nextDouble(RandomSource.create(), -0.25, 0.25)),
							(z + zdir * dist + dist * Mth.nextDouble(RandomSource.create(), -0.25, 0.25)), (xdir * 0.25), (ydir * 0.25), (zdir * 0.25));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SPLASH, (x + xdir * dist), (yheight + ydir * dist + 0.25), (z + zdir * dist), 2, 0.1, 0.1, 0.1, 0.05);
				}
				{
					final Vec3 _center = new Vec3((x + xdir * dist), (yheight + ydir * dist), (z + zdir * dist));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((1.5 * (1 + dist / 10)) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.toList();
					for (Entity entityiterator : _entfound) {
						entityiterator.clearFire();
						if (entityiterator instanceof EnderMan || entityiterator instanceof Endermite || entityiterator instanceof FireElementalEntity || entityiterator instanceof Blaze || entityiterator instanceof Strider
								|| entityiterator instanceof MagmaCube) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), (float) (3 * power));
						} else if (entityiterator.fireImmune()) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), (float) power);
						}
					}
				}
				dist = dist + 0.2;
			}
		}
	}
}
