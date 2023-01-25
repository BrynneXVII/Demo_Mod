package com.github.brynnexvii.demomod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CustomModelBlock extends Block{
	
	private static final VoxelShape SHAPE = makeShape();
	
	public CustomModelBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos,
			CollisionContext context) {
		return SHAPE;
	}
	
	public static VoxelShape makeShape(){
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.1875, 0.8125, 0.125, 0.8125), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.375, 0.25, 0.375, 0.625, 0.75, 0.625), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.25, 0.125, 0.25, 0.75, 0.25, 0.75), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.3125, 0.75, 0.3125, 0.6875, 0.8125, 0.6875), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.375, 0.8125, 0.4375, 0.4375, 0.875, 0.5625), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.5625, 0.8125, 0.4375, 0.625, 0.875, 0.5625), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.4375, 0.8125, 0.375, 0.5625, 0.875, 0.4375), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.4375, 0.8125, 0.5625, 0.5625, 0.875, 0.625), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.625, 0.8125, 0.375, 0.6875, 0.9375, 0.625), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.3125, 0.8125, 0.375, 0.375, 0.9375, 0.625), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.375, 0.8125, 0.3125, 0.625, 0.9375, 0.375), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.375, 0.8125, 0.625, 0.625, 0.9375, 0.6875), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.3125, 0.8125, 0.3125, 0.375, 1, 0.375), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.625, 0.8125, 0.3125, 0.6875, 1, 0.375), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.625, 0.8125, 0.625, 0.6875, 1, 0.6875), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.375, 0.8125, 0.5625, 0.4375, 0.9375, 0.625), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.3125, 0.8125, 0.625, 0.375, 1, 0.6875), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.5625, 0.8125, 0.5625, 0.625, 0.9375, 0.625), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.5625, 0.8125, 0.375, 0.625, 0.9375, 0.4375), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.375, 0.8125, 0.375, 0.4375, 0.9375, 0.4375), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.3125, 0.75, 0.3125, 0.6875, 1, 0.6875), BooleanOp.OR);

		return shape;
	}

}
