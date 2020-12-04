/**
 * 
 */
package com.someguyssoftware.treasure_metals_lootpack.eventhandler;

import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.gottschcore.world.WorldInfo;
import com.someguyssoftware.treasure2.Treasure;
import com.someguyssoftware.treasure_metals_lootpack.ModApp;

import net.minecraft.world.WorldServer;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author Mark Gottschling on Dec 3, 2020
 *
 */
public class WorldEventHandler {

	// reference to the mod.
	private IMod mod;
	
	/**
	 * 
	 */
	public WorldEventHandler(IMod mod) {
		setMod(mod);
	}

	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		ModApp.LOGGER.debug("Loading world event...");
		/*
		 * On load of dimension 0 (overworld), initialize the loot table's context and other static loot tables
		 */
		if (WorldInfo.isServerSide(event.getWorld()) && event.getWorld().provider.getDimension() == 0) {
			// register mod's loot tables with the LootTableMaster
			Treasure.LOOT_TABLE_MASTER.register(mod.getId());
		}	
	}
	
	@SubscribeEvent
	public void onWorldUnLoad(WorldEvent.Unload event) {
		ModApp.LOGGER.debug("Unloading world event...");
	}
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		ModApp.LOGGER.debug("Starting Server event...");
	}
	@SubscribeEvent
	public void onServerStarted(FMLServerStartedEvent event) {
		ModApp.LOGGER.debug("Started server event...");
	}
	
	@SubscribeEvent
	public void onServerStopping(FMLServerStoppingEvent event) {
		ModApp.LOGGER.debug("Stopping server event...");
	}
	
	/**
	 * @return the mod
	 */
	public IMod getMod() {
		return mod;
	}

	/**
	 * @param mod the mod to set
	 */
	public void setMod(IMod mod) {
		this.mod = mod;
	}

}
