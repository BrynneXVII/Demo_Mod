package com.github.brynnexvii.demomod.init;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.base.FuelItem;
import com.github.brynnexvii.demomod.base.ModArmorMaterial;
import com.github.brynnexvii.demomod.base.ModDyeItem;
import com.github.brynnexvii.demomod.items.AdvancedItem;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

	// method to give the base properties to an item and put it in the mod's
	// creative tab
	private static Item.Properties baseProps() {
		return new Item.Properties().tab(DemoMod.EXAMPLE_TAB);
	}

	// create deferred registry for items
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DemoMod.MODID);

	// registry objects = what we want to
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(baseProps()));
	public static final RegistryObject<Item> EXAMPLE_ANIMATED_ITEM = ITEMS.register("example_animated_item", () -> new Item(baseProps()));
	public static final RegistryObject<Item> EXAMPLE_FUEL = ITEMS.register("example_fuel", () -> new FuelItem(baseProps(), 500));
	public static final RegistryObject<Item> EXAMPLE_DYE = ITEMS.register("example_dye", () -> new ModDyeItem(DyeColor.BLUE,baseProps()));
	public static final RegistryObject<AdvancedItem> EXAMPLE_ADVANCED_ITEM = ITEMS.register("example_advanced_item", () -> new AdvancedItem(baseProps()));
	public static final RegistryObject<Item> EXAMPLE_CUSTOM_MODEL_ITEM = ITEMS.register("example_custom_model_item", () -> new Item(baseProps()));
	
	// food property class (for builder setup)
	public static class Foods {
		public static final FoodProperties EXAMPLE_FOOD = new FoodProperties.Builder().nutrition(7).saturationMod(0.7f)
				.fast().effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100), 0.25f).build();
	}

	// registry objects for the food items
	public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food",
			() -> new Item(baseProps().food(Foods.EXAMPLE_FOOD)));

	// tool tier class
	public static class ToolTiers {
		public static final Tier EXAMPLE_TIER = new ForgeTier(5, // tier level
				3000, // uses
				12.0f, // speed
				5.0f, // attack damage bonus
				20, // enchantability
				BlockInit.ModBlockTags.NEEDS_EXAMPLE_TOOL, // tag
				() -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get())); // repair material
	}

	// registry objects for tools
	public static final RegistryObject<SwordItem> EXAMPLE_SWORD = ITEMS.register("example_sword",
			() -> new SwordItem(ToolTiers.EXAMPLE_TIER, 3, -2.4f, baseProps()));
	public static final RegistryObject<PickaxeItem> EXAMPLE_PICKAXE = ITEMS.register("example_pickaxe",
			() -> new PickaxeItem(ToolTiers.EXAMPLE_TIER, 1, -2.8f, baseProps()));

	// armor material class
	public static class ArmorTiers {
		public static final ArmorMaterial EXAMPLE_ARMOR_TIER = new ModArmorMaterial("example_armor_material", // name
				40, // durability multiplier
				new int[] { 3, 6, 8, 3 }, // protection array
				27, // enchantability
				SoundEvents.ARMOR_EQUIP_DIAMOND, // equip sound
				4.0f, // toughness
				0.2f, // knockback resistance
				() -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get())); // repair material
	}

	// registry objects for armor
	public static final RegistryObject<ArmorItem> EXAMPLE_CHESTPLATE = ITEMS.register("example_chestplate",
			() -> new ArmorItem(ArmorTiers.EXAMPLE_ARMOR_TIER, EquipmentSlot.CHEST, baseProps()));

	// subclass for item tags
	public static class ModItemTags {
		// method to simplify tag creation in mod package
		private static TagKey<Item> create(String location) {
			return ItemTags.create(new ResourceLocation(DemoMod.MODID, location));
		}

		// method to simplify tag creation in mod package
		private static TagKey<Item> createMinecraft(String location) {
			return ItemTags.create(new ResourceLocation(location));
		}

		public static final TagKey<Item> FOX_FOOD = ModItemTags.createMinecraft("fox_food");
	}

	
	//spawn eggs
	public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_ENTITY_SPAWN_EGG = ITEMS.register("example_entity_spawn_egg", 
			() -> new ForgeSpawnEggItem(EntityInit.EXAMPLE_ENTITY, 0x4D2600, 0xFEEECD, baseProps().stacksTo(16)));

}
