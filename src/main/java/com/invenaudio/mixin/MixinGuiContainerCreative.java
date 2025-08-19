package com.invenaudio.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.invenaudio.InvenAudio;
import com.invenaudio.SoundResources;

import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.inventory.Slot;

@Mixin(GuiContainerCreative.class)
public class MixinGuiContainerCreative {
    @Inject(method = "handleMouseClick(Lnet/minecraft/inventory/Slot;III)V", at = @At("HEAD"))
    private void onSlotClick(Slot slot, int slotId, int button, int modifier, CallbackInfo ci) {
        //If the player picks up an item from a slot
        if (slot != null && slot.getHasStack()) {
            String stackDisplayName = slot.getStack().getDisplayName();
            if (stackDisplayName != null) {
                SoundResources.playInventorySound(SoundResources.getInventorySoundType(stackDisplayName));
            }
        }
        //If the player is already holding an item while over a slot
        else if (slot != null && InvenAudio.MC.thePlayer.inventory.getItemStack() != null) {
            String stackDisplayName = InvenAudio.MC.thePlayer.inventory.getItemStack().getDisplayName();
            if (stackDisplayName != null) {
                SoundResources.playInventorySound(SoundResources.getInventorySoundType(stackDisplayName));
            }
        }
    }
}