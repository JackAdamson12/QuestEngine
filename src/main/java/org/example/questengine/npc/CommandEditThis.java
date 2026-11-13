package org.example.questengine.npc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.questengine.commandQuestEdit.CommandQuestEdit;
import org.example.questengine.npc.sourse.NPCSessionManager;

public class CommandEditThis implements CommandExecutor
{
    private final CommandQuestEdit commandQuestEdit;
    private final NPCSessionManager npcSessionManager;
    private final NPCManager npcManager;

    public  CommandEditThis(CommandQuestEdit commandQuestEdit, NPCSessionManager npcSessionManager)
    {
        this.commandQuestEdit = commandQuestEdit;
        this.npcSessionManager = npcSessionManager;
        this.npcManager = new NPCManager(npcSessionManager);
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
        NPCManager npcManager = new NPCManager(npcSessionManager);
        if(!npcManager.choseEntity(player))
        {
            sender.sendMessage("Npc are not found");
            return true;
        }

        npcManager.choseEntity(player);





        return true;
    }

}
