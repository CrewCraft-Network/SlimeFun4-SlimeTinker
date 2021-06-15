package io.github.sefiraat.slimetinker.items;

import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AbstractItem extends SlimefunItemStack implements NotPlaceable {

    private final String id;

    public AbstractItem(String id, Material type, String name, String... lore) {
        super(id, type, name, lore);
        this.id = id;
    }

    public AbstractItem(String id, ItemStack item, String name, String... lore) {
        super(id, item, name, lore);
        this.id = id;
    }

    public AbstractItem(String id, String texture, String name, String... lore) {
        super(id, texture, name, lore);
        this.id = id;
    }

    @Override
    public @NotNull String getId() {
        return id;
    }

}
