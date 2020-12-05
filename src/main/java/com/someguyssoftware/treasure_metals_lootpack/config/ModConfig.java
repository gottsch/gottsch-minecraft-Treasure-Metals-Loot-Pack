/**
 * 
 */
package com.someguyssoftware.treasure_metals_lootpack.config;

import com.someguyssoftware.treasure_metals_lootpack.ModApp;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Ignore;
import net.minecraftforge.common.config.Config.Type;

/**
 * @author Mark Gottschling on Dec 4, 2020
 *
 */
@Config(modid = ModApp.MODID, name = ModApp.MODID + "/" + ModApp.MODID + "-"
		+ ModConfig.CONFIG_VERSION, type = Type.INSTANCE)
public class ModConfig {
	@Ignore
	public static final String CONFIG_VERSION = "c1.0";
}
