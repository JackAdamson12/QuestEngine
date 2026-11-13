package org.example.questengine.npc;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.example.questengine.npc.sourse.EditManager;
import org.example.questengine.npc.sourse.NPCSessionManager;
import org.example.questengine.npc.sourse.gui.panels.MainMenu;

import java.util.UUID;

public class NPCManager
{

    private UUID entityUUID;
    private Entity entity;
    private final NPCSessionManager npcSessionManager;
    private final MainMenu mainMenu;

    private EditManager editManager;

    public NPCManager(NPCSessionManager npcSessionManager)
    {
        this.npcSessionManager = npcSessionManager;
        this.mainMenu = new MainMenu();
    }

    public EditManager getEditManager()
    {
        return editManager;
    }


    public boolean choseEntity(Player player)
    {
        RayTraceResult result = player.rayTraceEntities(15);

        if(result == null || result.getHitEntity() == null)
        {
            return false;
        }

        entity = result.getHitEntity();
        entityUUID = entity.getUniqueId();
        editManager = new EditManager(entity);

        npcSessionManager.addSession(player.getUniqueId(),this);
        editEntity(player);

        return true;
    }

    private void editEntity(Player player)
    {
        mainMenu.openMenu(player);
    }

    public void finishEdit(Player player)
    {
        mainMenu.closeMenu(player);
    }

}
