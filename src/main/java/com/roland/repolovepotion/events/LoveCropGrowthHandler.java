package com.roland.repolovepotion.events;

import com.roland.repolovepotion.init.RepoLovePotionModMobEffects;
import com.roland.repolovepotion.init.RepoLovePotionModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.bus.api.SubscribeEvent;

public class LoveCropGrowthHandler {

    private static final int RADIUS = 18;
    private static final int GROWTH_ATTEMPTS = 1;
    private static final double GROWTH_CHANCE = 0.015;

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (event.getEntity().level().isClientSide()) return;

        if (!event.getEntity().hasEffect(RepoLovePotionModMobEffects.LOVE)) return;

        ServerLevel level = (ServerLevel) event.getEntity().level();
        BlockPos center = event.getEntity().blockPosition();

        BlockPos.betweenClosedStream(center.offset(-RADIUS, -1, -RADIUS), center.offset(RADIUS, 1, RADIUS))
                .forEach(pos -> {
                    BlockState state = level.getBlockState(pos);
                    if (state.getBlock() instanceof CropBlock crop) {
                        BlockPos below = pos.below();
                        BlockState soil = level.getBlockState(below);

                        if (soil.is(Blocks.FARMLAND)) {
                            if (level.random.nextDouble() < GROWTH_CHANCE) {
                                for (int i = 0; i < GROWTH_ATTEMPTS; i++) {
                                    if (!crop.isMaxAge(state)) {
                                        crop.performBonemeal(level, level.random, pos, state);
                                        level.sendParticles(ParticleTypes.HEART, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                                                3, 0.2, 0.2, 0.2, 0.02);
                                        level.playSound(null, pos, RepoLovePotionModSounds.GLUG_GLUG.get(), SoundSource.BLOCKS,
                                                0.75f, 1.0f + (level.random.nextFloat() * 0.5f - 0.25f));
                                    }
                                }
                            }
                        }
                    }
                }
        );
    }
}