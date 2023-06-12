package brightspark.chickencultmod.item;

import com.google.common.base.Suppliers;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

import java.util.function.Supplier;

public class BasicArmorMaterial implements ArmorMaterial {
	private final String name;
	private final int[] baseDurability;
	private final int durabilityMultiplier;
	private final int[] protection;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairIngredient;

	public BasicArmorMaterial(
		String name,
		int[] baseDurability,
		int durabilityMultiplier,
		int[] protection,
		int enchantability,
		SoundEvent equipSound,
		float toughness,
		float knockbackResistance,
		Supplier<Ingredient> repairIngredient
	) {
		this.name = name;
		this.baseDurability = baseDurability;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protection = protection;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}

	public static Builder builder(String name) {
		return new Builder(name);
	}

	public static Builder builder(String name, ArmorMaterials baseMaterial) {
		return new Builder(name, baseMaterial);
	}

	@Override
	public int getDurability(EquipmentSlot slot) {
		return baseDurability[slot.getEntitySlotId()] * durabilityMultiplier;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return protection[slot.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairIngredient.get();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getToughness() {
		return toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return knockbackResistance;
	}

	public static class Builder {
		private String name;
		private int[] baseDurability = ArmorMaterials.BASE_DURABILITY;
		private int durabilityMultiplier;
		private int[] protection;
		private int enchantability;
		private SoundEvent equipSound;
		private float toughness;
		private float knockbackResistance;
		private Supplier<Ingredient> repairIngredient;

		private Builder(String name) {
			this(name, ArmorMaterials.IRON);
		}

		private Builder(String name, ArmorMaterials baseMaterial) {
			this.name = name;
			durabilityMultiplier = baseMaterial.durabilityMultiplier;
			protection = baseMaterial.protectionAmounts;
			enchantability = baseMaterial.getEnchantability();
			equipSound = baseMaterial.getEquipSound();
			toughness = baseMaterial.getToughness();
			knockbackResistance = baseMaterial.getKnockbackResistance();
			repairIngredient = baseMaterial.repairIngredientSupplier.supplier;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder baseDurability(int[] baseDurability) {
			this.baseDurability = baseDurability;
			return this;
		}

		public Builder durabilityMultiplier(int durabilityMultiplier) {
			this.durabilityMultiplier = durabilityMultiplier;
			return this;
		}

		public Builder protection(int[] protection) {
			this.protection = protection;
			return this;
		}

		public Builder enchantability(int enchantability) {
			this.enchantability = enchantability;
			return this;
		}

		public Builder equipSound(SoundEvent equipSound) {
			this.equipSound = equipSound;
			return this;
		}

		public Builder toughness(float toughness) {
			this.toughness = toughness;
			return this;
		}

		public Builder knockbackResistance(float knockbackResistance) {
			this.knockbackResistance = knockbackResistance;
			return this;
		}

		public Builder repairIngredient(Supplier<Ingredient> repairIngredient) {
			this.repairIngredient = Suppliers.memoize(repairIngredient::get);
			return this;
		}

		public ArmorMaterial build() {
			return new BasicArmorMaterial(
				name,
				baseDurability,
				durabilityMultiplier,
				protection,
				enchantability,
				equipSound,
				toughness,
				knockbackResistance,
				repairIngredient
			);
		}
	}
}
