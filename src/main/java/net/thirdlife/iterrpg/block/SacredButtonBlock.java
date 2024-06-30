
package net.thirdlife.iterrpg.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SacredButtonBlock extends ButtonBlock {
	public SacredButtonBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(1f).dynamicShape(), BlockSetType.OAK, 30, true);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}
}
