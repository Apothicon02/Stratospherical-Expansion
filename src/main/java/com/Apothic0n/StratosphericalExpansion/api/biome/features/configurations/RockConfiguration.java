package com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class RockConfiguration implements FeatureConfiguration {
    public static final Codec<RockConfiguration> CODEC = RecordCodecBuilder.create((fields) -> {
        return fields.group(BlockState.CODEC.fieldOf("blobMaterial").forGetter((v) -> {
            return v.blobMaterial;
        }), IntProvider.codec(1, 32).fieldOf("blobWidth").forGetter((v) -> {
            return v.blobWidth;
        }), IntProvider.codec(1, 128).fieldOf("blobHeight").forGetter((v) -> {
            return v.blobHeight;
        })).apply(fields, RockConfiguration::new);
    });

    public final BlockState blobMaterial;
    private final IntProvider blobWidth;
    private final IntProvider blobHeight;

    public RockConfiguration(BlockState blobMaterial, IntProvider blobWidth, IntProvider blobHeight) {
        this.blobMaterial = blobMaterial;
        this.blobWidth = blobWidth;
        this.blobHeight = blobHeight;
    }

    public IntProvider getBlobWidth() {return this.blobWidth;}
    public IntProvider getBlobHeight() {return this.blobHeight;}

}
