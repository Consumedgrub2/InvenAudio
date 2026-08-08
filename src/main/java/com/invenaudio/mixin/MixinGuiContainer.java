package com.invenaudio.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.invenaudio.InvenAudio;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;

@Mixin(GuiContainer.class)
public class MixinGuiContainer {
    @Inject(method = "handleMouseClick(Lnet/minecraft/inventory/Slot;III)V", at = @At("TAIL"))
    private void onSlotClick(Slot slot, int slotId, int button, int modifier, CallbackInfo ci) {
        // If the player picks up an item from a slot
        if (slot != null && slot.getHasStack()) {
            // If it's only a pickup or shift-click operation
            if (modifier == 0 || modifier == 1){
                String stackDisplayName = slot.getStack().getDisplayName();
                InvenAudio.playInventorySound(stackDisplayName);
            }
        }
        // If the player is already holding an item while over a slot
        else if (slot != null && InvenAudio.MC.thePlayer.inventory.getItemStack() != null && modifier == 0) {
            String stackDisplayName = InvenAudio.MC.thePlayer.inventory.getItemStack().getDisplayName();
            InvenAudio.playInventorySound(stackDisplayName);
        }
        // If the player clicks and drags items across slots
        else if (slot != null && InvenAudio.MC.thePlayer.inventory.getItemStack() != null && modifier == 5){
            String stackDisplayName = InvenAudio.MC.thePlayer.inventory.getItemStack().getDisplayName();
            // Prevent the sfx from being played multiple times during a drag operation
            if (!InvenAudio.playedDragSound) {
                InvenAudio.playInventorySound(stackDisplayName);
                InvenAudio.playedDragSound = true;
            }
        }
    }
}