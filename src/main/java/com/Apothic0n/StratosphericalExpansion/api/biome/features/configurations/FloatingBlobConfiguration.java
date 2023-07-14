package com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class FloatingBlobConfiguration implements FeatureConfiguration {
    public static final Codec<FloatingBlobConfiguration> CODEC = RecordCodecBuilder.create((fields) -> {
        return fields.group(BlockState.CODEC.fieldOf("blobSurfaceMaterial").forGetter((v) -> {
            return v.blobSurfaceMaterial;
        }), BlockState.CODEC.fieldOf("blobMaterial").forGetter((v) -> {
            return v.blobMaterial;
        }), IntProvider.codec(1, 1024).fieldOf("blobSize").forGetter((v) -> {
            return v.blobSize;
        }), IntProvider.codec(1, 6).fieldOf("blobStretch").forGetter((v) -> {
            return v.blobStretch;
        })).apply(fields, FloatingBlobConfiguration::new);
    });
    public final BlockState blobSurfaceMaterial;
    public final BlockState blobMaterial;
    private final IntProvider blobSize;
    private final IntProvider blobStretch;

    public FloatingBlobConfiguration(BlockState blobSurfaceMaterial, BlockState blobMaterial, IntProvider blobSize, IntProvider blobStretch) {
        this.blobSurfaceMaterial = blobSurfaceMaterial;
        this.blobMaterial = blobMaterial;
        this.blobSize = blobSize;
        this.blobStretch = blobStretch;
    }

    public IntProvider getBlobSize() {return this.blobSize;}
    public IntProvider getBlobStretch() {return this.blobStretch;}
}
