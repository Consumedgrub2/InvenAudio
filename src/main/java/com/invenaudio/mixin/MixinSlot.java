package com.invenaudio.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@Mixin(Slot.class)
public class MixinSlot {
    @Inject(method = "onPickupFromSlot(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/item/ItemStack;)V", at = @At("HEAD"))
    private void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack, CallbackInfo ci) {
    }
    
    @Inject(method = "putStack(Lnet/minecraft/item/ItemStack;)V", at = @At("HEAD"))
    private void putStack(ItemStack itemStack, CallbackInfo ci) {
    }
}