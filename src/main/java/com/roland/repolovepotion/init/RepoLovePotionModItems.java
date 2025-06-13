
package com.roland.repolovepotion.init;

import com.roland.repolovepotion.item.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import com.roland.repolovepotion.RepoLovePotionMod;

public class RepoLovePotionModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(RepoLovePotionMod.MODID);

	public static final DeferredItem<Item> LOVE_POTION = REGISTRY.register("love_potion", LovePotionItem::new);
	public static final DeferredItem<Item> LOVE_CORE = REGISTRY.register("love_core", LoveCoreItem::new);
	public static final DeferredItem<Item> HEART_JAR = REGISTRY.register("heart_jar", HeartJarItem::new);
	public static final DeferredItem<Item> UNPOLISHED_LOVE_CORE = REGISTRY.register("unpolished_love_core", UnpolishedLoveCoreItem::new);
	public static final DeferredItem<Item> VILLAGER_RAP_DISC = REGISTRY.register("villager_rap_disc", VillagerRapDiscItem::new);
	public static final DeferredItem<Item> I_LOVE_DISC = REGISTRY.register("i_love_disc", ILoveDiscItem::new);
	public static final DeferredItem<Item> ARK_DISC = REGISTRY.register("ark_disc", ArkDiscItem::new);
	public static final DeferredItem<Item> LOVE_DUST = REGISTRY.register("love_dust", LoveDustItem::new);
	public static final DeferredItem<Item> INCOMPLETE_UNPOLISHED_LOVE_CORE = REGISTRY.register("incomplete_unpolished_love_core", () -> new IncompleteUnpolishedLoveCoreItem(new Item.Properties()));

}
