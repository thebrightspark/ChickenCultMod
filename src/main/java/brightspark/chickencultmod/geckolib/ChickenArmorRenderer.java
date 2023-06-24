package brightspark.chickencultmod.geckolib;

import brightspark.chickencultmod.item.ChickenArmor;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ChickenArmorRenderer extends GeoArmorRenderer<ChickenArmor> {
	public ChickenArmorRenderer() {
		super(BasicGeoModel.item("chicken_armor"));
	}
}
