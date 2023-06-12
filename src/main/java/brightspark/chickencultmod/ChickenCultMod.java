package brightspark.chickencultmod;

import brightspark.chickencultmod.item.ChickenArmor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class ChickenCultMod implements ModInitializer {
	public static final String MOD_ID = "chickencultmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ItemGroup GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "name"))
		.icon(() -> new ItemStack(Items.EGG))
		.build();

	@Override
	public void onInitialize() {
		armor("chicken", ChickenArmor::new);
		// TODO: Create custom 3D armour models using GeckoLib
		//  https://github.com/bernie-g/geckolib/wiki/Armor-Animations
	}

	private static void item(String name, Item item) {
		Registry.register(Registry.ITEM, Identifier.of(MOD_ID, name), item);
	}

	private static void armor(String name, Function<EquipmentSlot, ArmorItem> armorFactory) {
		item(name + "_helmet", armorFactory.apply(EquipmentSlot.HEAD));
		item(name + "_chestplate", armorFactory.apply(EquipmentSlot.CHEST));
		item(name + "_leggings", armorFactory.apply(EquipmentSlot.LEGS));
		item(name + "_boots", armorFactory.apply(EquipmentSlot.FEET));
	}
}
