package com.roland.repolovepotion;

import com.roland.repolovepotion.events.CreeperLoveAIHandler;
import com.roland.repolovepotion.events.LoveCropGrowthHandler;
import com.roland.repolovepotion.events.PlayerDeathHandler;
import com.roland.repolovepotion.events.PlayerLoveEffectHandler;
import com.roland.repolovepotion.init.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.util.Tuple;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;


@Mod("repo_love_potion")
public class RepoLovePotionMod {
	public static final Logger LOGGER = LogManager.getLogger(RepoLovePotionMod.class);
	public static final String MODID = "repo_love_potion";

	public RepoLovePotionMod(IEventBus modEventBus) {
		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::registerNetworking);
		RepoLovePotionModSounds.REGISTRY.register(modEventBus);

		RepoLovePotionModItems.REGISTRY.register(modEventBus);

		RepoLovePotionModTabs.REGISTRY.register(modEventBus);

		RepoLovePotionModMobEffects.REGISTRY.register(modEventBus);

		RepoLovePotionModVillagerProfessions.PROFESSIONS.register(modEventBus);

		RepoLovePotionModParticleTypes.REGISTRY.register(modEventBus);

		NeoForge.EVENT_BUS.register(PlayerDeathHandler.class);

		NeoForge.EVENT_BUS.register(new PlayerLoveEffectHandler());

		NeoForge.EVENT_BUS.register(LoveCropGrowthHandler.class);

		NeoForge.EVENT_BUS.register(CreeperLoveAIHandler.class);

	}



	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader,
																 IPayloadHandler<T> handler) {
	}

	public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
		networkingRegistered = true;
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setB(work.getB() - 1);
			if (work.getB() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getA().run());
		workQueue.removeAll(actions);
	}


}

