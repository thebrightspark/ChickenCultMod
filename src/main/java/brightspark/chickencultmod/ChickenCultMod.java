package brightspark.chickencultmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChickenCultMod implements ModInitializer {
	public static final String MOD_ID = "chickencultmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ItemGroup GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "name"))
		.icon(() -> new ItemStack(Items.EGG))
		.build();

	@Override
	public void onInitialize() {
		CCEntities.init();
		CCBlocks.init();
		CCItems.init();
	}
}
