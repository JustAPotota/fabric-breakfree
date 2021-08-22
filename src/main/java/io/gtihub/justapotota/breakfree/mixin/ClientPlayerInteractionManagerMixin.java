package io.gtihub.justapotota.breakfree.mixin;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @ModifyVariable(method = "isCurrentlyBreaking(Lnet/minecraft/util/math/BlockPos;)Z", at = @At("STORE"))
    private boolean bl(boolean original) {
        return true;
    }
}
