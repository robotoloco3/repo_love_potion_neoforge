
package com.roland.repolovepotion.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import com.roland.repolovepotion.potion.LoveMobEffect;
import com.roland.repolovepotion.RepoLovePotionMod;

public class RepoLovePotionModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, RepoLovePotionMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> LOVE = REGISTRY.register("love", () -> new LoveMobEffect());
}
