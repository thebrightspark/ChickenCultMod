package brightspark.chickencultmod;

import brightspark.chickencultmod.item.ChickenArmor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChickenCultMod implements ModInitializer {
	public static final String MOD_ID = "chickencultmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ItemGroup GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "name"))
		.icon(() -> new ItemStack(Items.CHICKEN))
		.build();

	@Override
	public void onInitialize() {
		item("chicken_helmet", new ChickenArmor(EquipmentSlot.HEAD));
		item("chicken_chestplate", new ChickenArmor(EquipmentSlot.CHEST));
		item("chicken_leggings", new ChickenArmor(EquipmentSlot.LEGS));
		item("chicken_boots", new ChickenArmor(EquipmentSlot.FEET));
	}

	private static void item(String name, Item item) {
		Registry.register(Registry.ITEM, Identifier.of(MOD_ID, name), item);
	}
}
