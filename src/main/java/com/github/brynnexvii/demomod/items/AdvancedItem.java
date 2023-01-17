package com.github.brynnexvii.demomod.items;

import java.util.List;

import com.github.brynnexvii.demomod.ClientAccess;
import com.github.brynnexvii.demomod.DemoMod;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class AdvancedItem extends Item{

	public AdvancedItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if(hand == InteractionHand.MAIN_HAND && !level.isClientSide()) {
			player.sendSystemMessage(Component.translatable(DemoMod.MODID + ".advanced_item.right_click")); //this activates
		} else if (hand == InteractionHand.OFF_HAND && !level.isClientSide()) {
			player.sendSystemMessage(Component.literal("LEFTING Sever"));
		} else if (hand == InteractionHand.MAIN_HAND && level.isClientSide()) {
			player.sendSystemMessage(Component.literal("RIGHTING Client")); //this activates
		} else {
			player.sendSystemMessage(Component.literal("LEFTING Client"));
		}
		
		
		return super.use(level, player, hand);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag) {
		super.appendHoverText(stack, level, components, flag);
		
		//always prints in the tooltip if added here
		//this one will print for any instance of the advanced item class
		components.add(Component.translatable(DemoMod.MODID + ".advanced_item.tooltip"));
		
		//base prints when shift is not pressed, expanded when it is (can always have base printed if it is added here instead and not passed, pass in null instead)
		// set to null like: Component baseTooltip = null; or put null in method call
		Component baseTooltip = Component.translatable((stack.getDescriptionId()).split("[.]", 2)[1] + ".tooltip");
		Component expandedTooltip = Component.translatable((stack.getDescriptionId()).split("[.]", 2)[1] + ".expanded_tooltip");
		
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientAccess.expandedItemTooltip(level, components, baseTooltip, expandedTooltip));
	}
	
	@Override
	public InteractionResult useOn(UseOnContext p_41427_) {
		// TODO Auto-generated method stub
		return super.useOn(p_41427_);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		// TODO Auto-generated method stub
		return super.onLeftClickEntity(stack, player, entity);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack p_41398_, Player p_41399_, LivingEntity p_41400_,
			InteractionHand p_41401_) {
		// TODO Auto-generated method stub
		return super.interactLivingEntity(p_41398_, p_41399_, p_41400_, p_41401_);
	}
}
