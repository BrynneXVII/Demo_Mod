package com.github.brynnexvii.demomod.init;

import com.github.brynnexvii.demomod.DemoMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	
	//Deferred register for blocks
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DemoMod.MODID);
	
	//Registry items for the blocks
	public static final RegistryObject<Block> EXAMPLE_BLOCK_OBJECT = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.FROGLIGHT)));
}
