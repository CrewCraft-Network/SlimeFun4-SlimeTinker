package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.categories.Categories;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.items.workstations.smeltery.DummySmeltery;
import io.github.sefiraat.slimetinker.items.workstations.workbench.DummyWorkbench;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.items.parts.AbstractPart;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public final class Parts {

    public static final String DESC_ERROR = "Error";

    private Parts() {
        throw new IllegalStateException("Utility class");
    }

    protected static ItemStack[] getDummyCastRecipe(ItemStack cast) {
        return new ItemStack[]{
                null, null, null,
                null, cast, null,
                null, null, null
        };
    }

    protected static ItemStack[] getDummyBindingRecipe(ItemStack binder) {
        return new ItemStack[]{
                binder, null,   binder,
                null,   binder, null,
                binder, null,   binder
        };
    }

    protected static final ItemStack[] RECIPE_BINDER_STRING = new ItemStack[] {
            new ItemStack(Material.STRING), null,                           new ItemStack(Material.STRING),
            null,                           new ItemStack(Material.STRING), null,
            new ItemStack(Material.STRING), null,                           new ItemStack(Material.STRING)
    };

    protected static final ItemStack[] RECIPE_BINDER_VINE = new ItemStack[] {
            new ItemStack(Material.VINE), null,                           new ItemStack(Material.VINE),
            null,                           new ItemStack(Material.VINE), null,
            new ItemStack(Material.VINE), null,                           new ItemStack(Material.VINE)
    };

    protected static final ItemStack[] RECIPE_BINDER_ROOT_RED = new ItemStack[] {
            new ItemStack(Material.CRIMSON_ROOTS),  null,                                   new ItemStack(Material.CRIMSON_ROOTS),
            null,                                   new ItemStack(Material.CRIMSON_ROOTS),  null,
            new ItemStack(Material.CRIMSON_ROOTS),  null,                                   new ItemStack(Material.CRIMSON_ROOTS)
    };

    protected static final ItemStack[] RECIPE_BINDER_ROOT_GREEN = new ItemStack[] {
            new ItemStack(Material.WARPED_ROOTS),   null,                                   new ItemStack(Material.WARPED_ROOTS),
            null,                                   new ItemStack(Material.WARPED_ROOTS),   null,
            new ItemStack(Material.WARPED_ROOTS),   null,                                   new ItemStack(Material.WARPED_ROOTS)
    };

    protected static final ItemStack[] RECIPE_BINDER_VINE_RED = new ItemStack[] {
            new ItemStack(Material.WEEPING_VINES),  null,                                   new ItemStack(Material.WEEPING_VINES),
            null,                                   new ItemStack(Material.WEEPING_VINES),  null,
            new ItemStack(Material.WEEPING_VINES),  null,                                   new ItemStack(Material.WEEPING_VINES)
    };

    protected static final ItemStack[] RECIPE_BINDER_VINE_GREEN = new ItemStack[] {
            new ItemStack(Material.TWISTING_VINES), null,                                   new ItemStack(Material.TWISTING_VINES),
            null,                                   new ItemStack(Material.TWISTING_VINES), null,
            new ItemStack(Material.TWISTING_VINES), null,                                   new ItemStack(Material.TWISTING_VINES)
    };

    public static final SlimefunItemStack PART_SHOVEL_HEAD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_SHOVEL_HEAD_DUMMY",
                    SkullTextures.PART_SHOVEL_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Shovel Head",
                    ThemeUtils.PASSIVE + "A cast shovel head."
            );

    public static final SlimefunItemStack PART_PICKAXE_HEAD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_PICKAXE_HEAD_DUMMY",
                    SkullTextures.PART_PICKAXE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Pickaxe Head",
                    ThemeUtils.PASSIVE + "A cast pickaxe head."
            );

    public static final SlimefunItemStack PART_AXE_HEAD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_AXE_HEAD_DUMMY",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Axe Head",
                    ThemeUtils.PASSIVE + "A cast axe head."
            );

    public static final SlimefunItemStack PART_HOE_HEAD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_HOE_HEAD_DUMMY",
                    SkullTextures.PART_HOE_HEAD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Hoe Head",
                    ThemeUtils.PASSIVE + "A cast hoe head."
            );

    public static final SlimefunItemStack PART_SWORD_BLADE_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_SWORD_BLADE_DUMMY",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Sword Blade",
                    ThemeUtils.PASSIVE + "A cast sword blade."
            );

    public static final SlimefunItemStack PART_TOOL_ROD_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_TOOL_ROD_DUMMY",
                    SkullTextures.PART_TOOL_ROD,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Tool Rod",
                    ThemeUtils.PASSIVE + "A cast tool rod."
            );

    public static final SlimefunItemStack PART_BINDING_DUMMY =
            ThemeUtils.themedItemStack(
                    "PART_BINDING_DUMMY",
                    SkullTextures.PART_BINDING,
                    ThemeUtils.ThemeItemType.CAST,
                    "Part: Binding",
                    ThemeUtils.PASSIVE + "A binging to hold parts together."
            );

    public static final SlimefunItemStack PART_AXE_HEAD =
            ThemeUtils.themedItemStack(
                    "PART_AXE_HEAD",
                    SkullTextures.PART_AXE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack PART_HOE_HEAD =
            ThemeUtils.themedItemStack(
                    "PART_HOE_HEAD",
                    SkullTextures.PART_HOE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack PART_PICKAXE_HEAD =
            ThemeUtils.themedItemStack(
                    "PART_PICKAXE_HEAD",
                    SkullTextures.PART_PICKAXE_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack PART_SHOVEL_HEAD =
            ThemeUtils.themedItemStack(
                    "PART_SHOVEL_HEAD",
                    SkullTextures.PART_SHOVEL_HEAD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack PART_SWORD_BLADE =
            ThemeUtils.themedItemStack(
                    "PART_SWORD_BLADE",
                    SkullTextures.PART_SWORD_BLADE,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack PART_TOOL_ROD =
            ThemeUtils.themedItemStack(
                    "PART_TOOL_ROD",
                    SkullTextures.PART_TOOL_ROD,
                    ThemeUtils.ThemeItemType.PART,
                    DESC_ERROR,
                    ThemeUtils.PASSIVE + DESC_ERROR
            );

    public static final SlimefunItemStack PART_BINDING_STRING =
            ThemeUtils.themedItemStack(
                    "PART_BINDING_STRING",
                    SkullTextures.PART_BINDING,
                    ThemeUtils.ThemeItemType.PART,
                    "String Binding",
                    ThemeUtils.PASSIVE + "A binding made of string."
            );

    public static final SlimefunItemStack PART_BINDING_VINE =
            ThemeUtils.themedItemStack(
                    "PART_BINDING_VINE",
                    SkullTextures.PART_BINDING,
                    ThemeUtils.ThemeItemType.PART,
                    "Vine Binding",
                    ThemeUtils.PASSIVE + "A binding made of vines."
            );

    public static final SlimefunItemStack PART_BINDING_ROOT_RED =
            ThemeUtils.themedItemStack(
                    "PART_BINDING_ROOT_RED",
                    SkullTextures.PART_BINDING,
                    ThemeUtils.ThemeItemType.PART,
                    "Crimson Root Binding",
                    ThemeUtils.PASSIVE + "A binding made of crimson roots."
            );

    public static final SlimefunItemStack PART_BINDING_ROOT_GREEN =
            ThemeUtils.themedItemStack(
                    "PART_BINDING_ROOT_GREEN",
                    SkullTextures.PART_BINDING,
                    ThemeUtils.ThemeItemType.PART,
                    "Warped Root Binding",
                    ThemeUtils.PASSIVE + "A binding made of warped roots."
            );

    public static final SlimefunItemStack PART_BINDING_VINE_RED =
            ThemeUtils.themedItemStack(
                    "PART_BINDING_VINE_RED",
                    SkullTextures.PART_BINDING,
                    ThemeUtils.ThemeItemType.PART,
                    "Weeping Vine Binding",
                    ThemeUtils.PASSIVE + "A binding made of weeping vines."
            );

    public static final SlimefunItemStack PART_BINDING_VINE_GREEN =
            ThemeUtils.themedItemStack(
                    "PART_BINDING_VINE_GREEN",
                    SkullTextures.PART_BINDING,
                    ThemeUtils.ThemeItemType.PART,
                    "Twisted Vine Binding",
                    ThemeUtils.PASSIVE + "A binding made of twisted vines."
            );

    public static final SlimefunItemStack PART_BINDING_GENERAL_DISPLAY =
            ThemeUtils.themedItemStack(
                    "PART_BINDING_GENERAL_DISPLAY",
                    Material.STRING,
                    ThemeUtils.ThemeItemType.CRAFTING,
                    "Binding Material",
                    ThemeUtils.PASSIVE + "A material suitable to make binding from.",
                    ThemeUtils.PASSIVE + "This is not JUST string, experiment with",
                    ThemeUtils.PASSIVE + "similar materials."
            );


    // Statics for Recipes
    public static final AbstractPart SHOVEL_HEAD = new AbstractPart(Categories.DUMMY, PART_SHOVEL_HEAD, DummySmeltery.TYPE, new ItemStack[9],"Shovel Head");
    public static final AbstractPart PICKAXE_HEAD = new AbstractPart(Categories.DUMMY, PART_PICKAXE_HEAD, DummySmeltery.TYPE, new ItemStack[9], "Pickaxe Head");
    public static final AbstractPart AXE_HEAD = new AbstractPart(Categories.DUMMY, PART_AXE_HEAD, DummySmeltery.TYPE, new ItemStack[9], "Axe Head");
    public static final AbstractPart HOE_HEAD = new AbstractPart(Categories.DUMMY, PART_HOE_HEAD, DummySmeltery.TYPE, new ItemStack[9], "Hoe Head");
    public static final AbstractPart SWORD_BLADE = new AbstractPart(Categories.DUMMY, PART_SWORD_BLADE, DummySmeltery.TYPE, new ItemStack[9], "Sword Blade");
    public static final AbstractPart TOOL_ROD = new AbstractPart(Categories.DUMMY, PART_TOOL_ROD, DummySmeltery.TYPE, new ItemStack[9], "Tool Rod");

    // Binders cant store class/mat - need a list to check against
    public static final Map<String, String> binderMap = new HashMap<>();

    public static void set(SlimeTinker p) {

        // Dummies for the recipe book
        new UnplaceableBlock(Categories.PARTS, PART_SHOVEL_HEAD_DUMMY, DummySmeltery.TYPE, getDummyCastRecipe(Casts.CAST_SHOVELHEAD)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_PICKAXE_HEAD_DUMMY, DummySmeltery.TYPE, getDummyCastRecipe(Casts.CAST_PICKAXEHEAD)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_AXE_HEAD_DUMMY, DummySmeltery.TYPE, getDummyCastRecipe(Casts.CAST_AXEHEAD)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_HOE_HEAD_DUMMY, DummySmeltery.TYPE, getDummyCastRecipe(Casts.CAST_HOEHEAD)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_SWORD_BLADE_DUMMY, DummySmeltery.TYPE, getDummyCastRecipe(Casts.CAST_SWORDBLADE)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_TOOL_ROD_DUMMY, DummySmeltery.TYPE, getDummyCastRecipe(Casts.CAST_TOOLROD)).register(p);
        new UnplaceableBlock(Categories.PARTS, PART_BINDING_DUMMY, DummyWorkbench.TYPE, getDummyBindingRecipe(PART_BINDING_GENERAL_DISPLAY)).register(p);

        // Real ones, not in recipe book due to the variations
        SHOVEL_HEAD.register(p);
        PICKAXE_HEAD.register(p);
        AXE_HEAD.register(p);
        HOE_HEAD.register(p);
        SWORD_BLADE.register(p);
        TOOL_ROD.register(p);

        // Bindings
        AbstractPart binderString = new AbstractPart(Categories.DUMMY, PART_BINDING_STRING, Workbench.TYPE, RECIPE_BINDER_STRING, "String Binder");
        binderString.register(p);
        AbstractPart binderVine = new AbstractPart(Categories.DUMMY, PART_BINDING_VINE, Workbench.TYPE, RECIPE_BINDER_VINE, "Vine Binder");
        binderVine.register(p);
        AbstractPart binderRootRed = new AbstractPart(Categories.DUMMY, PART_BINDING_ROOT_RED, Workbench.TYPE, RECIPE_BINDER_ROOT_RED, "Crimson Root Binder");
        binderRootRed.register(p);
        AbstractPart binderRootGreen = new AbstractPart(Categories.DUMMY, PART_BINDING_ROOT_GREEN, Workbench.TYPE, RECIPE_BINDER_ROOT_GREEN, "Warped Root Binder");
        binderRootGreen.register(p);
        AbstractPart binderVineRed = new AbstractPart(Categories.DUMMY, PART_BINDING_VINE_RED, Workbench.TYPE, RECIPE_BINDER_VINE_RED, "Weeping Vine Binder");
        binderVineRed.register(p);
        AbstractPart binderVineGreen = new AbstractPart(Categories.DUMMY, PART_BINDING_VINE_GREEN, Workbench.TYPE, RECIPE_BINDER_VINE_GREEN, "Twisted Vine Binder");
        binderVineGreen.register(p);

        binderMap.put(binderString.getId(), IDStrings.ID_STRING);
        binderMap.put(binderVine.getId(), IDStrings.ID_VINE);
        binderMap.put(binderRootRed.getId(), IDStrings.ID_ROOTRED);
        binderMap.put(binderRootGreen.getId(), IDStrings.ID_ROOTGREEN);
        binderMap.put(binderVineRed.getId(), IDStrings.ID_VINERED);
        binderMap.put(binderVineGreen.getId(), IDStrings.ID_VINEGREEN);

    }

}
