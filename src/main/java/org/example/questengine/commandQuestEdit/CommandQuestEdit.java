package org.example.questengine.commandQuestEdit;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommandQuestEdit implements CommandExecutor
{


    final private Map<UUID,Boolean> users = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        if(!sender.hasPermission("questengine.editor"))
        {
            sender.sendMessage("No permission");
            return true;
        }

        if(!(sender instanceof Player))
        {
            sender.sendMessage("Its command not for console");
            return true;
        }

        if(args.length != 0)
        {
            sender.sendMessage("Usage: /questeditor");
            return true;
        }


        Player player = (Player) sender;

        if (!(users.containsKey(player.getUniqueId())))
        {
            users.put(player.getUniqueId(), true);
        }
        else
        {
            if (cheakIsEnable(player.getUniqueId()))
            {
                disableMod(player.getUniqueId());
                sender.sendMessage("Quest editor is off");
            }
            else
            {
                enableMod(player.getUniqueId());
                sender.sendMessage("Quest editor is on");
            }
        }




        return true;
    }

    public boolean cheakIsEnable(UUID uuid)
    {
        if(users.containsKey(uuid))
        {
            boolean enable = users.get(uuid);
            if(enable)
            {
                return true;
            }
            return false;
        }
        return false;
    }

    private void enableMod(UUID uuid )
    {

        if(users.containsKey(uuid))
        {
            users.replace(uuid,true);
        }
        else return;
    }

    private void disableMod(UUID uuid )
    {

        if(users.containsKey(uuid))
        {
            users.replace(uuid,false);
        }
        else return;
    }
}
