package io.github.justapotota.breakfree.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ConfigPlugin implements IMixinConfigPlugin {
    private SemanticVersion v1_20;

    private Version minecraftVersion;

    @Override
    public void onLoad(String mixinPackage) {
        try {
            this.v1_20 = SemanticVersion.parse("1.20");
        } catch (VersionParsingException e) {
            throw new RuntimeException(e);
        }

        this.minecraftVersion = FabricLoader.getInstance().getModContainer("minecraft").get().getMetadata().getVersion();
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (Objects.equals(mixinClassName, "io.github.justapotota.breakfree.mixin.ClientPlayerInteractionManagerMixin120")) {
            return this.v1_20.compareTo(this.minecraftVersion) <= 0;
        } else if (Objects.equals(mixinClassName, "io.github.justapotota.breakfree.mixin.ClientPlayerInteractionManagerMixin119")) {
            return this.v1_20.compareTo(this.minecraftVersion) > 0;
        }
        return false;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return Collections.emptyList();
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
