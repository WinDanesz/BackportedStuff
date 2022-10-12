package com.windanesz.backportedstuff.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class SmeltingRecipes {

	public static void registerSmeltingRecipes() {
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.cobbled_deepslate, new ItemStack(Item.getItemFromBlock(BlockRegistry.deepslate)), 0.1F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.deepslate_gold_ore, new ItemStack(Items.GOLD_INGOT), 1.0F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.deepslate_diamond_ore, new ItemStack(Items.DIAMOND), 1.0F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.deepslate_iron_ore, new ItemStack(Items.IRON_INGOT), 0.7F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.deepslate_redstone_ore, new ItemStack(Items.REDSTONE), 0.7F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.deepslate_lapis_ore, new ItemStack(Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage()), 0.2F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.deepslate_coal_ore, new ItemStack(Items.COAL), 0.1F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.deepslate_emerald_ore, new ItemStack(Items.EMERALD), 1.0F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.deepslate_bricks, new ItemStack(Item.getItemFromBlock(BlockRegistry.cracked_deepslate_bricks)), 0.1F);
		FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlockRegistry.deepslate_tiles, new ItemStack(Item.getItemFromBlock(BlockRegistry.cracked_deepslate_tiles)), 0.1F);
	}
}
