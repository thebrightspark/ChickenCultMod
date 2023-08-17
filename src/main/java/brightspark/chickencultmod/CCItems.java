package brightspark.chickencultmod;

import brightspark.chickencultmod.item.BasicGeoArmorItem;
import brightspark.chickencultmod.item.ChickenArmor;
import brightspark.chickencultmod.item.ChickenArrowItem;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Position;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class CCItems {
	public static BasicGeoArmorItem WARRIOR_CHICKEN_HELMET, WARRIOR_CHICKEN_CHESTPLATE, WARRIOR_CHICKEN_LEGGINGS, WARRIOR_CHICKEN_BOOTS;
	public static Item EGG_SMALL;
	public static Item CHICKEN_ARROW;

	public static void init() {
		WARRIOR_CHICKEN_HELMET = item("warrior_chicken_helmet", new ChickenArmor(EquipmentSlot.HEAD, settings()));
		WARRIOR_CHICKEN_CHESTPLATE =
			item("warrior_chicken_chestplate", new ChickenArmor(EquipmentSlot.CHEST, settings()));
		WARRIOR_CHICKEN_LEGGINGS = item("warrior_chicken_leggings", new ChickenArmor(EquipmentSlot.LEGS, settings()));
		WARRIOR_CHICKEN_BOOTS = item("warrior_chicken_boots", new ChickenArmor(EquipmentSlot.FEET, settings()));

		EGG_SMALL = blockItem(CCBlocks.EGG_SMALL, settings().maxCount(1).fireproof().rarity(Rarity.EPIC));

		CHICKEN_ARROW = item("chicken_arrow", new ChickenArrowItem(settings()));
		dispenserProjectile(CHICKEN_ARROW, CCEntities.CHICKEN_ARROW);
	}

	private static <T extends Item> T item(String name, T item) {
		return Registry.register(Registry.ITEM, Identifier.of(ChickenCultMod.MOD_ID, name), item);
	}

	private static BlockItem blockItem(Block block, Item.Settings settings) {
		return Registry.register(Registry.ITEM, Registry.BLOCK.getId(block), new BlockItem(block, settings));
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
