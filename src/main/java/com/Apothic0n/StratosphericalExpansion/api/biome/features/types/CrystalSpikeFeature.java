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

public class CrystalSpikeFeature extends Feature<VerticalBlobConfiguration> {
    public CrystalSpikeFeature(Codec<VerticalBlobConfiguration> pContext) {
        super(pContext);
    }

    public boolean place(FeaturePlaceContext<VerticalBlobConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource random = pContext.random();
        VerticalBlobConfiguration config = pContext.config();
        Block hangFrom = config.blockOn.getBlock();
        Block hangFrom2 = config.blockOn2.getBlock();
        Block blobMaterial = config.blobMaterial.getBlock();
        Integer blobMass = config.getBlobMass().sample(random);
        Integer blobWidth = config.getBlobWidth().sample(random);
        Integer blobHeight = config.getBlobHeight().sample(random);
        if (worldgenlevel.isEmptyBlock(blockpos)) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(blockpos.above());
            if (!blockstate.is(hangFrom) && !blockstate.is(hangFrom2) && !blockstate.is(blobMaterial)) {
                return false;
            } else {
                worldgenlevel.setBlock(blockpos, blobMaterial.defaultBlockState(), 2);
                BlockPos blockpos1 = blockpos;
                boolean northNegative = false;//x
                boolean eastNegative = false;//z
                int randomNumber = (int)(Math.random()*(4-1+1)+1);
                if (randomNumber >= 4) {
                    northNegative = true;
                    eastNegative = true;
                } else if (randomNumber >= 3) {
                    northNegative = true;
                } else if (randomNumber >= 2) {
                    eastNegative = true;
                }
                int xFactor = 1;
                int zFactor = 1;
                if (northNegative) {xFactor = -1;}
                if (eastNegative) {zFactor = -1;}

                for (int i = 0; i < blobMass*4; ++i) {
                    int randomNumber2 = (int)(Math.random()*(4)+1);
                    if (randomNumber2 >= 4/blobHeight) { //25% chance per number up to 4.
                        blockpos1 = new BlockPos(blockpos1.getX() + xFactor, blockpos1.getY() - 1, blockpos1.getZ() + zFactor);
                    } else {
                        blockpos1 = new BlockPos(blockpos1.getX(), blockpos1.getY() - 1, blockpos1.getZ());
                    }
                    int xDistance = blockpos1.getX() - blockpos.getX();
                    int zDistance = blockpos1.getZ() - blockpos.getZ();
                    if (xDistance >= blobWidth || zDistance >= blobWidth) {
                        i = blobMass*5;
                    }
                    worldgenlevel.setBlock(blockpos1, blobMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.below(), blobMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.above(), blobMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.east(), blobMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.south(), blobMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.west(), blobMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.north(), blobMaterial.defaultBlockState(), 2);
                    i += 3;
                }
                return true;
            }
        }
    }
}
