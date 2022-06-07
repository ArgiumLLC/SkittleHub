package org.roguemc.skittlehub;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

public class Compass implements Listener {
    private SkittleHub mainClass = SkittleHub.getPlugin(SkittleHub.class);

    @EventHandler
    public void fireGUI(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Action a = event.getAction();
        if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK) {
            if (p.getItemInHand().getType() == Material.COMPASS) {
            p.openInventory(inv);
            }
        }
    }
    public final Inventory inv;
    public Compass() {
        inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "Compass");
        initalizeitems();
    }
    ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short) 0);


    public void initalizeitems() {
        ItemStack feather = new ItemStack(Material.FEATHER, 1);
        ItemMeta feathermeta = feather.getItemMeta();
        feathermeta.setDisplayName("§b§lComing Soon");
        feathermeta.setLore(Collections.singletonList("§7Click to join"));
        feather.setItemMeta(feathermeta);
        ItemStack slime = new ItemStack(Material.SLIME_BALL, 1);
        ItemMeta slimemeta = slime.getItemMeta();
        slimemeta.setDisplayName("§a§lSurvival");
        slimemeta.setLore(Collections.singletonList("§7Click to join"));
        slime.setItemMeta(slimemeta);
        ItemStack magma = new ItemStack(Material.MAGMA_CREAM, 1);
        ItemMeta magmameta = magma.getItemMeta();
        magmameta.setDisplayName("§e§lComing Soon");
        magmameta.setLore(Collections.singletonList("§7Click to join"));
        magma.setItemMeta(magmameta);
        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        inv.setItem(9, glass);
        inv.setItem(10, glass);
        inv.setItem(11, feather);
        inv.setItem(12, glass);
        inv.setItem(13, slime);
        inv.setItem(14, glass);
        inv.setItem(15, magma);
        inv.setItem(16, glass);
        inv.setItem(17, glass);
        inv.setItem(18, glass);
        inv.setItem(19, glass);
        inv.setItem(20, glass);
        inv.setItem(21, glass);
        inv.setItem(22, glass);
        inv.setItem(23, glass);
        inv.setItem(24, glass);
        inv.setItem(25, glass);
        inv.setItem(26, glass);




    }
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        e.setCancelled(true);


        final ItemStack clickedItem = e.getCurrentItem();
        // verify current item is not null
        if (clickedItem == null || clickedItem.getType().isAir()) return;
        if (clickedItem.getItemMeta().getDisplayName().equals("§a§lSurvival")) {
        Player p = (Player) e.getWhoClicked();
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("lobby");
            p.sendPluginMessage(mainClass, "BungeeCord", out.toByteArray());
        }
    }


}
