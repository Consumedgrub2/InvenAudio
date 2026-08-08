package com.invenaudio;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class InvenAudioConfig {

    public static void loadConfig(Configuration configuration){
        try{
            configuration.load();

            // Create configuration category descriptions

            configuration.addCustomCategoryComment("sfx_volume_levels","Volume levels for SFX. Minimum 0.0 - Maximum 1.0");
            configuration.addCustomCategoryComment("sfx_volume_levels.general_vanilla_sounds", "SFX for base Minecraft blocks/items.");
            configuration.addCustomCategoryComment("sfx_volume_levels.general_modded_sounds", "SFX for modded blocks/items.");
            configuration.addCustomCategoryComment("sfx_volume_levels.specific_modded_sounds", "SFX for specific modded blocks/items.");

            // Write Properties into the config file

            for (String soundName : SoundResources.generalVanillaSoundHashMap.keySet()){
                Property property = configuration.get("sfx_volume_levels.general_vanilla_sounds", soundName, 1.0);
                property.setMinValue(0.0);
                property.setMaxValue(1.0);
            }
            for (String soundName : SoundResources.generalModdedSoundHashMap.keySet()){
                Property property = configuration.get("sfx_volume_levels.general_modded_sounds", soundName, 1.0);
                property.setMinValue(0.0);
                property.setMaxValue(1.0);
            }
            for (String soundName : SoundResources.specificModdedSoundHashMap.keySet()){
                Property property = configuration.get("sfx_volume_levels.specific_modded_sounds", soundName, 1.0);
                property.setMinValue(0.0);
                property.setMaxValue(1.0);
            }



        } catch(Exception e) {

        } finally {

        }
    }
}
