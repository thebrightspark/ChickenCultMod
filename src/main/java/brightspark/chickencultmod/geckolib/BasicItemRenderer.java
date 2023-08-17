package brightspark.chickencultmod.geckolib;

import brightspark.chickencultmod.item.BasicGeoItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class BasicItemRenderer<T extends BasicGeoItem> extends GeoItemRenderer<T> {
	public BasicItemRenderer(String name) {
		super(BasicGeoModel.item(name));
	}
}
