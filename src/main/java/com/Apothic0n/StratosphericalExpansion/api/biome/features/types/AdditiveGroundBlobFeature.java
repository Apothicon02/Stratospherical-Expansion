package com.Apothic0n.StratosphericalExpansion.api.biome.features.types;

import com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations.VerticalBlobConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class AdditiveGroundBlobFeature extends Feature<VerticalBlobConfiguration> {
    public AdditiveGroundBlobFeature(Codec<VerticalBlobConfiguration> pContext) {super(pContext);}

    public boolean place(FeaturePlaceContext<VerticalBlobConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource random = pContext.random();
        VerticalBlobConfiguration config = pContext.config();
        Block standOn = config.blockOn.getBlock();
        Block standOn2 = config.blockOn2.getBlock();
        Block blobMaterial = config.blobMaterial.getBlock();
        Integer blobMass = config.getBlobMass().sample(random);
        Integer blobWidth = config.getBlobWidth().sample(random);
        Integer blobHeight = config.getBlobHeight().sample(random);
        if (worldgenlevel.isEmptyBlock(blockpos)) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(blockpos.below());
            if (!blockstate.is(standOn) && !blockstate.is(standOn2) && !blockstate.is(blobMaterial)) {
                return false;
            } else {
                worldgenlevel.setBlock(blockpos, blobMaterial.defaultBlockState(), 2);
                for(int i = 0; i < blobMass; ++i) {
                    BlockPos blockpos1 = blockpos.offset(random.nextInt(blobWidth) - random.nextInt(blobWidth), random.nextInt(blobHeight), random.nextInt(blobWidth) - random.nextInt(blobWidth));
                    BlockState blockBelow = worldgenlevel.getBlockState(blockpos1.below());
                    if (blockBelow.is(standOn) || blockBelow.is(standOn2) || blockBelow.is(blobMaterial)) {
                        worldgenlevel.setBlock(blockpos1, blobMaterial.defaultBlockState(), 2);
                    }
                }
                return true;
            }
        }
    }
}
