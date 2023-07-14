package com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class VerticalBlobConfiguration implements FeatureConfiguration {
    public static final Codec<VerticalBlobConfiguration> CODEC = RecordCodecBuilder.create((fields) -> {
        return fields.group(BlockState.CODEC.fieldOf("blockOn").forGetter((v) -> {
            return v.blockOn;
        }), BlockState.CODEC.fieldOf("blockOn2").forGetter((v) -> {
            return v.blockOn2;
        }), BlockState.CODEC.fieldOf("blobMaterial").forGetter((v) -> {
            return v.blobMaterial;
        }), IntProvider.codec(1, 1024).fieldOf("blobMass").forGetter((v) -> {
            return v.blobMass;
        }), IntProvider.codec(1, 32).fieldOf("blobWidth").forGetter((v) -> {
            return v.blobWidth;
        }), IntProvider.codec(1, 128).fieldOf("blobHeight").forGetter((v) -> {
            return v.blobHeight;
        })).apply(fields, VerticalBlobConfiguration::new);
    });
    public final BlockState blockOn;
    public final BlockState blockOn2;
    public final BlockState blobMaterial;
    private final IntProvider blobMass;
    private final IntProvider blobWidth;
    private final IntProvider blobHeight;

    public VerticalBlobConfiguration(BlockState blockOn, BlockState blockOn2, BlockState blobMaterial, IntProvider blobMass, IntProvider blobWidth, IntProvider blobHeight) {
        this.blockOn = blockOn;
        this.blockOn2 = blockOn2;
        this.blobMaterial = blobMaterial;
        this.blobMass = blobMass;
        this.blobWidth = blobWidth;
        this.blobHeight = blobHeight;
    }

    public IntProvider getBlobMass() {return this.blobMass;}
    public IntProvider getBlobWidth() {return this.blobWidth;}
    public IntProvider getBlobHeight() {return this.blobHeight;}

}
