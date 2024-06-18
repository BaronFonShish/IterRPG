
package net.thirdlife.iterrpg.common.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

public class ProfaneFleshBlockBlock extends Block {
	public ProfaneFleshBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WART_BLOCK).strength(3f, 1f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof HoeItem tieredItem)
			return tieredItem.getTier().getLevel() >= 0;
		return false;
	}
}
