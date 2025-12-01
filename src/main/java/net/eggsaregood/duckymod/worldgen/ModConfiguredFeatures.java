package net.eggsaregood.duckymod.worldgen;

import net.eggsaregood.duckymod.DuckyMod;
import net.eggsaregood.duckymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static net.eggsaregood.duckymod.block.ModBlocks.DUCKY_BLOCK;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_DUCKY_ORE_KEY = registerKey("ducky_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // Define blocks to replace
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // Ore targets
        List<OreConfiguration.TargetBlockState> overworldDuckyOres = List.of(
                OreConfiguration.target(stoneReplaceables, DUCKY_BLOCK.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, DUCKY_BLOCK.get().defaultBlockState())
        );

        // Register the configured feature
        register(context, OVERWORLD_DUCKY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldDuckyOres, 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(DuckyMod.MOD_ID, name)
        );
    }

    private static <FC extends OreConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration
    ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}