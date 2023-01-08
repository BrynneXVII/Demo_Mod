package com.github.brynnexvii.demomod.init;

import com.github.brynnexvii.demomod.DemoMod;
import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	
	//Deferred register for blocks
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DemoMod.MODID);

	//Registry method for block items
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties){
		RegistryObject<T> block = BLOCKS.register(name, supplier);
		ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
		return block;
	}
	
	//Registry items for the blocks
	public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block", () -> new Block(BlockBehaviour.Properties
			.of(Material.FROGLIGHT)
			.strength(2f)
			.requiresCorrectToolForDrops()), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
}
