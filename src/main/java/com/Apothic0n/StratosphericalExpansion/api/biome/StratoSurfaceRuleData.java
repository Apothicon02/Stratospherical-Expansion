package com.Apothic0n.StratosphericalExpansion.api.biome;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class StratoSurfaceRuleData {
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource BLACKSTONE = makeStateRule(Blocks.BLACKSTONE);
    private static final SurfaceRules.RuleSource AMETHYST_BLOCK = makeStateRule(Blocks.AMETHYST_BLOCK);
    private static final SurfaceRules.RuleSource BASALT = makeStateRule(Blocks.BASALT);
    private static final SurfaceRules.RuleSource SMOOTH_BASALT = makeStateRule(Blocks.SMOOTH_BASALT);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);

    private static final SurfaceRules.RuleSource MOSS_BLOCK = makeStateRule(Blocks.MOSS_BLOCK);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource ROOTED_DIRT = makeStateRule(Blocks.ROOTED_DIRT);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.CALCITE);
    private static final SurfaceRules.RuleSource GRANITE = makeStateRule(Blocks.GRANITE);
    private static final SurfaceRules.RuleSource DIORITE = makeStateRule(Blocks.DIORITE);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource TUFF = makeStateRule(Blocks.TUFF);

    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final SurfaceRules.RuleSource BLUE_ICE = makeStateRule(Blocks.BLUE_ICE);
    private static final SurfaceRules.RuleSource ICE = makeStateRule(Blocks.ICE);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);

    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource RED_TERRACOTTA = makeStateRule(Blocks.RED_TERRACOTTA);
    private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource YELLOW_TERRACOTTA = makeStateRule(Blocks.YELLOW_TERRACOTTA);
    private static final SurfaceRules.RuleSource CYAN_TERRACOTTA = makeStateRule(Blocks.CYAN_TERRACOTTA);
    private static final SurfaceRules.RuleSource BROWN_TERRACOTTA = makeStateRule(Blocks.BROWN_TERRACOTTA);
    private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = makeStateRule(Blocks.WHITE_TERRACOTTA);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);

    public static SurfaceRules.RuleSource overworldLike(boolean p_198381_, boolean p_198382_, boolean p_198383_) {
        SurfaceRules.ConditionSource surfacerules$conditionsource = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);
        SurfaceRules.ConditionSource surfacerules$conditionsource1 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource2 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
        SurfaceRules.ConditionSource surfacerules$conditionsource3 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
        SurfaceRules.ConditionSource surfacerules$conditionsource4 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource5 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource6 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource7 = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource8 = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource9 = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.ConditionSource surfacerules$conditionsource10 = SurfaceRules.hole();
        SurfaceRules.ConditionSource surfacerules$conditionsource11 = SurfaceRules.isBiome(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN);
        SurfaceRules.ConditionSource surfacerules$conditionsource12 = SurfaceRules.steep();
        SurfaceRules.RuleSource surfacerules$rulesource = SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource8, GRASS_BLOCK), DIRT);
        SurfaceRules.RuleSource surfacerules$rulesource1 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
        SurfaceRules.RuleSource surfacerules$rulesource2 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
        SurfaceRules.ConditionSource surfacerules$conditionsource13 = SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.BEACH, Biomes.SNOWY_BEACH);
        SurfaceRules.ConditionSource surfacerules$conditionsource14 = SurfaceRules.isBiome(Biomes.DESERT);
        SurfaceRules.RuleSource surfacerules$rulesource3 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.STONY_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125D, 0.0125D), CALCITE), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.STONY_SHORE), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.GRAVEL, -0.05D, 0.05D), surfacerules$rulesource2), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_HILLS), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE)), SurfaceRules.ifTrue(surfacerules$conditionsource13, surfacerules$rulesource1), SurfaceRules.ifTrue(surfacerules$conditionsource14, surfacerules$rulesource1), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.DRIPSTONE_CAVES), STONE));
        SurfaceRules.RuleSource surfacerules$rulesource4 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D), SurfaceRules.ifTrue(surfacerules$conditionsource8, POWDER_SNOW));
        SurfaceRules.RuleSource surfacerules$rulesource5 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.35D, 0.6D), SurfaceRules.ifTrue(surfacerules$conditionsource8, POWDER_SNOW));
        SurfaceRules.RuleSource surfacerules$rulesource6 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, -0.5D, 0.2D), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, -0.0625D, 0.025D), ICE), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_SLOPES), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, STONE), surfacerules$rulesource4, SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.JAGGED_PEAKS), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), SurfaceRules.sequence(surfacerules$rulesource4, DIRT)), surfacerules$rulesource3, SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), DIRT), surfacerules$rulesource2)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), MUD), DIRT);
        SurfaceRules.RuleSource surfacerules$rulesource7 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, 0.0D, 0.2D), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, 0.0D, 0.025D), ICE), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_SLOPES), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, STONE), surfacerules$rulesource5, SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.JAGGED_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, STONE), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), SurfaceRules.sequence(surfacerules$rulesource5, SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), surfacerules$rulesource3, SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), surfacerules$rulesource), surfacerules$rulesource2)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PODZOL))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.ICE_SPIKES), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), MUD), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MUSHROOM_FIELDS), MYCELIUM), surfacerules$rulesource);
        SurfaceRules.ConditionSource surfacerules$conditionsource15 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);
        SurfaceRules.ConditionSource surfacerules$conditionsource16 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);
        SurfaceRules.ConditionSource surfacerules$conditionsource17 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);
        SurfaceRules.RuleSource surfacerules$rulesource8 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WOODED_BADLANDS), SurfaceRules.ifTrue(surfacerules$conditionsource, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource15, COARSE_DIRT), SurfaceRules.ifTrue(surfacerules$conditionsource16, COARSE_DIRT), SurfaceRules.ifTrue(surfacerules$conditionsource17, COARSE_DIRT), surfacerules$rulesource))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SWAMP), SurfaceRules.ifTrue(surfacerules$conditionsource5, SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource6), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), WATER)))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), SurfaceRules.ifTrue(surfacerules$conditionsource4, SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource6), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), WATER)))))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource1, ORANGE_TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource3, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource15, TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource16, TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource17, TERRACOTTA), SurfaceRules.bandlands())), SurfaceRules.ifTrue(surfacerules$conditionsource7, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND)), SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource10), ORANGE_TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource9, WHITE_TERRACOTTA), surfacerules$rulesource2)), SurfaceRules.ifTrue(surfacerules$conditionsource2, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource6, SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource3), ORANGE_TERRACOTTA)), SurfaceRules.bandlands())), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource9, WHITE_TERRACOTTA)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource7, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource11, SurfaceRules.ifTrue(surfacerules$conditionsource10, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource8, AIR), SurfaceRules.ifTrue(SurfaceRules.temperature(), ICE), WATER))), surfacerules$rulesource7))), SurfaceRules.ifTrue(surfacerules$conditionsource9, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource11, SurfaceRules.ifTrue(surfacerules$conditionsource10, WATER))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, surfacerules$rulesource6), SurfaceRules.ifTrue(surfacerules$conditionsource13, SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)), SurfaceRules.ifTrue(surfacerules$conditionsource14, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN), surfacerules$rulesource1), surfacerules$rulesource2)));
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();
        if (p_198382_) {
            builder.add(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK));
        }

        if (p_198383_) {
            builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        }

        SurfaceRules.RuleSource surfacerules$rulesource9 = SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, surfacerules$rulesource8);
        builder.add(p_198381_ ? surfacerules$rulesource9 : surfacerules$rulesource8);
        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray((p_198379_) -> {
            return new SurfaceRules.RuleSource[p_198379_];
        }));
    }

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.RuleSource snowyGlacialCliffs = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SNOW_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, CALCITE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), CALCITE));

        SurfaceRules.RuleSource frozenGlacialCliffs = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SNOW_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, CALCITE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), CALCITE));

        SurfaceRules.RuleSource grassyTerracottaMesa = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DIRT),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), TERRACOTTA));

        SurfaceRules.RuleSource sandyTerracottaMesa = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, RED_SAND)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, TERRACOTTA),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), TERRACOTTA));

        SurfaceRules.RuleSource mossyCalciteCliffs = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, MOSS_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DIORITE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), CALCITE));

        SurfaceRules.RuleSource grassyMudCliffs = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, MUD),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), TUFF));

        SurfaceRules.RuleSource grassyGraniteCliffs = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, GRANITE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), TUFF));

        SurfaceRules.RuleSource rootedCliffs = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, ROOTED_DIRT),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), TUFF));

        SurfaceRules.RuleSource snowyDepths = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SNOW_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SNOW_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), CALCITE));

        SurfaceRules.RuleSource myceliumBlackstoneCliffs = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, MYCELIUM)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, MUD),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), BLACKSTONE));

        SurfaceRules.RuleSource snowyCalciteCliffs = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SNOW_BLOCK)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, DIORITE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(96), 1), STONE),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(64), 1), DEEPSLATE),
                SurfaceRules.ifTrue(SurfaceRules.steep(), CALCITE));

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FLOWER_FOREST), grassyGraniteCliffs), //Lush Oak
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FOREST), grassyGraniteCliffs),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SUNFLOWER_PLAINS), grassyGraniteCliffs),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.PLAINS), grassyGraniteCliffs), //Mushroom Plains
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.TAIGA), grassyGraniteCliffs),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.OLD_GROWTH_PINE_TAIGA), grassyGraniteCliffs),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA), grassyGraniteCliffs),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MEADOW), grassyGraniteCliffs),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.BAMBOO_JUNGLE), grassyMudCliffs),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SPARSE_JUNGLE), grassyMudCliffs),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.JUNGLE), grassyMudCliffs), //Lush Jungle
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.BAMBOO_JUNGLE), grassyMudCliffs),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SWAMP), grassyMudCliffs), //Mega Swamp
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), grassyMudCliffs),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.DARK_FOREST), rootedCliffs), //Enriched Roofed Forest

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_FOREST), snowyGlacialCliffs), //Frozen Roofed Forest

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.OLD_GROWTH_BIRCH_FOREST), mossyCalciteCliffs),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.BIRCH_FOREST), mossyCalciteCliffs), //Lush Birch
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.CHERRY_GROVE), mossyCalciteCliffs),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_PLAINS), frozenGlacialCliffs), //Glacial Plains

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SAVANNA), grassyTerracottaMesa), //Mega Savanna
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SAVANNA_PLATEAU), grassyTerracottaMesa),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA), grassyTerracottaMesa),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MUSHROOM_FIELDS), myceliumBlackstoneCliffs), //Mushroom Grove

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.DESERT), sandyTerracottaMesa), //Lush Desert

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.ICE_SPIKES), snowyCalciteCliffs), //Icy Taiga
                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), snowyCalciteCliffs),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_TAIGA), snowyDepths) //Oversnowed Taiga
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }
}
