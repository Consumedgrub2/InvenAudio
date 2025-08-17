package com.invenaudio;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiOpenEvent;

public class InventoryHandler {
    public static GuiContainer currentOpenGuiContainer;

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (event.gui != null) {
            if (event.gui instanceof GuiContainer) {
                currentOpenGuiContainer = (GuiContainer) event.gui;
            }
        }
    }
}