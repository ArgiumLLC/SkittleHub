package org.roguemc.skittlehub;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {
    @EventHandler
    public void cancelHunger(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }
    @EventHandler

    public void cancelChat(AsyncChatEvent event) {
        if (event.getPlayer().hasPermission("skittlehub.chat")) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void cancelDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
                event.setCancelled(true);
                ((Player) event.getEntity()).getPlayer().teleport(event.getEntity().getWorld().getSpawnLocation());
            }
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void blockPlaceBreak(BlockPlaceEvent event) {
        if (event.getPlayer().hasPermission("skittlehub.build")) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void blockBreak(BlockPlaceEvent event) {
        if (event.getPlayer().hasPermission("skittlehub.build")) {
            return;
        }
        else {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void dropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }
    @EventHandler
    public void cancelJoin(PlayerJoinEvent event) {
        event.setJoinMessage("");
        Player p = event.getPlayer();
        p.getInventory().clear();
        ItemStack comp = new ItemStack(Material.COMPASS);
        p.getInventory().setItem(4, comp);

    }
    @EventHandler
    public void cancelleave(PlayerQuitEvent event) {
        event.setQuitMessage("");
    }

}
