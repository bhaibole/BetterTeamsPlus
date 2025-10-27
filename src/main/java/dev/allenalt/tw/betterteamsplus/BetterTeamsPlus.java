package dev.allenalt.tw.betterteamsplus;

import dev.allenalt.tw.betterteamsplus.commands.TeamCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class BetterTeamsPlus extends JavaPlugin {

    private static BetterTeamsPlus instance;
    public static BetterTeamsPlus getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        saveMessages();

        getCommand("team").setExecutor(new TeamCommand());
        getLogger().info("BetterTeamsPlus v1.1 enabled with GUI & custom config support!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BetterTeamsPlus disabled.");
    }

    private void saveMessages() {
        File msgFile = new File(getDataFolder(), "messages.yml");
        if (!msgFile.exists()) {
            saveResource("messages.yml", false);
        }
    }

    public FileConfiguration getMessages() {
        return YamlConfiguration.loadConfiguration(new File(getDataFolder(), "messages.yml"));
    }
}
