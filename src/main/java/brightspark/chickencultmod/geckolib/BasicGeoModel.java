package brightspark.chickencultmod.geckolib;

import brightspark.chickencultmod.ChickenCultMod;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BasicGeoModel<T extends IAnimatable> extends AnimatedGeoModel<T> {
	private final Identifier model, texture, animation;

	private BasicGeoModel(String type, String name) {
		model = new Identifier(ChickenCultMod.MOD_ID, "geo/" + name + ".geo.json");
		texture = new Identifier(ChickenCultMod.MOD_ID, "textures/" + type + "/" + name + ".png");
		animation = new Identifier(ChickenCultMod.MOD_ID, "animations/" + name + ".animation.json");
	}

	public static <T extends IAnimatable> AnimatedGeoModel<T> item(String name) {
		return new BasicGeoModel<>("item", name);
	}

	public static <T extends IAnimatable> AnimatedGeoModel<T> block(String name) {
		return new BasicGeoModel<>("block", name);
	}

	public static <T extends IAnimatable> AnimatedGeoModel<T> entity(String name) {
		return new BasicGeoModel<>("entity", name);
	}

	@Override
	public Identifier getModelResource(T object) {
		return model;
	}

	@Override
	public Identifier getTextureResource(T object) {
		return texture;
	}

	@Override
	public Identifier getAnimationResource(T animatable) {
		return animation;
	}
}
