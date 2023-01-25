package com.github.brynnexvii.demomod.init;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.base.FluidRegistryContainer;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {
	//deferred registers
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DemoMod.MODID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, DemoMod.MODID);
	
	//registry objects
	public static final FluidRegistryContainer EXAMPLE_FLUID = new FluidRegistryContainer("example_fluid", 
			FluidType.Properties.create().canSwim(true).canDrown(false).canPushEntity(true)
				.canConvertToSource(true).lightLevel(7).supportsBoating(true), 
			() -> FluidRegistryContainer.createExtension(new FluidRegistryContainer.ClientExtensions(DemoMod.MODID, "example_fluid")
				.tint((State, Level, pos) -> pos.getX() > 15 || pos.getZ() > 15 ? 0xFF : 0).fogColor(0, 0.2f, 1f)),
			new FluidRegistryContainer.AdditionalProperties().slopeFindDistance(12), 
			BlockBehaviour.Properties.copy(Blocks.WATER),
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB).stacksTo(1));

}
