package brightspark.chickencultmod;

import brightspark.chickencultmod.entity.ChickenArrowEntityRenderer;
import brightspark.chickencultmod.geckolib.ChickenArmorRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import software.bernie.example.client.renderer.armor.GeckoArmorRenderer;

public class ChickenCultModClientInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(CCEntities.CHICKEN_ARROW, ChickenArrowEntityRenderer::new);

		GeckoArmorRenderer.registerArmorRenderer(new ChickenArmorRenderer(),
			CCItems.CHICKEN_HELMET, CCItems.CHICKEN_CHESTPLATE, CCItems.CHICKEN_LEGGINGS, CCItems.CHICKEN_BOOTS
		);
	}
}
