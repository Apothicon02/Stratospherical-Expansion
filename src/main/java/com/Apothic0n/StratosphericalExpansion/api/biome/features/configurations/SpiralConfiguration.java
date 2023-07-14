package com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

public class SpiralConfiguration implements FeatureConfiguration {
    public static final Codec<SpiralConfiguration> CODEC = RecordCodecBuilder.create((fields) -> {
        return fields.group(ForgeRegistries.BLOCKS.getCodec().listOf().fieldOf("validBlocks").xmap(ImmutableSet::copyOf, ImmutableList::copyOf).forGetter((v) -> {
            return (ImmutableSet<Block>)v.validBlocks;
        }), BlockState.CODEC.fieldOf("stemMaterial").forGetter((v) -> {
            return v.stemMaterial;
        }), BlockState.CODEC.fieldOf("leafMaterial").forGetter((v) -> {
            return v.leafMaterial;
        }), IntProvider.codec(1, 1024).fieldOf("blobMass").forGetter((v) -> {
            return v.blobMass;
        }), IntProvider.codec(1, 32).fieldOf("blobWidth").forGetter((v) -> {
            return v.blobWidth;
        }), IntProvider.codec(1, 128).fieldOf("blobHeight").forGetter((v) -> {
            return v.blobHeight;
        })).apply(fields, SpiralConfiguration::new);
    });
    public final Set<Block> validBlocks;
    public final BlockState stemMaterial;
    public final BlockState leafMaterial;
    private final IntProvider blobMass;
    private final IntProvider blobWidth;
    private final IntProvider blobHeight;

    public SpiralConfiguration(Set<Block> validBlocks, BlockState stemMaterial, BlockState leafMaterial, IntProvider blobMass, IntProvider blobWidth, IntProvider blobHeight) {
        this.validBlocks = validBlocks;
        this.stemMaterial = stemMaterial;
        this.leafMaterial = leafMaterial;
        this.blobMass = blobMass;
        this.blobWidth = blobWidth;
        this.blobHeight = blobHeight;
    }

    public IntProvider getBlobMass() {return this.blobMass;}
    public IntProvider getBlobWidth() {return this.blobWidth;}
    public IntProvider getBlobHeight() {return this.blobHeight;}

}
