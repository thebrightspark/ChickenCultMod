package brightspark.chickencultmod.item;

import brightspark.chickencultmod.geckolib.GeoUtils;
import net.minecraft.item.Item;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class BasicGeoItem extends Item implements IAnimatable {
	private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

	public BasicGeoItem(Settings settings) {
		super(settings);
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
