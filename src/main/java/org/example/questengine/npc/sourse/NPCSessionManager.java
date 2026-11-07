package org.example.questengine.npc.sourse;

import org.example.questengine.npc.NPCManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NPCSessionManager
{
    private final Map<UUID, NPCManager> ActiveSessions;

    public NPCSessionManager()
    {
        ActiveSessions = new HashMap<>();
    }


    public boolean addSession(UUID user, NPCManager session)
    {
        if(user == null || session == null)
        {
            return false;
        }

        if(checkSession(user))
        {
            return false;
        }

        ActiveSessions.put(user, session);
        return true;

    }

    public boolean removeSession(UUID user)
    {
        if(user == null)
        {
            return false;
        }

        if(!checkSession(user))
        {
            return false;
        }
        ActiveSessions.remove(user);
        return true;
    }

    public boolean checkSession(UUID user)
    {
        if(!ActiveSessions.containsKey(user))
        {
            return false;
        }

        return true;
    }

    public NPCManager getSession(UUID uuid)
    {
        return ActiveSessions.get(uuid);

    }

}
