package brightspark.chickencultmod;

import brightspark.chickencultmod.entity.ChickenArrowEntityRenderer;
import brightspark.chickencultmod.geckolib.BasicArmorRenderer;
import brightspark.chickencultmod.geckolib.BasicItemRenderer;
import brightspark.chickencultmod.item.BasicGeoArmorItem;
import brightspark.chickencultmod.item.BasicGeoItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import software.bernie.example.client.renderer.armor.GeckoArmorRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import static brightspark.chickencultmod.CCItems.*;

public class ChickenCultModClientInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(CCEntities.CHICKEN_ARROW, ChickenArrowEntityRenderer::new);

//		registerItemRenderer("egg_small", EGG_SMALL);
		registerArmorRenderer("warrior_chicken_armor",
			WARRIOR_CHICKEN_HELMET, WARRIOR_CHICKEN_CHESTPLATE, WARRIOR_CHICKEN_LEGGINGS, WARRIOR_CHICKEN_BOOTS
		);
	}

	private void registerItemRenderer(String name, BasicGeoItem item) {
		GeoItemRenderer.registerItemRenderer(item, new BasicItemRenderer<>(name));
	}

	private void registerArmorRenderer(String name, BasicGeoArmorItem... items) {
		GeckoArmorRenderer.registerArmorRenderer(new BasicArmorRenderer<>(name), items);
	}
}
