package io.github.sefiraat.slimetinker.items;

import io.github.sefiraat.slimetinker.events.EventsTick;
import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.Getter;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public final class ComponentMaterials {

    private ComponentMaterials() {
        throw new IllegalStateException("Utility class");
    }

    @Getter
    protected static final Map<String, ComponentMaterial> map = new HashMap<>();

    static {
        // region Vanilla + Core SF
        map.put(IDStrings.IRON,
                new ComponentMaterial
                        (
                                IDStrings.IRON,
                                "#8c8c8c",
                                true,
                                false,
                                true,
                                Material.IRON_NUGGET.toString(),
                                Material.IRON_INGOT.toString(),
                                Material.IRON_BLOCK.toString(),
                                Material.IRON_ORE.toString(),
                                null,
                                SlimefunItems.IRON_DUST.getItemId(),
                                Material.IRON_BOOTS.toString(),
                                Material.IRON_LEGGINGS.toString(),
                                Material.IRON_CHESTPLATE.toString(),
                                Material.IRON_HELMET.toString()
                        ));
        map.put(IDStrings.GOLD,
                new ComponentMaterial
                        (
                                IDStrings.GOLD,
                                "#ffe138",
                                true,
                                false,
                                true,
                                Material.GOLD_NUGGET.toString(),
                                Material.GOLD_INGOT.toString(),
                                Material.GOLD_BLOCK.toString(),
                                Material.GOLD_ORE.toString(),
                                null,
                                SlimefunItems.GOLD_DUST.getItemId(),
                                Material.GOLDEN_BOOTS.toString(),
                                Material.GOLDEN_LEGGINGS.toString(),
                                Material.GOLDEN_CHESTPLATE.toString(),
                                Material.GOLDEN_HELMET.toString()
                        ));
        map.put(IDStrings.COPPER,
                new ComponentMaterial
                        (
                                IDStrings.COPPER,
                                "#c99732",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_COPPER.getItemId(),
                                SlimefunItems.COPPER_INGOT.getItemId(),
                                Materials.BLOCK_CAST_COPPER.getItemId(),
                                null,
                                null,
                                SlimefunItems.COPPER_DUST.getItemId(),
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.LEAD,
                new ComponentMaterial
                        (
                                IDStrings.LEAD,
                                "#9043ba",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_LEAD.getItemId(),
                                SlimefunItems.LEAD_INGOT.getItemId(),
                                Materials.BLOCK_CAST_LEAD.getItemId(),
                                null,
                                null,
                                SlimefunItems.COPPER_DUST.getItemId(),
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.SILVER,
                new ComponentMaterial
                        (
                                IDStrings.SILVER,
                                "#d4d4d4",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_SILVER.getItemId(),
                                SlimefunItems.SILVER_INGOT.getItemId(),
                                Materials.BLOCK_CAST_SILVER.getItemId(),
                                null,
                                null,
                                SlimefunItems.SILVER_DUST.getItemId(),
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.ALUMINUM,
                new ComponentMaterial
                        (
                                IDStrings.ALUMINUM,
                                "#b0b0b0",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_ALUMINUM.getItemId(),
                                SlimefunItems.ALUMINUM_INGOT.getItemId(),
                                Materials.BLOCK_CAST_ALUMINUM.getItemId(),
                                null,
                                null,
                                SlimefunItems.ALUMINUM_DUST.getItemId(),
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.TIN,
                new ComponentMaterial
                        (
                                IDStrings.TIN,
                                "#a89b9b",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_TIN.getItemId(),
                                SlimefunItems.TIN_INGOT.getItemId(),
                                Materials.BLOCK_CAST_TIN.getItemId(),
                                null,
                                null,
                                SlimefunItems.TIN_DUST.getItemId(),
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.ZINC,
                new ComponentMaterial
                        (
                                IDStrings.ZINC,
                                "#9ba8a6",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_ZINC.getItemId(),
                                SlimefunItems.ZINC_INGOT.getItemId(),
                                Materials.BLOCK_CAST_ZINC.getItemId(),
                                null,
                                null,
                                SlimefunItems.ZINC_DUST.getItemId(),
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.MAGNESIUM,
                new ComponentMaterial
                        (
                                IDStrings.MAGNESIUM,
                                "#e8cef5",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_MAGNESIUM.getItemId(),
                                SlimefunItems.MAGNESIUM_INGOT.getItemId(),
                                Materials.BLOCK_CAST_MAGNESIUM.getItemId(),
                                null,
                                null,
                                SlimefunItems.MAGNESIUM_DUST.getItemId(),
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.COAL,
                new ComponentMaterial
                        (
                                IDStrings.COAL,
                                "#2d2e2d",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_COAL.getItemId(),
                                Material.COAL.toString(),
                                Material.COAL_BLOCK.toString(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.STEEL,
                new ComponentMaterial
                        (
                                IDStrings.STEEL,
                                "#d1d1d1",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_STEEL.getItemId(),
                                SlimefunItems.STEEL_INGOT.getItemId(),
                                Materials.BLOCK_CAST_STEEL.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.DAMSTEEL,
                new ComponentMaterial
                        (
                                IDStrings.DAMSTEEL,
                                "#a38c8c",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_DAMASCUS_STEEL.getItemId(),
                                SlimefunItems.DAMASCUS_STEEL_INGOT.getItemId(),
                                Materials.BLOCK_CAST_DAMASCUS_STEEL.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.DURALIUM,
                new ComponentMaterial
                        (
                                IDStrings.DURALIUM,
                                "#a3a089",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_DURALIUM.getItemId(),
                                SlimefunItems.DURALUMIN_INGOT.getItemId(),
                                Materials.BLOCK_CAST_DURALIUM.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.BRONZE,
                new ComponentMaterial
                        (
                                IDStrings.BRONZE,
                                "#877435",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_BRONZE.getItemId(),
                                SlimefunItems.BRONZE_INGOT.getItemId(),
                                Materials.BLOCK_CAST_BRONZE.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.ALUBRONZE,
                new ComponentMaterial
                        (
                                IDStrings.ALUBRONZE,
                                "#bdaa6d",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_ALU_BRONZE.getItemId(),
                                SlimefunItems.ALUMINUM_BRONZE_INGOT.getItemId(),
                                Materials.BLOCK_CAST_ALU_BRONZE.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.HARD,
                new ComponentMaterial
                        (
                                IDStrings.HARD,
                                "#29251a",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_HARD_METAL.getItemId(),
                                SlimefunItems.HARDENED_METAL_INGOT.getItemId(),
                                Materials.BLOCK_CAST_HARD_METAL.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.CORBRONZE,
                new ComponentMaterial
                        (
                                IDStrings.CORBRONZE,
                                "#8a6500",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_COR_BRONZE.getItemId(),
                                SlimefunItems.CORINTHIAN_BRONZE_INGOT.getItemId(),
                                Materials.BLOCK_CAST_COR_BRONZE.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.SOLDER,
                new ComponentMaterial
                        (
                                IDStrings.SOLDER,
                                "#b7afbd",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_SOLDER.getItemId(),
                                SlimefunItems.SOLDER_INGOT.getItemId(),
                                Materials.BLOCK_CAST_SOLDER.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.BILLON,
                new ComponentMaterial
                        (
                                IDStrings.BILLON,
                                "#b0c2be",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_BILLON.getItemId(),
                                SlimefunItems.BILLON_INGOT.getItemId(),
                                Materials.BLOCK_CAST_BILLON.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.BRASS,
                new ComponentMaterial
                        (
                                IDStrings.BRASS,
                                "#dbcd4b",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_BRASS.getItemId(),
                                SlimefunItems.BRASS_INGOT.getItemId(),
                                Materials.BLOCK_CAST_BRASS.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.ALUBRASS,
                new ComponentMaterial
                        (
                                IDStrings.ALUBRASS,
                                "#dbd279",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_ALU_BRASS.getItemId(),
                                SlimefunItems.ALUMINUM_BRASS_INGOT.getItemId(),
                                Materials.BLOCK_CAST_ALU_BRASS.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.NICKEL,
                new ComponentMaterial
                        (
                                IDStrings.NICKEL,
                                "#ebebeb",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_NICKEL.getItemId(),
                                SlimefunItems.NICKEL_INGOT.getItemId(),
                                Materials.BLOCK_CAST_NICKEL.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.COBALT,
                new ComponentMaterial
                        (
                                IDStrings.COBALT,
                                "#9e9e9e",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_COBALT.getItemId(),
                                SlimefunItems.COBALT_INGOT.getItemId(),
                                Materials.BLOCK_CAST_COBALT.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.REINFORCED,
                new ComponentMaterial
                        (
                                IDStrings.REINFORCED,
                                "#465899",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_REINFORCED.getItemId(),
                                SlimefunItems.REINFORCED_ALLOY_INGOT.getItemId(),
                                Materials.BLOCK_CAST_REINFORCED.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.STRING,
                new ComponentMaterial
                        (
                                IDStrings.STRING,
                                "#f5f5f5",
                                false,
                                true,
                                false,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.VINE,
                new ComponentMaterial
                        (
                                IDStrings.VINE,
                                "#4ca86b",
                                false,
                                true,
                                false,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.ROOTRED,
                new ComponentMaterial
                        (
                                IDStrings.ROOTRED,
                                "#b5365e",
                                false,
                                true,
                                false,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.ROOTGREEN,
                new ComponentMaterial
                        (
                                IDStrings.ROOTGREEN,
                                "#36b549",
                                false,
                                true,
                                false,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.VINERED,
                new ComponentMaterial
                        (
                                IDStrings.VINERED,
                                "#9c091d",
                                false,
                                true,
                                false,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        map.put(IDStrings.VINEGREEN,
                new ComponentMaterial
                        (
                                IDStrings.VINEGREEN,
                                "#1b8045",
                                false,
                                true,
                                false,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
        // endregion

        // region Infinity Expac

        map.put(IDStrings.VOID,
                new ComponentMaterial
                        (
                                IDStrings.VOID,
                                "#5c5756",
                                true,
                                false,
                                true,
                                "VOID_BIT",
                                "VOID_INGOT",
                                Materials.BLOCK_CAST_VOID.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.INFINITY,
                new ComponentMaterial
                        (
                                IDStrings.INFINITY,
                                "#d1ebf0",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_INFINITY.getItemId(),
                                "INFINITE_INGOT",
                                Materials.BLOCK_CAST_INFINITY.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.FORTUNE,
                new ComponentMaterial
                        (
                                IDStrings.FORTUNE,
                                "#f0d541",
                                true,
                                false,
                                true,
                                null,
                                null,
                                null,
                                null,
                                "FORTUNE_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.MAGIC,
                new ComponentMaterial
                        (
                                IDStrings.MAGIC,
                                "#c941e8",
                                true,
                                false,
                                true,
                                null,
                                null,
                                null,
                                null,
                                "MAGIC_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.EARTH,
                new ComponentMaterial
                        (
                                IDStrings.EARTH,
                                "#44e34f",
                                true,
                                false,
                                true,
                                null,
                                null,
                                null,
                                null,
                                "EARTH_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.METAL,
                new ComponentMaterial
                        (
                                IDStrings.METAL,
                                "#5b615b",
                                true,
                                false,
                                true,
                                null,
                                null,
                                null,
                                null,
                                "METAL_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.MAGSTEEL,
                new ComponentMaterial
                        (
                                IDStrings.MAGSTEEL,
                                "#730000",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_MAGSTEEL.getItemId(),
                                "MAGSTEEL",
                                Materials.BLOCK_CAST_MAGSTEEL.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.TITANIUM,
                new ComponentMaterial
                        (
                                IDStrings.TITANIUM,
                                "#adadad",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_TITANIUM.getItemId(),
                                "TITANIUM",
                                Materials.BLOCK_CAST_TITANIUM.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.MYTHRIL,
                new ComponentMaterial
                        (
                                IDStrings.MYTHRIL,
                                "#4ebdc7",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_MYTHRIL.getItemId(),
                                "MYTHRIL",
                                Materials.BLOCK_CAST_MYTHRIL.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.ADAMANTITE,
                new ComponentMaterial
                        (
                                IDStrings.ADAMANTITE,
                                "#c93ec2",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_ADAMANTITE.getItemId(),
                                "ADAMANTITE",
                                Materials.BLOCK_CAST_ADAMANTITE.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.MAGNONIUM,
                new ComponentMaterial
                        (
                                IDStrings.MAGNONIUM,
                                "#4a0446",
                                true,
                                false,
                                true,
                                Materials.NUGGET_CAST_MAGNONIUM.getItemId(),
                                "MAGNONIUM",
                                Materials.BLOCK_CAST_MAGNONIUM.getItemId(),
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGIRON,
                new ComponentMaterial
                        (
                                IDStrings.SINGIRON,
                                "#8c8c8c",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "IRON_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGGOLD,
                new ComponentMaterial
                        (
                                IDStrings.SINGGOLD,
                                "#ffe138",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "GOLD_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGCOPPER,
                new ComponentMaterial
                        (
                                IDStrings.SINGCOPPER,
                                "#c99732",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "COPPER_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGLEAD,
                new ComponentMaterial
                        (
                                IDStrings.SINGLEAD,
                                "#9043ba",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "LEAD_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGSILVER,
                new ComponentMaterial
                        (
                                IDStrings.SINGSILVER,
                                "#d4d4d4",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "SILVER_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGALUMINUM,
                new ComponentMaterial
                        (
                                IDStrings.SINGALUMINUM,
                                "#b0b0b0",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "ALUMINUM_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGTIN,
                new ComponentMaterial
                        (
                                IDStrings.SINGTIN,
                                "#a89b9b",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "TIN_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGZINC,
                new ComponentMaterial
                        (
                                IDStrings.SINGZINC,
                                "#9ba8a6",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "ZINC_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGMAGNESIUM,
                new ComponentMaterial
                        (
                                IDStrings.SINGMAGNESIUM,
                                "#e8cef5",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "MAGNESIUM_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        map.put(IDStrings.SINGINFINITY,
                new ComponentMaterial
                        (
                                IDStrings.SINGINFINITY,
                                "#e8cef5",
                                true,
                                false,
                                true,
                                null,
                                null,
                                "INFINITY_SINGULARITY",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null
                        ));

        // endregion

        // region Event comsumers

        // Gold - Rod - All that Glitters
        map.get(IDStrings.GOLD).setEventTick(true);
        map.get(IDStrings.GOLD).setEventTickConsumer(EventsTick::rodGold);

        // endregion

    }

    public static ComponentMaterial getById(String id) {
        return map.get(id);
    }

}
