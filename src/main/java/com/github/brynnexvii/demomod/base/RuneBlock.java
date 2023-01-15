package com.github.brynnexvii.demomod.base;

import java.util.function.ToIntFunction;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class RuneBlock extends MultifaceBlock implements SimpleWaterloggedBlock{ 
	
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	   
	public RuneBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	
	  @Override public MultifaceSpreader getSpreader() { 
		  return null; 
	  }
	  
	  public static ToIntFunction<BlockState> emission(int glowLevel) { 
		  return (blockState) -> { 
			  return MultifaceBlock.hasAnyFace(blockState) ? glowLevel : 0; 
		  };
	  }
	 	

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateDefBuilder) {
		super.createBlockStateDefinition(stateDefBuilder);
	    stateDefBuilder.add(WATERLOGGED);
    }

	//done best to rename the inputs here, not quite sure about the waterPos one though
	public BlockState updateShape(BlockState placementBlockState, Direction direction, BlockState attachBlockState, LevelAccessor levelAccessor, BlockPos waterPos, BlockPos attachBlockPos) {
		if (placementBlockState.getValue(WATERLOGGED)) {
			levelAccessor.scheduleTick(waterPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
	    }

	    return super.updateShape(placementBlockState, direction, attachBlockState, levelAccessor, waterPos, attachBlockPos);
	}
	
	public boolean canBeReplaced(BlockState blockState, BlockPlaceContext context) {
		return false;
	}
	
	public FluidState getFluidState(BlockState blockState) {
		return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
	}
	
	public boolean propagatesSkylightDown(BlockState blockState, BlockGetter getter, BlockPos pos) {
		return blockState.getFluidState().isEmpty();
	}
	
}
