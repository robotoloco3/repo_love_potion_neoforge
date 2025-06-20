package com.roland.repolovepotion.events;

import com.roland.repolovepotion.init.RepoLovePotionModVillagerProfessions;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class NewTaxManHandler {

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getTarget() instanceof Villager villager)) return;

        if (villager.getVillagerData().getProfession() != RepoLovePotionModVillagerProfessions.TAX_MAN.get())
            return;

        if (villager.getOffers().size() < 10) {
            applyAllTrades(villager); // This is now valid
        }
    }

    public static void applyAllTrades(Villager villager) {
        Int2ObjectMap<VillagerTrades.ItemListing[]> tradeMap =
                VillagerTrades.TRADES.get(RepoLovePotionModVillagerProfessions.TAX_MAN.get());

        if (tradeMap == null) return;

        villager.getOffers().clear();

        for (int level = 1; level <= 5; level++) {
            VillagerTrades.ItemListing[] listings = tradeMap.get(level);
            if (listings == null) continue;

            for (VillagerTrades.ItemListing listing : listings) {
                MerchantOffer offer = listing.getOffer(villager, villager.level().random);
                if (offer != null) {
                    villager.getOffers().add(offer);
                }
            }
        }
    }
}
