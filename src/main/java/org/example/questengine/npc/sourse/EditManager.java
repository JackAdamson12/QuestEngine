package org.example.questengine.npc.sourse;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class EditManager
{
    private Entity npc;

    private String name;
    private boolean aiMod;
    private boolean invisible;
    private boolean invulnerable;
    private boolean glowing;
    private boolean silent;

    public EditManager(Entity npc)
    {
        this.npc = npc;
        loadFromEntity();
    }

    private void loadFromEntity()
    {
        this.name = npc.getCustomName();
        this.invisible = npc.isInvisible();
        this.invulnerable = npc.isInvulnerable();
        this.glowing = npc.isGlowing();
        this.silent = npc.isSilent();

        if (npc instanceof LivingEntity living)
        {
            this.aiMod = living.hasAI();
        }
    }

    public Entity getNpc()
    {
        return npc;
    }

    // Name
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // AI
    public boolean getAI()
    {
        return aiMod;
    }

    public void setAI(boolean aiMod)
    {
        this.aiMod = aiMod;
    }

    // Invisible
    public boolean getInvisible()
    {
        return invisible;
    }

    public void setInvisible(boolean invisible)
    {
        this.invisible = invisible;
    }

    // Invulnerable
    public boolean getInvulnerable()
    {
        return invulnerable;
    }

    public void setInvulnerable(boolean invulnerable)
    {
        this.invulnerable = invulnerable;
    }

    // Glowing
    public boolean getGlowing()
    {
        return glowing;
    }

    public void setGlowing(boolean glowing)
    {
        this.glowing = glowing;
    }

    // Silent
    public boolean getSilent()
    {
        return silent;
    }

    public void setSilent(boolean silent)
    {
        this.silent = silent;
    }


    public void saveNPC()
    {
        if(npc == null || !npc.isValid())
        {
            return;
        }

        npc.setCustomName(name);
        npc.setCustomNameVisible(name != null && !name.isBlank());

        npc.setInvulnerable(invulnerable);
        npc.setInvisible(invisible);
        npc.setGlowing(glowing);
        npc.setSilent(silent);

        if(npc instanceof LivingEntity living)
        {
            living.setAI(aiMod);
            living.setRemoveWhenFarAway(false);
        }

        npc.setPersistent(true);


    }
}