package com.invenaudio;

import cpw.mods.fml.client.config.IConfigElement;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.util.ArrayList;
import java.util.HashMap;

public class InvenAudioConfig {

    // For the gui-based config
    public static ArrayList<IConfigElement> configProperties = new ArrayList<>();

    public static final HashMap<ResourceLocation, Double> sfxVolumeMap = new HashMap<>();

    public static Property fallbackSoundProperty;

    public static void loadConfig(Configuration configuration){
        try{
            configuration.load();

            // Create configuration category descriptions
            configuration.addCustomCategoryComment("sfx_volume_levels", "Volume levels for SFX. Minimum 0.0 - Maximum 1.0");
            configuration.addCustomCategoryComment("sfx_volume_levels.general_vanilla_sounds", "SFX for base Minecraft blocks/items.");
            configuration.addCustomCategoryComment("sfx_volume_levels.general_modded_sounds", "SFX for modded blocks/items.");
            configuration.addCustomCategoryComment("sfx_volume_levels.specific_modded_sounds", "SFX for specific modded blocks/items.");

            // Write Properties into the config file

            // Don't forget the fallback sound!
            fallbackSoundProperty = configuration.get("sfx_volume_levels", SoundResources.finalFallbackSound.toString(), 1.0, "The default fallback sound for when the item name doesn't match any known entry in the lists below.");
            fallbackSoundProperty.setMinValue(0.0);
            fallbackSoundProperty.setMaxValue(1.0);

            // Clear to make sure duplicates aren't added while calling again through in-game config gui
            sfxVolumeMap.clear();
            configProperties.clear();

            for (ResourceLocation resourceLocation : SoundResources.generalVanillaSoundHashMap.values()){
                Property property = configuration.get("sfx_volume_levels.general_vanilla_sounds", resourceLocation.toString(), 1.0);
                property.setMinValue(0.0);
                property.setMaxValue(1.0);
                sfxVolumeMap.put(resourceLocation, Math.max(0.0, Math.min(1.0, property.getDouble()))); // Ensure that it's within range no matter what
                configProperties.add(new ConfigElement<>(property));
            }
            for (ResourceLocation resourceLocation : SoundResources.generalModdedSoundHashMap.values()){
                Property property = configuration.get("sfx_volume_levels.general_modded_sounds", resourceLocation.toString(), 1.0);
                property.setMinValue(0.0);
                property.setMaxValue(1.0);
                sfxVolumeMap.put(resourceLocation, Math.max(0.0, Math.min(1.0, property.getDouble()))); // Ensure that it's within range no matter what
                configProperties.add(new ConfigElement<>(property));
            }
            for (ResourceLocation resourceLocation : SoundResources.specificModdedSoundHashMap.values()){
                Property property = configuration.get("sfx_volume_levels.specific_modded_sounds", resourceLocation.toString(), 1.0);
                property.setMinValue(0.0);
                property.setMaxValue(1.0);
                sfxVolumeMap.put(resourceLocation, Math.max(0.0, Math.min(1.0, property.getDouble()))); // Ensure that it's within range no matter what
                configProperties.add(new ConfigElement<Property>(property));
            }
        } catch(Exception e) {
            Constants.LOGGER.error("There was an issue attempting to write to the log file: " + e);
        } finally {
            if (configuration.hasChanged()){
                configuration.save();
            }
        }
    }
}