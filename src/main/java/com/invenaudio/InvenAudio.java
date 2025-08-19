package com.invenaudio;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;

import net.minecraft.client.Minecraft;

@Mod(modid = Constants.MODID, version = Constants.VERSION, name = Constants.NAME, acceptedMinecraftVersions = Constants.ACCEPTED_MINECRAFT_VERSIONS, dependencies = Constants.DEPENDENCIES)
public class InvenAudio
{
    public static final Minecraft MC = Minecraft.getMinecraft();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        Constants.LOGGER.info("Playing with InvenAudio Mod version " + Constants.VERSION + ".");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        //For bullshit forge 1.7.10 lwjgl sound system init error, please comment out during release build.
        MC.refreshResources();
        Constants.LOGGER.warn("Refreshed Minecraft resources... Please disable this during production build.");
        SoundResources.registerStringSoundAssociations();
    }
}