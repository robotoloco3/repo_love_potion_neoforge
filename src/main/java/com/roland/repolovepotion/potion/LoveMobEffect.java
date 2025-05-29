package com.roland.repolovepotion.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import java.util.Set;

import com.roland.repolovepotion.RepoLovePotionMod;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import com.roland.repolovepotion.init.RepoLovePotionModSounds;

public class LoveMobEffect extends MobEffect {
    public LoveMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -65383);
        this.addAttributeModifier(Attributes.JUMP_STRENGTH,
            ResourceLocation.fromNamespaceAndPath(RepoLovePotionMod.MODID, "effect.love_0"),
            0.2, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.STEP_HEIGHT,
            ResourceLocation.fromNamespaceAndPath(RepoLovePotionMod.MODID, "effect.love_2"),
            3, AttributeModifier.Operation.ADD_VALUE);
    }

    @Override
    public ParticleOptions createParticleOptions(MobEffectInstance effectInstance) {
        return ParticleTypes.HEART;
    }

    @Override
    public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
        cures.add(EffectCures.MILK);
        cures.add(EffectCures.PROTECTED_BY_TOTEM);
        cures.add(EffectCures.HONEY);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        Level level = entity.level();

        if (!level.isClientSide && level.random.nextFloat() < 0.01f) {
            level.playSound(
                null,
                entity.blockPosition(),
                RepoLovePotionModSounds.YIPEE.get(),
                SoundSource.PLAYERS,
                1.0F,
                1.0F + level.random.nextFloat() * 0.2F
            );
        }

        return super.applyEffectTick(entity, amplifier);
    }
}