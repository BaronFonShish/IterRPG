
package net.thirdlife.iterrpg.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class FleshBlockBlock extends Block {
	public FleshBlockBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_NYLIUM).sound(SoundType.WART_BLOCK).strength(3f, 1f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
