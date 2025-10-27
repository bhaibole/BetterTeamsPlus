package dev.allenalt.tw.betterteamsplus;

import org.bukkit.plugin.java.JavaPlugin;

public class BetterTeamsPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("BetterTeamsPlus has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BetterTeamsPlus has been disabled.");
    }
}
