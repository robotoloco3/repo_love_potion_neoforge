
package com.roland.repolovepotion.item;

import net.minecraft.world.effect.MobEffectInstance;
import com.roland.repolovepotion.init.RepoLovePotionModMobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import java.util.List;
import java.util.Random;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class LovePotionItem extends Item {
	private static final Random RANDOM = new Random();
	private static final double MAX_DISTANCE = 24.0;
	private static final String DEFAULT_PLAYER_NAME = "this potion";
	
	private static final String[] TRANSITIVE_VERBS = {
	    "adore",
		"sing oh la la with",
		"crush on",
		"fan over",
		"root for",
		"olala over",
		"geek out over",
		"vibe with",
		"fangirl over",
		"fanboy over",
		"heart",
		"olalalalala",
		"can't even",
		"obsess over",
		"trip over",
		"flip for",
		"freak over",
		"go nuts for",
		"go crazy for",
		"get hyped to",
		"hype up",
		"read a book with",
		"ride or die for",
		"show love for",
		"dance with",
		"ship",
		"low-key crush on",
		"have a thing for",
		"can't stop thinking about",
		"eyeing",
		"have robofeeling for",
		"catch crushie feelings for",
		"go heart eyes for",
		"get butterflies over",
		"have heart eyes for",
		"can't get over",
		"can't get enough of",
		"get in my feels over",
		"dream about",
		"imagine being happy with",
		"can't handle",
		"get weak for",
		"melt for",
		"have a soft spot for",
		"got a thing for",
		"obsessed with",
		"blushing over",
		"head over heels for",
		"feel the feels for",
		"admire",
		"crushing hard on",
		"can't even with",
		"totally into",
		"lost in",
		"robofeels about",
		"gaga for",
		"beeping and booping over",
		"extracting valuables with",
		"grooving to",
		"all about",
		"blown away by",
		"hyped about",
		"tripping over",
		"losing it over",
		"crying over",
		"obsessing over",
		"dying for",
		"looking at",
		"checking out",
		"having nothing but love for",
		"waiting on",
		"going wild for",
		"living for",
		"hooked on",
		"feeling",
		"hyped for",
		"showing mad love to",
		"sending hugs to",
		"sending hearts to",
		"0 1 1 0 1 1 0 0 0 1 1 0 1 1 1 1 0 1 1 1 0 1 1 0 0 1 1 0 0 1 0 1",
		"be friends with",
		"laugh hard with",
		"vibing with",
		"like",
		"cherish",
		"enjoy",
		"appreciate",
		"love",
		"treasure",
		"care for",
		"go gaga ding dong for",
		"long for",
		"think of",
		"miss",
		"want to be with",
		"smile at",
		"look at",
		"blush around",
		"get shy around",
		"laugh and cry with",
		"sing love songs with",
		"talk to",
		"listen to",
		"hold hands with",
		"share secrets with",
		"walk with",
		"sit with",
		"be near",
		"hang out with",
		"spend time with",
		"be around",
		"wink at",
		"wave to",
		"call",
		"write to",
		"sing to",
		"dance with",
		"cook for",
		"make art for",
		"make gifts for",
		"give gifts to",
		"surprise",
		"hug",
		"make taxman happy with",
		"ride the cart with",
		"robotickle",
		"do a stand-up routine for",
		"enjoy the sunset with",
		"share laughs with",
		"make smile",
		"bring joy to",
		"be silly with",
		"go on adventures with",
		"explore with",
		"go to Japan with",
		"grow old with",
		"Play Ark with",
		"Love with",
		"Goon for",
		"Cuddle",
		"Snuggle",
		"Goon to",
		"Tickle my pickle with",
		"Tickle my pickle for",
		"Throw it back to",
		"Collaborate with",
		"go awww lala for",
		"ark survival evolved",
		"go 'awwawawawawawawaaaaaa they so sweeetttt' to",
		"do 7:30 with"
	};

	
	private static final String[] INTRANSITIVE_VERBS = {
	    "vibe",
		"wow wow wow",
		"geek out",
		"daydream",
		"crush",
		"fangirl",
		"fanboy",
		"cheer",
		"freak out",
		"melt",
		"chill",
		"robostalk",
		"go oh la la",
		"robodance",
		"rock out",
		"hug",
		"kick it",
		"work",
		"match",
		"boot up",
		"meet up",
		"catch feels",
		"connect",
		"get along",
		"robohang",
		"check out",
		"look up",
		"catch up",
		"hang out",
		"tune in",
		"break",
		"tap in",
		"dive in",
		"get in",
		"be in",
		"collab",
		"share",
		"swap",
		"trade",
		"deal",
		"work",
		"play",
		"compete",
		"challenge",
		"engage",
		"join in",
		"get in on",
		"mix in",
		"add in",
		"help",
		"support",
		"follow",
		"track",
		"keep tabs",
		"keep up",
		"stay updated",
		"keep an eye",
		"buzz",
		"wow",
		"download the latest update",
		"update",
		"shout out",
		"yell",
		"scream",
		"hype",
		"beep boop beep boop",
		"vent",
		"express",
		"spill the beans",
		"confess love",
		"admit feelings",
		"declare bankruptcy",
		"dream",
		"blush",
		"imagine",
		"robodrool",
		"obsess",
		"admire",
		"go woop woop",
		"freak out",
		"lose it",
		"freak",
		"feel",
		"glow",
		"... i dunno ...",
		"trip",
		"groove",
		"beep boop",
		"crush",
		"flirt",
		"giggle",
		"smile",
		"laugh",
		"beam",
		"grin",
		"wonder",
		"wish",
		"hope",
		"long",
		"like",
		"leave a like and subscribe",
		"react",
		"lurk",
		"go OP",
		"despawn",
		"fart",
		"peep",
		"spy",
		"peek",
		"sigh",
		"breathe",
		"relate",
		"resonate",
		"go gaga ding dong",
		"boop",
		"jam",
		"flutter",
		"tingle",
		"twirl",
		"dance",
		"sing",
		"hum",
		"beep",
		"skip",
		"float",
		"sparkle",
		"bubble",
		"chirp",
		"glisten",
		"twinkle",
		"ponder",
		"admire",
		"breathe",
		"relax",
		"fancy",
		"laugh",
		"imagine",
		"melt",
		"smirk",
		"chuckle",
		"Smash",
		"Bust",
		"Water bucket release",
		"ark survival evolved",
		"Flint n steel"

	};
	
	private static final String[] ADVERBS = {
	    "totally",
		"super",
		"uber",
		"mega",
		"super mega",
		"seriously",
		"majorly",
		"legit",
		"absolutely",
		"completely",
		"for reals",
		"utterly",
		"high-key",
		"incredibly",
		"madly",
		"like ...",
		"like... seriously",
		"sooo",
		"really",
		"so",
		"sooooooooo",
		"unbelievably",
		"very",
		"like soooo",
		"extra",
		"extremely",
		"really really",
		"fiercely",
		"like,for reals",
		"greatly",
		"hugely",
		"immensely",
		"intensely",
		"massively",
		"so so soooo",
		"really really really",
		"like totes",
		"like... totally",
		"like.. somehow sooo",
		"simply",
		"supremely",
		"surprisingly",
		"super mega ultra",
		"ultra",
		"unusually",
		"way way",
		"way",
		"insanely",
		"like ... insanelyyyy",
		"freakishly",
		"extra extra",
		"overwhelmingly",
		"reeeaaally",
		"weirdly",
		"suuuuper",
		"way waaaay",
		"crazy",
		"like suuuuuper",
		"really sooo",
		"low-key",
		"high-key",
		"literally",
		"for reeeaal soo",
		"legit",
		"honestly",
		"kinda",
		"sort of",
		"basically",
		"downright",
		"like literally",
		"very very",
		"like like.. like... sooo",
		"like... actually",
		"suuuuper suuuuper",
		"genuinely",
		"truly",
		"sincerely",
		"busting a move",
		"Boogy woogy",
		"boogy woogity",
		"going crazyyyyyyyyyyyyyyyyyyyy",
		"Creaming",
		"ark survival evolved",
		"going YAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYA",
		"YAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYAYA"
	};
	
	private static final String[] ADJECTIVES = {
	    "epic",
		"awesome",
		"adorable",
		"adorbs",
		"fab",
		"cool",
		"dreamy",
		"snazzy",
		"rad",
		"stellar",
		"dope",
		"amazing",
		"breathtaking",
		"charming",
		"cute",
		"ah meh zin geh",
		"fresh",
		"funky",
		"glowing",
		"oh la la la",
		"incredible",
		"olala",
		"lovable",
		"lovely",
		"upgraded",
		"neat",
		"on point",
		"peachy",
		"0 1 1 0 0 0 1 1 0 1 1 1 0 1 0 1 0 1 1 1 0 1 0 0 0 1 1 0 0 1 0 1",
		"woop y woop y woo",
		"likey likey",
		"oooh ya ya",
		"slick",
		"smart",
		"smooth",
		"sparkling",
		"OMG",
		"stunning",
		"stylish",
		"ooooh yeaaa",
		"superb",
		"supreme",
		"sweet",
		"wowie",
		"trendy",
		"unreal",
		"vibrant",
		"wicked",
		"me likey",
		"beep boop",
		"oh my",
		"oof in a good way",
		"brilliant",
		"oh ya ya",
		"chic",
		"ah ... mazing",
		"clever",
		"comfy",
		"cu ... wait ... teh ... cute",
		"woop woop",
		"hugable",
		"cute",
		"yas queen",
		"sooo like ... wow",
		"divine",
		"electric",
		"elegant",
		"elite",
		"1337",
		"engaging",
		"enticing",
		"fancy",
		"fierce",
		"fire",
		"fly",
		"glam",
		"gorgeous",
		"hype mode",
		"iconic",
		"legendary",
		"litty",
		"wow wow wow",
		"magical",
		"majestic",
		"bootiiifoool",
		"poppin'",
		"precious",
		"C O O L ... cool",
		"C U T E ... cute",
		"... ... *blushes* ...",
		"slaying",
		"spicy",
		"robohandsome",
		"wowa wowa yas yas",
		"on fleek",
		"robocute",
		"wholesome",
		"winning",
		"robodorable",
		"powerful",
		"pretty",
		"beautiful",
		"sweet",
		"kind",
		"wow wow wow wow wow",
		"100%",
		"0 1 1 0 0 0 1 0 0 1 1 0 0 0 0 1 0 1 1 0 0 1 0 0",
		"fun",
		"brave",
		"interesting",
		"smart in the head",
		"sparkling",
		"shiny",
		"warm",
		"heroic",
		"friendly",
		"financially stable",
		"oh la la oh la la la la",
		"romantic",
		"cozy",
		"wonderful",
		"fantastic",
		"super",
		"great",
		"delightful",
		"fabulous",
		"marvelous",
		"nice",
		"pleasant",
		"good",
		"special",
		"unique",
		"o la la la yes yes",
		"yeah yeah wow wow",
		"wooooow",
		"oh woooow",
		"oh my gawd",
		"Yiiipiiii yipiiiiii yiipiiiiiiii",
		"Bustable",
		"Sooooo smash",
		"smashable",
		"cozyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
		"yummy",
		"creamy",
		"ark survival evolved",
		"wobble dogs"
	};
	
	private static final String[] INTENSIFIERS = {
	    "totally",
		"super",
		"uber",
		"mega",
		"super mega",
		"seriously",
		"majorly",
		"legit",
		"absolutely",
		"completely",
		"for reals",
		"utterly",
		"high-key",
		"incredibly",
		"madly",
		"like ...",
		"like... seriously",
		"sooo",
		"really",
		"so",
		"sooooooooo",
		"unbelievably",
		"very",
		"like soooo much",
		"extra",
		"extremely",
		"really really",
		"fiercely",
		"like, for reals",
		"greatly",
		"hugely",
		"immensely",
		"intensely",
		"massively",
		"so so soooo",
		"really really really",
		"like totes",
		"like... totally",
		"like.. somehow sooo much",
		"simply",
		"supremely",
		"surprisingly",
		"super mega ultra",
		"ultra",
		"unusually",
		"way way",
		"way",
		"insanely",
		"like ... insanelyyyy",
		"freakishly",
		"extra extra",
		"overwhelmingly",
		"reeeaaally",
		"weirdly",
		"suuuuper",
		"way waaaay",
		"crazy",
		"like suuuuuper",
		"really sooo",
		"low-key",
		"high-key",
		"literally",
		"for reeeaal soo",
		"legit",
		"honestly",
		"kinda",
		"sort of",
		"basically",
		"downright",
		"like literally",
		"very very",
		"like like.. like... sooo much",
		"like... actually",
		"suuuuper suuuuper",
		"genuinely",
		"truly",
		"sincerely",
		"downbad",
		"ark survival evolved",
		"Boogy woogy",
		"yummyyyyyyyyyyy"

	};
	
	private static final String[] NOUNS = {
	    "bae",
		"bro",
		"fam",
		"goals",
		"friendo",
		"buddy",
		"pal",
		"champ",
		"MVP",
		"rockstar",
		"hero",
		"idol",
		"star",
		"queen",
		"king",
		"baby",
		"beast",
		"boss",
		"bruh",
		"boss queen",
		"girl",
		"dude",
		"genius",
		"guru",
		"cutie",
		"legend",
		"player",
		"boss king",
		"pog",
		"partner",
		"prodigy",
		"pro",
		"role model",
		"boy",
		"soulmate",
		"superhero",
		"sweetie",
		"twin",
		"robot",
		"wizard",
		"wonder",
		"crushie",
		"angel",
		"viral hit",
		"blessing",
		"champion",
		"charmer",
		"crush",
		"darling",
		"dear",
		"gamer",
		"fave",
		"friend",
		"gem",
		"heartthrob",
		"honey",
		"heartbreaker",
		"inspiration",
		"love",
		"main",
		"other half",
		"crushcrush",
		"person",
		"precious",
		"sunshine",
		"treasure",
		"bestie",
		"boo",
		"cutie",
		"sister",
		"sis",
		"brother",
		"fam",
		"beauty",
		"megacrush",
		"best friend",
		"supercrush",
		"favfav",
		"main character",
		"robo",
		"icon",
		"legend",
		"mood",
		"vibe",
		"goat",
		"man",
		"woman",
		"goal",
		"winner",
		"yas queen",
		"cute robot",
		"robot crush",
		"pal",
		"sweetheart",
		"pumpkin",
		"sugar",
		"baby",
		"peach",
		"dove",
		"cupcake",
		"buttercup",
		"snugglebug",
		"silly goose",
		"teddy bear",
		"dream",
		"princess",
		"prince",
		"superstar",
		"Massive smashable gyattt",
		"Ark survival evolved",
		"Drake",
		"child",
		"ARK",
		"Smash",
		"Lov",
		"Huggable lov",
		"Bald person",
		"Gru",
		"Giraffe",
		"MY LOVE",
		"Nerd"
	};
	
	private static final String[] MESSAGES_WITH_PLAYER = {
	    "Can't even with how {adjective} {playerName} is.",
	    "{playerName} makes everything {intensifier} legit.",
	    "Why is {playerName} so {adjective}? So cute!",
	    "Every time I see {playerName} I {intransitiveVerb}.",
	    "{playerName} is just {intensifier} {adjective} you know?",
	    "Got me {adverb} thinking about {playerName} all day.",
	    "Just want to {transitiveVerb} {playerName}.",
	    "Oh my {playerName} is {intensifier} {adjective}!",
	    "When {playerName} smiles I {intransitiveVerb}.",
	    "{playerName} you are so {adjective}!",
	    "Can we talk about how {adjective} {playerName} is?",
	    "{playerName} has such a {adjective} vibe.",
	    "Just saw {playerName} looking {adjective} so sweet.",
	    "Wow {playerName} is so {adjective}!",
	    "Every time {playerName} talks I {intransitiveVerb}.",
	    "{playerName} and me = {intensifier} {adjective} vibes.",
	    "Is it just me or is {playerName} {intensifier} {adjective}?",
	    "Not gonna lie {playerName} is {adverb} {adjective}.",
	    "{playerName} is always {adjective} and I love it.",
	    "I can't help {intransitiveVerb} over {playerName}.",
	    "Guess who has a crush on {playerName}? Me!",
	    "{playerName} walking in makes my day {intensifier} {adjective}.",
	    "Hey {playerName} keep being you!",
	    "With {playerName} everything is {adjective}.",
	    "Just {adverb} dreaming about {playerName}.",
	    "{playerName} looks so {adjective} today.",
	    "Low-key {playerName} is the most {adjective} person.",
	    "High-key crushing on {playerName}!",
	    "{playerName} has that {adjective} something.",
	    "For real {playerName}'s vibe is {intensifier} {adjective}.",
	    "Can't help but {transitiveVerb} {playerName}; they're so {adjective}.",
	    "{playerName} is {adverb} my {noun}!",
	    "Life is more {adjective} with {playerName} around.",
	    "{playerName}'s laugh is {intensifier} {adjective}.",
	    "{playerName} you {adverb} {transitiveVerb} my world.",
	    "Why is {playerName} so {adjective}?",
	    "Did you see {playerName} today? So {adjective}!",
	    "It's {adverb} {adjective} how much I {transitiveVerb} {playerName}.",
	    "Me whenever I see {playerName}: So {adjective}!",
	    "{playerName} has me {adverb} {intransitiveVerb}.",
	    "Just saw {playerName} and yep still {adjective}.",
	    "{playerName} is my {intensifier} {adjective} crush.",
	    "Can confirm {playerName} is {adjective}!",
	    "Everyday mood: {intransitiveVerb} about how {adjective} {playerName} is.",
	    "{playerName} stop being so {adjective}; I can't handle it.",
	    "When {playerName} is {intensifier} {adjective}... *swoons*",
	    "Just {intransitiveVerb} about {playerName} being so {adjective}.",
	    "Yep {playerName} keeps getting more {adjective}.",
	    "{playerName} makes me believe in {intensifier} {adjective} things.",
	    "Daily reminder: {playerName} is {intensifier} {adjective}.",
	    "To be honest {playerName} rocks that {adjective} look {adverb}.",
	    "Seeing {playerName} today was {adverb} the highlight.",
	    "I can't stop {intransitiveVerb} when I think of {playerName}.",
	    "{playerName} you make my heart {intransitiveVerb}.",
	    "Is it possible to {transitiveVerb} {playerName} more?",
	    "{playerName} is just too {adjective}!",
	    "Thinking about {playerName} makes me {intransitiveVerb}.",
	    "My day gets {adjective} when I see {playerName}.",
	    "{playerName} is my favorite {noun}.",
	    "I {transitiveVerb} {playerName} so much!",
	    "Just {adverb} wishing I could {transitiveVerb} {playerName}.",
	    "Whenever I see {playerName} I {intransitiveVerb} inside.",
	    "{playerName} has the most {adjective} smile.",
	    "Can't wait to {transitiveVerb} {playerName} again.",
	    "If only {playerName} knew how {adjective} they are.",
	    "Feeling {adjective} thanks to {playerName}.",
	    "{playerName} you're {intensifier} {adjective}!",
	    "I just want to {transitiveVerb} {playerName} all day.",
	    "{playerName} you make me {intransitiveVerb}.",
	    "Life is {adjective} with {playerName}.",
	    "{playerName} is like the most {adjective} dream.",
	    "Can't stop smiling because of {playerName}.",
	    "I think I {transitiveVerb} {playerName}.",
	    "{playerName} makes my heart {intransitiveVerb}.",
	    "Oh {playerName} you're so {adjective}!",
	    "Just thinking about {playerName} makes me happy.",
	    "Wish I could {transitiveVerb} {playerName} right now.",
	    "{playerName} is simply {adjective}.",
	    "Feeling {adjective} whenever {playerName} is around.",
	    "{playerName} you brighten my day!",
	    "I {transitiveVerb} {playerName} more than anything.",
	    "Just {adverb} thinking about {playerName}.",
	    "{playerName} is {intensifier} {adjective}!",
	    "Can't get enough of {playerName}'s {adjective} vibes.",
	    "{playerName} is {adverb} {adjective}.",
	    "Just {intransitiveVerb} about how {adjective} {playerName} is.",
	    "{playerName} makes my day {intensifier} awesome.",
		"{playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}! {playerName}!",
		"{playerName} has a {adjective} {noun} ",
	    "{playerName} makes me want to bust."
		
	};

	public LovePotionItem() {
	    super(new Item.Properties()
	        .stacksTo(1)
	        .rarity(Rarity.EPIC)
	        .food(new FoodProperties.Builder()
	            .nutrition(0)
	            .saturationModifier(0.0f)
	            .alwaysEdible()
	            .build()));
	}

	

	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public int getUseDuration(@NotNull ItemStack itemstack, @NotNull LivingEntity livingEntity) {
		return 40;
	}



    @Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, Level level, @NotNull LivingEntity entity) {

        if (!level.isClientSide && entity instanceof ServerPlayer serverPlayer) {
	        List<ServerPlayer> players = serverPlayer.serverLevel().players().stream()
	            .filter(p -> !p.equals(serverPlayer))
	            .toList();
	
	        ServerPlayer nearest = null;
	        double closestDistance = Double.MAX_VALUE;
	        
	        for (ServerPlayer other : players) {
	            double distance = other.distanceTo(serverPlayer);
	            if (distance <= MAX_DISTANCE && distance < closestDistance) {
	                closestDistance = distance;
	                nearest = other;
	            }
	        }

            serverPlayer.getCooldowns().addCooldown(stack.getItem(), 260);


            SoundEvent soundEvent = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("repo_love_potion:bluh_bluh"));
			long seed = serverPlayer.getRandom().nextLong();
			double radius = 24.0;
    		Vec3 sourcePos = serverPlayer.position();
            Holder<SoundEvent> soundHolder = null;
            if (soundEvent != null) {
                soundHolder = BuiltInRegistries.SOUND_EVENT.wrapAsHolder(soundEvent);
            }

            for (ServerPlayer other : serverPlayer.serverLevel().players()) {
			    if (other.position().distanceTo(sourcePos) <= radius) {
                    if (soundHolder != null) {
                        other.connection.send(new ClientboundSoundPacket(
                            soundHolder,
                            SoundSource.PLAYERS,
                            sourcePos.x,
                               sourcePos.y,
                            sourcePos.z,
                            1.0f,
                            1.0f,
                            seed
                        ));
                    }
                }
		}

			MobEffectInstance loveEffect = new MobEffectInstance(RepoLovePotionModMobEffects.LOVE, 900, 0, false, true, true);

			serverPlayer.removeEffect(RepoLovePotionModMobEffects.LOVE);
			serverPlayer.addEffect(loveEffect);
			if (nearest != null) {
				nearest.removeEffect(RepoLovePotionModMobEffects.LOVE);
				nearest.addEffect(loveEffect);
			}

            String transitiveVerb = TRANSITIVE_VERBS[RANDOM.nextInt(TRANSITIVE_VERBS.length)];
            String intransitiveVerb = INTRANSITIVE_VERBS[RANDOM.nextInt(INTRANSITIVE_VERBS.length)];
            String adverb = ADVERBS[RANDOM.nextInt(ADVERBS.length)];
            String intensifier = INTENSIFIERS[RANDOM.nextInt(INTENSIFIERS.length)];
            String adjective = ADJECTIVES[RANDOM.nextInt(ADJECTIVES.length)];
            String noun = NOUNS[RANDOM.nextInt(NOUNS.length)];

            String playerName = (nearest != null) ? nearest.getName().getString() : DEFAULT_PLAYER_NAME;

            String template = MESSAGES_WITH_PLAYER[RANDOM.nextInt(MESSAGES_WITH_PLAYER.length)];

			sendFormattedMessage(serverPlayer,
                template,
                Map.of(
                    "playerName", Component.literal(playerName).withStyle(ChatFormatting.GOLD),
                    "adverb", Component.literal(adverb).withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.BOLD),
                    "intensifier", Component.literal(intensifier).withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.BOLD),
                    "intransitiveVerb", Component.literal(intransitiveVerb).withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.BOLD),
                    "transitiveVerb", Component.literal(transitiveVerb).withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.BOLD),
                    "adjective", Component.literal(adjective).withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.BOLD),
                    "noun", Component.literal(noun).withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.BOLD)
                ),
                ChatFormatting.DARK_PURPLE
            );
        }

        return stack;
    }

	private String pluralizeVerb(String verb) {
		if (verb.endsWith("e")) {
			return verb + "s";
		} else {
			return verb + "es";
		}
	}
	public void sendFormattedMessage(ServerPlayer player, String template, Map<String, Component> placeholders, ChatFormatting defaultColor) {
		Pattern pattern = Pattern.compile("\\{(\\w+?)(s)?}");
		Matcher matcher = pattern.matcher(template);

		int lastEnd = 0;
		MutableComponent message = Component.empty();

		while (matcher.find()) {
			String before = template.substring(lastEnd, matcher.start());
			String key = matcher.group(1);
			boolean isPlural = matcher.group(2) != null;

			if (!before.isEmpty()) {
				message.append(Component.literal(before).withStyle(defaultColor));
			}

			Component base = placeholders.get(key);

			if (base != null) {
				String plain = base.getString();
				if (isPlural) {
					String plural = pluralizeVerb(plain);
					message.append(Component.literal(plural).withStyle(base.getStyle()));
				} else {
					message.append(base);
				}
			} else {
				message.append(Component.literal("{" + key + (isPlural ? "s" : "") + "}").withStyle(ChatFormatting.RED));
			}

			lastEnd = matcher.end();
		}

		if (lastEnd < template.length()) {
			String after = template.substring(lastEnd);
			message.append(Component.literal(after).withStyle(defaultColor));
		}

		for (ServerPlayer onlinePlayer : player.serverLevel().players()) {
			onlinePlayer.sendSystemMessage(message);
		}
	}
}
