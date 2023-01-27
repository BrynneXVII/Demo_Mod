package com.github.brynnexvii.demomod.entities;

import com.github.brynnexvii.demomod.init.EntityInit;
import com.github.brynnexvii.demomod.init.ItemInit;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RunAroundLikeCrazyGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class ExampleEntityClass extends AbstractHorse {
	
	public ExampleEntityClass(EntityType<? extends AbstractHorse> type, Level level) {
		super(type, level);
	}
	
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
		AbstractHorse abstracthorse;
	    if (mob instanceof Horse) {
	    	abstracthorse = EntityType.HORSE.create(level); 	   	  
	    } else {
	    	abstracthorse = EntityInit.EXAMPLE_ENTITY.get().create(level);  
	    }
	      return abstracthorse;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
	    this.goalSelector.addGoal(1, new RunAroundLikeCrazyGoal(this, 1.2D));
	    this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D, AbstractHorse.class));
	    this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.0D));
	    this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.7D));
	    this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
	    this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.of(ItemInit.EXAMPLE_ITEM.get()), false));
		this.addBehaviourGoals();
	}
	
	
	public static AttributeSupplier.Builder getExampleEnitityAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.FLYING_SPEED, 0.7f)
				.add(Attributes.JUMP_STRENGTH, 0.7f)
				.add(Attributes.MOVEMENT_SPEED, 0.7f)
				.add(Attributes.MAX_HEALTH, 25D)
				.add(Attributes.FOLLOW_RANGE, 17)
				.add(ForgeMod.ENTITY_GRAVITY.get(), 0.5f);
	}
}
