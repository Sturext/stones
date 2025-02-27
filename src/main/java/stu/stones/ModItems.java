package stu.stones;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
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
    public static final Item THUNDERSTAFF =  registerItem("thunderstaff",ThunderStaffItem::new, new Item.Settings().maxCount(1));
    public static final Item FIRESTAFF =  registerItem("firestaff",ThunderStaffItem::new, new Item.Settings().maxCount(1));
    public static final Item WATERSTAFF =  registerItem("waterstaff",ThunderStaffItem::new, new Item.Settings().maxCount(1));
    public static final Item WINDSTAFF =  registerItem("windstaff",ThunderStaffItem::new, new Item.Settings().maxCount(1));


    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings){
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("stones",name));
        return Items.register(registerKey,factory,settings);
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
    }

    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::customIngredients);
    }



}
