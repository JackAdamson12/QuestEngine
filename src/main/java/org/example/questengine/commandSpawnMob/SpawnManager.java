package org.example.questengine.commandSpawnMob;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;

import org.bukkit.Location;

public class SpawnManager
{

    public boolean spawn(Player player, EntityType entitySpawn)
    {
        if (player == null || entitySpawn == null)
        {
            return false;
        }

        if (!entitySpawn.isSpawnable())
        {
            return false;
        }

        RayTraceResult result = player.rayTraceBlocks(50);
        Location location;

        if (result == null)
        {
            player.sendMessage("Spawn error");
            return false;
        }
        location = result.getHitPosition().toLocation(player.getWorld());
        location.add(0, 0.1, 0);

        try
        {
            Entity entity = player.getWorld().spawnEntity(location,entitySpawn);
            return true;
        }
        catch (IllegalArgumentException | IllegalStateException e)
        {
            e.printStackTrace();
            return false;
        }

    }



}

