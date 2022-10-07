package com.windanesz.backportedstuff.registry;

import com.windanesz.backportedstuff.BackportedStuff;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;

@ObjectHolder(BackportedStuff.MODID)
@Mod.EventBusSubscriber
public final class ItemRegistry {

	private ItemRegistry() {} // No instances!

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {

		IForgeRegistry<Item> registry = event.getRegistry();

		registerItemBlock(registry, BlockRegistry.deepslate);
		registerItemBlock(registry, BlockRegistry.cobbled_deepslate);
		registerItemBlock(registry, BlockRegistry.moss_block);
		registerItemBlock(registry, BlockRegistry.moss_carpet);
		registerItemBlock(registry, BlockRegistry.deepslate_coal_ore);
		registerItemBlock(registry, BlockRegistry.deepslate_diamond_ore);
		registerItemBlock(registry, BlockRegistry.deepslate_emerald_ore);
		registerItemBlock(registry, BlockRegistry.deepslate_gold_ore);
		registerItemBlock(registry, BlockRegistry.deepslate_iron_ore);
		registerItemBlock(registry, BlockRegistry.deepslate_lapis_ore);
		registerItemBlock(registry, BlockRegistry.deepslate_redstone_ore);
	}

	@Nonnull
	@SuppressWarnings("ConstantConditions")
	public static <T> T placeholder() { return null; }

	// below registry methods are courtesy of EB
	public static void registerItem(IForgeRegistry<Item> registry, String name, String modid, Item item) {
		registerItem(registry, name, modid, item, false);
	}

	public static void registerItem(IForgeRegistry<Item> registry, String modid, String name, Item item, boolean setTabIcon) {
		item.setRegistryName(modid, name);
		item.setTranslationKey(item.getRegistryName().toString());
		registry.register(item);
	}

	public static void registerItemBlock(IForgeRegistry<Item> registry, Block block) {
		Item itemblock = new ItemBlock(block).setRegistryName(block.getRegistryName());
		registry.register(itemblock);
	}

	public static void registerItemBlock(IForgeRegistry<Item> registry, Block block, Item itemblock) {
		itemblock.setRegistryName(block.getRegistryName());
		registry.register(itemblock);
	}
}