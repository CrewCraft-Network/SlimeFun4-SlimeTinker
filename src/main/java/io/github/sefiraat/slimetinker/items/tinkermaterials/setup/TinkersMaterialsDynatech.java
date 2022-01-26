package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.events.EntityDamageEvents;
import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import io.github.sefiraat.slimetinker.events.RightClickEvents;
import io.github.sefiraat.slimetinker.events.TickEvents;
import io.github.sefiraat.slimetinker.events.friend.TraitEventType;
import io.github.sefiraat.slimetinker.events.friend.TraitPartType;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public final class TinkersMaterialsDynatech {

    private TinkersMaterialsDynatech() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, TinkerMaterial> CM_MAP = new HashMap<>();

    private static final TinkerMaterial STAINLESS_STEEL = new TinkerMaterial(Ids.STAINLESS_STEEL, SlimefunItem.getById("STAINLESS_STEEL").getItem(), "#d1d1d1")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.DYN_STAINLESS_STEEL_HEAD)
        .setTraitToolRod(Traits.DYN_STAINLESS_STEEL_ROD)
        .setTraitArmorPlates(Traits.DYN_STAINLESS_STEEL_PLATES)
        .setTraitArmorLinks(Traits.DYN_STAINLESS_STEEL_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_STAINLESSSTEEL.getItemId())
        .setFormIngot("STAINLESS_STEEL")
        .setFormBlock(Materials.BLOCK_CAST_STAINLESSSTEEL.getItemId())
        .addAlloyRecipe(
            TinkersMaterialsCore.getCmMap().get(Ids.IRON).getLiquidItemStack(2),
            TinkersMaterialsCore.getCmMap().get(Ids.ZINC).getLiquidItemStack(1)
        )
        .build();

    private static final TinkerMaterial VEX_GEM = new TinkerMaterial(Ids.VEX_GEM, SlimefunItem.getById("VEX_GEM").getItem(), "#38c0c2")
        .setLiquidTexture(SkullTextures.ALLOY_BLUE_PALE)
        .setTraitToolBinder(Traits.DYN_VEX_GEM_BINDING)
        .setTraitArmorGambeson(Traits.DYN_VEX_GEM_GAMBESON)
        .setFormGem("VEX_GEM")
        .build();

    private static final TinkerMaterial STARDUST = new TinkerMaterial(Ids.STARDUST, SlimefunItem.getById("STAR_DUST").getItem(), "#fdff96")
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.DYN_STAR_DUST_HEAD)
        .setTraitToolRod(Traits.DYN_STAR_DUST_ROD)
        .setTraitArmorPlates(Traits.DYN_STAR_DUST_PLATES)
        .setTraitArmorLinks(Traits.DYN_STAR_DUST_LINKS)
        .setFormOre("STARDUST_METEOR")
        .setFormGem("STAR_DUST")
        .build();

    private static final TinkerMaterial GHOSTLY_ESSENCE = new TinkerMaterial(Ids.GHOSTLY_ESSENCE, SlimefunItem.getById("GHOSTLY_ESSENCE").getItem(), "#d4ffef")
        .setLiquidTexture(SkullTextures.ALLOY_BROWN)
        .setTraitToolHead(Traits.DYN_GHOSTLY_ESSENCE_HEAD)
        .setTraitToolRod(Traits.DYN_GHOSTLY_ESSENCE_ROD)
        .setTraitArmorPlates(Traits.DYN_GHOSTLY_ESSENCE_PLATES)
        .setTraitArmorLinks(Traits.DYN_GHOSTLY_ESSENCE_LINKS)
        .setFormDust("GHOSTLY_ESSENCE")
        .build();

    private static final TinkerMaterial TESSERACT = new TinkerMaterial(Ids.TESSERACT, SlimefunItem.getById("TESSERACTING_OBJ").getItem(), "#c7ba9f")
        .setLiquidTexture(SkullTextures.ALLOY_TAN)
        .setTraitToolHead(Traits.DYN_TESSERACT_HEAD)
        .setTraitArmorPlates(Traits.DYN_TESSERACT_PLATES)
        .setTraitArmorLinks(Traits.DYN_TESSERACT_LINKS)
        .setFormBlock("TESSERACTING_OBJ")
        .build();

    static {
        CM_MAP.put(Ids.STAINLESS_STEEL, STAINLESS_STEEL);
        CM_MAP.put(Ids.VEX_GEM, VEX_GEM);
        CM_MAP.put(Ids.STARDUST, STARDUST);
        CM_MAP.put(Ids.GHOSTLY_ESSENCE, GHOSTLY_ESSENCE);
        CM_MAP.put(Ids.TESSERACT, TESSERACT);

        setupToolConsumers();
        setupArmourConsumers();
    }

    public static void setupToolConsumers() {

        CM_MAP.get(Ids.STARDUST).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headStarDust);                    // Bright Fury
        CM_MAP.get(Ids.STAINLESS_STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.ROD, EntityDamageEvents::rodStainlessSteel);         // Cutlery
        CM_MAP.get(Ids.TESSERACT).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.HEAD, RightClickEvents::headTessMat);                         // HyperCube [A]
        CM_MAP.get(Ids.GHOSTLY_ESSENCE).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.ROD, RightClickEvents::rodGhostly);                     // HyperCube [B]
        CM_MAP.get(Ids.GHOSTLY_ESSENCE).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.BINDER, PlayerDamagedEvents::bindGhostly);           // Incorporeal
        CM_MAP.get(Ids.VEX_GEM).addEvent(TraitEventType.RIGHT_CLICK, TraitPartType.BINDER, RightClickEvents::bindVex);                             // NoClip
        CM_MAP.get(Ids.STAINLESS_STEEL).addEvent(TraitEventType.ENTITY_DAMAGED, TraitPartType.HEAD, EntityDamageEvents::headStainlessSteel);       // Super Dooper Stainless
        CM_MAP.get(Ids.STARDUST).addEvent(TraitEventType.TICK, TraitPartType.ROD, TickEvents::rodStarDust);                                        // Yvaine

    }

    public static void setupArmourConsumers() {

        CM_MAP.get(Ids.VEX_GEM).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonVex);                                     // Annoying
        CM_MAP.get(Ids.STARDUST).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::brightBurn);                                        // Brightburn (CO)
        CM_MAP.get(Ids.GHOSTLY_ESSENCE).addEvent(TraitEventType.TICK, TraitPartType.GAMBESON, TickEvents::gambesonGhostly);                         // Ghost in the Shell
        CM_MAP.get(Ids.GHOSTLY_ESSENCE).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksGhostly);                               // Ghostly
        CM_MAP.get(Ids.TESSERACT).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::hyperbolic);                                       // Hyperbolic Tesseration - Links - Store
        CM_MAP.get(Ids.TESSERACT).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.LINKS, PlayerDamagedEvents::hyperbolic);                    // Hyperbolic Tesseration - Links - Absorb
        CM_MAP.get(Ids.TESSERACT).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::hyperbolic);                                       // Hyperbolic Tesseration - Plate - Store
        CM_MAP.get(Ids.TESSERACT).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::hyperbolic);                    // Hyperbolic Tesseration - Plate - Absorb
        CM_MAP.get(Ids.STARDUST).addEvent(TraitEventType.TICK, TraitPartType.PLATE, TickEvents::plateStardust);                                     // Starshine
        CM_MAP.get(Ids.STAINLESS_STEEL).addEvent(TraitEventType.PLAYER_DAMAGED, TraitPartType.PLATE, PlayerDamagedEvents::plateStainlessSteel);     // The Standard
        CM_MAP.get(Ids.STAINLESS_STEEL).addEvent(TraitEventType.TICK, TraitPartType.LINKS, TickEvents::linksStainlessSteel);                        // Water Safe
    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
