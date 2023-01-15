package com.github.brynnexvii.demomod.events;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.init.BlockInit;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DemoMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
	}
		
}
