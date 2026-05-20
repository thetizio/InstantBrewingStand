package com.tizio.instantbrewingstand.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BrewingStandBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingStandBlockEntity.class)
public class InstantBrewing {

	@Shadow
	int brewTime;

	@Inject(method="tick",at= @At(value = "HEAD"))
	private static void set(World world, BlockPos pos, BlockState state, BrewingStandBlockEntity blockEntity, CallbackInfo ci){
		((InstantBrewing)(Object)(blockEntity)).brewTime = 1;
	}

}