package net.lordjayda.erstemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.lordjayda.erstemod.block.ModBlocks;
import net.lordjayda.erstemod.block.custom.LettuceCropBlock;
import net.lordjayda.erstemod.item.ModItems;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import java.util.concurrent.CompletableFuture;

import static net.lordjayda.erstemod.block.ModBlocks.*;

public class ModBlocksLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlocksLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.CUTTING_BOARD);
        this.add(LETTUCE_HEADCROP, this.createCropDrops(LETTUCE_HEADCROP, ModItems.LETTUCE_HEAD, ModItems.LETTUCE_SEED,
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(LETTUCE_HEADCROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LettuceCropBlock.AGE, LettuceCropBlock.MAX_AGE))));
        this.add(TOMATO_CROP, this.createCropDrops(TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEED,
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(TOMATO_CROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LettuceCropBlock.AGE, LettuceCropBlock.MAX_AGE))
        ));
    }
}
