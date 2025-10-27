package me.dev_allenalt_tw.betterteamsplus;

import org.bukkit.plugin.java.JavaPlugin;

public class BetterTeamsPlus extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("BetterTeamsPlus enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BetterTeamsPlus disabled!");
    }
}
