package com.roland.repolovepotion.events;


import com.roland.repolovepotion.init.RepoLovePotionModMobEffects;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;


public class PlayerLoveEffectHandler {

    private static final long BREED_COOLDOWN_TICKS = 40L;
    private final Map<UUID, Long> lastBreedTime = new WeakHashMap<>();

    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (level.isClientSide) return;
        if (!player.hasEffect(RepoLovePotionModMobEffects.LOVE)) return;

        long gameTime = level.getGameTime();
        double radius = 8.0D;

        List<Animal> animals = level.getEntitiesOfClass(Animal.class, player.getBoundingBox().inflate(radius));

        for (Animal animal : animals) {
            UUID id = animal.getUUID();

            if (animal.isBaby() || animal.isInLove()) continue;

            long lastTime = lastBreedTime.getOrDefault(id, 0L);
            if (gameTime - lastTime < BREED_COOLDOWN_TICKS) continue;

            animal.setInLove(player);
            lastBreedTime.put(id, gameTime);
        }
    }
}
