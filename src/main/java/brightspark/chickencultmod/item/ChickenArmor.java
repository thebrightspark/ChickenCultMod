package brightspark.chickencultmod.item;

import brightspark.chickencultmod.ChickenCultMod;
import com.google.common.base.Suppliers;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public class ChickenArmor extends ArmorItem {
	public ChickenArmor(EquipmentSlot slot) {
		super(ChickenArmorMaterial.INSTANCE, slot, new Item.Settings().group(ChickenCultMod.GROUP));
	}

	private static class ChickenArmorMaterial implements ArmorMaterial {
		private static final String NAME = "chicken";
		private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
		private static final int DURABILITY_MULTIPLIER = 15;
		private static final int[] PROTECTION = new int[]{2, 5, 6, 2};
		private static final int ENCHANTABILITY = 9;
		private static final SoundEvent EQUIP_SOUND = SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
		private static final float TOUGHNESS = 0F;
		private static final float KNOCKBACK_RESISTANCE = 0F;
		private static final Supplier<Ingredient> REPAIR_INGREDIENT =
			Suppliers.memoize(() -> Ingredient.ofItems(Items.CHICKEN));

		static final ChickenArmorMaterial INSTANCE = new ChickenArmorMaterial();

		private ChickenArmorMaterial() {}

		@Override
		public int getDurability(EquipmentSlot slot) {
			return BASE_DURABILITY[slot.getEntitySlotId()] * DURABILITY_MULTIPLIER;
		}

		@Override
		public int getProtectionAmount(EquipmentSlot slot) {
			return PROTECTION[slot.getEntitySlotId()];
		}

		@Override
		public int getEnchantability() {
			return ENCHANTABILITY;
		}

		@Override
		public SoundEvent getEquipSound() {
			return EQUIP_SOUND;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return REPAIR_INGREDIENT.get();
		}

		@Override
		public String getName() {
			return NAME;
		}

		@Override
		public float getToughness() {
			return TOUGHNESS;
		}

		@Override
		public float getKnockbackResistance() {
			return KNOCKBACK_RESISTANCE;
		}
	}
}
