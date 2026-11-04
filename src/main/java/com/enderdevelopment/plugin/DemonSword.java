package com.enderdevelopment.plugin;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class DemonSword {
    private final Main plugin;

    public DemonSword(Main plugin) {
        this.plugin = plugin;
    }

    public ItemStack createDemonSword() {
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = sword.getItemMeta();

        if (meta != null) {
            meta.setDisplayName("Demon Sword");
            meta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft("sharpness")), 5, true);
            meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
            meta.addEnchant(Enchantment.KNOCKBACK, 2, true);

            NamespacedKey key = new NamespacedKey(plugin, "demon_sword");
            meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 1);

            sword.setItemMeta(meta);
        }

        return sword;
    }
}