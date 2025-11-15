package com.windanesz.backportedstuff.worldgen;

import com.windanesz.backportedstuff.Settings;
import com.windanesz.backportedstuff.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

@Mod.EventBusSubscriber
public class DeepslateGen {

	// Worldgen temporarily disabled
	/*
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onPopulateChunk(PopulateChunkEvent.Pre event) {
		
		// Only run on server side
		if (event.getWorld().isRemote) {
			return;
		}

		// Check if deepslate generation is enabled
		if (!Settings.generalSettings.enableDeepslateGeneration) {
			return;
		}

		World world = event.getWorld();
		int chunkX = event.getChunkX() << 4;
		int chunkZ = event.getChunkZ() << 4;
		int yThreshold = Settings.generalSettings.deepslateYThreshold;
		int transitionRange = Settings.generalSettings.deepslateTransitionRange;
		boolean replaceOres = Settings.generalSettings.replaceOresWithDeepslate;

		// Calculate the Y range to process (including transition zone)
		int maxY = Math.min(yThreshold + transitionRange, 256);
		
		Random random = new Random();
		long worldSeed = world.getSeed();

		// Iterate through all blocks in the chunk
		for (int x = 0; x < 16; ++x) {
			for (int z = 0; z < 16; ++z) {
				for (int y = 0; y < maxY; ++y) {
					
					BlockPos pos = new BlockPos(chunkX + x, y, chunkZ + z);
					IBlockState state = world.getBlockState(pos);
					Block block = state.getBlock();
						
					// Calculate replacement chance
					float replacementChance = getReplacementChance(y, yThreshold, transitionRange);
					
					// Skip if no chance
					if (replacementChance <= 0.0f) continue;
					
					// Always replace if 100%
					boolean shouldReplace = replacementChance >= 1.0f;
					
					// Otherwise use deterministic random
					if (!shouldReplace) {
						random.setSeed(worldSeed + pos.getX() * 341873128712L + pos.getY() * 132897987541L + pos.getZ() * 938193739L);
						shouldReplace = random.nextFloat() < replacementChance;
					}
					
					if (shouldReplace) {
						// Replace stone with deepslate
						if (block == Blocks.STONE && state.getValue(net.minecraft.block.BlockStone.VARIANT) == net.minecraft.block.BlockStone.EnumType.STONE) {
							world.setBlockState(pos, BlockRegistry.deepslate.getDefaultState(), 2);
						}
						// Replace ores with deepslate variants if enabled
						else if (replaceOres) {
							IBlockState replacement = getDeepslateOreReplacement(block);
							if (replacement != null) {
								world.setBlockState(pos, replacement, 2);
							}
						}
					}
				}
			}
		}
	}	/**
	 * Calculates the probability of replacing stone with deepslate at a given Y-level.
	 * Creates a smooth transition around the threshold.
	 * 
	 * @param y The Y-coordinate to check
	 * @param yThreshold The center of the transition (configured threshold)
	 * @param transitionRange The range over which the transition occurs
	 * @return A value between 0.0 (no replacement) and 1.0 (always replace)
	 */
	private static float getReplacementChance(int y, int yThreshold, int transitionRange) {
		if (transitionRange == 0) {
			// No transition, hard cutoff at threshold
			return y < yThreshold ? 1.0f : 0.0f;
		}
		
		// Calculate distance from threshold
		float distance = yThreshold - y;
		
		// Below threshold-range: always replace (100%)
		if (distance >= transitionRange) {
			return 1.0f;
		}
		
		// Above threshold: never replace (0%)
		if (distance <= 0) {
			return 0.0f;
		}
		
		// In transition zone: smooth gradient (smoothstep)
		float normalized = distance / transitionRange;
		return normalized * normalized * (3.0f - 2.0f * normalized);
	}

	/**
	 * Maps vanilla ore blocks to their deepslate variants.
	 * @param block The block to check
	 * @return The deepslate variant state, or null if no replacement exists
	 */
	private static IBlockState getDeepslateOreReplacement(Block block) {
		if (block == Blocks.COAL_ORE) {
			return BlockRegistry.deepslate_coal_ore.getDefaultState();
		} else if (block == Blocks.IRON_ORE) {
			return BlockRegistry.deepslate_iron_ore.getDefaultState();
		} else if (block == Blocks.GOLD_ORE) {
			return BlockRegistry.deepslate_gold_ore.getDefaultState();
		} else if (block == Blocks.DIAMOND_ORE) {
			return BlockRegistry.deepslate_diamond_ore.getDefaultState();
		} else if (block == Blocks.EMERALD_ORE) {
			return BlockRegistry.deepslate_emerald_ore.getDefaultState();
		} else if (block == Blocks.LAPIS_ORE) {
			return BlockRegistry.deepslate_lapis_ore.getDefaultState();
		} else if (block == Blocks.REDSTONE_ORE) {
			return BlockRegistry.deepslate_redstone_ore.getDefaultState();
		} else if (block == Blocks.LIT_REDSTONE_ORE) {
			return BlockRegistry.lit_deepslate_redstone_ore.getDefaultState();
		}
		return null;
	}
	*/
}
