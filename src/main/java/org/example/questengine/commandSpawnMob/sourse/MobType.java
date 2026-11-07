package org.example.questengine.commandSpawnMob.sourse;

import org.bukkit.entity.EntityType;

public enum MobType {

    // Пассивные и нейтральные
    ALLAY(EntityType.ALLAY),
    ARMADILLO(EntityType.ARMADILLO),
    AXOLOTL(EntityType.AXOLOTL),
    BAT(EntityType.BAT),
    BEE(EntityType.BEE),
    CAMEL(EntityType.CAMEL),
    CAT(EntityType.CAT),
    CHICKEN(EntityType.CHICKEN),
    COD(EntityType.COD),
    COPPER_GOLEM(EntityType.COPPER_GOLEM),
    COW(EntityType.COW),
    DOLPHIN(EntityType.DOLPHIN),
    DONKEY(EntityType.DONKEY),
    FOX(EntityType.FOX),
    FROG(EntityType.FROG),
    GHAST_HAPPY(EntityType.HAPPY_GHAST),
    GLOW_SQUID(EntityType.GLOW_SQUID),
    GOAT(EntityType.GOAT),
    HORSE(EntityType.HORSE),
    IRON_GOLEM(EntityType.IRON_GOLEM),
    LLAMA(EntityType.LLAMA),
    MOOSHROOM(EntityType.MOOSHROOM),
    MULE(EntityType.MULE),
    NAUTILUS(EntityType.NAUTILUS),
    OCELOT(EntityType.OCELOT),
    PANDA(EntityType.PANDA),
    PARROT(EntityType.PARROT),
    PIG(EntityType.PIG),
    POLAR_BEAR(EntityType.POLAR_BEAR),
    PUFFERFISH(EntityType.PUFFERFISH),
    RABBIT(EntityType.RABBIT),
    SALMON(EntityType.SALMON),
    SHEEP(EntityType.SHEEP),
    SKELETON_HORSE(EntityType.SKELETON_HORSE),
    SNIFFER(EntityType.SNIFFER),
    SNOW_GOLEM(EntityType.SNOW_GOLEM),
    SQUID(EntityType.SQUID),
    STRIDER(EntityType.STRIDER),
    TADPOLE(EntityType.TADPOLE),
    TRADER_LLAMA(EntityType.TRADER_LLAMA),
    TROPICAL_FISH(EntityType.TROPICAL_FISH),
    TURTLE(EntityType.TURTLE),
    VILLAGER(EntityType.VILLAGER),
    WANDERING_TRADER(EntityType.WANDERING_TRADER),
    WOLF(EntityType.WOLF),
    ZOMBIE_HORSE(EntityType.ZOMBIE_HORSE),

    // Враждебные
    BLAZE(EntityType.BLAZE),
    BOGGED(EntityType.BOGGED),
    BREEZE(EntityType.BREEZE),
    CAMEL_HUSK(EntityType.CAMEL_HUSK),
    CAVE_SPIDER(EntityType.CAVE_SPIDER),
    CREAKING(EntityType.CREAKING),
    CREEPER(EntityType.CREEPER),
    DROWNED(EntityType.DROWNED),
    ELDER_GUARDIAN(EntityType.ELDER_GUARDIAN),
    ENDERMAN(EntityType.ENDERMAN),
    ENDERMITE(EntityType.ENDERMITE),
    EVOKER(EntityType.EVOKER),
    GHAST(EntityType.GHAST),
    GUARDIAN(EntityType.GUARDIAN),
    HOGLIN(EntityType.HOGLIN),
    HUSK(EntityType.HUSK),
    MAGMA_CUBE(EntityType.MAGMA_CUBE),
    PARCHED(EntityType.PARCHED),
    PHANTOM(EntityType.PHANTOM),
    PIGLIN(EntityType.PIGLIN),
    PIGLIN_BRUTE(EntityType.PIGLIN_BRUTE),
    PILLAGER(EntityType.PILLAGER),
    RAVAGER(EntityType.RAVAGER),
    SHULKER(EntityType.SHULKER),
    SILVERFISH(EntityType.SILVERFISH),
    SKELETON(EntityType.SKELETON),
    SLIME(EntityType.SLIME),
    SPIDER(EntityType.SPIDER),
    STRAY(EntityType.STRAY),
    VEX(EntityType.VEX),
    VINDICATOR(EntityType.VINDICATOR),
    WARDEN(EntityType.WARDEN),
    WITCH(EntityType.WITCH),
    WITHER_SKELETON(EntityType.WITHER_SKELETON),
    ZOGLIN(EntityType.ZOGLIN),
    ZOMBIE(EntityType.ZOMBIE),
    ZOMBIE_NAUTILUS(EntityType.ZOMBIE_NAUTILUS),
    ZOMBIE_VILLAGER(EntityType.ZOMBIE_VILLAGER),
    ZOMBIFIED_PIGLIN(EntityType.ZOMBIFIED_PIGLIN),

    // Боссы и специальные мобы
    ENDER_DRAGON(EntityType.ENDER_DRAGON),
    WITHER(EntityType.WITHER),
    GIANT(EntityType.GIANT),
    ILLUSIONER(EntityType.ILLUSIONER);

    private final EntityType entityType;

    MobType(EntityType entityType) {
        this.entityType = entityType;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public static MobType findEntityType(String mob)
    {
        if(mob == null || mob.isBlank())
        {
            return null;
        }

        String[] word = mob.split("");
        StringBuilder newStrMob = new StringBuilder();
        for(String symbol : word)
        {
            if(symbol.equals(" "))
            {
                symbol = "_";
            }
            newStrMob.append(symbol);
        }

        String res = newStrMob.toString().toUpperCase();


        for(MobType entity : MobType.values())
        {
            if(res.equals(entity.name()))
            {
                return entity;
            }

        }
        return null;
    }
}
