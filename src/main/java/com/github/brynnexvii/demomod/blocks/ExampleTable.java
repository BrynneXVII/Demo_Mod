package com.github.brynnexvii.demomod.blocks;

import com.github.brynnexvii.demomod.blockentities.ExampleTableBlockEntity;
import com.github.brynnexvii.demomod.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ExampleTable extends Block implements EntityBlock{

	private static final VoxelShape SHAPE = makeShape();	
	
	public ExampleTable(Properties properties) {
		super(properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityInit.EXAMPLE_TABLE.get().create(pos, state);
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> type) {
		return level.isClientSide() ? null : ($0, $1, $2, blockEntity) -> {
			if(blockEntity instanceof ExampleTableBlockEntity exampleTable) {
				exampleTable.tick();
			}
		};
	}
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult result) {
		return super.use(state, level, pos, player, hand, result);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos,
			CollisionContext context) {
		return SHAPE;
	}
	
	public static VoxelShape makeShape(){
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0.0625, 0.375, 0.25, 0.9375, 0.5, 0.75), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0, 0, 0.1875, 0.125, 0.4375, 0.3125), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0.1875, 1, 0.4375, 0.3125), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0.6875, 1, 0.4375, 0.8125), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0, 0, 0.6875, 0.125, 0.4375, 0.8125), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.3125, 0.5, 0.3125, 0.375, 0.75, 0.375), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.3125, 0.5, 0.625, 0.375, 0.75, 0.6875), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.625, 0.5, 0.3125, 0.6875, 0.75, 0.375), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.625, 0.5, 0.625, 0.6875, 0.75, 0.6875), BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.3125, 0.75, 0.3125, 0.6875, 0.8125, 0.6875), BooleanOp.OR);

		return shape;
	}

}
