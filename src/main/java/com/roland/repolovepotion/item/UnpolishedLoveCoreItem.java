
package com.roland.repolovepotion.item;


import com.simibubi.create.AllDataComponents;
import net.createmod.catnip.theme.Color;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class UnpolishedLoveCoreItem extends Item {
	public UnpolishedLoveCoreItem(Properties p_i48487_1_) {
		super(p_i48487_1_.stacksTo(1));
	}
	public float getProgress(ItemStack stack) {
		if (!stack.has(AllDataComponents.SEQUENCED_ASSEMBLY))
			return 0;
		return Objects.requireNonNull(stack.get(AllDataComponents.SEQUENCED_ASSEMBLY)).progress();
	}
	@Override
	public boolean isBarVisible(@NotNull ItemStack stack) {
		return true;
	}

	@Override
	public int getBarWidth(@NotNull ItemStack stack) {
		return Math.round(getProgress(stack) * 13);
	}

	@Override
	public int getBarColor(@NotNull ItemStack stack) {
		return Color.mixColors(0xFF_FFC074, 0xFF_46FFE0, getProgress(stack));
	}

}
