package stu.stones;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item THUNDERSTONE = registerItem("thunderstone", Item::new,  new Item.Settings().maxCount(64));
    public static final Item FIRESTONE = registerItem("firestone", Item::new,  new Item.Settings().maxCount(64));
    public static final Item WATERSTONE = registerItem("waterstone", Item::new,  new Item.Settings().maxCount(64));
    public static final Item WINDSTONE = registerItem("windstone", Item::new,  new Item.Settings().maxCount(64));
    public static final Item THUNDERSTAFF =  registerItem("thunderstaff",ThunderStaffItem::new, new Item.Settings().maxDamage(32));
    public static final Item FIRESTAFF =  registerItem("firestaff",FireStaffItem::new, new Item.Settings().maxDamage(64));
    public static final Item WATERSTAFF =  registerItem("waterstaff",WaterStaffItem::new, new Item.Settings().maxDamage(64));
    public static final Item WINDSTAFF =  registerItem("windstaff",WindStaffItem::new, new Item.Settings().maxDamage(64));
    public static final Block THUNDERORE = registerBlock("thunderore", Block::new, Block.Settings.create().strength(3.0f).requiresTool());
    public static final Block FIREORE = registerBlock("fireore", Block::new, Block.Settings.create().strength(3.0f).requiresTool());
    public static final Block WATERORE = registerBlock("waterore", Block::new, Block.Settings.create().strength(3.0f).requiresTool());
    public static final Block WINDORE = registerBlock("windore", Block::new, Block.Settings.create().strength(3.0f).requiresTool());


    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings){
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("stones",name));
        return Items.register(registerKey,factory,settings);
    }

    public static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings){
        final RegistryKey<Block> registerKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of("stones",name));
        Block freshBlock = Blocks.register(registerKey,factory,settings);
        Items.register(freshBlock);
        return freshBlock;
    }

    private static void customIngredients(FabricItemGroupEntries entries){
        entries.add(THUNDERSTONE);
        entries.add(FIRESTONE);
        entries.add(WATERSTONE);
        entries.add(WINDSTONE);
        entries.add(THUNDERSTAFF);
        entries.add(FIRESTAFF);
        entries.add(WATERSTAFF);
        entries.add(WINDSTAFF);
        entries.add(THUNDERORE);
        entries.add(FIREORE);
        entries.add(WATERORE);
        entries.add(WINDORE);
    }

    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::customIngredients);
    }



}
