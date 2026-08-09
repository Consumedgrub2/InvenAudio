package com.invenaudio;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = Constants.MODID, version = Constants.VERSION, name = Constants.NAME, acceptedMinecraftVersions = Constants.ACCEPTED_MINECRAFT_VERSIONS, dependencies = Constants.DEPENDENCIES, guiFactory = "com.invenaudio.gui.InvenAudioGuiFactory")
public class InvenAudio
{
    public static Configuration configuration;

    public static final Minecraft MC = Minecraft.getMinecraft();

    // Boolean flag to prevent multiple sfx clips playing at the same time while dragging in inventory
    public static boolean playedDragSound = false;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        SoundResources.registerStringSoundAssociations();

        // Initialize a new config for this mod
        configuration = new Configuration(event.getSuggestedConfigurationFile());
        InvenAudioConfig.loadConfig(configuration);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        Constants.LOGGER.info("InvenAudio mod version " + Constants.VERSION);
    }

    public static void playInventorySound(String stackDisplayName){
        if (stackDisplayName != null){
            SoundResources.playInventorySoundAtPlayer(SoundResources.getInventorySoundType(stackDisplayName));
        }
    }
}