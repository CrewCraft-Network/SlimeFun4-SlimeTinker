package io.github.sefiraat.slimetinker.listeners;

import io.github.sefiraat.slimetinker.events.EntityDamageEventFriend;
import io.github.sefiraat.slimetinker.items.ComponentMaterials;
import io.github.sefiraat.slimetinker.items.materials.ComponentMaterial;
import io.github.sefiraat.slimetinker.items.templates.ToolTemplate;
import io.github.sefiraat.slimetinker.modifiers.Modifications;
import io.github.sefiraat.slimetinker.utils.Experience;
import io.github.sefiraat.slimetinker.utils.IDStrings;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EntityDamagedListener implements Listener {

    @EventHandler
    public void onPlayerDamaged(EntityDamageByEntityEvent event) { // When player is damaged, for Diamond mod

        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof LivingEntity)) {
            return;
        }

        Player player = (Player) event.getEntity();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        modChecks(event, heldItem);

    }

    @EventHandler
    public void onEntityDamaged(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player) || event.isCancelled() || !(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        Player player = (Player) event.getDamager();
        ItemStack heldItem = player.getInventory().getItemInMainHand();

        if (!ToolTemplate.isTool(heldItem)) { // Not a Tinker's tool, so we don't care
            return;
        }

        // Properties
        ItemMeta im = heldItem.getItemMeta();
        assert im != null;
        PersistentDataContainer c = im.getPersistentDataContainer();
        String matPropertyHead = ItemUtils.getToolHeadMaterial(c);
        String matPropertyBinding = ItemUtils.getToolBindingMaterial(c);
        String matPropertyRod = ItemUtils.getToolRodMaterial(c);
        int toolLevel = Experience.getToolLevel(c);

        EntityDamageEventFriend friend = new EntityDamageEventFriend(heldItem, player, event.getEntity(), toolLevel);

        for (Map.Entry<String, ComponentMaterial> mat : ComponentMaterials.getMap().entrySet()) {
            if (mat.getValue().isEventEntityDamagedHead() && matPropertyHead.equals(mat.getKey())) {
                mat.getValue().getEntityDamagedConsumerHead().accept(friend);
            }
            if (mat.getValue().isEventEntityDamagedBind() && matPropertyBinding.equals(mat.getKey())) {
                mat.getValue().getEntityDamagedConsumerBind().accept(friend);
            }
            if (mat.getValue().isEventEntityDamagedRod() && matPropertyRod.equals(mat.getKey())) {
                mat.getValue().getEntityDamagedConsumerRod().accept(friend);
            }
        }


        // Cancel if tool is broken (moved down here as we bypass if the duralium event fires)
        if (cancelIfBroken(heldItem)) {
            if (matPropertyHead.equals(IDStrings.DURALIUM)) { // Run duraluim as it will flag the duraliumCheck meaning we can bypass durability checks
                ComponentMaterials.getMap().get(matPropertyHead).getEntityDamagedConsumerHead().accept(friend);
            }
            if (!friend.isDuraliumCheck()) {
                player.sendMessage(ThemeUtils.WARNING + "Your weapon is broken, you should really repair it!");
                event.setCancelled(true);
                return;
            }
        }

        // Mods
        modChecks(event, heldItem, friend);

        // Settle
        event.setDamage(event.getDamage() * friend.getDamageMod());
        Experience.addToolExp(heldItem, (int) Math.ceil(event.getDamage() * friend.getToolExpMod()), player, false);

    }

    private boolean cancelIfBroken(ItemStack itemStack) {
        Damageable damageable = (Damageable) itemStack.getItemMeta();
        assert damageable != null;
        return damageable.getDamage() == itemStack.getType().getMaxDurability() - 1;
    }

    private void modChecks(EntityDamageByEntityEvent event, ItemStack heldItem, EntityDamageEventFriend friend) { // Player damaging entity

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (modLevels.containsKey(Material.QUARTZ.toString())) { // QUARTZ
            modCheckQuartz(modLevels.get(Material.QUARTZ.toString()), friend);
        }

    }

    private void modChecks(EntityDamageByEntityEvent event, ItemStack heldItem) { // Entity Damaging player

        Map<String, Integer> modLevels = Modifications.getAllModLevels(heldItem);

        if (modLevels.containsKey(Material.DIAMOND.toString())) { // DIAMOND
            modCheckDiamond(event, modLevels.get(Material.DIAMOND.toString()));
        }

    }

    private void modCheckQuartz(int level, EntityDamageEventFriend friend) {
        friend.setDamageMod(friend.getDamageMod() + (level * 0.2));
    }

    private void modCheckDiamond(EntityDamageByEntityEvent event, int level) {
        int rnd = ThreadLocalRandom.current().nextInt(1,11);
        if (rnd <= (level)) {
            Entity e = event.getDamager();
            LivingEntity l = (LivingEntity) e;
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.TEAL, 1);
            e.getWorld().spawnParticle(Particle.REDSTONE, e.getLocation(), 50, 1.5, 1.5, 1.5, 1, dustOptions);
            l.damage(event.getDamage());
            event.setCancelled(true);
        }
    }

}
