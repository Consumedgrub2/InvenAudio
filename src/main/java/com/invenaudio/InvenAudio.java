package com.invenaudio;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Constants.MODID, version = Constants.VERSION, name = Constants.NAME, acceptedMinecraftVersions = Constants.ACCEPTED_MINECRAFT_VERSIONS)
public class InvenAudio
{
    public static final Minecraft MC = Minecraft.getMinecraft();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //For bullshit forge 1.7.10 lwjgl sound system init error, please comment out during release build.
        MC.refreshResources();
        Constants.LOGGER.warn("Refreshed Minecraft resources... Please disable this during production build.");

        Constants.LOGGER.info("Playing with InvenAudio Mod version " + Constants.VERSION + ".");
        MinecraftForge.EVENT_BUS.register(new InventoryHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}