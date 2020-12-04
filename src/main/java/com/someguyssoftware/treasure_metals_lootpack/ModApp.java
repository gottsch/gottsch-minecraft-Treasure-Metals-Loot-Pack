/**
 * 
 */
package com.someguyssoftware.treasure_metals_lootpack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.gottschcore.annotation.Credits;
import com.someguyssoftware.gottschcore.config.IConfig;
import com.someguyssoftware.gottschcore.mod.AbstractMod;
import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.gottschcore.version.BuildVersion;
import com.someguyssoftware.treasure2.eventhandler.WorldEventHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Mark Gottschling on Dec 3, 2020
 *
 */
@Mod(modid = ModApp.MODID, name = ModApp.NAME, version = ModApp.VERSION, dependencies = "required-after:gottschcore@[1.13.0,)", acceptedMinecraftVersions = "[1.12.2]", updateJSON = ModApp.UPDATE_JSON_URL)
@Credits(values = { "Treasure2: Metals Loot Pack was first developed by Mark Gottschling on Dec 3, 2020."})
public class ModApp extends AbstractMod {
	// constants
	public static final String MODID = "treasure2_metals_lp";
	protected static final String NAME = "Treasure2 Metals LP";
	protected static final String VERSION = "1.0.0";

	public static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-Treasure/master/update.json";

	private static final BuildVersion MINECRAFT_VERSION = new BuildVersion(1, 12, 2);

	// latest version
	private static BuildVersion latestVersion;

	// logger
	public static Logger LOGGER = LogManager.getLogger(ModApp.NAME);

	@Instance(value = ModApp.MODID)
	public static ModApp instance;
	
	/**
	 * 
	 */
	public ModApp() {
		
	}
	
	/**
	 * 
	 * @param event
	 */
	@Override
	@EventHandler
	public void preInt(FMLPreInitializationEvent event) {
		super.preInt(event);
		
		// register additional events
		MinecraftForge.EVENT_BUS.register(new WorldEventHandler(getInstance()));
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getConfig()
	 */
	@Override
	public IConfig getConfig() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getMinecraftVersion()
	 */
	@Override
	public BuildVersion getMinecraftVersion() {
		return ModApp.MINECRAFT_VERSION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getVerisionURL()
	 */
	@Override
	public String getVerisionURL() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getName()
	 */
	@Override
	public String getName() {
		return ModApp.NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getId()
	 */
	@Override
	public String getId() {
		return ModApp.MODID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getInstance()
	 */
	@Override
	public IMod getInstance() {
		return ModApp.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getVersion()
	 */
	@Override
	public String getVersion() {
		return ModApp.VERSION;
	}

	@Override
	public BuildVersion getModLatestVersion() {
		return latestVersion;
	}

	@Override
	public void setModLatestVersion(BuildVersion version) {
		ModApp.latestVersion = version;
	}

	@Override
	public String getUpdateURL() {
		return ModApp.UPDATE_JSON_URL;
	}
}
