package brightspark.chickencultmod.item;

import brightspark.chickencultmod.geckolib.GeoUtils;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class BasicGeoArmorItem extends ArmorItem implements IAnimatable {
	private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

	public BasicGeoArmorItem(
		ArmorMaterial material,
		EquipmentSlot slot,
		Settings settings
	) {
		super(material, slot, settings);
	}

	@Override
	public void registerControllers(AnimationData animationData) {
		animationData.addAnimationController(GeoUtils.idleAnimationController(this));
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}
}
