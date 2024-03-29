package com.github.brynnexvii.demomod;

import com.github.brynnexvii.demomod.init.BlockEntityInit;
import com.github.brynnexvii.demomod.init.BlockInit;
import com.github.brynnexvii.demomod.init.ConfiguredFeatureInit;
import com.github.brynnexvii.demomod.init.EntityInit;
import com.github.brynnexvii.demomod.init.FluidInit;
import com.github.brynnexvii.demomod.init.ItemInit;
import com.github.brynnexvii.demomod.init.PaintingInit;
import com.github.brynnexvii.demomod.init.PlacedFeatureInit;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DemoMod.MODID)
public class DemoMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "demomod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public DemoMod()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        //bus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BlockInit.BLOCKS.register(bus);
        
        // Register the Deferred Register to the mod event bus so our items get registered
        ItemInit.ITEMS.register(bus);
        
        // Register the Deferred Register to the mod event bus so our paintings get registered
        PaintingInit.PAINTINGS.register(bus);
        
        // Register the Deferred Register to the mod event bus so our configured features (like ores veins) get registered
        ConfiguredFeatureInit.CONFIGURED_FEATURES.register(bus);
        
        // Register the Deferred Register to the mod event bus so our placed features (ore vein structures) get registered
        PlacedFeatureInit.PLACED_FEATURES.register(bus);
        
        // Register the Deferred Register to the mod event bus so our fluid types get registered
        FluidInit.FLUID_TYPES.register(bus);
        
        // Register the Deferred Register to the mod event bus so our fluids get registered
        FluidInit.FLUIDS.register(bus);
        
        // Register the Deferred Register to the mod event bus so our entities get registered
        EntityInit.ENTITY_TYPES.register(bus);
        
        // Register the Deferred Register to the mod event bus so our block entities get registered
        BlockEntityInit.BLOCK_ENTITIES.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    public static final CreativeModeTab EXAMPLE_TAB = new CreativeModeTab(MODID) {
    	@Override
    	public ItemStack makeIcon() {
    		return ItemInit.EXAMPLE_ITEM.get().getDefaultInstance();
    	}
    };

	/*
	 * private void commonSetup(final FMLCommonSetupEvent event) { // Some common
	 * setup code LOGGER.info("HELLO FROM COMMON SETUP");
	 * LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
	 * }
	 * 
	 * // You can use SubscribeEvent and let the Event Bus discover methods to call
	 * 
	 * @SubscribeEvent public void onServerStarting(ServerStartingEvent event) { //
	 * Do something when the server starts
	 * LOGGER.info("HELLO from server starting"); }
	 * 
	 * // You can use EventBusSubscriber to automatically register all static
	 * methods in the class annotated with @SubscribeEvent
	 * 
	 * @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	 * public static class ClientModEvents {
	 * 
	 * @SubscribeEvent public static void onClientSetup(FMLClientSetupEvent event) {
	 * // Some client setup code LOGGER.info("HELLO FROM CLIENT SETUP");
	 * LOGGER.info("MINECRAFT NAME >> {}",
	 * Minecraft.getInstance().getUser().getName()); } }
	 */
}
