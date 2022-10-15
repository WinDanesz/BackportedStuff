package com.windanesz.backportedstuff.registry;

import com.windanesz.backportedstuff.BackportedStuff;
import com.windanesz.backportedstuff.items.SlabItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
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

		registerItemBlock(registry, BlockRegistry.polished_deepslate);
		registerItemBlock(registry, BlockRegistry.deepslate_bricks);
		registerItemBlock(registry, BlockRegistry.deepslate_tiles);
		registerItemBlock(registry, BlockRegistry.cracked_deepslate_bricks);
		registerItemBlock(registry, BlockRegistry.cracked_deepslate_tiles);
		registerItemBlock(registry, BlockRegistry.reinforced_deepslate);
		registerItemBlock(registry, BlockRegistry.deepslate_tile_stairs);
		registerItemBlock(registry, BlockRegistry.deepslate_brick_stairs);
		registerItemBlock(registry, BlockRegistry.cobbled_deepslate_stairs);
		registerItemBlock(registry, BlockRegistry.deepslate_brick_slab, new SlabItem(BlockRegistry.deepslate_brick_slab, BlockRegistry.deepslate_brick_double_slab));
		registerItemBlock(registry, BlockRegistry.deepslate_tile_slab, new SlabItem(BlockRegistry.deepslate_tile_slab, BlockRegistry.deepslate_tile_double_slab));
		registerItemBlock(registry, BlockRegistry.deepslate_brick_wall);
	    registerItemBlock(registry, BlockRegistry.deepslate_tile_wall);
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