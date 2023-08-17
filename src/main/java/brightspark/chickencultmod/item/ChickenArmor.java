package brightspark.chickencultmod.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;

public class ChickenArmor extends BasicGeoArmorItem {
	private static final ArmorMaterial CHICKEN_ARMOR_MATERIAL =
		BasicArmorMaterial.builder("chicken", ArmorMaterials.IRON)
			.equipSound(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER)
			.repairIngredient(() -> Ingredient.ofItems(Items.CHICKEN))
			.build();

	public ChickenArmor(EquipmentSlot slot, Settings settings) {
		super(CHICKEN_ARMOR_MATERIAL, slot, settings);
	}
}
