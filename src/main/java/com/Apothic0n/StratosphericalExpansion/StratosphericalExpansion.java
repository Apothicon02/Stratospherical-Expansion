package com.Apothic0n.StratosphericalExpansion;

import com.Apothic0n.StratosphericalExpansion.api.biome.StratoSurfaceRuleData;
import com.Apothic0n.StratosphericalExpansion.api.biome.features.StratoFeatureRegistry;
import com.Apothic0n.StratosphericalExpansion.core.objects.StratoBlocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.SurfaceRuleManager;

@Mod(StratosphericalExpansion.MODID)
public class StratosphericalExpansion {
    public static final String MODID = "strato";

    public StratosphericalExpansion() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        StratoFeatureRegistry.register(eventBus);
        StratoBlocks.BLOCKS.register(eventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SurfaceRuleManager.setDefaultSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, StratoSurfaceRuleData.makeRules());
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        StratoBlocks.fixBlockRenderLayers();
    }
}