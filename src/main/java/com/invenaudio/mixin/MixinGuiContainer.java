package com.invenaudio.mixin;

import com.invenaudio.Constants;
import com.invenaudio.InventoryHandler;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.inventory.GuiContainer;

@Mixin(GuiContainer.class)
public class MixinGuiContainer {
    @Inject(method = "mouseClicked(III)V", at = @At("HEAD"))
    private void onMouseClicked(int mouseX, int mouseY, int button, CallbackInfo ci) {
        Constants.LOGGER.info("Clicked the mouse! " + mouseX + " " + mouseY + " Button: " + button);
        if (button == 0) {
            GuiContainer currentGui = InventoryHandler.currentOpenGuiContainer;
            Constants.LOGGER.info(currentGui);
        }
    }
}