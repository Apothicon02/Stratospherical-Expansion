package com.Apothic0n.StratosphericalExpansion.api.biome.features.types;

import com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations.SpiralConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Set;

public class SpiralFeature extends Feature<SpiralConfiguration> {
    public SpiralFeature(Codec<SpiralConfiguration> pContext) {
        super(pContext);
    }

    public boolean place(FeaturePlaceContext<SpiralConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource random = pContext.random();
        SpiralConfiguration config = pContext.config();
        Set<Block> validBlocks = config.validBlocks;
        Block stemMaterial = config.stemMaterial.getBlock();
        Block leafMaterial = config.leafMaterial.getBlock();
        Integer blobMass = config.getBlobMass().sample(random);
        Integer blobWidth = config.getBlobWidth().sample(random);
        Integer blobHeight = config.getBlobHeight().sample(random);
        if (!worldgenlevel.isEmptyBlock(blockpos) && validBlocks.contains(worldgenlevel.getBlockState(blockpos.above()).getBlock().defaultBlockState())) {
            worldgenlevel.setBlock(blockpos, stemMaterial.defaultBlockState(), 2);
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
            int spiralStep = 1;

            for (int i = 0; i < blobMass*4;) {
                int randomNumber2 = (int)(Math.random()*(4)+1);
                if (randomNumber2 >= 4/blobHeight) { //25% chance per number up to 4.
                    blockpos1 = new BlockPos(blockpos1.getX() + xFactor, blockpos1.getY() - 1, blockpos1.getZ() + zFactor);
                } else {
                    blockpos1 = new BlockPos(blockpos1.getX(), blockpos1.getY() - 1, blockpos1.getZ());
                }
                worldgenlevel.setBlock(blockpos1, stemMaterial.defaultBlockState(), 2);
                worldgenlevel.setBlock(blockpos1.below(), stemMaterial.defaultBlockState(), 2);
                worldgenlevel.setBlock(blockpos1.above(), stemMaterial.defaultBlockState(), 2);
                if (spiralStep == 1) {
                    worldgenlevel.setBlock(blockpos1.north(), stemMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.east(), stemMaterial.defaultBlockState(), 2);
                } else if (spiralStep == 2) {
                    worldgenlevel.setBlock(blockpos1.east(), stemMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.south(), stemMaterial.defaultBlockState(), 2);
                } else if (spiralStep == 3) {
                    worldgenlevel.setBlock(blockpos1.south(), stemMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.west(), stemMaterial.defaultBlockState(), 2);
                } else if (spiralStep == 4) {
                    worldgenlevel.setBlock(blockpos1.west(), stemMaterial.defaultBlockState(), 2);
                    worldgenlevel.setBlock(blockpos1.north(), stemMaterial.defaultBlockState(), 2);
                    spiralStep = 0;
                }
                int xDistance = blockpos1.getX() - blockpos.getX();
                int zDistance = blockpos1.getZ() - blockpos.getZ();
                if (xDistance >= blobWidth || zDistance >= blobWidth) {
                    break;
                } else if (randomNumber2 >= 4/blobHeight && !(xDistance >= blobWidth - 4) && !(zDistance >= blobWidth - 4) && !leafMaterial.defaultBlockState().isAir()) {
                    for (int b = 1; b <= 4;) {
                        int randomNumber3 = (int)(Math.random()*(2));
                        if (randomNumber3 >= 1) {
                            placeBranch(worldgenlevel, blockpos1.below(b).north(randomNumber3).east(randomNumber3 - 1), leafMaterial.defaultBlockState());
                            b++;
                        } else {
                            b = 5;
                            int randomNumber4 = (int)(Math.random()*(8));
                            if (randomNumber4 >= 7 && Blocks.WARPED_WART_BLOCK.equals(leafMaterial)) {
                                worldgenlevel.setBlock(blockpos1.below(b), Blocks.SHROOMLIGHT.defaultBlockState(), 2);
                            }
                        }
                    }
                }
                spiralStep++;
                i += 3;
            }
            return true;
        }
        return false;
    }

    private void placeBranch(WorldGenLevel level, BlockPos blockPos, BlockState material) {
        placeLeafBlock(level, blockPos.north(), material);
        placeLeafBlock(level, blockPos.east(), material);
        placeLeafBlock(level, blockPos.south(), material);
        placeLeafBlock(level, blockPos.west(), material);
        placeLeafBlock(level, blockPos.north().east(), material);
        placeLeafBlock(level, blockPos.south().east(), material);
        placeLeafBlock(level, blockPos.north().west(), material);
        placeLeafBlock(level, blockPos.south().west(), material);
        blockPos = blockPos.below();
        placeLeafBlock(level, blockPos.north().east(), material);
        placeLeafBlock(level, blockPos.south().east(), material);
        placeLeafBlock(level, blockPos.north().west(), material);
        placeLeafBlock(level, blockPos.south().west(), material);
    }

    private void placeLeafBlock(WorldGenLevel level, BlockPos blockPos, BlockState material) {
        if (level.getBlockState(blockPos).isAir()) {
            level.setBlock(blockPos, material, 2);
        }
    }
}
