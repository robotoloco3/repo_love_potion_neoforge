
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
			tabData.accept(RepoLovePotionModItems.I_LOVE_DISK.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(RepoLovePotionModItems.LOVE_CORE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(RepoLovePotionModItems.HEART_JAR.get());
			tabData.accept(RepoLovePotionModItems.UNPOLISHED_LOVE_CORE.get());
			tabData.accept(RepoLovePotionModItems.LOVE_DUST.get());
			tabData.accept(RepoLovePotionModItems.INCOMPLETE_UNPOLISHED_LOVE_CORE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(RepoLovePotionModItems.VILLAGER_RAP_DISK.get());
		}
	}
}
