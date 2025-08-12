package com.invenaudio;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;

@Mod(modid = InvenAudio.MODID, version = InvenAudio.VERSION, name = InvenAudio.NAME, acceptedMinecraftVersions = "1.7.10")
public class InvenAudio
{
    public static final String MODID = "invenaudio";
    public static final String VERSION = "0.0.0.1";
    public static final String NAME = "Inven Audio";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //For bullshit forge 1.7.10 lwjgl sound system init error, please comment out during release build.
        Minecraft.getMinecraft().refreshResources();

        System.out.println("Playing with InvenAudio Mod version $v".format(VERSION));
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}