package com.tizio.instantbrewingstand.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingStandBlockEntity.class)
public class InstantBrewing {

	@Inject(at = @At("HEAD"), method = "serverTick")
    private static void set(final ServerLevel level, final BlockPos pos, final BlockState blockState, final BrewingStandBlockEntity entity, CallbackInfo ci){
        ((BrewingStandBlockEntityAccessor)(entity)).setBrewTime(1);
    }

}