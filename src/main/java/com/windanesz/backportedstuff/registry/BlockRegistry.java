package com.windanesz.backportedstuff.registry;

import com.windanesz.backportedstuff.BackportedStuff;
import com.windanesz.backportedstuff.blocks.BlockDoubleSlabBase;
import com.windanesz.backportedstuff.blocks.SlabBaseBlock;
import com.windanesz.backportedstuff.blocks.CobbledDeepslateBlock;
import com.windanesz.backportedstuff.blocks.DeepslateBlock;
import com.windanesz.backportedstuff.blocks.DeepslateOreBlock;
import com.windanesz.backportedstuff.blocks.DeepslateRedstoneOreBlock;
import com.windanesz.backportedstuff.blocks.DeepslateTileStairsBlock;
import com.windanesz.backportedstuff.blocks.DeepslateVariantBlock;
import com.windanesz.backportedstuff.blocks.MossBlock;
import com.windanesz.backportedstuff.blocks.MossCarpetBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;

@GameRegistry.ObjectHolder(BackportedStuff.MODID)
@Mod.EventBusSubscriber
public class BlockRegistry {

	public static final Block deepslate = placeholder();
	public static final Block cobbled_deepslate = placeholder();
	public static final Block moss_block = placeholder();
	public static final Block moss_carpet = placeholder();
	public static final Block deepslate_coal_ore = placeholder();
	public static final Block deepslate_diamond_ore = placeholder();
	public static final Block deepslate_emerald_ore = placeholder();
	public static final Block deepslate_gold_ore = placeholder();
	public static final Block deepslate_iron_ore = placeholder();
	public static final Block deepslate_lapis_ore = placeholder();
	public static final Block deepslate_redstone_ore = placeholder();
	public static final Block lit_deepslate_redstone_ore = placeholder();

	public static final Block polished_deepslate = placeholder();
	public static final Block deepslate_bricks = placeholder();
	public static final Block deepslate_tiles = placeholder();
	public static final Block cracked_deepslate_bricks = placeholder();
	public static final Block cracked_deepslate_tiles = placeholder();
	public static final Block reinforced_deepslate = placeholder();
	public static final Block deepslate_tile_stairs = placeholder();
	public static final Block deepslate_brick_stairs = placeholder();
	public static final Block cobbled_deepslate_stairs = placeholder();
	public static final Block deepslate_brick_slab = placeholder();
	public static final Block deepslate_brick_double_slab = placeholder();
	public static final Block deepslate_tile_slab = placeholder();
	public static final Block deepslate_tile_double_slab = placeholder();
	public static final Block deepslate_brick_wall = placeholder();
	public static final Block deepslate_tile_wall = placeholder();

	private BlockRegistry() {} // no instances

	@Nonnull
	@SuppressWarnings("ConstantConditions")
	public static <T> T placeholder() { return null; }

