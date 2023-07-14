package com.Apothic0n.StratosphericalExpansion.api.biome.features.types;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CavePickleFeature extends Feature<NoneFeatureConfiguration> {
    public CavePickleFeature(Codec<NoneFeatureConfiguration> pContext) {
        super(pContext);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        RandomSource random = pContext.random();
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        BlockPos blockpos1 = new BlockPos(blockpos.getX(), blockpos.above().getY(), blockpos.getZ());
        BlockState blockstate = Blocks.SEA_PICKLE.defaultBlockState().setValue(SeaPickleBlock.PICKLES, Integer.valueOf(random.nextInt(4) + 1));
        if (worldgenlevel.getBlockState(blockpos1).is(Blocks.WATER) && blockstate.canSurvive(worldgenlevel, blockpos1)) {
            worldgenlevel.setBlock(blockpos1, blockstate, 2);
            return true;
        } else {
            return false;
        }
    }
}
