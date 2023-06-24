package brightspark.chickencultmod.entity;

import brightspark.chickencultmod.CCEntities;
import brightspark.chickencultmod.CCItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class ChickenArrowEntity extends PersistentProjectileEntity {
	public ChickenArrowEntity(EntityType<? extends ChickenArrowEntity> entityType, World world) {
		super(entityType, world);
	}

	public ChickenArrowEntity(World world, LivingEntity owner) {
		super(CCEntities.CHICKEN_ARROW, owner, world);
	}

	public ChickenArrowEntity(World world, double x, double y, double z) {
		super(CCEntities.CHICKEN_ARROW, x, y, z, world);
	}

	@Override
	public void tick() {
		super.tick();
		if (world.isClient() && !inGround) {
			world.addParticle(ParticleTypes.CLOUD, getX(), getY(), getZ(), 0, 0, 0);
		}
	}

	@Override
	protected ItemStack asItemStack() {
		return new ItemStack(CCItems.CHICKEN_ARROW);
	}

	@Override
	protected void onBlockHit(BlockHitResult blockHitResult) {
		super.onBlockHit(blockHitResult);
		spawnChicken();
	}

	@Override
	protected void onHit(LivingEntity target) {
		super.onHit(target);
		spawnChicken();
	}

	@SuppressWarnings("DataFlowIssue")
	private void spawnChicken() {
		ChickenEntity entity = EntityType.CHICKEN.create(world);
		entity.refreshPositionAndAngles(getX(), getY(), getZ(), 0, 0);
		world.spawnEntity(entity);

		discard();
	}
}
