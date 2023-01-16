package com.github.brynnexvii.demomod.init;

import com.github.brynnexvii.demomod.DemoMod;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PaintingInit {

	public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, DemoMod.MODID);
	
	public static final RegistryObject<PaintingVariant> EXAMPLE_PAINTING = PAINTINGS.register("example_painting", () -> new PaintingVariant(16, 32));
}
