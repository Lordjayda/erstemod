package net.lordjayda.erstemod.item;

import net.lordjayda.erstemod.Erstemod;
import net.lordjayda.erstemod.block.ModBlocks;
import net.lordjayda.erstemod.food.ModFoods;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.function.Function;

public class ModItems {
    public static Item BURGER;
    public static Item LETTUCE;
    public static Item LETTUCE_HEAD;
    public static Item LETTUCE_SEED;
    public static Item TOMATO;
    public static Item TOMATO_SLICE;
    public static Item TOMATO_SEED;
    public static Item PATTY;
    public static Item RAW_PATTY;
    public static Item BUN;
    public static Item TOP_BUN;
    public static Item BOTTOM_BUN;
    public static ArrayList<Item> itemList = new ArrayList<>();
//einfach kopieren und namen und id ändern




    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        Item item = Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Erstemod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Erstemod.MOD_ID, name)))));
        itemList.add(item);
        return item;
    }

    public static void  registerModItems () {
        BURGER = registerItem( "burger", properties -> new Item(properties.food(ModFoods.BURGER)));
        LETTUCE = registerItem( "lettuce", properties -> new Item(properties.food(ModFoods.salad)));
        LETTUCE_HEAD = registerItem( "lettuce_head", properties -> new Item(properties.food(ModFoods.salad)));
        LETTUCE_SEED = registerItem( "lettuce_seed", properties -> new BlockItem(ModBlocks.LETTUCE_HEADCROP, properties.useItemDescriptionPrefix()));
        TOMATO = registerItem( "tomato", properties -> new Item(properties.food(ModFoods.tomato)));
        TOMATO_SLICE = registerItem( "tomato_slice", properties -> new Item(properties.food(ModFoods.tomato_slice)));
        TOMATO_SEED = registerItem( "tomato_seed", properties -> new BlockItem(ModBlocks.TOMATO_CROP, properties.useItemDescriptionPrefix()));
        PATTY = registerItem( "patty", properties -> new Item(properties.food(ModFoods.patty)));
        RAW_PATTY = registerItem( "raw_patty", properties -> new Item(properties.food(ModFoods.raw_patty)));
        BUN = registerItem( "bun", Item::new );
        TOP_BUN = registerItem( "top_bun", Item::new );
        BOTTOM_BUN = registerItem( "bottom_bun", Item::new );
        Erstemod.LOGGER.info("Registering Mod Items for" + Erstemod.MOD_ID);
    }
}
