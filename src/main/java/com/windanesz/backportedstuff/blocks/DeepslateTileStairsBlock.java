package com.windanesz.backportedstuff.blocks;

import com.windanesz.backportedstuff.sounds.DeepslateSounds;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;

public class DeepslateTileStairsBlock extends BlockStairs {

	public DeepslateTileStairsBlock(IBlockState modelState) {
		this(modelState, false);
	}

	public DeepslateTileStairsBlock(IBlockState modelState, boolean isBricks) {
		super(modelState);
		this.setSoundType(isBricks ? DeepslateSounds.DEEPSLATE_BRICKS() : DeepslateSounds.DEEPSLATE());
	}
}
