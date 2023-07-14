package com.Apothic0n.StratosphericalExpansion.core.events;

import com.Apothic0n.StratosphericalExpansion.StratosphericalExpansion;
import com.Apothic0n.StratosphericalExpansion.core.objects.StratoBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StratosphericalExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonModEvents {

    @SubscribeEvent
    public static void itemUsed(PlayerInteractEvent.RightClickBlock event) {
        Level pLevel = event.getLevel();
        BlockPos pPos =  event.getHitVec().getBlockPos();
        BlockState pBlock = pLevel.getBlockState(pPos);
        ItemStack pStack = event.getItemStack();
        Player player = event.getEntity();
        if (!pLevel.isClientSide) { //Runs stuff on the server every time a player right-clicks a block
            if (pStack.getItem() == Items.GLOW_INK_SAC && pBlock.getBlock() == Blocks.AMETHYST_CLUSTER) {
                pLevel.setBlock(pPos, StratoBlocks.GLOWING_AMETHYST.get().withPropertiesOf(pBlock), 2);
                float f = Mth.randomBetween(pLevel.random, 0.8F, 1.2F);
                pLevel.playSound((Player)null, pPos, SoundEvents.DOLPHIN_EAT, SoundSource.BLOCKS, 1.0F, f);
                player.swing(event.getHand(), true);
                if (!player.isCreative()) {
                    pStack.setCount(pStack.getCount() - 1);
                }
            }
        }
    }

    //@SubscribeEvent
    //public static void biomeLoading(@Nonnull BiomeModifiers event) {
        //if (ModList.get().isLoaded("darkerdepths")) {
        //    event.getGeneration().addFeature(GenerationStep.Decoration.STRONGHOLDS, DDPlacedFeatures.SILVER_ORE);
        //    event.getGeneration().addFeature(GenerationStep.Decoration.STRONGHOLDS, DDPlacedFeatures.MAGMA_ORE);
        //    if (event.getName().toString().equals("strato:submerged_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.GLIMMERING_VINES);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.PETRIFIED_BRANCH);
        //    } else if (event.getName().toString().equals("strato:tropical_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.AMBER);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.GLIMMERING_VINES);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.HUGE_GLOWSHROOM);
        //        final Holder<PlacedFeature> SPARSE_GRIME_SURFACE = BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("strato", "sparse_grime_surface"), new PlacedFeature(Holder.hackyErase(DDConfiguredFeatures.GRIME_SURFACE), List.of(CountPlacement.of(UniformInt.of(112, 148)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome())));
        //        event.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, SPARSE_GRIME_SURFACE);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.PETRIFIED_BRANCH);
        //    } else if (event.getName().toString().equals("strato:lush_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.AMBER);
        //        final Holder<PlacedFeature> DENSE_PETRIFIED_BRANCH = BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation("strato", "dense_petrified_branch"), new PlacedFeature(Holder.hackyErase(DDConfiguredFeatures.PETRIFIED_BRANCH), List.of(CountPlacement.of(UniformInt.of(236, 254)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome())));
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DENSE_PETRIFIED_BRANCH);
        //    } else if (event.getName().toString().equals("strato:dripping_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.AMBER);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, DDPlacedFeatures.ARID_SURFACE);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.ARID_BOULDER);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.PETRIFIED_BRANCH);
        //    } else if (event.getName().toString().equals("strato:deep_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, DDPlacedFeatures.SHALE_SURFACE);
        //    } else if (event.getName().toString().equals("strato:molten_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DDPlacedFeatures.AMBER);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, DDPlacedFeatures.MOLTEN_POOL);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, DDPlacedFeatures.MOLTEN_SPRING);
        //    }
        //}
        //if (ModList.get().isLoaded("quark")) {
        //    if (event.getName().toString().equals("strato:tropical_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, placed_glow_shrooms);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, placed_glow_extras);
        //    }
        //}
        //if (ModList.get().isLoaded("galosphere")) {
        //    Holder<PlacedFeature> GALOSPHERE_LARGE_CEILING_ALLURITE_PLACED = PlacementUtils.register("large_ceiling_allurite", GConfiguredFeatures.LARGE_ALLURITE_CRYSTAL_CEILING, CountPlacement.of(UniformInt.of(60, 90)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        //    Holder<PlacedFeature> GALOSPHERE_CEILING_ALLURITE_PLACED = PlacementUtils.register("ceiling_allurite", GConfiguredFeatures.ALLURITE_CRYSTAL_CEILING, CountPlacement.of(UniformInt.of(90, 140)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        //    Holder<PlacedFeature> GALOSPHERE_LARGE_FLOOR_ALLURITE_PLACED = PlacementUtils.register("large_floor_allurite", GConfiguredFeatures.LARGE_ALLURITE_CRYSTAL_FLOOR, CountPlacement.of(UniformInt.of(48, 69)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        //    Holder<PlacedFeature> GALOSPHERE_FLOOR_ALLURITE_PLACED = PlacementUtils.register("floor_allurite", GConfiguredFeatures.ALLURITE_CRYSTAL_FLOOR, CountPlacement.of(UniformInt.of(45, 75)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());

        //    Holder<PlacedFeature> GALOSPHERE_LARGE_FLOOR_LUMIERE_PLACED = PlacementUtils.register("large_floor_lumiere", GConfiguredFeatures.LARGE_LUMIERE_CRYSTAL_FLOOR, CountPlacement.of(UniformInt.of(6, 20)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        //    Holder<PlacedFeature> GALOSPHERE_FLOOR_LUMIERE_PLACED = PlacementUtils.register("floor_lumiere", GConfiguredFeatures.LUMIERE_CRYSTAL_FLOOR, CountPlacement.of(UniformInt.of(10, 16)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());

        //    if (event.getName().toString().equals("strato:frozen_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, GALOSPHERE_LARGE_CEILING_ALLURITE_PLACED);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, GALOSPHERE_CEILING_ALLURITE_PLACED);
        //    } else if (event.getName().toString().equals("strato:lush_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, GALOSPHERE_LARGE_FLOOR_LUMIERE_PLACED);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, GALOSPHERE_FLOOR_LUMIERE_PLACED);
        //    } else if (event.getName().toString().equals("strato:submerged_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, GALOSPHERE_LARGE_CEILING_ALLURITE_PLACED);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, GALOSPHERE_CEILING_ALLURITE_PLACED);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, GALOSPHERE_FLOOR_ALLURITE_PLACED);
        //    } else if (event.getName().toString().equals("strato:glacial_cavity")) {
        //        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, GALOSPHERE_LARGE_FLOOR_ALLURITE_PLACED);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, GALOSPHERE_CEILING_ALLURITE_PLACED);
        //        event.getGeneration().addFeature(GenerationStep.Decoration.FLUID_SPRINGS, GALOSPHERE_FLOOR_ALLURITE_PLACED);
        //    }
        //}
    //}
}
