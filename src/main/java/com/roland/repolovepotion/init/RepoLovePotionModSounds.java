
package com.roland.repolovepotion.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.roland.repolovepotion.RepoLovePotionMod;

public class RepoLovePotionModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, RepoLovePotionMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> GLUG_GLUG = REGISTRY.register("glug_glug", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "glug_glug")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLUH_BLUH = REGISTRY.register("bluh_bluh", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "bluh_bluh")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VILLAGER_RAP = REGISTRY.register("villager_rap", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "villager_rap")));
	public static final DeferredHolder<SoundEvent, SoundEvent> I_LOVE_SONG = REGISTRY.register("i_love_song", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "i_love_song")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DEMONS = REGISTRY.register("demons", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "demons")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DIAMONDS = REGISTRY.register("diamonds", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "diamonds")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DOUBLE_LIFE = REGISTRY.register("double_life", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "double_life")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RULE_WORLD = REGISTRY.register("rule_world", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "rule_world")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLOWERS = REGISTRY.register("flowers", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "flowers")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GANGSTA = REGISTRY.register("gangsta", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "gangsta")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HYMN = REGISTRY.register("hymn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "hymn")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WORRIED = REGISTRY.register("worried", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "worried")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEVITATING = REGISTRY.register("levitating", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "levitating")));
	public static final DeferredHolder<SoundEvent, SoundEvent> JAGGER = REGISTRY.register("jagger", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "jagger")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SUNFLOWER = REGISTRY.register("sunflower", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "sunflower")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THUNDER = REGISTRY.register("thunder", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "thunder")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UPTOWN = REGISTRY.register("uptown", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "uptown")));
	public static final DeferredHolder<SoundEvent, SoundEvent> VIVA = REGISTRY.register("viva", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "viva")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HOLY_MOLY = REGISTRY.register("holy_moly", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "holy_moly")));
	public static final DeferredHolder<SoundEvent, SoundEvent> YIPEE = REGISTRY.register("yipee", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "yipee")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ARK_SONG = REGISTRY.register("ark_song", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("repo_love_potion", "ark_song")));
}
