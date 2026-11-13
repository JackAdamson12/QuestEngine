package org.example.questengine.npc.sourse.gui.panels;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ButtonCreator
{

    public ItemStack createButton(Material material, String name)
    {
        ItemStack item = new ItemStack(material);

        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text(name));
        item.setItemMeta(meta);

        return item;
    }


    public void mainMenu(Inventory inventory)
    {
        inventory.setItem(10, createButton(Material.WRITABLE_BOOK, "Name"));
        inventory.setItem(11, createButton(Material.SHIELD, "Invulnerable"));
        inventory.setItem(12, createButton(Material.REDSTONE, "AI"));
        inventory.setItem(13, createButton(Material.GLOWSTONE_DUST, "Glowing"));
        inventory.setItem(14, createButton(Material.NOTE_BLOCK, "Silent"));
        inventory.setItem(15, createButton(Material.ENDER_EYE, "Invisible"));
        inventory.setItem(16, createButton(Material.BOOK, "Quest"));

        inventory.setItem(22, createButton(Material.EMERALD, "Save"));
    }

}
