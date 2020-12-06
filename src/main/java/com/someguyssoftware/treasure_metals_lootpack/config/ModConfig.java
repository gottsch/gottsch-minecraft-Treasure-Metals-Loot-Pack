/**
 * 
 */
package com.someguyssoftware.treasure_metals_lootpack.config;

import com.someguyssoftware.treasure2.config.TreasureConfig;
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
public class ModConfig {
	@Ignore
	public static final String CONFIG_VERSION = "c1.0";
	
	@Ignore
	public static TreasureConfig instance = new TreasureConfig();
	
	/**
	 * 
	 */
	public ModConfig() {}
}
