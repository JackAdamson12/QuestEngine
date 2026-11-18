package org.example.questengine.npc.sourse.dialogapi.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.example.questengine.npc.sourse.dialogapi.NPCTalkDialog;

import java.util.UUID;

public class ClickMobListener implements Listener
{
    @EventHandler
    public void onNpcClick(PlayerInteractEntityEvent event)
    {

        if(!event.getHand().equals(EquipmentSlot.HAND))
        {
            return;
        }
        Entity mob = event.getRightClicked();

        if(mob.customName() == null)
        {
            return;
        }
        event.setCancelled(true);

        Player player = event.getPlayer();

        NPCTalkDialog npcTalkDialog = new NPCTalkDialog();
        npcTalkDialog.open(player,mob.getUniqueId());

    }
}
