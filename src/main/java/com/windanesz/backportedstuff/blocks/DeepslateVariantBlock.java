package com.windanesz.backportedstuff.blocks;

import com.windanesz.backportedstuff.registry.BlockRegistry;
import com.windanesz.backportedstuff.sounds.DeepslateSounds;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class DeepslateVariantBlock extends Block {

	public DeepslateVariantBlock() {
		this(false);
	}

	public DeepslateVariantBlock(boolean isBricks) {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setSoundType(isBricks ? DeepslateSounds.DEEPSLATE_BRICKS() : DeepslateSounds.DEEPSLATE());
	}

	@Override
	public EnumPushReaction getPushReaction(IBlockState state) {
		return state.getBlock() == BlockRegistry.reinforced_deepslate ? EnumPushReaction.IGNORE : super.getPushReaction(state);
	}
}
