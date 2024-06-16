
package net.thirdlife.iterrpg.block;

import net.thirdlife.iterrpg.procedures.WalkOnCloudProcedure;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class CloudBlockBlock extends Block {
	public CloudBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.POWDER_SNOW).strength(0.25f).speedFactor(0.9f).jumpFactor(1.2f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 4;
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.WALKABLE;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		WalkOnCloudProcedure.execute(world, entity);
	}
}
