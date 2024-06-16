package net.thirdlife.iterrpg.procedures;

import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class BarrierEngageProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double distance = 0;
		boolean flag = false;
		boolean wallmeet = false;
		boolean up = false;
		boolean down = false;
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == IterRpgModBlocks.RUNIC_GRIMSTONE_ACTIVE.get()) {
			distance = 0.5;
			for (int index0 = 0; index0 < 16; index0++) {
				if ((world.getBlockState(BlockPos.containing(x + 0.5, y + 0.5 + distance, z + 0.5))).getBlock() == IterRpgModBlocks.BARRIER_PROJECTOR.get()) {
					up = true;
				}
				distance = distance + 1;
			}
			if (up) {
				wallmeet = true;
				distance = 1;
				for (int index1 = 0; index1 < 18; index1++) {
					if (wallmeet) {
						if (Math.random() >= 0.5) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (x + 0.5), (y + 0.5 + distance), (z + 0.5), 1, 0.2, 0.2, 0.2, 0.002);
						}
						{
							final Vec3 _center = new Vec3((x + 0.5), (y + 0.5 + distance), (z + 0.5));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof ThrownEnderpearl) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.DRAGON_BREATH, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 6, 0.2, 0.2, 0.2, 0.02);
									if (!entityiterator.level().isClientSide())
										entityiterator.discard();
								}
							}
						}
						if (world.isEmptyBlock(BlockPos.containing(x + 0.5, y + 0.5 + distance, z + 0.5))) {
							world.setBlock(BlockPos.containing(x + 0.5, y + 0.5 + distance, z + 0.5), IterRpgModBlocks.GIANT_PHANTOM_CHAIN.get().defaultBlockState(), 3);
						}
						if ((world.getBlockState(BlockPos.containing(x + 0.5, y + 0.5 + distance, z + 0.5))).getBlock() == IterRpgModBlocks.GIANT_PHANTOM_CHAIN.get()) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x + 0.5, y + 0.5 + distance, z + 0.5);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("demoncharge", 2);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 0.5, y + 0.5 + distance, z + 0.5))).getBlock() == IterRpgModBlocks.BARRIER_PROJECTOR.get()) {
							wallmeet = false;
						}
						distance = distance + 1;
					}
				}
			}
		}
	}
}
