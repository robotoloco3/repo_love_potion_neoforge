
package com.roland.repolovepotion.item;

import com.roland.repolovepotion.RepoLovePotionMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RuleWorldDiscItem extends Item {
	public RuleWorldDiscItem() {
		super(new Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(RepoLovePotionMod.MODID, "rule_world_disc"))));
	}
}
