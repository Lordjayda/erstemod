package net.lordjayda.erstemod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.lordjayda.erstemod.Erstemod;
import net.lordjayda.erstemod.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
//hier neuen output für etwas im creative tab
    public static void registerModCreativeModeTabs(){
        CreativeModeTab BURGER_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                Identifier.fromNamespaceAndPath(Erstemod.MOD_ID, "burgers"),
                FabricCreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BURGER))
                        .title(Component.translatable("creativemodetab.erstemod.burgers"))
                        .displayItems((parameters, output) ->{
                            for (Item item : ModItems.itemList) {
                                output.accept(item);
                            }
                        }).build());
        Erstemod.LOGGER.info("Tabs registriert für" + Erstemod.MOD_ID);
    }
}