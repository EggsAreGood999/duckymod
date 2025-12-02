package item;

import net.eggsaregood.duckymod.DuckyMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DuckyMod.MOD_ID);

    public static final RegistryObject<Item> DUCKY = ITEMS.register("ducky",
       () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DUCKY_STICK = ITEMS.register("ducky_stick",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DUCKY_WAND = ITEMS.register("ducky_wand",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_DUCKY_ORE = ITEMS.register("raw_ducky_ore",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BURNT_DUCKY_ORE = ITEMS.register("burnt_ducky_ore",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }






}
