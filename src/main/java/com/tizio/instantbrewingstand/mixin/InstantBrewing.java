package com.tizio.instantbrewingstand.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.world.level.block.entity.BrewingStandBlockEntity.class)
public class InstantBrewing {

    @Inject(method="serverTick",at= @At(value = "HEAD"))
    private static void set(Level level, BlockPos pos, BlockState state, BrewingStandBlockEntity blockEntity, CallbackInfo ci){
        ((BrewingStandBlockEntityAccessor)(blockEntity)).setBrewTime(1);
    }

}