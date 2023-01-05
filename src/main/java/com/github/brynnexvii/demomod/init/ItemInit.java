package com.github.brynnexvii.demomod.init;

import com.github.brynnexvii.demomod.DemoMod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	//create deferred registry for items
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DemoMod.MODID);
	
	//registry objects = what we want to 
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

	
	//Dye item set up
	//Material colours seem to map to a range of 64 types, all of which are defined by minecraft
	//public static final DyeColor ELECTRIC_INDIGO = new DyeColor(17, "electric_indigo", 0, MaterialColor.COLOR_PURPLE, 0, 7274751); 
	
	//public static final RegistryObject<Item> EXAMPLE_DYE = ITEMS.register("example_dye", () -> new DyeItem(null, null));
	
}
