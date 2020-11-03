package com.jreynolds97.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import com.jreynolds97.plugin.bowListener;
/**
 * Hello world!
 *
 */
public class NoBowRNG extends JavaPlugin {
    public void onEnable(){
        getLogger().info("Bow RNG disabling enabled");
        getServer().getPluginManager().registerEvents(new bowListener(), this);
    }

    public void onDisable(){
        getLogger().info("Bow RNG disabling shutdown");
    }
}
