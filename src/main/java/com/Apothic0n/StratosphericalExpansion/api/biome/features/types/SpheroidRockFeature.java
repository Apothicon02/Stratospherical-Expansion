package com.Apothic0n.StartosphericalExpansion.api.biome.features.types;

import com.Apothic0n.StartosphericalExpansion.api.biome.features.configurations.RockConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Random;

public class SpheroidRockFeature extends Feature<RockConfiguration> {
    public SpheroidRockFeature(Codec<RockConfiguration> pContext) {
        super(pContext);
    }

    public boolean place(FeaturePlaceContext<RockConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        Random random = pContext.random();
        RockConfiguration config = pContext.config();
        Block blobMaterial = config.blobMaterial.getBlock();
        Integer blobWidth = config.getBlobWidth().sample(random);
        Integer blobHeight = config.getBlobHeight().sample(random);
        blobHeight++;
        if (worldgenlevel.isEmptyBlock(blockpos.below())) {
            return false;
        } else {
            Integer blobWidth1 = blobWidth;
            for (int h = 0; h < blobHeight; ++h) {
                if (blobWidth1 > 0) {
                    for (int w = 0; w < blobWidth1; ++w) {
                        for (int l = 0; l < blobWidth1; ++l) {
                            int randomNumber = (int)(Math.random()*(42-1+1)+1);
                            if (randomNumber < 42) {
                                worldgenlevel.setBlock(blockpos.offset(-w, h, l), blobMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos.offset(-w, -h, -l), blobMaterial.defaultBlockState(), 2);
                                int randomNumber2 = (int)(Math.random()*(33-1+1)+1);
                                if (randomNumber2 < 33) {
                                    worldgenlevel.setBlock(blockpos.offset(-w, h, -l), blobMaterial.defaultBlockState(), 2);
                                    worldgenlevel.setBlock(blockpos.offset(-w, -h, l), blobMaterial.defaultBlockState(), 2);
                                    int randomNumber3 = (int)(Math.random()*(27-1+1)+1);
                                    if (randomNumber3 < 27) {
                                        worldgenlevel.setBlock(blockpos.offset(w, h, l), blobMaterial.defaultBlockState(), 2);
                                        worldgenlevel.setBlock(blockpos.offset(w, -h, -l), blobMaterial.defaultBlockState(), 2);
                                        int randomNumber4 = (int)(Math.random()*(20-1+1)+1);
                                        if (randomNumber4 < 20) {
                                            worldgenlevel.setBlock(blockpos.offset(w, h, -l), blobMaterial.defaultBlockState(), 2);
                                            worldgenlevel.setBlock(blockpos.offset(w, -h, l), blobMaterial.defaultBlockState(), 2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (h == blobHeight-2) {
                    blobWidth1--;
                }
            }
            return true;
        }
    }
}