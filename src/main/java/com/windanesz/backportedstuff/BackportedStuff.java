package com.windanesz.backportedstuff;

import com.windanesz.backportedstuff.registry.BlockRegistry;
import com.windanesz.backportedstuff.registry.SmeltingRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import java.util.Random; 

@Mod(modid = BackportedStuff.MODID, name = BackportedStuff.NAME, version = "@VERSION@", acceptedMinecraftVersions = "[@MCVERSION@]")
public class BackportedStuff {

	public static final String MODID = "backportedstuff";
	public static final String NAME = "Backported Stuff";

	public static final Random rand = new Random();

	public static Logger logger;

	// The instance of the mod that Forge uses.
	@Mod.Instance(BackportedStuff.MODID)
	public static BackportedStuff instance;

	// Location of the proxy code, used by Forge.
	@SidedProxy(clientSide = "com.windanesz.backportedstuff.client.ClientProxy", serverSide = "com.windanesz.backportedstuff.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		logger = event.getModLog();

		proxy.registerRenderers();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		MinecraftForge.EVENT_BUS.register(instance);
		proxy.registerParticles();
		proxy.init();
		SmeltingRecipes.registerSmeltingRecipes();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		BlockRegistry.registerOreDictionaryEntries();
	}

	@EventHandler
	public void serverStartup(FMLServerStartingEvent event) { }

}
