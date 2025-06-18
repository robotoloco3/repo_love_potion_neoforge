
package com.roland.repolovepotion.init;

import com.roland.repolovepotion.item.*;
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
	public static final DeferredItem<Item> DEMONS_DISC = REGISTRY.register("demons_disc", DemonsDiscItem::new);
	public static final DeferredItem<Item> DIAMONDS_DISC = REGISTRY.register("diamonds_disc", DiamondsDiscItem::new);
	public static final DeferredItem<Item> DOUBLE_LIFE_DISC = REGISTRY.register("double_life_disc", DoubleLifeDiscItem::new);
	public static final DeferredItem<Item> RULE_WORLD_DISC = REGISTRY.register("rule_world_disc", RuleWorldDiscItem::new);
	public static final DeferredItem<Item> FLOWERS_DISC = REGISTRY.register("flowers_disc", FlowersDiscItem::new);
	public static final DeferredItem<Item> GANGSTA_DISC = REGISTRY.register("gangsta_disc", GangstaDiscItem::new);
	public static final DeferredItem<Item> HYMN_DISC = REGISTRY.register("hymn_disc", HymnDiscItem::new);
	public static final DeferredItem<Item> WORRIED_DISC = REGISTRY.register("worried_disc", WorriedDiscItem::new);
	public static final DeferredItem<Item> LEVITATING_DISC = REGISTRY.register("levitating_disc", LevitatingDiscItem::new);
	public static final DeferredItem<Item> JAGGER_DISC = REGISTRY.register("jagger_disc", JaggerDiscItem::new);
	public static final DeferredItem<Item> SUNFLOWER_DISC = REGISTRY.register("sunflower_disc", SunflowerDiscItem::new);
	public static final DeferredItem<Item> THUNDER_DISC = REGISTRY.register("thunder_disc", ThunderDiscItem::new);
	public static final DeferredItem<Item> UPTOWN_DISC = REGISTRY.register("uptown_disc", UptownDiscItem::new);
	public static final DeferredItem<Item> VIVA_DISC = REGISTRY.register("viva_disc", VivaDiscItem::new);
}