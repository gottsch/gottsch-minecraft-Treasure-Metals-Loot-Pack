/**
 * 
 */
package com.someguyssoftware.treasure_metals_lootpack.config;


import com.someguyssoftware.gottschcore.config.IConfig;
import com.someguyssoftware.treasure_metals_lootpack.TreasureMetalsLP;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Ignore;
import net.minecraftforge.common.config.Config.Type;

/**
 * @author Mark Gottschling on Dec 4, 2020
 *
 */
@Config(modid = TreasureMetalsLP.MODID, name = TreasureMetalsLP.MODID + "/" + TreasureMetalsLP.MODID + "-"
		+ ModConfig.CONFIG_VERSION, type = Type.INSTANCE)
public class ModConfig implements IConfig {
	@Ignore
	public static final String CONFIG_VERSION = "c1.0";
    
	@Comment({"Enables/Disables mod."})
	@Name("01. Enable the mod:")
	public boolean enabled = true;
	
	@Comment({"The directory where mods are located.", "This is relative to the Minecraft install path."})
	@Name("02. Mods folder:")
	public String folder = "mods";
	
	@Comment({"The directory where configs are located.", "Resource files will be located here as well.", "This is relative to the Minecraft install path."})
	@Name("03. Config folder:")
	public String configFolder = "config";
	
	@Comment({"Enables/Disables version checking."})
	@Name("04. Enable the version checker:")
	public boolean enableVersionChecker = true;
	
	@Comment({"The latest published version number.", "This is auto-updated by the version checker.", "This may be @deprecated."})
	@Name("05. Latest mod version available:")
	public String latestVersion = "";
	
	@Comment({"Remind the user of the latest version (as indicated in latestVersion proeprty) update."})
	@Name("06. Enable latest mod version reminder:")
	public boolean latestVersionReminder = true;
    
	@Ignore
	public static ModConfig instance = new ModConfig();
	
	/**
	 * 
	 */
    public ModConfig() {}
    
    @net.minecraftforge.fml.common.Mod.EventBusSubscriber
	public static class EventHandler {
		/**
		 * Inject the new values and save to the config file when the config has been changed from the GUI.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(TreasureMetalsLP.MODID)) {
				ConfigManager.sync(TreasureMetalsLP.MODID, Config.Type.INSTANCE);
			}
		}
    }
    
    @Override
	public boolean isModEnabled() {
		return enabled;
	}

	@Override
	public void setModEnabled(boolean modEnabled) {
		enabled = modEnabled;
	}

	@Override
	public String getModsFolder() {
		return folder;
	}

	@Override
	public void setModsFolder(String modsFolder) {
		folder = modsFolder;
    }
    
	@Override
	public boolean isEnableVersionChecker() {
		return enableVersionChecker;
	}

	@Override
	public String getLatestVersion() {
		return latestVersion;
	}

	@Override
	public void setEnableVersionChecker(boolean enableVersionChecker) {
		enableVersionChecker = enableVersionChecker;
	}

	@Override
	public void setLatestVersion(String latestVersion) {
		this.latestVersion = latestVersion;

	}

	@Override
	public boolean isLatestVersionReminder() {
		return latestVersionReminder;
	}

	@Override
	public void setLatestVersionReminder(boolean latestVersionReminder) {
		this.latestVersionReminder = latestVersionReminder;
	}
}
