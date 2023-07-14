package com.Apothic0n.StratosphericalExpansion.api.biome.features.types;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.DripstoneUtils;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.LargeDripstoneConfiguration;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;

public class LargeGranitePillarFeature extends Feature<LargeDripstoneConfiguration> {
    public LargeGranitePillarFeature(Codec<LargeDripstoneConfiguration> pContext) {
        super(pContext);
    }

    public boolean place(FeaturePlaceContext<LargeDripstoneConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource random = pContext.random();
        LargeDripstoneConfiguration config = pContext.config();

        if (!DripstoneUtils.isEmptyOrWaterOrLava(worldgenlevel, blockpos)) {
            return false;
        } else {
            Optional<Column> optional = Column.scan(worldgenlevel, blockpos, config.floorToCeilingSearchRange, DripstoneUtils::isEmptyOrWater, DripstoneUtils::isDripstoneBaseOrLava);
            if (optional.isPresent() && optional.get() instanceof Column.Range) {
                Column.Range column$range = (Column.Range) optional.get();
                if (column$range.height() < 4) {
                    return false;
                } else {
                    int i = (int) ((float) column$range.height() * config.maxColumnRadiusToCaveHeightRatio);
                    int j = Mth.clamp(i, config.columnRadius.getMinValue(), config.columnRadius.getMaxValue());
                    int k = Mth.randomBetweenInclusive(random, config.columnRadius.getMinValue(), j);
                    LargePillar largepillarfeature$largepillar = makeGranite(blockpos.atY(column$range.ceiling() - 1), false, random, k, config.stalactiteBluntness, config.heightScale);
                    LargePillar largepillarfeature$largepillar1 = makeGranite(blockpos.atY(column$range.floor() + 1), true, random, k, config.stalagmiteBluntness, config.heightScale);
                    WindOffsetter largepillarfeature$windoffsetter;
                    if (largepillarfeature$largepillar.isSuitableForWind(config) && largepillarfeature$largepillar1.isSuitableForWind(config)) {
                        largepillarfeature$windoffsetter = new WindOffsetter(blockpos.getY(), random, config.windSpeed);
                    } else {
                        largepillarfeature$windoffsetter = WindOffsetter.noWind();
                    }

                    boolean flag = largepillarfeature$largepillar.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(worldgenlevel, largepillarfeature$windoffsetter);
                    boolean flag1 = largepillarfeature$largepillar1.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(worldgenlevel, largepillarfeature$windoffsetter);
                    if (flag) {
                        largepillarfeature$largepillar.placeBlocks(worldgenlevel, random, largepillarfeature$windoffsetter);
                    }

                    if (flag1) {
                        largepillarfeature$largepillar1.placeBlocks(worldgenlevel, random, largepillarfeature$windoffsetter);
                    }

                    return true;
                }
            } else {
                return false;
            }
        }
    }
    private static LargePillar makeGranite(BlockPos pRoot, boolean pPointingUp, RandomSource pRandom, int pRadius, FloatProvider pBluntnessBase, FloatProvider pScaleBase) {
        return new LargePillar(pRoot, pPointingUp, pRadius, (double)pBluntnessBase.sample(pRandom), (double)pScaleBase.sample(pRandom));
    }

    static final class LargePillar {
        private BlockPos root;
        private final boolean pointingUp;
        private int radius;
        private final double bluntness;
        private final double scale;

        LargePillar(BlockPos pRoot, boolean pPointingUp, int pRadius, double pBluntness, double pScale) {
            this.root = pRoot;
            this.pointingUp = pPointingUp;
            this.radius = pRadius;
            this.bluntness = pBluntness;
            this.scale = pScale;
        }

        private int getHeight() {
            return this.getHeightAtRadius(0.0F);
        }

        private int getMinY() {
            return this.pointingUp ? this.root.getY() : this.root.getY() - this.getHeight();
        }

        private int getMaxY() {
            return !this.pointingUp ? this.root.getY() : this.root.getY() + this.getHeight();
        }

