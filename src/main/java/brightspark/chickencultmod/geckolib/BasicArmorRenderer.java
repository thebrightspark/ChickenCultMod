package brightspark.chickencultmod.geckolib;

import brightspark.chickencultmod.item.BasicGeoArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BasicArmorRenderer<T extends BasicGeoArmorItem> extends GeoArmorRenderer<T> {
	public BasicArmorRenderer(String name) {
		super(BasicGeoModel.armor(name));
	}
}
