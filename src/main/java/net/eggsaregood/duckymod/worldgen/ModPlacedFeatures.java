package net.eggsaregood.duckymod.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;


public class ModPlacedFeatures {

    // 🔹 Key for your placed feature
    public static final ResourceKey<PlacedFeature> ORE_MY_ORE_PLACED =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    new ResourceLocation("Duckymod", "ore_my_ore"));

    // 🔹 Called from your main mod's data bootstrap (or from ModWorldgen.java)
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);

        // == Placement modifiers ==
        var modifiers = OrePlacement.commonOrePlacement(
                10, // veins per chunk
                HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(-64),
                        VerticalAnchor.absolute(32))
        );

        context.register(
                ORE_MY_ORE_PLACED,
                new PlacedFeature(
                        configured.getOrThrow(ModConfiguredFeatures.ORE_MY_ORE),  // your configured feature
                        modifiers
                )
        );
    }
}