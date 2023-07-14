package com.Apothic0n.StratosphericalExpansion.core.objects;

import com.Apothic0n.StratosphericalExpansion.StratosphericalExpansion;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.level.block.Blocks.AMETHYST_CLUSTER;

public final class StratoBlocks {
    private StratoBlocks() {}

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, StratosphericalExpansion.MODID);

    public static final RegistryObject<Block> AMETHYST_VINES = BLOCKS.register("amethyst_vines", () ->
            new AmethystVinesBlock(BlockBehaviour.Properties.copy(AMETHYST_CLUSTER)
                    .randomTicks().strength(0.2F).noCollission().sound(SoundType.MEDIUM_AMETHYST_BUD)));

    public static final RegistryObject<Block> AMETHYST_VINES_PLANT = BLOCKS.register("amethyst_vines_plant", () ->
            new AmethystVinesBlock(BlockBehaviour.Properties.copy(AMETHYST_CLUSTER)
                    .noCollission().strength(0.2F).sound(SoundType.LARGE_AMETHYST_BUD)));

    public static final RegistryObject<Block> GLOWING_AMETHYST = BLOCKS.register("glowing_amethyst", () ->
            new GlowingAmethystBlock(3, 4, BlockBehaviour.Properties.copy(AMETHYST_CLUSTER)
                    .lightLevel(brightness -> {return 11;})));

    public static void fixBlockRenderLayers() {
            ItemBlockRenderTypes.setRenderLayer(AMETHYST_VINES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(AMETHYST_VINES_PLANT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(GLOWING_AMETHYST.get(), RenderType.cutout());
    }
}
