package net.thirdlife.iterrpg.common.procedures;

import net.thirdlife.iterrpg.init.IterRpgModEntities;
import net.thirdlife.iterrpg.init.IterRpgModBlocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WitchmudGolemSpawnProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (blockstate.getBlock() == IterRpgModBlocks.CATTAIL.get() && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == IterRpgModBlocks.WITCHMUD.get()) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, -69, z), null);
				world.destroyBlock(_pos, false);
			}
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(IterRpgModBlocks.CATTAIL.get().defaultBlockState()));
			world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(IterRpgModBlocks.CATTAIL.get().defaultBlockState()));
			world.destroyBlock(BlockPos.containing(x, y - 1, z), false);
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = IterRpgModEntities.MUDKIN.get().spawn(_serverLevel, BlockPos.containing((x + 0.5), (y - 0.5), (z + 0.5)), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				if ((entitytospawn) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
					_toTame.tame(_owner);
			}
		}
	}
}
