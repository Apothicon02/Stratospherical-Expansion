package com.Apothic0n.StratosphericalExpansion.api.biome.features.types;

import com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations.FloatingBlobConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
public class FloatingBlobFeature extends Feature<FloatingBlobConfiguration> {
    public FloatingBlobFeature(Codec<FloatingBlobConfiguration> pContext) {
        super(pContext);
    }

    public boolean place(FeaturePlaceContext<FloatingBlobConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource random = pContext.random();
        FloatingBlobConfiguration config = pContext.config();
        Block blobSurfaceMaterial = config.blobSurfaceMaterial.getBlock();
        Block blobMaterial = config.blobMaterial.getBlock();
        Integer blobSize = config.getBlobSize().sample(random);
        Integer blobStretch = config.getBlobStretch().sample(random);
        float f = (float)(random.nextInt(3) + 4);

        for(int i = 0; f > blobSize*0.04; --i) {
            for(int j = Mth.floor(-f); j <= Mth.ceil(f); ++j) {
                for(int k = Mth.floor(-f); k <= Mth.ceil(f); ++k) {
                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
                        if (worldgenlevel.getBlockState(blockpos.offset(j, i+1, k)).isAir()) {
                            this.setBlock(worldgenlevel, blockpos.offset(j, i, k), blobSurfaceMaterial.defaultBlockState());
                        } else {
                            this.setBlock(worldgenlevel, blockpos.offset(j, i, k), blobMaterial.defaultBlockState());
                        }
                    }
                }
            }

            f = (float)((double)f - ((double)random.nextInt(blobStretch) + 0.5D));
        }

        return true;
    }
}
