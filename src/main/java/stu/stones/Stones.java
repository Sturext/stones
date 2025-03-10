package stu.stones;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Stones implements ModInitializer {


    @Override
    public void onInitialize() {
        ModItems.registerModItems(); //adds items to creative tab under natural blocks
    }
}
