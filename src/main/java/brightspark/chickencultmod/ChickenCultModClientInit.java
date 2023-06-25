package brightspark.chickencultmod;

import brightspark.chickencultmod.entity.ChickenArrowEntityRenderer;
import brightspark.chickencultmod.geckolib.BasicArmorRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import software.bernie.example.client.renderer.armor.GeckoArmorRenderer;

public class ChickenCultModClientInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(CCEntities.CHICKEN_ARROW, ChickenArrowEntityRenderer::new);

		GeckoArmorRenderer.registerArmorRenderer(
			new BasicArmorRenderer("warrior_chicken_armor"),
			CCItems.WARRIOR_CHICKEN_HELMET,
			CCItems.WARRIOR_CHICKEN_CHESTPLATE,
			CCItems.WARRIOR_CHICKEN_LEGGINGS,
			CCItems.WARRIOR_CHICKEN_BOOTS
		);
	}
}
