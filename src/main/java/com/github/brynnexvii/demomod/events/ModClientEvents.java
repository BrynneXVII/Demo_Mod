package com.github.brynnexvii.demomod.events;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.client.models.ExampleEntityClassModel;
import com.github.brynnexvii.demomod.client.renderer.ExampleEntityClassRenderer;
import com.github.brynnexvii.demomod.init.BlockInit;
import com.github.brynnexvii.demomod.init.EntityInit;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DemoMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
	}
	
	@SubscribeEvent
	public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntityClassRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ExampleEntityClassModel.LAYER_LOCATION, ExampleEntityClassModel::createBodyLayer);
	}
}
