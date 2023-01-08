package com.github.brynnexvii.demomod.init;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.base.ModArmorMaterial;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.accesstransformer.generated.AtParser.Return_valueContext;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	
	//method to give the base properties to an item and put it in the mod's creative tab
	private static Item.Properties baseProps () {
		return new Item.Properties().tab(DemoMod.EXAMPLE_TAB);
	}
	
	//create deferred registry for items
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DemoMod.MODID);
	
	//registry objects = what we want to 
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(baseProps()));
	
	
	//food property class (for builder setup)
	public static class Foods {
		public static final FoodProperties EXAMPLE_FOOD = new FoodProperties.Builder()
				.nutrition(7)
				.saturationMod(0.7f)
				.fast()
				.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100), 0.25f)
				.build();
	}
	
	//registry objects for the food items
	public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food", () -> new Item(
			baseProps()
			.food(Foods.EXAMPLE_FOOD)));
	
	//tool tier class
	public static class ToolTiers {
		public static final Tier EXAMPLE_TIER = new ForgeTier(
				5, 		//tier level
				3000, 	//uses
				12.0f, 	//speed
				5.0f, 	//attack damage bonus
				20, 	//enchantability
				null, 	//tag
				() -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get())); //repair material
	}
	
	//registry objects for tools
	public static final RegistryObject<SwordItem> EXAMPLE_SWORD = ITEMS.register("example_sword", () -> new SwordItem(
			ToolTiers.EXAMPLE_TIER, 3, -2.4f, baseProps())); 
	public static final RegistryObject<PickaxeItem> EXAMPLE_PICKAXE = ITEMS.register("example_pickaxe", () -> new PickaxeItem(
			ToolTiers.EXAMPLE_TIER, 1, -2.8f, baseProps()));
	
	
	//armor material class
	public static class ArmorTiers {
		public static final ArmorMaterial EXAMPLE_ARMOR_TIER = new ModArmorMaterial(
				"example_armor_material", 			//name
				40, 								//durability multiplier
				new int[]{3, 6, 8, 3},				//protection array
				27, 								//enchantability
				SoundEvents.ARMOR_EQUIP_DIAMOND, 	//equip sound
				4.0f, 								//toughness
				0.2f,								//knockback resistance 
				() -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));	//repair material
	}
	
	//registry objects for armor
	public static final RegistryObject<ArmorItem> EXAMPLE_CHESTPLATE = ITEMS.register("example_chestplate", () -> new ArmorItem(ArmorTiers.EXAMPLE_ARMOR_TIER, EquipmentSlot.CHEST, baseProps()));
	
	
	//Dye item set up
	//Material colours seem to map to a range of 64 types, all of which are defined by minecraft
	//public static final DyeColor ELECTRIC_INDIGO = new DyeColor(17, "electric_indigo", 0, MaterialColor.COLOR_PURPLE, 0, 7274751); 
	
	//public static final RegistryObject<Item> EXAMPLE_DYE = ITEMS.register("example_dye", () -> new DyeItem(null, null));
	
}
