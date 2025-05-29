package com.roland.repolovepotion.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.roland.repolovepotion.init.RepoLovePotionModMobEffects;

public class GiveLoveProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(RepoLovePotionModMobEffects.LOVE, 600, 1, false, false));
	}
}
