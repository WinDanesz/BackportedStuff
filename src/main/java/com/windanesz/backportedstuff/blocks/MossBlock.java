package com.windanesz.backportedstuff.blocks;

import com.windanesz.backportedstuff.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class MossBlock extends Block {

	public MossBlock() {
		super(Material.GRASS);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(BlockRegistry.moss_block);
	}

	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		return MapColor.getBlockColor(EnumDyeColor.CYAN);
	}
}
