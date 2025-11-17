package item;

import net.eggsaregood.duckymod.DuckyMod;
import net.eggsaregood.duckymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DuckyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("alexanderite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DUCKY.get()))
                    .title(Component.translatable("Ducky"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.DUCKY.get());
                        output.accept(ModBlocks.ducky_block.get());
                        output.accept(ModItems.DUCKY_STICK.get());
                    }).build());


       public static void register(IEventBus eventBus) {
            CREATIVE_MODE_TABS.register(eventBus);



    }
}
