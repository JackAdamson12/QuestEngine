package org.example.questengine;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.questengine.commandQuestEdit.CommandQuestEdit;
import org.example.questengine.commandSpawnMob.CommandSpawnMob;
import org.example.questengine.commandSpawnMob.SpawnManager;
import org.example.questengine.npc.sourse.NPCSessionManager;

public final class Main extends JavaPlugin
{

    private final NPCSessionManager npcSessionManager = new NPCSessionManager();
    private final SpawnManager spawnManager = new SpawnManager();
    private final CommandQuestEdit questEdit = new CommandQuestEdit();
    @Override
    public void onEnable()
    {
        getCommand("qeditor").setExecutor(questEdit);
        getCommand("spawnmob").setExecutor(new CommandSpawnMob(questEdit));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
