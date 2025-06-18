
package com.roland.repolovepotion.init;

import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import com.simibubi.create.AllItems;

@EventBusSubscriber
public class RepoLovePotionModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == RepoLovePotionModVillagerProfessions.TAX_MAN.get()) {
			event.getTrades().get(2).add(
					new BasicItemListing(new ItemStack(Items.EMERALD, 16), new ItemStack(Items.BREAD, 32), new ItemStack(RepoLovePotionModItems.I_LOVE_DISC.get()), 10, 0, 0.05f));
			event.getTrades().get(1).add(
					new BasicItemListing(new ItemStack(Blocks.LANTERN, 2), new ItemStack(Items.EMERALD, 10), new ItemStack(Blocks.LANTERN), 10, 5, 0.2f));
			event.getTrades().get(3).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.I_LOVE_DISC.get()), new ItemStack(AllItems.STURDY_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.DEMONS_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.DIAMONDS_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.DOUBLE_LIFE_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.FLOWERS_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.GANGSTA_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.HYMN_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.JAGGER_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.LEVITATING_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.RULE_WORLD_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.SUNFLOWER_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.THUNDER_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.UPTOWN_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.VIVA_DISC.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(
					new BasicItemListing(new ItemStack(RepoLovePotionModItems.VILLAGER_RAP_DISC.get()), new ItemStack(AllItems.GOLDEN_SHEET.get(), 10), new ItemStack(RepoLovePotionModItems.WORRIED_DISC.get()), 10, 5, 0.05f));
		}
	}
}
