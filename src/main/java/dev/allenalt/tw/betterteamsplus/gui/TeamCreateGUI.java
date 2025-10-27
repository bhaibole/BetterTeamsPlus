package dev.allenalt.tw.betterteamsplus.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class TeamCreateGUI implements Listener {

    public void open(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Create Your Team");

        ItemStack confirm = new ItemStack(Material.LIME_CONCRETE);
        ItemMeta meta = confirm.getItemMeta();
        meta.setDisplayName("§aConfirm Creation");
        meta.setLore(List.of("§7Click to create a team!", "", "§eYou will be asked for a name"));
        confirm.setItemMeta(meta);

        gui.setItem(13, confirm);

        player.openInventory(gui);
        Bukkit.getPluginManager().registerEvents(this, Bukkit.getPluginManager().getPlugin("BetterTeamsPlus"));
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Create Your Team")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.LIME_CONCRETE) {
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage("§ePlease type your new team name in chat.");
            }
        }
    }
}
