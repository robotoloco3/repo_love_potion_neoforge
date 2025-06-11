
package com.roland.repolovepotion.item;


import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.minecraft.world.item.Rarity;

public class IncompleteUnpolishedLoveCoreItem extends SequencedAssemblyItem {
	public IncompleteUnpolishedLoveCoreItem() {
		super(new Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
