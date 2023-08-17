package brightspark.chickencultmod;

import brightspark.chickencultmod.block.MotherEggBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CCBlocks {
	public static Block EGG_SMALL;

	public static void init() {
		EGG_SMALL = block("egg_small", new MotherEggBlock(settings(Material.EGG)));
	}

	private static <T extends Block> T block(String name, T block) {
		return Registry.register(Registry.BLOCK, Identifier.of(ChickenCultMod.MOD_ID, name), block);
	}

	private static AbstractBlock.Settings settings(Material material) {
		return AbstractBlock.Settings.of(material);
	}
}
