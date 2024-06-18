package net.thirdlife.iterrpg.common.block.entity;

import net.thirdlife.iterrpg.init.IterRpgModBlockEntities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class SacredSaplingBlockEntity extends BlockEntity {
	public SacredSaplingBlockEntity(BlockPos pos, BlockState state) {
		super(IterRpgModBlockEntities.SACRED_SAPLING.get(), pos, state);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
	}
}
