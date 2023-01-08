package com.github.brynnexvii.demomod.base;

import java.util.function.Supplier;

import com.github.brynnexvii.demomod.DemoMod;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public record ModArmorMaterial(String name, int durability, int[] protection, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) implements ArmorMaterial {

	//base durability per slot values from the MC code, can change if you wish
	private static final int[] DURABILITY_PER_SLOT = new int[]{13, 15, 16, 11};
	
	@Override
	public int getDurabilityForSlot(EquipmentSlot slot) {
		return DURABILITY_PER_SLOT[slot.getIndex()] * this.durability;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot slot) {
		return this.protection[slot.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}

	@Override
	public String getName() {
		return DemoMod.MODID + ":" + this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
	
}
