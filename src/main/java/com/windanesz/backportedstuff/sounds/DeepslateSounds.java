package com.windanesz.backportedstuff.sounds;

import com.windanesz.backportedstuff.BackportedStuff;
import net.minecraft.block.SoundType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Custom sounds for deepslate blocks to match vanilla Minecraft 1.17+ behavior.
 * Deepslate has a unique sound profile that's deeper and more resonant than regular stone.
 */
@Mod.EventBusSubscriber(modid = BackportedStuff.MODID)
public class DeepslateSounds {
	
	private DeepslateSounds() {}

	// Sound events for deepslate blocks - these will be injected by @GameRegistry.ObjectHolder
	@GameRegistry.ObjectHolder(BackportedStuff.MODID + ":block.deepslate.break")
	public static final SoundEvent BLOCK_DEEPSLATE_BREAK = createSound("block.deepslate.break");
	
	@GameRegistry.ObjectHolder(BackportedStuff.MODID + ":block.deepslate.step")
	public static final SoundEvent BLOCK_DEEPSLATE_STEP = createSound("block.deepslate.step");
	
	@GameRegistry.ObjectHolder(BackportedStuff.MODID + ":block.deepslate.place")
	public static final SoundEvent BLOCK_DEEPSLATE_PLACE = createSound("block.deepslate.place");
	
	@GameRegistry.ObjectHolder(BackportedStuff.MODID + ":block.deepslate.hit")
	public static final SoundEvent BLOCK_DEEPSLATE_HIT = createSound("block.deepslate.hit");

	// Sound events for deepslate bricks - higher pitched, more refined sound
	@GameRegistry.ObjectHolder(BackportedStuff.MODID + ":block.deepslate_bricks.break")
	public static final SoundEvent BLOCK_DEEPSLATE_BRICKS_BREAK = createSound("block.deepslate_bricks.break");
	
	@GameRegistry.ObjectHolder(BackportedStuff.MODID + ":block.deepslate_bricks.step")
	public static final SoundEvent BLOCK_DEEPSLATE_BRICKS_STEP = createSound("block.deepslate_bricks.step");
	
	@GameRegistry.ObjectHolder(BackportedStuff.MODID + ":block.deepslate_bricks.place")
	public static final SoundEvent BLOCK_DEEPSLATE_BRICKS_PLACE = createSound("block.deepslate_bricks.place");
	
	@GameRegistry.ObjectHolder(BackportedStuff.MODID + ":block.deepslate_bricks.hit")
	public static final SoundEvent BLOCK_DEEPSLATE_BRICKS_HIT = createSound("block.deepslate_bricks.hit");

	/**
	 * Custom SoundType for deepslate blocks.
	 * Volume: 1.0F, Pitch: 0.8F for a deeper sound compared to regular stone.
	 * This is created lazily to ensure sound events are registered first.
	 */
	private static SoundType deepslateSoundType;
	
	public static SoundType DEEPSLATE() {
		if (deepslateSoundType == null) {
			deepslateSoundType = new SoundType(
				1.0F,  // volume
				0.8F,  // pitch (lower pitch = deeper sound)
				BLOCK_DEEPSLATE_BREAK,
				BLOCK_DEEPSLATE_STEP,
				BLOCK_DEEPSLATE_PLACE,
				BLOCK_DEEPSLATE_HIT,
				BLOCK_DEEPSLATE_STEP  // fall sound uses step sound
			);
		}
		return deepslateSoundType;
	}

	/**
	 * Custom SoundType for deepslate bricks blocks.
	 * Volume: 0.5F (for fall sound), Pitch: 0.75F (for fall sound) matching vanilla values.
	 * Individual sound events have their own volume/pitch settings in sounds.json.
	 * This is created lazily to ensure sound events are registered first.
	 */
	private static SoundType deepslateBricksSoundType;
	
	public static SoundType DEEPSLATE_BRICKS() {
		if (deepslateBricksSoundType == null) {
			deepslateBricksSoundType = new SoundType(
				0.5F,  // volume (fall sound volume from wiki)
				0.75F,  // pitch (fall sound pitch from wiki)
				BLOCK_DEEPSLATE_BRICKS_BREAK,
				BLOCK_DEEPSLATE_BRICKS_STEP,
				BLOCK_DEEPSLATE_BRICKS_PLACE,
				BLOCK_DEEPSLATE_BRICKS_HIT,
				BLOCK_DEEPSLATE_BRICKS_STEP  // fall sound uses step sound
			);
		}
		return deepslateBricksSoundType;
	}

	/**
	 * Creates a sound with the given name, to be read from {@code assets/backportedstuff/sounds.json}.
	 */
	public static SoundEvent createSound(String name) {
		return new SoundEvent(new ResourceLocation(BackportedStuff.MODID, name)).setRegistryName(name);
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().register(BLOCK_DEEPSLATE_BREAK);
		event.getRegistry().register(BLOCK_DEEPSLATE_STEP);
		event.getRegistry().register(BLOCK_DEEPSLATE_PLACE);
		event.getRegistry().register(BLOCK_DEEPSLATE_HIT);
		
		event.getRegistry().register(BLOCK_DEEPSLATE_BRICKS_BREAK);
		event.getRegistry().register(BLOCK_DEEPSLATE_BRICKS_STEP);
		event.getRegistry().register(BLOCK_DEEPSLATE_BRICKS_PLACE);
		event.getRegistry().register(BLOCK_DEEPSLATE_BRICKS_HIT);
		
		BackportedStuff.logger.info("Registered deepslate and deepslate_bricks sounds");
	}
}
