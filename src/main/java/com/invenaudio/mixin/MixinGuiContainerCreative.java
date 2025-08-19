package com.invenaudio.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.invenaudio.Constants;

import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.inventory.Slot;

@Mixin(GuiContainerCreative.class)
public class MixinGuiContainerCreative {
    @Inject(method = "handleMouseClick(Lnet/minecraft/inventory/Slot;III)V", at = @At("HEAD"))
    private void onSlotClick(Slot slot, int slotId, int button, int modifier, CallbackInfo ci) {
        if (slot != null) {
            Constants.LOGGER.info("Found the slot: " + slot.slotNumber);
        }
    }
}