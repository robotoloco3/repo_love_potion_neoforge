package com.roland.repolovepotion.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerDeathHandler {

    @SubscribeEvent
    public static void onLivingDeath(@NotNull LivingDeathEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        ServerLevel level = player.serverLevel();
        Scoreboard scoreboard = level.getScoreboard();
        PlayerTeam team = scoreboard.getPlayerTeam("love_effect");

        if (team != null) {
            scoreboard.removePlayerFromTeam(player.getScoreboardName(), team);

            if (team.getPlayers().isEmpty()) {
                    scoreboard.removePlayerTeam(team);
            }

        }

    }
}
