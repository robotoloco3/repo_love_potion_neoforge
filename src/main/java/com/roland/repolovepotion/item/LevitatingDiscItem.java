
package com.roland.repolovepotion.item;

import com.roland.repolovepotion.RepoLovePotionMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class LevitatingDiscItem extends Item {
	public LevitatingDiscItem() {
		super(new Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(RepoLovePotionMod.MODID, "levitating_disc"))));
	}
}
