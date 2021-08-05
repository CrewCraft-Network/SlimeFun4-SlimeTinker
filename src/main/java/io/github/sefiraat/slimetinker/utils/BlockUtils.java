package io.github.sefiraat.slimetinker.utils;

import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Container;

import javax.annotation.Nullable;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public final class BlockUtils {

    public static boolean isValidBreakEvent(Block block) {
        return !isPlaced(block) && !BlockStorage.hasBlockInfo(block) && !(block instanceof Container);
    }

    public static boolean isPlaced(Block block) {
        return block.hasMetadata(IDStrings.PLACED);
    }

}
