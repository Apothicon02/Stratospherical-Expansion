package com.Apothic0n.StratosphericalExpansion.api.biome.features;

import com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations.RockConfiguration;
import com.Apothic0n.StratosphericalExpansion.api.biome.features.types.SpheroidRockFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public abstract class StratoFeatureRegistry {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, com.Apothic0n.StratosphericalExpansion.StratosphericalExpansion.MODID);

    public static final RegistryObject<Feature<RockConfiguration>> SPHEROID_ROCK = FEATURES.register("spheroid_rock", () ->
            new SpheroidRockFeature(RockConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}

