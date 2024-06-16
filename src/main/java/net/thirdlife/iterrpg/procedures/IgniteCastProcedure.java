package net.thirdlife.iterrpg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class IgniteCastProcedure {
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
		power = WandReturnPowerProcedure.execute(entity);
		dist = 0;
		yheight = y + entity.getBbHeight() * 0.85;
		xdir = entity.getLookAngle().x;
		ydir = entity.getLookAngle().y;
		zdir = entity.getLookAngle().z;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, (float) 0.5, (float) 1.25);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, (float) 0.5, (float) 1.25, false);
			}
		}
		hit = true;
		for (int index0 = 0; index0 < (int) (3.5 * WandReturnPowerProcedure.execute(entity) * 5); index0++) {
			if (hit) {
				if (((world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).is(BlockTags.create(new ResourceLocation("minecraft:campfires")))
						|| (world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).is(BlockTags.create(new ResourceLocation("minecraft:candles"))))
						&& ((world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp10
								&& (world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist))).getValue(_getbp10)) == false) {
					{
						BlockPos _pos = BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
					hit = false;
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LAVA, (x + xdir * dist), (yheight + ydir * dist + 0.25), (z + zdir * dist), 4, 0.1, 0.1, 0.1, 0.05);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLAME, (x + xdir * dist), (yheight + ydir * dist + 0.25), (z + zdir * dist), 4, 0.1, 0.1, 0.1, 0.05);
				}
				if (world.getBlockState(BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist)).isFaceSturdy(world, BlockPos.containing(x + xdir * dist, yheight + ydir * dist, z + zdir * dist), Direction.UP)
						&& world.isEmptyBlock(BlockPos.containing(x + xdir * dist, yheight + ydir * dist + 1, z + zdir * dist))
						&& Blocks.FIRE.defaultBlockState().canSurvive(world, BlockPos.containing(x + xdir * dist, yheight + ydir * dist + 1, z + zdir * dist))) {
					hit = false;
					world.setBlock(BlockPos.containing(x + xdir * dist, yheight + ydir * dist + 1, z + zdir * dist), Blocks.FIRE.defaultBlockState(), 3);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LAVA, (x + xdir * dist), (yheight + ydir * dist + 1), (z + zdir * dist), 4, 0.1, 0.1, 0.1, 0.05);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLAME, (x + xdir * dist), (yheight + ydir * dist + 1), (z + zdir * dist), 4, 0.1, 0.1, 0.1, 0.05);
				}
				{
					final Vec3 _center = new Vec3((x + xdir * dist), (yheight + ydir * dist), (z + zdir * dist));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("iter_rpg:entity_not_damage")))
								&& entityiterator instanceof LivingEntity && !(entity == entityiterator)) {
							hit = false;
							entityiterator.setSecondsOnFire((int) (5 * WandReturnPowerProcedure.execute(entity)));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FLAME, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 5, 0.3, (entityiterator.getBbHeight() / 3), 0.3, 0.05);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.LAVA, (entityiterator.getX()), (entityiterator.getY() + entityiterator.getBbHeight() / 2), (entityiterator.getZ()), 4, 0.3, (entityiterator.getBbHeight() / 3), 0.3, 0.05);
						}
					}
				}
				dist = dist + 0.2;
			}
		}
	}
}
