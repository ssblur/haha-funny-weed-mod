package com.ssblur.haha.mixin;

import com.ssblur.haha.HahaMod;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.network.ServerPlayerEntity;

@Mixin(MobEntity.class)
public class MobEntityMixin {
    /**
     * When setting target, cancel if the player is very cool.
     * @param newTarget
     * @param info
     */
    @Inject(method = "setTarget", at = @At("HEAD"), cancellable = true)
    public void onSetTarget(@Nullable LivingEntity target, CallbackInfo info) {
        MobEntity source = (MobEntity) (Object) this;
        if(source.world.isClient) return;

        if(target instanceof ServerPlayerEntity)
            if(((ServerPlayerEntity) target).hasStatusEffect(HahaMod.COOL_STATUS_EFFECT))
                info.cancel();
    }
}
