package io.gtihub.justapotota.breakfree.mixin;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Shadow private ItemStack selectedStack;

    @ModifyVariable(method = "isCurrentlyBreaking", at = @At("STORE"))
    private ItemStack stack(ItemStack stack) {
        return this.selectedStack;
    }
}
