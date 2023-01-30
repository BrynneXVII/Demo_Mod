package com.github.brynnexvii.demomod.blockentities;

import com.github.brynnexvii.demomod.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ExampleTableBlockEntity extends BlockEntity{
	private int value;
	private static final int MAX_VALUE = 60;
	

	public ExampleTableBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.EXAMPLE_TABLE.get(), pos, state);
	}
	
	public void tick() {
		value++;
		if(value > MAX_VALUE) {
			value = 0;
			((ServerLevel) this.level).sendParticles(ParticleTypes.DRAGON_BREATH, this.getBlockPos().getX(), this.getBlockPos().getY() + 2, this.getBlockPos().getZ(), 1, 0, 0, 0, 0);
		}
	}
	
	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		this.value = nbt.getInt("Value");
	}
	
	@Override
	protected void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		nbt.putInt("Value", this.value);
	}

}