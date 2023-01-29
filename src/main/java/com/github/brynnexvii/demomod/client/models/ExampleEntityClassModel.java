package com.github.brynnexvii.demomod.client.models;

import com.github.brynnexvii.demomod.DemoMod;
import com.github.brynnexvii.demomod.entities.ExampleEntityClass;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityClassModel extends EntityModel<ExampleEntityClass> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(DemoMod.MODID, "example_entity"), "main");
	private final ModelPart Body;
	private final ModelPart TailA;
	private final ModelPart Leg1A;
	private final ModelPart Leg2A;
	private final ModelPart Leg3A;
	private final ModelPart Leg4A;
	private final ModelPart Head;
	private final ModelPart Ear1;
	private final ModelPart Ear2;
	private final ModelPart MuleEarL;
	private final ModelPart MuleEarR;
	private final ModelPart Neck;
	private final ModelPart Bag1;
	private final ModelPart Bag2;
	private final ModelPart Saddle;
	private final ModelPart SaddleMouthL;
	private final ModelPart SaddleMouthR;
	private final ModelPart SaddleMouthLine;
	private final ModelPart SaddleMouthLineR;
	private final ModelPart HeadSaddle;
	private final ModelPart WingL;
	private final ModelPart WingR;

	public ExampleEntityClassModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.TailA = root.getChild("TailA");
		this.Leg1A = root.getChild("Leg1A");
		this.Leg2A = root.getChild("Leg2A");
		this.Leg3A = root.getChild("Leg3A");
		this.Leg4A = root.getChild("Leg4A");
		this.Head = root.getChild("Head");
		this.Ear1 = root.getChild("Ear1");
		this.Ear2 = root.getChild("Ear2");
		this.MuleEarL = root.getChild("MuleEarL");
		this.MuleEarR = root.getChild("MuleEarR");
		this.Neck = root.getChild("Neck");
		this.Bag1 = root.getChild("Bag1");
		this.Bag2 = root.getChild("Bag2");
		this.Saddle = root.getChild("Saddle");
		this.SaddleMouthL = root.getChild("SaddleMouthL");
		this.SaddleMouthR = root.getChild("SaddleMouthR");
		this.SaddleMouthLine = root.getChild("SaddleMouthLine");
		this.SaddleMouthLineR = root.getChild("SaddleMouthLineR");
		this.HeadSaddle = root.getChild("HeadSaddle");
		this.WingL = root.getChild("WingL");
		this.WingR = root.getChild("WingR");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition Body = parts.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 32).addBox(-5.0F, -8.0F, -20.0F, 10.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 9.0F));

		PartDefinition TailA = parts.addOrReplaceChild("TailA", CubeListBuilder.create().texOffs(42, 36).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 11.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Leg1A = parts.addOrReplaceChild("Leg1A", CubeListBuilder.create().texOffs(48, 21).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 13.0F, 9.0F));

		PartDefinition Leg2A = parts.addOrReplaceChild("Leg2A", CubeListBuilder.create().texOffs(48, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, 9.0F));

		PartDefinition Leg3A = parts.addOrReplaceChild("Leg3A", CubeListBuilder.create().texOffs(48, 21).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 13.0F, -9.0F));

		PartDefinition Leg4A = parts.addOrReplaceChild("Leg4A", CubeListBuilder.create().texOffs(48, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, -9.0F));

		PartDefinition Head = parts.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -11.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Ear1 = parts.addOrReplaceChild("Ear1", CubeListBuilder.create().texOffs(19, 16).mirror().addBox(-0.5F, -18.0F, 2.99F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, 0.5236F, 0.0F, 0.0873F));

		PartDefinition Ear2 = parts.addOrReplaceChild("Ear2", CubeListBuilder.create().texOffs(19, 16).addBox(-1.5F, -18.0F, 2.99F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, 0.5236F, 0.0F, -0.0873F));

		PartDefinition MuleEarL = parts.addOrReplaceChild("MuleEarL", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(-3.0F, -22.0F, 2.99F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, 0.5236F, 0.0F, 0.2618F));

		PartDefinition MuleEarR = parts.addOrReplaceChild("MuleEarR", CubeListBuilder.create().texOffs(0, 12).addBox(1.0F, -22.0F, 2.99F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, 0.5236F, 0.0F, -0.2618F));

		PartDefinition Neck = parts.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 35).addBox(-2.0F, -11.0F, -3.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(56, 36).addBox(-1.0F, -16.0F, 4.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Bag1 = parts.addOrReplaceChild("Bag1", CubeListBuilder.create().texOffs(26, 21).addBox(-9.0F, 0.0F, 0.0F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 3.0F, 11.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Bag2 = parts.addOrReplaceChild("Bag2", CubeListBuilder.create().texOffs(26, 21).mirror().addBox(1.0F, 0.0F, 0.0F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 3.0F, 11.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Saddle = parts.addOrReplaceChild("Saddle", CubeListBuilder.create().texOffs(26, 0).addBox(-5.0F, 1.0F, -5.5F, 10.0F, 9.0F, 9.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition SaddleMouthL = parts.addOrReplaceChild("SaddleMouthL", CubeListBuilder.create().texOffs(29, 5).addBox(2.0F, -14.0F, -6.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition SaddleMouthR = parts.addOrReplaceChild("SaddleMouthR", CubeListBuilder.create().texOffs(29, 5).addBox(-3.0F, -14.0F, -6.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition SaddleMouthLine = parts.addOrReplaceChild("SaddleMouthLine", CubeListBuilder.create().texOffs(32, 2).addBox(3.1F, -10.0F, -11.5F, 0.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -8.0F));

		PartDefinition SaddleMouthLineR = parts.addOrReplaceChild("SaddleMouthLineR", CubeListBuilder.create().texOffs(32, 2).addBox(-3.1F, -10.0F, -11.5F, 0.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -8.0F));

		PartDefinition HeadSaddle = parts.addOrReplaceChild("HeadSaddle", CubeListBuilder.create().texOffs(19, 0).addBox(-2.0F, -16.0F, -5.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.25F))
		.texOffs(0, 0).addBox(-3.0F, -16.0F, -3.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 7.0F, -8.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition WingL = parts.addOrReplaceChild("WingL", CubeListBuilder.create().texOffs(62, 34).addBox(0.0F, -1.0F, -1.0F, 15.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(53, 0).addBox(0.0F, 0.0F, 1.0F, 15.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 5.0F, -8.0F));

		PartDefinition TipL_r1 = WingL.addOrReplaceChild("TipL_r1", CubeListBuilder.create().texOffs(62, 62).addBox(0.0F, 0.0F, 0.0F, 13.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -1.0F, -1.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition TipFeathersL_r1 = WingL.addOrReplaceChild("TipFeathersL_r1", CubeListBuilder.create().texOffs(53, 11).addBox(-1.0F, 0.0F, 0.0F, 13.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.0F, 1.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition WingR = parts.addOrReplaceChild("WingR", CubeListBuilder.create().texOffs(0, 64).addBox(-20.0F, -20.0F, -9.0F, 15.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(53, 22).addBox(-20.0F, -19.0F, -7.0F, 15.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition TipFeathersR_r1 = WingR.addOrReplaceChild("TipFeathersR_r1", CubeListBuilder.create().texOffs(53, 38).addBox(-12.0F, 0.0F, 0.0F, 13.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -19.0F, -7.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition TipR_r1 = WingR.addOrReplaceChild("TipR_r1", CubeListBuilder.create().texOffs(34, 64).addBox(-13.0F, 0.0F, 0.0F, 13.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -20.0F, -9.0F, 0.0F, 0.4363F, 0.0F));

		return LayerDefinition.create(mesh, 128, 128);
	}

	@Override
	public void setupAnim(ExampleEntityClass entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TailA.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1A.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2A.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3A.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4A.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ear1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ear2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		MuleEarL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		MuleEarR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bag1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bag2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Saddle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SaddleMouthL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SaddleMouthR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SaddleMouthLine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SaddleMouthLineR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		HeadSaddle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		WingL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		WingR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}