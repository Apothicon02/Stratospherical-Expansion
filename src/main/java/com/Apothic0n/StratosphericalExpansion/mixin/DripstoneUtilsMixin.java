package com.Apothic0n.StratosphericalExpansion.mixin;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.DripstoneUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DripstoneUtils.class)
public class DripstoneUtilsMixin {
    @Inject(at = @At("RETURN"), method = "isEmptyOrWaterOrLava(Lnet/minecraft/world/level/block/state/BlockState;)Z", cancellable = true)
    private static void strato_isEmptyOrWaterOrLava(BlockState p_159667_, CallbackInfoReturnable ci) {
        if (p_159667_.is(Blocks.FROSTED_ICE)) {
            ci.setReturnValue(true);
        }
    }
}
