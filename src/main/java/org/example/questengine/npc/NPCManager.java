package org.example.questengine.npc;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.example.questengine.npc.sourse.NPCSessionManager;

import java.util.UUID;

public class NPCManager
{

    private UUID entityUUID;
    private Entity entity;
    private final NPCSessionManager npcSessionManager;

    public NPCManager(NPCSessionManager npcSessionManager)
    {
        this.npcSessionManager = npcSessionManager;
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

        npcSessionManager.addSession(player.getUniqueId(),this);
        //editEntity();

       // npcSessionManager.removeSession(player.getUniqueId());
        return true;
    }

    public void editEntity(Player player)
    {

    }

}
