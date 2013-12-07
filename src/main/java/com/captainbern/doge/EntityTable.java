package com.captainbern.doge;

import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.List;

public class EntityTable {

    private final HashMap<EntityType, EntityType> LOOKUP = new HashMap<EntityType, EntityType>();

    public EntityTable(List<String> list) {
        for(String string : list) {
            String[] split = string.split(":");
            if(split.length < 2) {
                Doge.LOGGER.warning("Invalid setting at: " + string);
                continue;
            }
            LOOKUP.put(EntityType.valueOf(split[0].toUpperCase()), EntityType.valueOf(split[1].toUpperCase()));
        }
    }

    public EntityType getDisguiseIdFor(EntityType type) {
        if(!LOOKUP.containsKey(type))
            return type;
        return LOOKUP.get(type);
    }

    public HashMap<EntityType, EntityType> getLookUpTable() {
        return LOOKUP;
    }

    public boolean contains(EntityType type) {
        return LOOKUP.containsKey(type);
    }
}
