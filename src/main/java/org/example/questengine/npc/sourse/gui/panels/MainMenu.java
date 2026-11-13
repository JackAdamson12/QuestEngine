package org.example.questengine.npc.sourse.gui.panels;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MainMenu
{
    private static final int SLOTS = 27;
    private final ButtonCreator bc = new ButtonCreator();

    public void openMenu(Player player)
    {
        Inventory mainMenu = Bukkit.createInventory(null,SLOTS,"NPC Editor");
        bc.mainMenu(mainMenu);
        player.openInventory(mainMenu);

    }

    public void closeMenu(Player player)
    {
        player.closeInventory();
    }

}
