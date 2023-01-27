package com.github.brynnexvii.demomod.init;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.entities.ExampleEntityClass;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
	//deferred register
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DemoMod.MODID);
	
	//registry objects
	public static final RegistryObject<EntityType<ExampleEntityClass>> EXAMPLE_ENTITY = ENTITY_TYPES.register("example_entity", () ->
			EntityType.Builder.of(ExampleEntityClass::new, MobCategory.CREATURE).build(new ResourceLocation(DemoMod.MODID, "example_entity").toString()));
}
