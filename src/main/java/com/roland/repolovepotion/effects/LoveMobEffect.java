package com.roland.repolovepotion.effects;


import com.roland.repolovepotion.init.RepoLovePotionModParticleTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Team;
import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import java.util.Set;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import com.roland.repolovepotion.init.RepoLovePotionModSounds;
import net.tslat.effectslib.api.ExtendedMobEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LoveMobEffect extends ExtendedMobEffect {
    public LoveMobEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xffff0099);
    }

    @Override
    public @NotNull ParticleOptions createParticleOptions(@NotNull MobEffectInstance mobEffectInstance) {
        return RepoLovePotionModParticleTypes.BLANK_PARTICLE.get();
    }

    @Override
    public void fillEffectCures(Set<EffectCure> cures, @NotNull MobEffectInstance effectInstance) {
        cures.add(EffectCures.HONEY);
    }

    @Override
    public boolean shouldTickEffect(@Nullable MobEffectInstance effectInstance, @Nullable LivingEntity entity, int ticksRemaining, int amplifier) {
        return true;
    }
    @Override
    public boolean tick(LivingEntity entity, @Nullable MobEffectInstance effectInstance, int amplifier) {

        Level level = entity.level();

        if (!level.isClientSide && level.random.nextFloat() < 0.01f) {
            level.playSound(
                null,
                entity.blockPosition(),
                RepoLovePotionModSounds.YIPEE.get(),
                SoundSource.PLAYERS,
                1.0F,
                1.0F + level.random.nextFloat() * 0.6F
            );
        }

        if (!level.isClientSide && level.random.nextFloat() < 0.1F) {
            ((ServerLevel)level).sendParticles(RepoLovePotionModParticleTypes.LOVE_PARTICLE.get(),
                    entity.getX(), entity.getY() + 1.0D, entity.getZ(),
                    3, 0.1D, 0.1D, 0.1D, 0.01D);
        }
        return true;
    }

    @Override
    public void onEffectStarted(@NotNull LivingEntity entity, int amplifier) {
        if (!(entity instanceof ServerPlayer player)) return;

        ServerLevel level = player.serverLevel();
        Scoreboard scoreboard = level.getScoreboard();

        PlayerTeam team = scoreboard.getPlayerTeam("love_effect");
        if (team == null) {
            team = scoreboard.addPlayerTeam("love_effect");
            team.setColor(ChatFormatting.LIGHT_PURPLE);
            team.setSeeFriendlyInvisibles(true);
            team.setNameTagVisibility(Team.Visibility.ALWAYS);
            team.setCollisionRule(Team.CollisionRule.NEVER);
        }
        if (!entity.hasEffect(MobEffects.GLOWING)) {
            entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 9999, 0, false, false, false));
        }
        scoreboard.addPlayerToTeam(player.getScoreboardName(), team);
    }
    @Override
    public void onExpiry(MobEffectInstance effectInstance, LivingEntity entity) {
        if (entity instanceof ServerPlayer player) {
            ServerLevel level = player.serverLevel();
            Scoreboard scoreboard = level.getScoreboard();

            level.playSound(
                    null,
                    entity.blockPosition(),
                    RepoLovePotionModSounds.HOLY_MOLY.get(),
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F + level.random.nextFloat() * 0.6F - 0.3F
            );

            PlayerTeam team = scoreboard.getPlayerTeam("love_effect");
            if (team != null) {
                scoreboard.removePlayerFromTeam(player.getScoreboardName(), team);

                if (team.getPlayers().isEmpty()) {
                    scoreboard.removePlayerTeam(team);
                }

            }
            if (entity.hasEffect(MobEffects.GLOWING)) {
                entity.removeEffect(MobEffects.GLOWING);
            }
        }
    }
    @Override
    public boolean onRemove(MobEffectInstance effectInstance, LivingEntity entity) {

        if (entity instanceof ServerPlayer player) {
            ServerLevel level = player.serverLevel();
            Scoreboard scoreboard = level.getScoreboard();

            level.playSound(
                    null,
                    entity.blockPosition(),
                    RepoLovePotionModSounds.HOLY_MOLY.get(),
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F + level.random.nextFloat() * 0.6F - 0.3F
            );

            PlayerTeam team = scoreboard.getPlayerTeam("love_effect");
            if (team != null) {
                scoreboard.removePlayerFromTeam(player.getScoreboardName(), team);

                if (team.getPlayers().isEmpty()) {
                    scoreboard.removePlayerTeam(team);
                }

            }
            if (entity.hasEffect(MobEffects.GLOWING)) {
                entity.removeEffect(MobEffects.GLOWING);
            }
        }

        return true;
    }
}