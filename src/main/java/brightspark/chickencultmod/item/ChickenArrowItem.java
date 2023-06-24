package brightspark.chickencultmod.item;

import brightspark.chickencultmod.entity.ChickenArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ChickenArrowItem extends ArrowItem {
	public ChickenArrowItem(Settings settings) {
		super(settings);
	}

	@Override
	public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
		return new ChickenArrowEntity(world, shooter);
	}
}
