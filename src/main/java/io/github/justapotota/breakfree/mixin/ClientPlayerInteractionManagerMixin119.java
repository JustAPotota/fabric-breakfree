package io.github.justapotota.breakfree.mixin;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin119 {
    @ModifyVariable(method = "isCurrentlyBreaking", at = @At("STORE"))
    private boolean bl(boolean original) {
        return true;
    }
}