	public static void registerBlock(IForgeRegistry<Block> registry, String name, Block block) {
		block.setRegistryName(BackportedStuff.MODID, name);
		block.setTranslationKey(block.getRegistryName().toString());
		registry.register(block);
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();

		registerBlock(registry, "deepslate", (new DeepslateBlock()).setHardness(3F).setResistance(10.0F));
		registerBlock(registry, "cobbled_deepslate", (new CobbledDeepslateBlock()).setHardness(3F).setResistance(10.0F));
		registerBlock(registry, "moss_block", (new MossBlock()).setHardness(0.1F).setResistance(0.1F));
		registerBlock(registry, "moss_carpet", (new MossCarpetBlock()).setHardness(0.1F).setResistance(0.1F));

		registerBlock(registry, "deepslate_coal_ore", (new DeepslateOreBlock(MapColor.GRAY).setHardness(3.0F).setResistance(10.0F)));
		registerBlock(registry, "deepslate_diamond_ore", (new DeepslateOreBlock(MapColor.GRAY).setHardness(3.0F).setResistance(10.0F)));
		registerBlock(registry, "deepslate_emerald_ore", (new DeepslateOreBlock(MapColor.GRAY).setHardness(3.0F).setResistance(10.0F)));
		registerBlock(registry, "deepslate_gold_ore", (new DeepslateOreBlock(MapColor.GRAY).setHardness(3.0F).setResistance(10.0F)));
		registerBlock(registry, "deepslate_iron_ore", (new DeepslateOreBlock(MapColor.GRAY).setHardness(3.0F).setResistance(10.0F)));
		registerBlock(registry, "deepslate_lapis_ore", (new DeepslateOreBlock(MapColor.GRAY).setHardness(3.0F).setResistance(10.0F)));
		registerBlock(registry, "deepslate_redstone_ore", (new DeepslateRedstoneOreBlock(false).setHardness(3.0F).setResistance(10.0F)));
		registerBlock(registry, "lit_deepslate_redstone_ore", (new DeepslateRedstoneOreBlock(true).setHardness(3.0F).setResistance(10.0F)));
		registerBlock(registry, "polished_deepslate", (new DeepslateVariantBlock()).setHardness(3.5F).setResistance(10.0F));
		registerBlock(registry, "deepslate_bricks", (new DeepslateVariantBlock()).setHardness(3.5F).setResistance(10.0F));
		registerBlock(registry, "deepslate_tiles", (new DeepslateVariantBlock()).setHardness(3.5F).setResistance(10.0F));
		registerBlock(registry, "cracked_deepslate_bricks", (new DeepslateVariantBlock()).setHardness(3.5F).setResistance(10.0F));
		registerBlock(registry, "cracked_deepslate_tiles", (new DeepslateVariantBlock()).setHardness(3.5F).setResistance(10.0F));
		registerBlock(registry, "reinforced_deepslate", (new DeepslateVariantBlock()).setHardness(55F).setResistance(1200.0F));
		Block block = (new Block(Material.ROCK)).setHardness(2.0F).setResistance(10.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		registerBlock(registry, "deepslate_tile_stairs", (new DeepslateTileStairsBlock(block.getDefaultState())).setHardness(3.5F).setResistance(10.0F));
		registerBlock(registry, "deepslate_brick_stairs", (new DeepslateTileStairsBlock(block.getDefaultState())).setHardness(3.5F).setResistance(10.0F));
		registerBlock(registry, "cobbled_deepslate_stairs", (new DeepslateTileStairsBlock(block.getDefaultState())).setHardness(3.5F).setResistance(10.0F));

		//registerBlock(registry, "deepslate_brick_slab", (new BlockHalfStoneSlabNew().setHardness(3.5F).setResistance(10.0F));
		registerBlock(registry, "deepslate_brick_slab", (new SlabBaseBlock(Material.ROCK)).setHardness(3.5F).setResistance(10.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
		registerBlock(registry, "deepslate_brick_double_slab", (new BlockDoubleSlabBase(Material.ROCK, BlockRegistry.deepslate_brick_slab)).setHardness(3.5F).setResistance(10.0F));
		registerBlock(registry, "deepslate_tile_slab", (new SlabBaseBlock(Material.ROCK)).setHardness(3.5F).setResistance(10.0F).setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
		registerBlock(registry, "deepslate_tile_double_slab", (new BlockDoubleSlabBase(Material.ROCK, BlockRegistry.deepslate_tile_slab)).setHardness(3.5F).setResistance(10.0F));
//		((BlockDoubleSlabBase) deepslate_brick_double_slab).setSlab(deepslate_brick_slab);
		//registerBlock(registry, "deepslate_tile_slab", (new BlockHalfStoneSlabNew().setHardness(3.5F).setResistance(10.0F));
		//registerBlock(registry, "deepslate_brick_wall", (new BlockWall(block)).setHardness(3.5F).setResistance(10.0F));
		//registerBlock(registry, "deepslate_tile_wall", (new BlockWall(block)).setHardness(3.5F).setResistance(10.0F));

	}

	public static void registerOreDictionaryEntries() {

		OreDictionary.registerOre("stone", BlockRegistry.deepslate);
		OreDictionary.registerOre("cobblestone", BlockRegistry.cobbled_deepslate);
		OreDictionary.registerOre("oreGold", BlockRegistry.deepslate_gold_ore);
		OreDictionary.registerOre("oreIron", BlockRegistry.deepslate_iron_ore);
		OreDictionary.registerOre("oreLapis", BlockRegistry.deepslate_lapis_ore);
		OreDictionary.registerOre("oreDiamond", BlockRegistry.deepslate_diamond_ore);
		OreDictionary.registerOre("oreRedstone", BlockRegistry.deepslate_redstone_ore);
		OreDictionary.registerOre("oreEmerald", BlockRegistry.deepslate_emerald_ore);
		OreDictionary.registerOre("oreCoal", BlockRegistry.deepslate_coal_ore);

	}

	//	/** Called from the preInit method in the main mod class to register all the tile entities. */
	//	public static void registerTileEntities(){
	//		// TODO
	//	}

}
