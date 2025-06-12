
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
	public static final DeferredItem<Item> VILLAGER_RAP_DISK = REGISTRY.register("villager_rap_disk", VillagerRapDiskItem::new);
	public static final DeferredItem<Item> I_LOVE_DISK = REGISTRY.register("i_love_disk", ILoveDiskItem::new);
	public static final DeferredItem<Item> ARK_DISK = REGISTRY.register("ark_disk", ArkDiskItem::new);
	public static final DeferredItem<Item> LOVE_DUST = REGISTRY.register("love_dust", LoveDustItem::new);
	public static final DeferredItem<Item> INCOMPLETE_UNPOLISHED_LOVE_CORE = REGISTRY.register("incomplete_unpolished_love_core", IncompleteUnpolishedLoveCoreItem::new);
}
