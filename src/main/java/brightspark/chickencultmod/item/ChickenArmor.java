package brightspark.chickencultmod.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class ChickenArmor extends ArmorItem implements IAnimatable {
	private static final ArmorMaterial CHICKEN_ARMOR_MATERIAL =
		BasicArmorMaterial.builder("chicken", ArmorMaterials.IRON)
			.equipSound(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER)
			.repairIngredient(() -> Ingredient.ofItems(Items.CHICKEN))
			.build();
	private final AnimationFactory animationFactory = GeckoLibUtil.createFactory(this);

	public ChickenArmor(EquipmentSlot slot, Settings settings) {
		super(CHICKEN_ARMOR_MATERIAL, slot, settings);
	}

	private <T extends IAnimatable> PlayState animationPredicate(AnimationEvent<T> event) {
		event.getController().setAnimation(
			new AnimationBuilder().addAnimation("animation.chicken_armor.new", EDefaultLoopTypes.LOOP)
		);
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "controller", 20, this::animationPredicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return animationFactory;
	}
}
