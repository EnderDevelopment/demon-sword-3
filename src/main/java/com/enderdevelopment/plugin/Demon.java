package com.enderdevelopment.plugin;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Demon {
    private final Main plugin;

    public Demon(Main plugin) {
        this.plugin = plugin;
    }

    public void spawnDemon(Player player) {
        Location location = player.getLocation().add(0, 1, 0);
        Zombie demon = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        demon.setCustomName("Demon");
        demon.setCustomNameVisible(true);
        demon.setAdult();
        demon.setAI(true);
        demon.setRemoveWhenFarAway(false);
        demon.setMaxHealth(2000);
        demon.setHealth(2000);
        demon.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 255, false, false));

        // Add more demon properties and abilities here
    }
}