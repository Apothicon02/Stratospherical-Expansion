package com.Apothic0n.StratosphericalExpansion.world.dimension;

import com.Apothic0n.StratosphericalExpansion.StratosphericalExpansion;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class StratoDimensions {
    public static ResourceKey<Level> StratoDim = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(StratosphericalExpansion.MODID, "stratospherical"));
}
