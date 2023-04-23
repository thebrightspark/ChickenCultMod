package brightspark.chickencultmod.item;

import brightspark.chickencultmod.ChickenCultMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;

public class ChickenArmor extends ArmorItem {
	public ChickenArmor(EquipmentSlot slot) {
		super(ArmorMaterials.DIAMOND, slot, new Item.Settings().group(ChickenCultMod.GROUP));
	}
}
