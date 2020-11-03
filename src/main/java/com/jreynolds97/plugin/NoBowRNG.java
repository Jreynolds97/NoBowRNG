package com.jreynolds97.plugin;

import org.bukkit.plugin.java.JavaPlugin;
/**
 * No Bow RNG Main
 * Author: Justin Reynolds
 */
public class NoBowRNG extends JavaPlugin {
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new bowListener(), this);
    }
}
