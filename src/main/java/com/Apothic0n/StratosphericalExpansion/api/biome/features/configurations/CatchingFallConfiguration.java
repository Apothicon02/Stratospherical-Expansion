package com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

public class CatchingFallConfiguration implements FeatureConfiguration {
    public static final Codec<CatchingFallConfiguration> CODEC = RecordCodecBuilder.create((fields) -> {
        return fields.group(FluidState.CODEC.fieldOf("state").forGetter((v) -> {
            return v.state;
        }), Codec.BOOL.fieldOf("requires_block_below").orElse(true).forGetter((v) -> {
            return v.requiresBlockBelow;
        }), Codec.INT.fieldOf("rock_count").orElse(4).forGetter((v) -> {
            return v.rockCount;
        }), Codec.INT.fieldOf("hole_count").orElse(1).forGetter((v) -> {
            return v.holeCount;
        }), ForgeRegistries.BLOCKS.getCodec().listOf().fieldOf("validBlocks").xmap(ImmutableSet::copyOf, ImmutableList::copyOf).forGetter((v) -> {
            return (ImmutableSet<Block>)v.validBlocks;
        }), ForgeRegistries.BLOCKS.getCodec().listOf().fieldOf("invalidBlocks").xmap(ImmutableSet::copyOf, ImmutableList::copyOf).forGetter((v) -> {
            return (ImmutableSet<Block>) v.validBlocks;
        }), ForgeRegistries.BLOCKS.getCodec().fieldOf("basinMaterial").forGetter((v) -> {
            return v.basinMaterial;
        }), ForgeRegistries.BLOCKS.getCodec().fieldOf("basinMaterial2").forGetter((v) -> {
            return v.basinMaterial2;
        })).apply(fields, CatchingFallConfiguration::new);
    });
    public final FluidState state;
    public final boolean requiresBlockBelow;
    public final int rockCount;
    public final int holeCount;
    public final Set<Block> validBlocks;
    public final Set<Block> invalidBlocks;
    public final Block basinMaterial;
    public final Block basinMaterial2;

    public CatchingFallConfiguration(FluidState fluidState, boolean requiresBlockBelow, int rockCount, int holeCount, Set<Block> validBlocks, Set<Block> invalidBlocks, Block basinMaterial, Block basinMaterial2) {
        this.state = fluidState;
        this.requiresBlockBelow = requiresBlockBelow;
        this.rockCount = rockCount;
        this.holeCount = holeCount;
        this.validBlocks = validBlocks;
        this.invalidBlocks = invalidBlocks;
        this.basinMaterial = basinMaterial;
        this.basinMaterial2 = basinMaterial2;
    }
}