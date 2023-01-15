package com.github.brynnexvii.demomod.events;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.init.BlockInit;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DemoMod.MODID, bus = Bus.MOD)
public class ModCommonEvents {

	@SubscribeEvent
	public static void commonSetup(FMLClientSetupEvent event) {
		//enqueue the events so they occur at the right time, not before something they reference
		event.enqueueWork(() -> {
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlockInit.EXAMPLE_FLOWER.getId(), BlockInit.POTTED_EXAMPLE_FLOWER);
		});
	}
}
