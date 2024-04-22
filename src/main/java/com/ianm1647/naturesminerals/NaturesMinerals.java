package com.ianm1647.naturesminerals;

import com.ianm1647.naturesminerals.config.NaturesMineralsConfig;
import com.ianm1647.naturesminerals.item.ItemList;
import com.ianm1647.naturesminerals.registry.BlockRegistry;
import com.ianm1647.naturesminerals.registry.ItemRegistry;
import com.ianm1647.naturesminerals.registry.UtilRegistry;
import com.ianm1647.naturesminerals.world.ModOreGeneration;
import draylar.omegaconfig.OmegaConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NaturesMinerals implements ModInitializer {
	public static final String MODID = "naturesminerals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static NaturesMineralsConfig CONFIG = OmegaConfig.register(NaturesMineralsConfig.class);

	public static final RegistryKey<ItemGroup> GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MODID, "group"));


	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM_GROUP, GROUP, FabricItemGroup.builder()
				.displayName(Text.translatable("itemGroup.naturesminerals.group"))
				.icon(() -> new ItemStack(ItemList.KUNZITE_INGOT))
				.build());

		ItemRegistry.registerItems();
		BlockRegistry.registerBlocks();
		ModOreGeneration.generateOres();
		UtilRegistry.registerUtils();
		LOGGER.info("Natures Minerals loaded");
	}
}