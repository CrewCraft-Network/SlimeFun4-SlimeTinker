package io.github.sefiraat.slimetinker.utils;

import io.github.sefiraat.slimetinker.items.materials.AbstractItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class ThemeUtils {

    private ThemeUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static final String PREFIX = "" + ChatColor.GRAY + "[Slime Tinker] ";
    public static final String SUFFIX = "" + ChatColor.GRAY + "";

    public static final ChatColor WARNING = ChatColor.YELLOW;
    public static final ChatColor ERROR = ChatColor.RED;
    public static final ChatColor NOTICE = ChatColor.WHITE;
    public static final ChatColor PASSIVE = ChatColor.GRAY;
    public static final ChatColor SUCCESS = ChatColor.GREEN;

    public static final ChatColor MAIN = ChatColor.of("#21588f");
    public static final ChatColor GUI_HEAD = ChatColor.of("#03fcdf");
    public static final ChatColor CLICK_INFO = ChatColor.of("#e4ed32");
    public static final ChatColor ITEM_TYPEDESC = ChatColor.of("#f0ea4f");
    public static final ChatColor ITEM_CRAFTING = ChatColor.of("#dbcea9");
    public static final ChatColor ITEM_MACHINE = ChatColor.of("#3295a8");
    public static final ChatColor ITEM_RARE_DROP = ChatColor.of("#bf307f");
    public static final ChatColor ITEM_BASE = ChatColor.of("#9e9e9e");
    public static final ChatColor ITEM_CHEST = ChatColor.of("#b89b1c");
    public static final ChatColor ITEM_MOLTEN_METAL = ChatColor.of("#a60a0a");
    public static final ChatColor ITEM_LIQUID = ChatColor.of("#65dbb4");

    public static final String LORE_TYPE_CRAFT = ITEM_TYPEDESC + "Crafting Material";
    public static final String LORE_TYPE_MACHINE = ITEM_TYPEDESC + "Machine";
    public static final String LORE_TYPE_DROP = ITEM_TYPEDESC + "Drop";
    public static final String LORE_TYPE_BASE = ITEM_TYPEDESC + "Base Resource";
    public static final String LORE_TYPE_CHEST = ITEM_TYPEDESC + "Chest";
    public static final String LORE_MOLTEN_METAL = ITEM_TYPEDESC + "Molten Metal";
    public static final String LORE_LIQUID = ITEM_TYPEDESC + "Liquid";

    public static SlimefunItemStack themedItemStack(String id, String skull, SimpleItemType type, String name, String... loreLines) {
        AbstractItem itemStack = new AbstractItem(
                id,
                skull,
                itemTypeColor(type) + name,
                ""
        );
        ItemMeta im = itemStack.getItemMeta();
        List<String> lore = im.getLore();
        for (String s : loreLines) {
            lore.add(ThemeUtils.PASSIVE + s);
        }
        lore.add("");
        lore.add(itemTypeDescriptor(type));
        im.setLore(lore);
        itemStack.setItemMeta(im);
        return itemStack;
    }

    public static SlimefunItemStack themedItemStack(String id, Material material, SimpleItemType type, String name, String... loreLines) {
        AbstractItem itemStack = new AbstractItem(
                id,
                material,
                itemTypeColor(type) + name,
                ""
        );
        ItemMeta im = itemStack.getItemMeta();
        List<String> lore = im.getLore();
        for (String s : loreLines) {
            lore.add(ThemeUtils.PASSIVE + s);
        }
        lore.add("");
        lore.add(itemTypeDescriptor(type));
        im.setLore(lore);
        itemStack.setItemMeta(im);
        return itemStack;
    }

    public static ChatColor itemTypeColor(SimpleItemType type) {
        switch (type) {
            case DROP: return ITEM_RARE_DROP;
            case CHEST: return ITEM_CHEST;
            case MACHINE: return ITEM_MACHINE;
            case CRAFTING: return ITEM_CRAFTING;
            case MOLTEN_METAL: return ITEM_MOLTEN_METAL;
            case LIQUID: return ITEM_LIQUID;
            default: return ITEM_BASE;
        }
    }

    public static String itemTypeDescriptor(SimpleItemType type) {
        switch (type) {
            case DROP: return LORE_TYPE_DROP;
            case CHEST: return LORE_TYPE_CHEST;
            case MACHINE: return LORE_TYPE_MACHINE;
            case CRAFTING: return LORE_TYPE_CRAFT;
            case MOLTEN_METAL: return LORE_MOLTEN_METAL;
            case LIQUID: return LORE_LIQUID;
            default: return LORE_TYPE_BASE;
        }
    }

    public static String toTitleCase(String string) {
        final char[] delimiters = { ' ', '_' };
        return WordUtils.capitalizeFully(string, delimiters);
    }

    public enum SimpleItemType {
        CRAFTING,
        MACHINE,
        CHEST,
        DROP,
        BASE,
        MOLTEN_METAL,
        LIQUID
    }

}
