package com.windanesz.backportedstuff.blocks;

import com.windanesz.backportedstuff.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class DeepslateBlock extends Block {

	public static final PropertyEnum<EnumAxis> DEEPSLATE_AXIS = PropertyEnum.<EnumAxis>create("axis", EnumAxis.class);

	public DeepslateBlock() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DEEPSLATE_AXIS, DeepslateBlock.EnumAxis.Y));

	}

	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState();

		switch (meta) {
			case 0:
				iblockstate = iblockstate.withProperty(DEEPSLATE_AXIS, DeepslateBlock.EnumAxis.Y);
				break;
			case 1:
				iblockstate = iblockstate.withProperty(DEEPSLATE_AXIS, DeepslateBlock.EnumAxis.X);
				break;
			case 2:
				iblockstate = iblockstate.withProperty(DEEPSLATE_AXIS, DeepslateBlock.EnumAxis.Z);
				break;
			default:
				iblockstate = iblockstate.withProperty(DEEPSLATE_AXIS, DeepslateBlock.EnumAxis.Y);
		}

		return iblockstate;
	}

	public int getMetaFromState(IBlockState state) {
		switch (state.getValue(DEEPSLATE_AXIS)) {

			case X:
				return 1;
			case Z:
				return 2;
			case Y:
			default:
				return 0;

		}
	}

	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(DEEPSLATE_AXIS, DeepslateBlock.EnumAxis.fromFacingAxis(facing.getAxis()));
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
			case COUNTERCLOCKWISE_90:
			case CLOCKWISE_90:

				switch ((DeepslateBlock.EnumAxis) state.getValue(DEEPSLATE_AXIS)) {
					case X:
						return state.withProperty(DEEPSLATE_AXIS, DeepslateBlock.EnumAxis.Z);
					case Z:
						return state.withProperty(DEEPSLATE_AXIS, DeepslateBlock.EnumAxis.X);
					default:
						return state;
				}

			default:
				return state;
		}
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, DEEPSLATE_AXIS);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(BlockRegistry.cobbled_deepslate);
	}

	public static enum EnumAxis implements IStringSerializable {
		X("x"),
		Y("y"),
		Z("z");

		private final String name;

		private EnumAxis(String name) {
			this.name = name;
		}

		public static DeepslateBlock.EnumAxis fromFacingAxis(EnumFacing.Axis axis) {
			switch (axis) {
				case X:
					return X;
				case Z:
					return Z;
				default:
					return Y;
			}
		}

		public String toString() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}
	}
}
