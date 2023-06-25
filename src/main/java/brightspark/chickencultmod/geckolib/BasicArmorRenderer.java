package brightspark.chickencultmod.geckolib;

import brightspark.chickencultmod.item.ChickenArmor;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BasicArmorRenderer extends GeoArmorRenderer<ChickenArmor> {
	public BasicArmorRenderer(String name) {
		super(BasicGeoModel.armor(name));
	}
}
