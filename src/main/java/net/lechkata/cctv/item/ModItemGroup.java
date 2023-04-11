package net.lechkata.cctv.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lechkata.cctv.CCTV;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup CCTV_TAB;

    public static void registerItemGroups(){
        CCTV_TAB = FabricItemGroup.builder(new Identifier(CCTV.MOD_ID, "cctv_tab"))
                .displayName(Text.literal("CCTV"))
                .icon(() -> new ItemStack(ModItems.TABLET)).build();
    }
}
