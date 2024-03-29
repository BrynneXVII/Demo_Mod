package com.github.brynnexvii.demomod.init;

import java.util.function.Supplier;
import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.base.RuneBlock;
import com.github.brynnexvii.demomod.blocks.AdvancedBlock;
import com.github.brynnexvii.demomod.blocks.CustomModelBlock;
import com.github.brynnexvii.demomod.blocks.ExampleTable;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
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
	
	//Registry method for burnable block items
	private static <T extends Block> RegistryObject<T> registerBurnable(String name, Supplier<T> supplier, Item.Properties properties, int burnTime){
		RegistryObject<T> block = BLOCKS.register(name, supplier);
		ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties) {
				
			@Override
			public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
				return burnTime;
			}
		});
		return block;
	}
	
	//Registry items for the blocks
	public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block", () -> new Block(BlockBehaviour.Properties
			.of(Material.FROGLIGHT)
			.strength(2f)
			.requiresCorrectToolForDrops()), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	public static final RegistryObject<Block> EXAMPLE_ANIMATED_BLOCK = register("example_animated_block", () -> new Block(BlockBehaviour.Properties
			.of(Material.STONE)
			.strength(2f)
			.requiresCorrectToolForDrops()), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	public static final RegistryObject<Block> EXAMPLE_FUEL_BLOCK = registerBurnable("example_fuel_block", () -> new Block(BlockBehaviour.Properties
			.of(Material.STONE)
			.strength(1f)
			.requiresCorrectToolForDrops()), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB), 1000);
	public static final RegistryObject<Block> EXAMPLE_RUNE = register("example_rune", () -> new RuneBlock(BlockBehaviour.Properties
			.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_RED)
			.noCollission()
			.strength(0.2F)
			.sound(SoundType.GLOW_LICHEN)
			.lightLevel(RuneBlock.emission(15))), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	public static final RegistryObject<FlowerBlock> EXAMPLE_FLOWER = register("example_flower", () -> new FlowerBlock(
			MobEffects.HEALTH_BOOST, 
			10, 
			BlockBehaviour.Properties.copy(Blocks.LILY_OF_THE_VALLEY)),
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	public static final RegistryObject<FlowerPotBlock> POTTED_EXAMPLE_FLOWER = BLOCKS.register("potted_example_flower", () -> new FlowerPotBlock(
			() -> (FlowerPotBlock) Blocks.FLOWER_POT,
			EXAMPLE_FLOWER, 
			BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
	public static final RegistryObject<AdvancedBlock> EXAMPLE_ADVANCED_BLOCK = register("example_advanced_block", () -> new AdvancedBlock(
			BlockBehaviour.Properties.copy(Blocks.BEACON)
			.randomTicks()), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	public static final RegistryObject<Block> EXAMPLE_CUSTOM_MODEL_BLOCK = register("example_custom_model_block", () -> new CustomModelBlock(
			BlockBehaviour.Properties.of(Material.WOOD).dynamicShape().noOcclusion()), new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	public static final RegistryObject<ExampleTable> EXAMPLE_TABLE = register("example_table", () -> new ExampleTable(
			BlockBehaviour.Properties.of(Material.WOOD).dynamicShape().requiresCorrectToolForDrops().strength(5f)), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	
	
	//ore registry items
	public static final RegistryObject<Block> EXAMPLE_OVERWORLD_ORE = register("example_overworld_ore", () -> new Block(BlockBehaviour.Properties
			.copy(Blocks.DIAMOND_ORE)), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	public static final RegistryObject<Block> EXAMPLE_DEEPSLATE_ORE = register("example_deepslate_ore", () -> new Block(BlockBehaviour.Properties
			.copy(Blocks.DEEPSLATE_DIAMOND_ORE)), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	public static final RegistryObject<Block> EXAMPLE_NETHER_ORE = register("example_nether_ore", () -> new Block(BlockBehaviour.Properties
			.copy(Blocks.ANCIENT_DEBRIS)), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	public static final RegistryObject<Block> EXAMPLE_END_ORE = register("example_end_ore", () -> new Block(BlockBehaviour.Properties
			.copy(Blocks.END_STONE)), 
			new Item.Properties().tab(DemoMod.EXAMPLE_TAB));
	
	//Subclass for a block tags
	public static class ModBlockTags {
		//method to simplify tag creation
		private static TagKey<Block> create(String location){
			return BlockTags.create(new ResourceLocation(DemoMod.MODID, location));
		}
		
		
		public static final TagKey<Block> NEEDS_EXAMPLE_TOOL = ModBlockTags.create("needs_example_tool");
		
	}
	
	
}
