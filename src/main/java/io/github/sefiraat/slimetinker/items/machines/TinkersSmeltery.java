package io.github.sefiraat.slimetinker.items.machines;

import io.github.mooy1.infinitylib.slimefun.AbstractContainer;
import io.github.sefiraat.slimetinker.items.gui.GUIItems;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class TinkersSmeltery extends AbstractContainer {

    private static final int[] BACKGROUND_SLOTS = {27,28,29,30,31,32,33,34,35,36,40,44,45,46,47,48,49,50,51,52,53};
    private static final int[] BACKGROUND_INPUT_SLOTS = {0,1,2,9,11,18,19,20};
    private static final int[] BACKGROUND_CAST_SLOTS = {3,4,5,12,14,21,22,23};
    private static final int[] BACKGROUND_OUTPUT_SLOTS = {6,7,8,15,17,24,25,26};
    protected static final int INPUT_SLOT = 10;
    protected static final int CAST_SLOT = 13;
    protected static final int OUTPUT_SLOT = 16;

    protected static final int PURGE_BUTTON = 41;
    protected static final int ALLOY_BUTTON = 42;
    protected static final int POUR_BUTTON = 43;

    protected static final int LAVA_INFO = 37;
    protected static final int METAL_INFO = 39;

    private final Map<Location, TinkersSmelteryCache> caches = new HashMap<>();

    public TinkersSmeltery(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        addItemHandler(new BlockTicker() {
            @Override
            public boolean isSynchronized() {
                return true;
            }

            @Override
            public void tick(Block block, SlimefunItem item, Config data) {
                TinkersSmelteryCache cache = TinkersSmeltery.this.caches.get(block.getLocation());
                if (cache != null) {
                    cache.process();
                }
            }
        });

    }

    @Override
    protected void setupMenu(BlockMenuPreset blockMenuPreset) {
        blockMenuPreset.setSize(54);

        blockMenuPreset.drawBackground(GUIItems.menuBackground(), BACKGROUND_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundInput(), BACKGROUND_INPUT_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundOutput(), BACKGROUND_OUTPUT_SLOTS);
        blockMenuPreset.drawBackground(GUIItems.menuBackgroundCast(), BACKGROUND_CAST_SLOTS);

        blockMenuPreset.addItem(LAVA_INFO, GUIItems.menuLavaInfo(0, 0));
        blockMenuPreset.addItem(METAL_INFO, GUIItems.menuMetalInfo(0, 0, null));

        blockMenuPreset.addItem(PURGE_BUTTON, GUIItems.menuPurge());
        blockMenuPreset.addMenuClickHandler(PURGE_BUTTON, (player, i, itemStack, clickAction) -> clickPurge());

        blockMenuPreset.addItem(ALLOY_BUTTON, GUIItems.menuAlloy());
        blockMenuPreset.addMenuClickHandler(ALLOY_BUTTON, (player, i, itemStack, clickAction) -> clickAlloy());

        blockMenuPreset.addItem(POUR_BUTTON, GUIItems.menuPour());
        blockMenuPreset.addMenuClickHandler(POUR_BUTTON, (player, i, itemStack, clickAction) -> clickPour());

    }

    @Override
    protected int @NotNull [] getTransportSlots(@NotNull DirtyChestMenu dirtyChestMenu, @NotNull ItemTransportFlow itemTransportFlow, ItemStack itemStack) {
        if (itemTransportFlow == ItemTransportFlow.INSERT) {
            return new int[] {INPUT_SLOT};
        } else if (itemTransportFlow == ItemTransportFlow.WITHDRAW) {
            return new int[] {OUTPUT_SLOT};
        } else {
            return new int[0];
        }
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent event, @Nonnull BlockMenu blockMenu, @Nonnull Location location) {
        super.onBreak(event, blockMenu, location);
        TinkersSmelteryCache simpleInventoryCache = caches.remove(location);
        if (simpleInventoryCache != null) {
            simpleInventoryCache.kill(location);
        }
        blockMenu.dropItems(location, INPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu menu, @Nonnull Block b) {
        super.onNewInstance(menu, b);
        caches.put(b.getLocation(), new TinkersSmelteryCache(menu));
        menu.addMenuOpeningHandler((player -> validateMultiblock()));
    }

    private void validateMultiblock() {
        // TODO Validate the shape of the multiblock and stop opening if invalid.
    }

    private boolean clickPurge() {
        return false;
    }

    private boolean clickAlloy() {
        return false;
    }

    private boolean clickPour() {
        return false;
    }

}
