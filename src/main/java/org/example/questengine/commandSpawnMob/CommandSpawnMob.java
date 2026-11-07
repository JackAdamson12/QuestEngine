package org.example.questengine.commandSpawnMob;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.example.questengine.commandQuestEdit.CommandQuestEdit;
import org.example.questengine.commandSpawnMob.sourse.MobType;

import java.util.Arrays;

public class CommandSpawnMob implements CommandExecutor
{

    private final CommandQuestEdit commandQuestEdit;
    private final SpawnManager spawnManager = new SpawnManager();
    //spawn zombie here

    public CommandSpawnMob(CommandQuestEdit commandQuestEdit)
    {
        this.commandQuestEdit = commandQuestEdit;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(!(sender instanceof Player))
        {
            sender.sendMessage("Only players can use this command!");
            return true;
        }


        Player player = (Player) sender;


        if(!commandQuestEdit.cheakIsEnable(player.getUniqueId()))
        {
            sender.sendMessage("Turn on quest editor for this operation");
            return true;
        }

        if(args.length < 2)
        {
            sender.sendMessage("User /spawnmob + [entity] + here");
            return true;
        }

        String[] subArray = Arrays.copyOfRange(args, 0, args.length - 1);
        String mob = String.join( " ", subArray);
        String loc = args[args.length - 1];


        if(loc == null || loc.isBlank())
        {
            sender.sendMessage("Spawn location is empty");
            return true;
        }


        if(loc.equals("here"))
        {
            MobType foundMob = MobType.findEntityType(mob);

            if (foundMob == null) {
                sender.sendMessage("Unknown mob type!");
                return true;
            }

            EntityType entity = foundMob.getEntityType();

            if(spawnManager.spawn(player,entity))
            {
                sender.sendMessage(ChatColor.GREEN + "Spawn is complete!");
                return true;
            }
            else
            {
                sender.sendMessage(ChatColor.RED + "Spawn is fault");
                return true;
            }
        }
        else
        {
            sender.sendMessage("Enter a keyword here to spawn a mob");
            return true;
        }

    }
}
