package com.windanesz.backportedstuff.blocks;

import com.windanesz.backportedstuff.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class DeepslateVariantBlock extends Block {

	public DeepslateVariantBlock() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public EnumPushReaction getPushReaction(IBlockState state) {
		return state.getBlock() == BlockRegistry.reinforced_deepslate ? EnumPushReaction.IGNORE : super.getPushReaction(state);
	}
}
