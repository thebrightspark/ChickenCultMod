package brightspark.chickencultmod;

import brightspark.chickencultmod.entity.ChickenArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

public class CCEntities {
	public static EntityType<ChickenArrowEntity> CHICKEN_ARROW;

	public static void init() {
		CHICKEN_ARROW = entity(
			"chicken_arrow",
			ChickenArrowEntity::new,
			(builder) -> builder.dimensions(EntityDimensions.fixed(0.5F, 0.5F))
				.trackRangeChunks(5)
				.trackedUpdateRate(20)
		);
	}

	private static <T extends Entity> EntityType<T> entity(
		String name,
		EntityType.EntityFactory<T> factory,
		Consumer<FabricEntityTypeBuilder<T>> builder
	) {
		FabricEntityTypeBuilder<T> b = FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory);
		builder.accept(b);
		return Registry.register(Registry.ENTITY_TYPE, Identifier.of(ChickenCultMod.MOD_ID, name), b.build());
	}
}
