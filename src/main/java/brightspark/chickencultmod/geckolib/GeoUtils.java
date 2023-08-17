package brightspark.chickencultmod.geckolib;

import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

public class GeoUtils {
	public static <T extends IAnimatable> PlayState idleAnimationPredicate(AnimationEvent<T> event) {
		event.getController()
			.setAnimation(new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));
		return PlayState.CONTINUE;
	}

	public static <T extends IAnimatable> AnimationController<T> idleAnimationController(T animatable) {
		return new AnimationController<>(animatable, "controller", 20, GeoUtils::idleAnimationPredicate);
	}
}
