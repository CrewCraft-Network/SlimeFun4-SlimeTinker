package io.github.sefiraat.slimetinker.modifiers;

import io.github.sefiraat.slimetinker.SlimeTinker;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Modifications {

    public static final LinkedList<Material> MODIFICAION_LIST = new LinkedList<>();
    public static final Map<Material, Mod> MODIFICATION_DEFINITIONS = new HashMap<>();
    public static final Map<Integer, Integer> MOD_MAP_REDSTONE = new HashMap<>();
    public static final Map<Integer, Integer> MOD_MAP_LAPIS = new HashMap<>();
    public static final Map<Integer, Integer> MOD_MAP_QUARTZ = new HashMap<>();
    public static final Map<Integer, Integer> MOD_MAP_DIAMOND = new HashMap<>();
    public static final Map<Integer, Integer> MOD_MAP_EMERALD = new HashMap<>();
    public static final Map<Integer, Integer> MOD_MAP_OBSIDIAN = new HashMap<>();

    static {

        // ALL NEW MODS MUST BE PLACED AFTER EXISTING ONES
        MODIFICAION_LIST.add(Material.REDSTONE);
        MODIFICAION_LIST.add(Material.LAPIS_LAZULI);
        MODIFICAION_LIST.add(Material.QUARTZ);
        MODIFICAION_LIST.add(Material.DIAMOND);
        MODIFICAION_LIST.add(Material.EMERALD);
        MODIFICAION_LIST.add(Material.OBSIDIAN);

        MOD_MAP_REDSTONE.put(1, 128);
        MOD_MAP_REDSTONE.put(2, 256);
        MOD_MAP_REDSTONE.put(3, 384);
        MOD_MAP_REDSTONE.put(4, 512);
        MODIFICATION_DEFINITIONS.put(Material.REDSTONE, new Mod(MOD_MAP_REDSTONE, SlimeTinker.inst().getKeys().getToolModLevelRedstone()));
        MOD_MAP_LAPIS.put(1, 128);
        MOD_MAP_LAPIS.put(2, 256);
        MOD_MAP_LAPIS.put(3, 384);
        MOD_MAP_LAPIS.put(4, 512);
        MODIFICATION_DEFINITIONS.put(Material.LAPIS_LAZULI, new Mod(MOD_MAP_LAPIS, SlimeTinker.inst().getKeys().getToolModLevelLapis()));
        MOD_MAP_QUARTZ.put(1, 128);
        MOD_MAP_QUARTZ.put(2, 256);
        MOD_MAP_QUARTZ.put(3, 384);
        MOD_MAP_QUARTZ.put(4, 512);
        MODIFICATION_DEFINITIONS.put(Material.QUARTZ, new Mod(MOD_MAP_QUARTZ, SlimeTinker.inst().getKeys().getToolModLevelQuartz()));
        MOD_MAP_DIAMOND.put(1, 128);
        MOD_MAP_DIAMOND.put(2, 256);
        MOD_MAP_DIAMOND.put(3, 384);
        MOD_MAP_DIAMOND.put(4, 512);
        MODIFICATION_DEFINITIONS.put(Material.DIAMOND, new Mod(MOD_MAP_DIAMOND, SlimeTinker.inst().getKeys().getToolModLevelDiamond()));
        MOD_MAP_EMERALD.put(1, 128);
        MOD_MAP_EMERALD.put(2, 256);
        MOD_MAP_EMERALD.put(3, 384);
        MOD_MAP_EMERALD.put(4, 512);
        MODIFICATION_DEFINITIONS.put(Material.EMERALD, new Mod(MOD_MAP_EMERALD, SlimeTinker.inst().getKeys().getToolModLevelEmerald()));
        MOD_MAP_OBSIDIAN.put(1, 128);
        MOD_MAP_OBSIDIAN.put(2, 256);
        MOD_MAP_OBSIDIAN.put(3, 384);
        MOD_MAP_OBSIDIAN.put(4, 512);
        MODIFICATION_DEFINITIONS.put(Material.OBSIDIAN, new Mod(MOD_MAP_OBSIDIAN, SlimeTinker.inst().getKeys().getToolModLevelObsidian()));

    }

    public static void setModificationMap(PersistentDataContainer c, LinkedHashMap<Material, Integer> map) {
        int[] mapArray = new int[MODIFICAION_LIST.size()];
        for (int i = 0; i < MODIFICAION_LIST.size(); i++) {
            mapArray[i] = map.get(MODIFICAION_LIST.get(i));
        }
        c.set(SlimeTinker.inst().getKeys().getToolMods(), PersistentDataType.INTEGER_ARRAY, mapArray);
    }

    public static LinkedHashMap<Material, Integer> getModificationMap(ItemStack itemStack) {
        LinkedHashMap<Material, Integer> map = new LinkedHashMap<>();
        ItemMeta im = itemStack.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        if (c.has(SlimeTinker.inst().getKeys().getToolMods(), PersistentDataType.INTEGER_ARRAY)) {
            int[] mapArray = c.get(SlimeTinker.inst().getKeys().getToolMods(), PersistentDataType.INTEGER_ARRAY);
            assert mapArray != null;
            for (Material m : MODIFICAION_LIST) {
                if ((MODIFICAION_LIST.indexOf(m) + 1) > mapArray.length) {
                    map.put(m, 0);
                } else {
                    map.put(m, mapArray[MODIFICAION_LIST.indexOf(m)]);
                }
            }
        } else {
            for (Material m : MODIFICAION_LIST) {
                map.put(m, 0);
            }
            setModificationMap(c, map);
            itemStack.setItemMeta(im);
        }
        return map;
    }

    public static LinkedHashMap<Material, Integer> getModificationMap(PersistentDataContainer c) {
        LinkedHashMap<Material, Integer> map = new LinkedHashMap<>();
        if (c.has(SlimeTinker.inst().getKeys().getToolMods(), PersistentDataType.INTEGER_ARRAY)) {
            int[] mapArray = c.get(SlimeTinker.inst().getKeys().getToolMods(), PersistentDataType.INTEGER_ARRAY);
            assert mapArray != null;
            for (Material m : MODIFICAION_LIST) {
                if ((MODIFICAION_LIST.indexOf(m) + 1) > mapArray.length) {
                    map.put(m, 0);
                } else {
                    map.put(m, mapArray[MODIFICAION_LIST.indexOf(m)]);
                }
            }
        } else {
            for (Material m : MODIFICAION_LIST) {
                map.put(m, 0);
            }
            setModificationMap(c, map);
        }
        return map;
    }

    public static int getModLevel(Mod mod, ItemStack itemStack) {
        if (itemStack.getItemMeta().getPersistentDataContainer().has(mod.getLevelKey(), PersistentDataType.INTEGER)) {
            return itemStack.getItemMeta().getPersistentDataContainer().get(mod.getLevelKey(), PersistentDataType.INTEGER);
        } else {
            return 0;
        }
    }

    public static void setModLevel(Mod mod, PersistentDataContainer c, int level) {
        c.set(mod.getLevelKey(), PersistentDataType.INTEGER, level);
    }

    public static Map<Material, Integer> getAllModLevels(ItemStack itemStack) {
        Map<Material, Integer> map = new HashMap<>();
        for (Material m : MODIFICAION_LIST) {
            int level = getModLevel(MODIFICATION_DEFINITIONS.get(m), itemStack);
            Integer progress = getModificationMap(itemStack).get(m);
            if (level > 0 || (progress != null && progress > 0)) { // Has level or progress towards level
                map.put(m, level);
            }
        }
        return map;
    }


}
