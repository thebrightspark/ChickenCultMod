package brightspark.chickencultmod;

import brightspark.chickencultmod.item.ChickenArmor;
import brightspark.chickencultmod.item.ChickenArrowItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Position;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class CCItems {
	public static Item
		WARRIOR_CHICKEN_HELMET, WARRIOR_CHICKEN_CHESTPLATE, WARRIOR_CHICKEN_LEGGINGS, WARRIOR_CHICKEN_BOOTS,
		CHICKEN_ARROW;

	public static void init() {
		WARRIOR_CHICKEN_HELMET = item("warrior_chicken_helmet", new ChickenArmor(EquipmentSlot.HEAD, settings()));
		WARRIOR_CHICKEN_CHESTPLATE =
			item("warrior_chicken_chestplate", new ChickenArmor(EquipmentSlot.CHEST, settings()));
		WARRIOR_CHICKEN_LEGGINGS = item("warrior_chicken_leggings", new ChickenArmor(EquipmentSlot.LEGS, settings()));
		WARRIOR_CHICKEN_BOOTS = item("warrior_chicken_boots", new ChickenArmor(EquipmentSlot.FEET, settings()));

		CHICKEN_ARROW = item("chicken_arrow", new ChickenArrowItem(settings()));
		dispenserProjectile(CHICKEN_ARROW, CCEntities.CHICKEN_ARROW);
	}

	private static Item item(String name, Item item) {
		return Registry.register(Registry.ITEM, Identifier.of(ChickenCultMod.MOD_ID, name), item);
	}

	private static Item.Settings settings() {
		return new Item.Settings().group(ChickenCultMod.GROUP);
	}

	private static void dispenserProjectile(Item item, EntityType<? extends ProjectileEntity> entityType) {
		DispenserBlock.registerBehavior(item, new ProjectileDispenserBehavior() {
			@SuppressWarnings("DataFlowIssue")
			@Override
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				ProjectileEntity entity = entityType.create(world);
				entity.setPosition(position.getX(), position.getY(), position.getZ());
				return entity;
			}
		});
	}
}
