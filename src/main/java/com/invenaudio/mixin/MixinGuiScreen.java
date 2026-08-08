package com.invenaudio.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.invenaudio.InvenAudio;

import net.minecraft.client.gui.GuiScreen;

@Mixin(GuiScreen.class)
public class MixinGuiScreen {
    @Inject(method = "handleMouseInput()V", at = @At("TAIL"))
    private void handleMouseInput(CallbackInfo ci){
        // Reset the flag after mouse input is processed on Minecraft's end
        InvenAudio.playedDragSound = false;
    }
}