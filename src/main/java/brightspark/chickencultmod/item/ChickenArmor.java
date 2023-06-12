package brightspark.chickencultmod.item;

import brightspark.chickencultmod.ChickenCultMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;

public class ChickenArmor extends ArmorItem {
	private static final ArmorMaterial CHICKEN_ARMOR_MATERIAL =
		BasicArmorMaterial.builder("chicken", ArmorMaterials.IRON)
			.equipSound(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER)
			.repairIngredient(() -> Ingredient.ofItems(Items.CHICKEN))
			.build();

	public ChickenArmor(EquipmentSlot slot) {
		super(CHICKEN_ARMOR_MATERIAL, slot, new Item.Settings().group(ChickenCultMod.GROUP));
	}
}
