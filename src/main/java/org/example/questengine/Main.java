package org.example.questengine;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.questengine.commandQuestEdit.CommandQuestEdit;
import org.example.questengine.commandSpawnMob.CommandSpawnMob;
import org.example.questengine.commandSpawnMob.SpawnManager;
import org.example.questengine.npc.CommandEditThis;
import org.example.questengine.npc.NPCManager;
import org.example.questengine.npc.sourse.EditManager;
import org.example.questengine.npc.sourse.NPCSessionManager;
import org.example.questengine.npc.sourse.gui.events.MainMenuListener;

public final class Main extends JavaPlugin
{

    private final NPCSessionManager npcSessionManager = new NPCSessionManager();
    private final SpawnManager spawnManager = new SpawnManager();
    private final CommandQuestEdit questEdit = new CommandQuestEdit();
    private final NPCManager npcManager = new NPCManager(npcSessionManager);
    @Override
    public void onEnable()
    {
        getCommand("qeditor").setExecutor(questEdit);
        getCommand("spawnmob").setExecutor(new CommandSpawnMob(questEdit));

        getCommand("editthis").setExecutor(new CommandEditThis(questEdit,npcSessionManager));
        getServer().getPluginManager().registerEvents(new MainMenuListener(npcSessionManager), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
