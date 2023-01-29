package com.github.brynnexvii.demomod.client.renderer;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.client.models.ExampleEntityClassModel;
import com.github.brynnexvii.demomod.entities.ExampleEntityClass;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityClassRenderer extends MobRenderer<ExampleEntityClass, ExampleEntityClassModel>{

	private static final ResourceLocation TEXTURE = new ResourceLocation(DemoMod.MODID, "textures/entities/example_entity.png");
	
	public ExampleEntityClassRenderer(EntityRendererProvider.Context context) {
		super(context, new ExampleEntityClassModel(context.bakeLayer(ExampleEntityClassModel.LAYER_LOCATION)), 0.5f);
	}
	
	public ResourceLocation getTextureLocation(ExampleEntityClass entity) {
		return TEXTURE;
	}
}
