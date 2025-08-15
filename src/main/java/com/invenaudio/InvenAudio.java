package com.invenaudio;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MODID, version = Constants.VERSION, name = Constants.NAME, acceptedMinecraftVersions = Constants.ACCEPTED_MINECRAFT_VERSIONS)
public class InvenAudio
{
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //For bullshit forge 1.7.10 lwjgl sound system init error, please comment out during release build.
        Minecraft.getMinecraft().refreshResources();

        System.out.println("Playing with InvenAudio Mod version " + Constants.VERSION + ".");
        MinecraftForge.EVENT_BUS.register(new InventoryHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}