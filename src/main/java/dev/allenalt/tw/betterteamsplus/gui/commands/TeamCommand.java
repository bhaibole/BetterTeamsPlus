package dev.allenalt.tw.betterteamsplus.commands;

import dev.allenalt.tw.betterteamsplus.BetterTeamsPlus;
import dev.allenalt.tw.betterteamsplus.gui.TeamCreateGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("create")) {
            if (BetterTeamsPlus.getInstance().getConfig().getBoolean("team-gui-enabled")) {
                player.sendMessage(color(getMsg("team-create-start")));
                new TeamCreateGUI().open(player);
            } else {
                player.sendMessage(color(getMsg("team-name-prompt")));
            }
        } else {
            player.sendMessage(color("&7Usage: /team create"));
        }

        return true;
    }

    private String getMsg(String key) {
        return BetterTeamsPlus.getInstance().getMessages().getString(key)
                .replace("&", "§");
    }

    private String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
