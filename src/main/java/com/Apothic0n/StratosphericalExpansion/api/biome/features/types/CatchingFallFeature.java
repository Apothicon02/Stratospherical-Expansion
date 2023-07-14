package com.Apothic0n.StratosphericalExpansion.api.biome.features.types;

import com.Apothic0n.StratosphericalExpansion.api.biome.features.configurations.CatchingFallConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class CatchingFallFeature extends Feature<CatchingFallConfiguration> {
    public CatchingFallFeature(Codec<CatchingFallConfiguration> pContext) {
        super(pContext);
    }

    public boolean place(FeaturePlaceContext<CatchingFallConfiguration> pContext) {
        CatchingFallConfiguration springconfiguration = pContext.config();
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        if (!springconfiguration.validBlocks.contains(worldgenlevel.getBlockState(blockpos.above()).getBlock().defaultBlockState())) {
            return false;
        } else if (springconfiguration.requiresBlockBelow && !springconfiguration.validBlocks.contains(worldgenlevel.getBlockState(blockpos.below()).getBlock())) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(blockpos);
            if (!blockstate.isAir() && !blockstate.is(springconfiguration.state.createLegacyBlock().getBlock()) && !springconfiguration.validBlocks.contains(blockstate.getBlock())) {
                return false;
            } else {
                int i = 0;
                int j = 0;
                if (springconfiguration.validBlocks.contains(worldgenlevel.getBlockState(blockpos.west()).getBlock())) {
                    ++j;
                }

                if (springconfiguration.validBlocks.contains(worldgenlevel.getBlockState(blockpos.east()).getBlock())) {
                    ++j;
                }

                if (springconfiguration.validBlocks.contains(worldgenlevel.getBlockState(blockpos.north()).getBlock())) {
                    ++j;
                }

                if (springconfiguration.validBlocks.contains(worldgenlevel.getBlockState(blockpos.south()).getBlock())) {
                    ++j;
                }

                if (springconfiguration.validBlocks.contains(worldgenlevel.getBlockState(blockpos.below()).getBlock())) {
                    ++j;
                }

                int k = 0;
                if (worldgenlevel.isEmptyBlock(blockpos.west())) {
                    ++k;
                }

                if (worldgenlevel.isEmptyBlock(blockpos.east())) {
                    ++k;
                }

                if (worldgenlevel.isEmptyBlock(blockpos.north())) {
                    ++k;
                }

                if (worldgenlevel.isEmptyBlock(blockpos.south())) {
                    ++k;
                }

                if (worldgenlevel.isEmptyBlock(blockpos.below())) {
                    ++k;
                }

                if (j >= springconfiguration.rockCount && k >= springconfiguration.holeCount) {
                    BlockPos blockpos1 = blockpos.below();
                    Boolean shouldGenerate = true;
                    if (!worldgenlevel.isEmptyBlock(blockpos1.below())) {
                        blockpos1 = blockpos1.above();
                        if (worldgenlevel.isEmptyBlock(blockpos1.north())) {
                            blockpos1 = blockpos1.north();
                        } else if (worldgenlevel.isEmptyBlock(blockpos1.east())) {
                            blockpos1 = blockpos1.east();
                        } else if (worldgenlevel.isEmptyBlock(blockpos1.south())) {
                            blockpos1 = blockpos1.south();
                        } else if (worldgenlevel.isEmptyBlock(blockpos1.west())) {
                            blockpos1 = blockpos1.west();
                        }
                    }
                    if (worldgenlevel.isEmptyBlock(blockpos1.below(5))) {
                        for(int l = 0; l < 200; ++l) {
                            BlockState blockBelow = worldgenlevel.getBlockState(blockpos1.below());

                            if (springconfiguration.validBlocks.contains(blockBelow.getBlock())) {
                                blockpos1 = blockpos1.below();
                                worldgenlevel.setBlock(blockpos1, springconfiguration.state.createLegacyBlock(), 2);
                                worldgenlevel.scheduleTick(blockpos1, springconfiguration.state.getType(), 0);
                                worldgenlevel.setBlock(blockpos1.north(), springconfiguration.state.createLegacyBlock(), 2);
                                worldgenlevel.scheduleTick(blockpos1.north(), springconfiguration.state.getType(), 0);
                                worldgenlevel.setBlock(blockpos1.east(), springconfiguration.state.createLegacyBlock(), 2);
                                worldgenlevel.scheduleTick(blockpos1.east(), springconfiguration.state.getType(), 0);
                                worldgenlevel.setBlock(blockpos1.south(), springconfiguration.state.createLegacyBlock(), 2);
                                worldgenlevel.scheduleTick(blockpos1.south(), springconfiguration.state.getType(), 0);
                                worldgenlevel.setBlock(blockpos1.west(), springconfiguration.state.createLegacyBlock(), 2);
                                worldgenlevel.scheduleTick(blockpos1.west(), springconfiguration.state.getType(), 0);

                                worldgenlevel.setBlock(blockpos1.south().south(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.south().south().south(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.south().south().above(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.south().south().south().above(), springconfiguration.basinMaterial.defaultBlockState(), 2);

                                worldgenlevel.setBlock(blockpos1.south().south().west(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.south().west(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.south().west().west(), springconfiguration.basinMaterial.defaultBlockState(), 2);

                                worldgenlevel.setBlock(blockpos1.west().west(), springconfiguration.basinMaterial.defaultBlockState(), 2);

                                worldgenlevel.setBlock(blockpos1.west().north(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.west().north().above(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.west().west().north(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.west().north().north(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.west().north().north().above(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.west().north().north().north(), springconfiguration.basinMaterial.defaultBlockState(), 2);

                                worldgenlevel.setBlock(blockpos1.north().north(), springconfiguration.basinMaterial.defaultBlockState(), 2);

                                worldgenlevel.setBlock(blockpos1.north().north().east(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.north().north().east().east(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.north().east(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.north().east().above(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.north().east().east().above(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.north().east().east(), springconfiguration.basinMaterial.defaultBlockState(), 2);

                                worldgenlevel.setBlock(blockpos1.east().east(), springconfiguration.basinMaterial.defaultBlockState(), 2);

                                worldgenlevel.setBlock(blockpos1.east().south(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.east().south().above(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.east().east().south(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.east().south().south(), springconfiguration.basinMaterial.defaultBlockState(), 2);
                                worldgenlevel.setBlock(blockpos1.east().east().south().south(), springconfiguration.basinMaterial.defaultBlockState(), 2);

                                l = 200;
                            } else if (springconfiguration.invalidBlocks.contains(blockBelow.getBlock())) { //cant generate over these to prevent large lava cast-like formations
                                l = 200;
                                shouldGenerate = false;
                            } else {
                                blockpos1 = blockpos1.below();
                            }
                        }
                        if (shouldGenerate) {
                            worldgenlevel.setBlock(blockpos, springconfiguration.state.createLegacyBlock(), 2);
                            worldgenlevel.scheduleTick(blockpos, springconfiguration.state.getType(), 0);
                        }
                    }
                    ++i;
                }
                return i > 0;
            }
        }
    }
}
