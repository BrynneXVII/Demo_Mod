package com.github.brynnexvii.demomod;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

public class ClientAccess {
	
	private static final String TEXT_DARK_RED = "\u00A74";
	private static final String TEXT_RED = "\u00A7c";
	private static final String TEXT_GOLD = "\u00A76";
	private static final String TEXT_YELLOW = "\u00A7e";
	private static final String TEXT_DARK_GREEN = "\u00A72";
	private static final String TEXT_GREEN = "\u00A7a";
	private static final String TEXT_AQUA = "\u00A7b";
	private static final String TEXT_DARK_AQUA = "\u00A73";
	private static final String TEXT_DARK_BLUE = "\u00A71";
	private static final String TEXT_BLUE = "\u00A79";
	private static final String TEXT_LIGHT_PURPLE = "\u00A7d";
	private static final String TEXT_DARK_PURPLE = "\u00A75";
	private static final String TEXT_WHITE = "\u00A7f";
	private static final String TEXT_GRAY = "\u00A77";
	private static final String TEXT_DARK_GRAY = "\u00A78";
	private static final String TEXT_BLACK = "\u00A70";
	
	public static void expandedItemTooltip(Level level, List<Component> components, Component baseToolTip, Component expandedToolTip) {
		
		if(!Screen.hasShiftDown()) {
			if(baseToolTip != null) {
				components.add(baseToolTip);
			}
			components.add(Component.literal("Press " + TEXT_DARK_AQUA + "SHIFT " + TEXT_WHITE + "for more information"));
		} else {
			components.add(expandedToolTip);
		}
		
	}
	
	
}
