package org.example.questengine.npc.sourse.gui.events;

import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.example.questengine.npc.NPCManager;
import org.example.questengine.npc.sourse.EditManager;
import org.example.questengine.npc.sourse.NPCSessionManager;
import org.example.questengine.npc.sourse.dialogapi.NPCNameDialog;
import org.example.questengine.npc.sourse.gui.panels.MainMenu;

public class MainMenuListener implements Listener
{
    private final NPCSessionManager npcSessionManager;


    public MainMenuListener(NPCSessionManager npcSessionManager)
    {
        this.npcSessionManager = npcSessionManager;
    }

    private final NPCNameDialog npcNameDialog = new NPCNameDialog();
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }
        if (!event.getView().getTitle().equals("NPC Editor")) {
            return;
        }
        if (event.getClickedInventory() == null)
            return;

        if (event.getClickedInventory() != event.getView().getTopInventory())
            return;

        event.setCancelled(true);

        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR)
            return;

        NPCManager npcManager = npcSessionManager.getSession(player.getUniqueId());
        EditManager editManager = npcManager.getEditManager();

        if (event.getSlot() == 10) {
            npcNameDialog.open(player, editManager);
        }

        if (event.getSlot() == 11) {
            if (editManager.getInvulnerable()) {
                editManager.setInvulnerable(false);
                player.sendMessage(ChatColor.RED + "Invulnerable: Disabled");
            } else {
                editManager.setInvulnerable(true);
                player.sendMessage(ChatColor.GREEN + "Invulnerable: Enabled");
            }
        }

        if (event.getSlot() == 12) {
            if (editManager.getAI()) {
                editManager.setAI(false);
                player.sendMessage(ChatColor.RED + "AI: Disabled");
            } else {
                editManager.setAI(true);
                player.sendMessage(ChatColor.GREEN + "AI: Enabled");
            }
        }

        if (event.getSlot() == 13) {
            if (editManager.getGlowing()) {
                editManager.setGlowing(false);
                player.sendMessage(ChatColor.RED + "Glowing: Disabled");
            } else {
                editManager.setGlowing(true);
                player.sendMessage(ChatColor.GREEN + "Glowing: Enabled");
            }
        }

        if (event.getSlot() == 14) {
            if (editManager.getSilent()) {
                editManager.setSilent(false);
                player.sendMessage(ChatColor.RED + "Silent: Disabled");
            } else {
                editManager.setSilent(true);
                player.sendMessage(ChatColor.GREEN + "Silent: Enabled");
            }
        }

        if (event.getSlot() == 15) {
            if (editManager.getInvisible()) {
                editManager.setInvisible(false);
                player.sendMessage(ChatColor.RED + "Invisible: Disabled");
            } else {
                editManager.setInvisible(true);
                player.sendMessage(ChatColor.GREEN + "Invisible: Enabled");
            }
        }

        if (event.getSlot() == 16)
        {
            // Quest Editor
        }

        if (event.getSlot() == 22) {
            editManager.saveNPC();
            player.sendMessage(ChatColor.GREEN + "NPC settings saved successfully!");
            npcManager.finishEdit(player);
            npcSessionManager.removeSession(player.getUniqueId());
        }

    }

}
