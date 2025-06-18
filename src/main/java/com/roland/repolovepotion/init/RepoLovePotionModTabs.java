
package com.roland.repolovepotion.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import com.roland.repolovepotion.RepoLovePotionMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class RepoLovePotionModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RepoLovePotionMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(RepoLovePotionModItems.LOVE_POTION.get());
			tabData.accept(RepoLovePotionModItems.I_LOVE_DISC.get());
			tabData.accept(RepoLovePotionModItems.ARK_DISC.get());
			tabData.accept(RepoLovePotionModItems.VILLAGER_RAP_DISC.get());
			tabData.accept(RepoLovePotionModItems.DEMONS_DISC.get());
			tabData.accept(RepoLovePotionModItems.DIAMONDS_DISC.get());
			tabData.accept(RepoLovePotionModItems.DOUBLE_LIFE_DISC.get());
			tabData.accept(RepoLovePotionModItems.RULE_WORLD_DISC.get());
			tabData.accept(RepoLovePotionModItems.FLOWERS_DISC.get());
			tabData.accept(RepoLovePotionModItems.LEVITATING_DISC.get());
			tabData.accept(RepoLovePotionModItems.GANGSTA_DISC.get());
			tabData.accept(RepoLovePotionModItems.HYMN_DISC.get());
			tabData.accept(RepoLovePotionModItems.WORRIED_DISC.get());
			tabData.accept(RepoLovePotionModItems.JAGGER_DISC.get());
			tabData.accept(RepoLovePotionModItems.SUNFLOWER_DISC.get());
			tabData.accept(RepoLovePotionModItems.THUNDER_DISC.get());
			tabData.accept(RepoLovePotionModItems.UPTOWN_DISC.get());
			tabData.accept(RepoLovePotionModItems.VIVA_DISC.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(RepoLovePotionModItems.LOVE_CORE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(RepoLovePotionModItems.HEART_JAR.get());
			tabData.accept(RepoLovePotionModItems.UNPOLISHED_LOVE_CORE.get());
			tabData.accept(RepoLovePotionModItems.LOVE_DUST.get());
			tabData.accept(RepoLovePotionModItems.INCOMPLETE_UNPOLISHED_LOVE_CORE.get());
		}
	}
}
