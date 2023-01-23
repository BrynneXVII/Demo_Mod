package com.github.brynnexvii.demomod.init;

import java.util.List;

import com.github.brynnexvii.demomod.DemoMod;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PlacedFeatureInit {

	//deferred register
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DemoMod.MODID);
	
	//helper methods for placement generators
	private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
		return orePlacement(CountPlacement.of(countPerChunk), height);
	}
	
	private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
		return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
	}
	
	//registry objects
	public static final RegistryObject<PlacedFeature> EXAMPLE_OVERWORLD_ORE = PLACED_FEATURES.register("example_overworld_ore", 
			() -> new PlacedFeature(ConfiguredFeatureInit.EXAMPLE_OVERWORLD_ORE.getHolder().get(), 
					commonOrePlacement(10, HeightRangePlacement.triangle(
							VerticalAnchor.aboveBottom(10), 
							VerticalAnchor.absolute(60)
					))));
	public static final RegistryObject<PlacedFeature> EXAMPLE_NETHER_ORE = PLACED_FEATURES.register("example_nether_ore", 
			() -> new PlacedFeature(ConfiguredFeatureInit.EXAMPLE_NETHER_ORE.getHolder().get(), 
					commonOrePlacement(10, HeightRangePlacement.uniform(
							VerticalAnchor.bottom(), 
							VerticalAnchor.top()
					))));
	public static final RegistryObject<PlacedFeature> EXAMPLE_END_ORE = PLACED_FEATURES.register("example_end_ore", 
			() -> new PlacedFeature(ConfiguredFeatureInit.EXAMPLE_END_ORE.getHolder().get(), 
					commonOrePlacement(10, HeightRangePlacement.uniform(
							VerticalAnchor.bottom(), 
							VerticalAnchor.belowTop(50)
					))));
	
	
}
