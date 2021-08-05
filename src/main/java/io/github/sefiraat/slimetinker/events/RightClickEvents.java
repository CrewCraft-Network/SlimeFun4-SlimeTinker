package io.github.sefiraat.slimetinker.events;

import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.events.friend.EventFriend;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import org.apache.commons.lang.Validate;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public final class RightClickEvents {

    public static void headTessMat(EventFriend friend) {
        friend.setHypercube(friend.getHypercube() + 1);
    }

    public static void rodGhostly(EventFriend friend) {
        friend.setHypercube(friend.getHypercube() + 1);
    }

    public static void bindVex(EventFriend friend) {
        Player p = friend.getPlayer();
        ItemStack i = friend.getTool();
        ItemMeta im = i.getItemMeta();
        NamespacedKey key = SlimeTinker.inst().getKeys().getTraitsCooldownNoClip();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        long time = System.currentTimeMillis();
        if (c.has(key, PersistentDataType.LONG)) {
            Long cd = c.get(key, PersistentDataType.LONG);
            assert cd != null;
            if (cd > time) {
                p.sendMessage(ThemeUtils.WARNING + "NoClip is on cooldown!");
                return;
            }
        }

        int rndX = ThreadLocalRandom.current().nextInt(-25,26);
        int rndY = ThreadLocalRandom.current().nextInt(0,5);
        int rndZ = ThreadLocalRandom.current().nextInt(-25,26);
        Location location = p.getLocation().clone().add(rndX, rndY, rndZ);
        if (p.getWorld().getBlockAt(location).getType() == Material.AIR) {
            p.teleport(location);
            p.getWorld().playEffect(friend.getPlayer().getLocation(), Effect.ENDEREYE_LAUNCH, 10);
        } else {
            p.sendMessage(ThemeUtils.WARNING + "Couldn't teleport! Try again.");
            return;
        }

        Instant cd = Instant.ofEpochMilli(time).plusSeconds(300);
        c.set(key, PersistentDataType.LONG, cd.toEpochMilli());
        i.setItemMeta(im);
    }

    public static void plateInfinity(EventFriend friend) {
        ItemStack i = friend.getActiveStack();
        ItemMeta im = i.getItemMeta();
        NamespacedKey k = SlimeTinker.inst().getKeys().getArmourInfiniteCapacityStored();
        Validate.notNull(im, "Meta is null, nope!");
        double d = PersistentDataAPI.getDouble(im, k, 0);
        if (d > 1) {
            List<Entity> entityList = friend.getPlayer().getNearbyEntities(3,3,3);
            for (Entity e : entityList) {
                if (e instanceof LivingEntity) {
                    LivingEntity l = (LivingEntity) e;
                    if (l instanceof Player && l.getUniqueId() == friend.getPlayer().getUniqueId()) {
                        continue;
                    }
                    l.damage(Math.floor(d));
                    l.getWorld().spawnParticle(Particle.CLOUD, l.getLocation(), 4, 0, 0, 0);
                }
            }
        }
        PersistentDataAPI.setDouble(im, k, 0);
        i.setItemMeta(im);
    }
}
