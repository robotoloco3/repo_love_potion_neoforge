
package com.roland.repolovepotion.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HeartJarItem extends Item {
	public HeartJarItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
