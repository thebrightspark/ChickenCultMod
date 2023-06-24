package brightspark.chickencultmod.entity;

import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class ChickenArrowEntityRenderer extends ProjectileEntityRenderer<ChickenArrowEntity> {
	public ChickenArrowEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	@Override
	public Identifier getTexture(ChickenArrowEntity entity) {
		return ArrowEntityRenderer.TEXTURE;
	}
}
