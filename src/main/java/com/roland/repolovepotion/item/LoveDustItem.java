
package com.roland.repolovepotion.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class LoveDustItem extends Item {
	public LoveDustItem() {
		super(new Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
