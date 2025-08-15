package com.invenaudio;

import com.invenaudio.InvenAudio;
import com.invenaudio.SoundResources;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.MouseEvent;

public class InventoryHandler {
    public static Minecraft mc = Minecraft.getMinecraft();
    public static boolean isGuiOpen = false;

    @SubscribeEvent
    public void guiEvent(GuiScreenEvent.ActionPerformedEvent guiScreenEvent) {
        if (true) {
            System.out.println("gui event");
        }
    }
    @SubscribeEvent
    public void onMouseInput(MouseEvent mouseEvent) {
        if (mouseEvent.button == 0) {
            if (true) {
                System.out.println("In chest");
                if (mc.thePlayer.inventory.getCurrentItem() != null) {
                    System.out.println("Mouse 0 was clicked! Item grabbed: " + mc.thePlayer.inventory.getCurrentItem().getDisplayName().toString());
                }
            }
        }
    }
}