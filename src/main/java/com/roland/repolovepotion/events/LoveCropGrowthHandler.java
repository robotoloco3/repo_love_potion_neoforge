package com.roland.repolovepotion.events;


import com.roland.repolovepotion.init.RepoLovePotionModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.bus.api.SubscribeEvent;

public class LoveCropGrowthHandler {

    private static final int RADIUS = 12;
    private static final int EXTRA_TICKS = 10;

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (event.getEntity().level().isClientSide()) return;

        if (!event.getEntity().hasEffect(RepoLovePotionModMobEffects.LOVE)) return;

        ServerLevel level = (ServerLevel) event.getEntity().level();
        BlockPos center = event.getEntity().blockPosition();

        BlockPos.betweenClosedStream(center.offset(-RADIUS, -2, -RADIUS), center.offset(RADIUS, 2, RADIUS))
                .forEach(pos -> {
                    BlockState state = level.getBlockState(pos);
                    if (state.getBlock() instanceof BonemealableBlock crop) {
                        if (crop.isValidBonemealTarget(level, pos, state)) {
                            for (int i = 0; i < EXTRA_TICKS; i++) {
                                crop.performBonemeal(level, level.random, pos, state);
                            }
                        }
                    }
                });
    }
}