package com.github.brynnexvii.demomod.init;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.blockentities.ExampleTableBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DemoMod.MODID);
	
	public static final RegistryObject<BlockEntityType<ExampleTableBlockEntity>> EXAMPLE_TABLE = BLOCK_ENTITIES.register("example_table", 
			() -> BlockEntityType.Builder.of(ExampleTableBlockEntity::new, BlockInit.EXAMPLE_TABLE.get()).build(null));
}
