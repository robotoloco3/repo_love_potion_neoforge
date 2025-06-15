package com.roland.repolovepotion.init;

import com.roland.repolovepotion.client.particle.LoveParticle;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RepoLovePotionModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(RepoLovePotionModParticleTypes.LOVE_PARTICLE.get(), LoveParticle::provider);
		event.registerSpriteSet(RepoLovePotionModParticleTypes.BLANK_PARTICLE.get(), LoveParticle::provider);
	}
}
