
package com.roland.repolovepotion.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class UnpolishedLoveCoreItem extends Item {
	public UnpolishedLoveCoreItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
