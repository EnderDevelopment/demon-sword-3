package com.enderdevelopment.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public class DemonListener implements Listener {
    private final Main plugin;

    public DemonListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item != null && item.hasItemMeta()) {
                NamespacedKey key = new NamespacedKey(plugin, "demon_sword");
                Integer value = item.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER);

                if (value != null && value == 1) {
                    Demon demon = new Demon(plugin);
                    demon.spawnDemon(player);
                }
            }
        }
    }
}