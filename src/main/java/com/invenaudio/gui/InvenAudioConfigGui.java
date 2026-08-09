package com.invenaudio.gui;

import com.invenaudio.Constants;
import com.invenaudio.InvenAudio;
import com.invenaudio.InvenAudioConfig;

import cpw.mods.fml.client.config.GuiConfig;

import net.minecraft.client.gui.GuiScreen;

public class InvenAudioConfigGui extends GuiConfig {
    public InvenAudioConfigGui(GuiScreen parentGuiScreen){
        super(parentGuiScreen, InvenAudioConfig.configProperties, Constants.MODID, false, false, getAbridgedConfigPath(InvenAudio.configuration.toString()));
    }

    @Override
    public void onGuiClosed(){
        super.onGuiClosed();
        InvenAudio.configuration.save();
        InvenAudioConfig.loadConfig(InvenAudio.configuration);
    }
}