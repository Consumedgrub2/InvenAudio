package com.invenaudio.mixin;

import com.invenaudio.Constants;
import com.invenaudio.InvenAudio;
import com.invenaudio.InventoryHandler;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@Mixin(GuiContainer.class)
public class MixinGuiContainer {
    @Inject(method = "handleMouseClick(Lnet/minecraft/inventory/Slot;III)V", at = @At("TAIL"))
    private void handleMouseClick(Slot slot, int slotId, int button, int modifier, CallbackInfo ci) {
        GuiContainer currentGui = InventoryHandler.currentOpenGuiContainer;
        if (currentGui != null && slot != null) {
            ItemStack currentItemStack = InvenAudio.MC.thePlayer.inventory.getItemStack();
            ItemStack slotStack = slot.getStack();
            Constants.LOGGER.info("handleMouseClick: slot=" + slot + ", slotId=" + slotId + ", button=" + button + ", modifier=" + modifier);
            //Just picked up an item from a slot
            if (currentItemStack != null) {
                Constants.LOGGER.info("Item: " + currentItemStack.getDisplayName());
            }
            //Just put an item in a slot
            else if (currentItemStack == null && slotStack != null){
                Constants.LOGGER.info("Item: " + slotStack.getDisplayName());
            }
        }
    }
}