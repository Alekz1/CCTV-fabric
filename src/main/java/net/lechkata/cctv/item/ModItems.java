package net.lechkata.cctv.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lechkata.cctv.CCTV;
import net.lechkata.cctv.item.custom.TabletItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TABLET = registerItem("tablet",
            new TabletItem(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CCTV.MOD_ID, name), item);
    }

    private static void addItemsToItemGroup(){
        addItemToGroup(ModItemGroup.CCTV_TAB, TABLET);
    }

    public static void addItemToGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    public static void registerModItems(){
        CCTV.LOGGER.info("Registering Items for "+ CCTV.MOD_ID);
        addItemsToItemGroup();
    }
}
