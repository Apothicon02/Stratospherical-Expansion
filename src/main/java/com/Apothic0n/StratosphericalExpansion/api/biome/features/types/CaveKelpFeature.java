package com.Apothic0n.StratosphericalExpansion.api.biome.features.types;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CaveKelpFeature extends Feature<NoneFeatureConfiguration> {
    public CaveKelpFeature(Codec<NoneFeatureConfiguration> pContext) {
        super(pContext);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        int i = 0;
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource random = pContext.random();
        BlockPos blockpos1 = new BlockPos(blockpos.getX(), blockpos.above().getY(), blockpos.getZ());
        if (worldgenlevel.getBlockState(blockpos1).is(Blocks.WATER)) {
            BlockState blockstate = Blocks.KELP.defaultBlockState();
            BlockState blockstate1 = Blocks.KELP_PLANT.defaultBlockState();
            int k = 1 + random.nextInt(10);

            for(int l = 0; l <= k; ++l) {
                if (worldgenlevel.getBlockState(blockpos1).is(Blocks.WATER) && worldgenlevel.getBlockState(blockpos1.above()).is(Blocks.WATER) && blockstate1.canSurvive(worldgenlevel, blockpos1)) {
                    if (l == k) {
                        worldgenlevel.setBlock(blockpos1, blockstate.setValue(KelpBlock.AGE, Integer.valueOf(random.nextInt(4) + 20)), 2);
                        ++i;
                    } else {
                        worldgenlevel.setBlock(blockpos1, blockstate1, 2);
                    }
                } else if (l > 0) {
                    BlockPos blockpos2 = blockpos1.below();
                    if (blockstate.canSurvive(worldgenlevel, blockpos2) && !worldgenlevel.getBlockState(blockpos2.below()).is(Blocks.KELP)) {
                        worldgenlevel.setBlock(blockpos2, blockstate.setValue(KelpBlock.AGE, Integer.valueOf(random.nextInt(4) + 20)), 2);
                        ++i;
                    }
                    break;
                }

                blockpos1 = blockpos1.above();
            }
        }

        return i > 0;
    }
}
