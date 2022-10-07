//package com.windanesz.backportedstuff.worldgen;
//
//import com.windanesz.backportedstuff.registry.BlockRegistry;
//import net.minecraft.block.Block;
//import net.minecraft.init.Blocks;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.chunk.Chunk;
//import net.minecraftforge.event.world.ChunkEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.eventhandler.EventPriority;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//@Mod.EventBusSubscriber
//public class DeepslateGen {
//
//	public static Block fromBlock = Blocks.STONE; // change this to suit your need
//	public static Block toBlock = BlockRegistry.deepslate; // change this to suit your need
//
//	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
//	public static void onEvent(ChunkEvent.Load event) {
//		Chunk theChunk = event.getChunk();
//
//		if (!theChunk.isPopulated()) {
//
//			// replace all blocks of a type with another block type
//
//			for (int x = 0; x < 16; ++x) {
//				for (int z = 0; z < 16; ++z) {
//					for (int y = 0; y < theChunk.getHeightValue(x, z) + 1; ++y) {
//						if (theChunk.getBlockState(x, y, z).getBlock() == fromBlock) {
//							theChunk.setBlockState(new BlockPos(x, y, z), toBlock.getDefaultState());
//						}
//					}
//				}
//			}
//			theChunk.markDirty();
//		}
//	}
//}
