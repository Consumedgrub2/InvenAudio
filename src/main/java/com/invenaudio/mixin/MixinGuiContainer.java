package com.invenaudio.mixin;

import com.invenaudio.Constants;
import com.invenaudio.InventoryHandler;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@Mixin(GuiContainer.class)
public class MixinGuiContainer {
    @Inject(method = "mouseClicked(III)V", at = @At("HEAD"))
    private void onMouseClicked(int mouseX, int mouseY, int button, CallbackInfo ci) {
        if (button == 0) {
            GuiContainer currentGui = InventoryHandler.currentOpenGuiContainer;
            ItemStack currentItemStack = Minecraft.getMinecraft().thePlayer.inventory.getItemStack();
            Constants.LOGGER.info(currentItemStack);
            @SuppressWarnings("unchecked") //Warning suppressed becuase 1.7.10 Minecraft uses old ass lists and not generic lists.
            List<Slot> invenSlots = currentGui.inventorySlots.inventorySlots;
            for (Slot slot : invenSlots) {
                Constants.LOGGER.info(slot.slotNumber);
            }
        }
    }
}