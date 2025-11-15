package com.windanesz.backportedstuff;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = BackportedStuff.MODID, name = "backportedstuff") // No fancy configs here so we can use the annotation, hurrah!
public class Settings {

	@SuppressWarnings("unused")
	@Mod.EventBusSubscriber(modid = BackportedStuff.MODID)
	private static class EventHandler {
		/**
		 * Inject the new values and save to the config file when the config has been changed from the GUI.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(BackportedStuff.MODID)) {
				ConfigManager.sync(BackportedStuff.MODID, Config.Type.INSTANCE);
			}
		}
	}

	@Config.Name("General Settings")
	@Config.LangKey("settings.backportedstuff:general_settings")
	public static GeneralSettings generalSettings = new GeneralSettings();

	public static class GeneralSettings {

		@Config.Comment("Enable deepslate world generation. When enabled, stone below the Y-threshold will be replaced with deepslate.")
		@Config.Name("Enable Deepslate Generation")
		public boolean enableDeepslateGeneration = true;

		@Config.Comment("The Y-level at which deepslate generation starts. Blocks below this level will be replaced with deepslate variants. Default: 20")
		@Config.Name("Deepslate Y-Level Threshold")
		@Config.RangeInt(min = 0, max = 255)
		public int deepslateYThreshold = 20;

		@Config.Comment("Replace vanilla stone ores with deepslate ore variants below the Y-threshold")
		@Config.Name("Replace Ores with Deepslate Variants")
		public boolean replaceOresWithDeepslate = true;

		@Config.Comment("The range (in blocks) over which deepslate gradually replaces stone around the Y-threshold. 0 = instant transition, higher values = more gradual. Default: 4")
		@Config.Name("Deepslate Transition Range")
		@Config.RangeInt(min = 0, max = 16)
		public int deepslateTransitionRange = 4;

	}
}