        boolean moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(WorldGenLevel pLevel, WindOffsetter pWindOffsetter) {
            while(this.radius > 1) {
                BlockPos.MutableBlockPos blockpos$mutableblockpos = this.root.mutable();
                int i = Math.min(10, this.getHeight());

                for(int j = 0; j < i; ++j) {
                    if (pLevel.getBlockState(blockpos$mutableblockpos).is(Blocks.LAVA)) {
                        return false;
                    }

                    if (DripstoneUtils.isCircleMostlyEmbeddedInStone(pLevel, pWindOffsetter.offset(blockpos$mutableblockpos), this.radius)) {
                        this.root = blockpos$mutableblockpos;
                        return true;
                    }

                    blockpos$mutableblockpos.move(this.pointingUp ? Direction.DOWN : Direction.UP);
                }

                this.radius /= 2;
            }

            return false;
        }

        private int getHeightAtRadius(float pRadius) {
            return (int)DripstoneUtils.getDripstoneHeight((double)pRadius, (double)this.radius, this.scale, this.bluntness);
        }

        void placeBlocks(WorldGenLevel pLevel, RandomSource pRandom, WindOffsetter pWindOffsetter) {
            for(int i = -this.radius; i <= this.radius; ++i) {
                for(int j = -this.radius; j <= this.radius; ++j) {
                    float f = Mth.sqrt((float)(i * i + j * j));
                    if (!(f > (float)this.radius)) {
                        int k = this.getHeightAtRadius(f);
                        if (k > 0) {
                            if ((double)pRandom.nextFloat() < 0.2D) {
                                k = (int)((float)k * Mth.randomBetween(pRandom, 0.8F, 1.0F));
                            }

                            BlockPos.MutableBlockPos blockpos$mutableblockpos = this.root.offset(i, 0, j).mutable();
                            boolean flag = false;
                            int l = this.pointingUp ? pLevel.getHeight(Heightmap.Types.WORLD_SURFACE_WG, blockpos$mutableblockpos.getX(), blockpos$mutableblockpos.getZ()) : Integer.MAX_VALUE;

                            for(int i1 = 0; i1 < k && blockpos$mutableblockpos.getY() < l; ++i1) {
                                BlockPos blockpos = pWindOffsetter.offset(blockpos$mutableblockpos);
                                if (DripstoneUtils.isEmptyOrWaterOrLava(pLevel, blockpos)) {
                                    flag = true;
                                    Block block = Blocks.GRANITE;
                                    pLevel.setBlock(blockpos, block.defaultBlockState(), 2);
                                } else if (flag && pLevel.getBlockState(blockpos).is(BlockTags.BASE_STONE_OVERWORLD) || flag && pLevel.getBlockState(blockpos).is(Blocks.ICE) || flag && pLevel.getBlockState(blockpos).is(Blocks.PACKED_ICE)) {
                                    break;
                                }

                                blockpos$mutableblockpos.move(this.pointingUp ? Direction.UP : Direction.DOWN);
                            }
                        }
                    }
                }
            }

        }

        boolean isSuitableForWind(LargeDripstoneConfiguration pConfig) {
            return this.radius >= pConfig.minRadiusForWind && this.bluntness >= (double)pConfig.minBluntnessForWind;
        }
    }

    static final class WindOffsetter {
        private final int originY;
        @Nullable
        private final Vec3 windSpeed;

        WindOffsetter(int pOriginY, RandomSource pRandom, FloatProvider pMagnitude) {
            this.originY = pOriginY;
            float f = pMagnitude.sample(pRandom);
            float f1 = Mth.randomBetween(pRandom, 0.0F, (float)Math.PI);
            this.windSpeed = new Vec3((double)(Mth.cos(f1) * f), 0.0D, (double)(Mth.sin(f1) * f));
        }

        private WindOffsetter() {
            this.originY = 0;
            this.windSpeed = null;
        }

        static WindOffsetter noWind() {
            return new WindOffsetter();
        }

        BlockPos offset(BlockPos pPos) {
            if (this.windSpeed == null) {
                return pPos;
            } else {
                int i = this.originY - pPos.getY();
                Vec3 vec3 = this.windSpeed.scale((double)i);
                return pPos.offset((int) vec3.x, 0, (int) vec3.z);
            }
        }
    }
}
