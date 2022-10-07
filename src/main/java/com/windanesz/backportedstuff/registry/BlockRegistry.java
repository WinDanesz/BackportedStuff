package com.windanesz.backportedstuff.registry;

import com.windanesz.backportedstuff.BackportedStuff;
import com.windanesz.backportedstuff.blocks.CobbledDeepslateBlock;
import com.windanesz.backportedstuff.blocks.DeepslateBlock;
import com.windanesz.backportedstuff.blocks.DeepslateOreBlock;
import com.windanesz.backportedstuff.blocks.DeepslateRedstoneOreBlock;
import com.windanesz.backportedstuff.blocks.MossBlock;
import com.windanesz.backportedstuff.blocks.MossCarpetBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
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
