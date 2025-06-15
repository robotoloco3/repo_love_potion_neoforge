package com.roland.repolovepotion.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import com.roland.repolovepotion.RepoLovePotionMod;

public class RepoLovePotionModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, RepoLovePotionMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LOVE_PARTICLE = REGISTRY.register("love_particle", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLANK_PARTICLE = REGISTRY.register("blank_particle", () -> new SimpleParticleType(true));
}

