package brightspark.chickencultmod;

import brightspark.chickencultmod.entity.ChickenArrowEntityRenderer;
import brightspark.chickencultmod.geckolib.BasicArmorRenderer;
import brightspark.chickencultmod.item.BasicGeoArmorItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import software.bernie.example.client.renderer.armor.GeckoArmorRenderer;

import static brightspark.chickencultmod.CCItems.*;

public class ChickenCultModClientInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(CCEntities.CHICKEN_ARROW, ChickenArrowEntityRenderer::new);

		registerArmorRenderer("warrior_chicken_armor",
			WARRIOR_CHICKEN_HELMET, WARRIOR_CHICKEN_CHESTPLATE, WARRIOR_CHICKEN_LEGGINGS, WARRIOR_CHICKEN_BOOTS
		);
	}

	private void registerArmorRenderer(String name, BasicGeoArmorItem... items) {
		GeckoArmorRenderer.registerArmorRenderer(new BasicArmorRenderer<>(name), items);
	}
}
