package net.eggsaregood.duckymod.worldgen;

import net.eggsaregood.duckymod.DuckyMod;
import net.kaupenjoe.tutorialmod.worldgen.ModConfiguredFeatures;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> DUCKY_BLOCK_PLACED_KEY =
            registerKey("ducky_block_placed");



    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        var configured = context.lookup(Registries.CONFIGURED_FEATURE);

        // --- Overworld Alexandrite ---
        register(context,
                DUCKY_BLOCK_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.DUCKY_BLOCK_PLACED_KEY,
                ModOrePlacement.commonOrePlacement(
                        12,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(80)
                        )
                )
        );




    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        // FIXED: Forge 1.21 uses the *constructor* for ResourceLocation
        ResourceKey<PlacedFeature> placedFeatureResourceKey = ResourceKey.create(
                Registries.PLACED_FEATURE,
                new ResourceLocation(DuckyMod.MOD_ID, name)
        );
        return placedFeatureResourceKey;
    }

    private static void register(
            BootstrapContext<PlacedFeature> context,
            ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> configuration,
            List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}