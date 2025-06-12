
package com.roland.repolovepotion.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import com.roland.repolovepotion.RepoLovePotionMod;

public class VillagerRapDiscItem extends Item {
	public VillagerRapDiscItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(RepoLovePotionMod.MODID, "villager_rap_disc"))));
	}
}
