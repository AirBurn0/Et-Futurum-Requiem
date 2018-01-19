package ganymedes01.etfuturum.configuration;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.enchantment.FrostWalker;
import ganymedes01.etfuturum.enchantment.Mending;
import ganymedes01.etfuturum.lib.Reference;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

	public static ConfigurationHandler INSTANCE = new ConfigurationHandler();
	public Configuration configFile;
	public String[] usedCategories = { Configuration.CATEGORY_GENERAL };

	private int configInteger(String name, boolean requireRestart, int def) {
		return configInteger(name, null, requireRestart, def);
	}

	private int configInteger(String name, String tooltip, boolean requireRestart, int def) {
		int config = configFile.get(Configuration.CATEGORY_GENERAL, name, def, tooltip).getInt(def);
		return config >= 0 ? config : def;
	}

	private boolean configBoolean(String name, String tooltip, boolean requireRestart, boolean def) {
		return configFile.get(Configuration.CATEGORY_GENERAL, name, def, tooltip).getBoolean(def);
	}

	private boolean configBoolean(String name, boolean requireRestart, boolean def) {
		return configBoolean(name, null, requireRestart, def);
	}

	public void init(File file) {
		configFile = new Configuration(file);

		syncConfigs();
	}

	private void syncConfigs() {
		//blocks
		EtFuturum.enableStones = configBoolean("Enable Granite/Andesite/Diorite", true, EtFuturum.enableStones);
		EtFuturum.maxStonesPerCluster = configInteger("Max number of Granite/Andesite/Diorite/Magma blocks in a cluster", true, EtFuturum.maxStonesPerCluster);
		
		EtFuturum.enableIronTrapdoor = configBoolean("Iron Trapdoor", true, EtFuturum.enableIronTrapdoor);
		EtFuturum.enableSponge = configBoolean("Sponge", true, EtFuturum.enableSponge);
		EtFuturum.enablePrismarine = configBoolean("Prismarine", true, EtFuturum.enablePrismarine);
		EtFuturum.enableDoors = configBoolean("Doors", true, EtFuturum.enableDoors);
		EtFuturum.enableInvertedDaylightSensor = configBoolean("Inverted Daylight Sensor", true, EtFuturum.enableInvertedDaylightSensor);
		EtFuturum.enableCoarseDirt = configBoolean("Coarse Dirt", true, EtFuturum.enableCoarseDirt);
		EtFuturum.enableRedSandstone = configBoolean("Red Sandstone", true, EtFuturum.enableRedSandstone);
		EtFuturum.enableFences = configBoolean("Fences and Gates", true, EtFuturum.enableFences);
		EtFuturum.enableBanners = configBoolean("Banners", true, EtFuturum.enableBanners);
		EtFuturum.enableSlimeBlock = configBoolean("Slime Block", true, EtFuturum.enableSlimeBlock);
		EtFuturum.enableOldGravel = configBoolean("Old Gravel", true, EtFuturum.enableOldGravel);
		EtFuturum.enableChorusFruit = configBoolean("Chorus Fruit (and related blocks)", true, EtFuturum.enableChorusFruit);
		EtFuturum.enableGrassPath = configBoolean("Grass Path", true, EtFuturum.enableGrassPath);
		EtFuturum.enableCryingObsidian = configBoolean("Crying Obsidian", true, EtFuturum.enableCryingObsidian);
		EtFuturum.enableRoses = configBoolean("Old Roses", true, EtFuturum.enableRoses);
		
		//items
		EtFuturum.enableMutton = configBoolean("Mutton", true, EtFuturum.enableMutton);
		EtFuturum.enableBeetroot = configBoolean("Beetroot", true, EtFuturum.enableBeetroot);
		EtFuturum.enableElytra = configBoolean("Elytra", true, EtFuturum.enableElytra);
		EtFuturum.enableTippedArrows = configBoolean("Tipped Arrows", true, EtFuturum.enableTippedArrows);
		EtFuturum.enableLingeringPotions = configBoolean("Lingering Potions", true, EtFuturum.enableLingeringPotions);
		
		//enchants
		EtFuturum.enableFrostWalker = configBoolean("Frost Walker", true, EtFuturum.enableFrostWalker);
		FrostWalker.ID = configInteger("Frost Walker ID", true, FrostWalker.ID);
		
		EtFuturum.enableMending = configBoolean("Mending", true, EtFuturum.enableMending);
		Mending.ID = configInteger("Mending ID", true, Mending.ID);
		//configFile.get("enchantment", "", true, null).getBoolean(true);
		//configFile.get("enchantment", "", def, null).getInt(def);
		
		//mobs
		EtFuturum.enableRabbit = configBoolean("Rabbits", true, EtFuturum.enableRabbit);
		EtFuturum.enableArmourStand = configBoolean("Armour Stand", true, EtFuturum.enableArmourStand);
		EtFuturum.enableEndermite = configBoolean("Endermite", true, EtFuturum.enableEndermite);
		EtFuturum.enableVillagerZombies = configBoolean("Villager Zombies", true, EtFuturum.enableVillagerZombies);
		
		//function
		EtFuturum.enableSilkTouchingMushrooms = configBoolean("Mushroom Blocks", true, EtFuturum.enableSilkTouchingMushrooms);
		EtFuturum.enableRecipeForPrismarine = configBoolean("Recipes for prismarine", true, EtFuturum.enableRecipeForPrismarine);
		EtFuturum.enableSticksFromDeadBushes = configBoolean("Dead Bushes drop sticks", true, EtFuturum.enableSticksFromDeadBushes);
		EtFuturum.enableSkullDrop = configBoolean("Skulls drop from charged creeper kills", true, EtFuturum.enableSkullDrop);
		EtFuturum.enableBurnableBlocks = configBoolean("Fences, gates and dead bushes burn", true, EtFuturum.enableBurnableBlocks);
		EtFuturum.enableUpdatedFoodValues = configBoolean("Use updated food values", true, EtFuturum.enableUpdatedFoodValues);
		EtFuturum.enableUpdatedHarvestLevels = configBoolean("Use updated harvest levels", true, EtFuturum.enableUpdatedHarvestLevels);
		EtFuturum.enableShearableGolems = configBoolean("Shearing Snow Golems", true, EtFuturum.enableShearableGolems);
		EtFuturum.enableShearableCobwebs = configBoolean("Shears harvest cobwebs", true, EtFuturum.enableShearableCobwebs);
		EtFuturum.enableStoneBrickRecipes = configBoolean("Stone Brick Recipes", true, EtFuturum.enableStoneBrickRecipes);
		EtFuturum.enableBabyGrowthBoost = configBoolean("Baby growth boost", true, EtFuturum.enableBabyGrowthBoost);
		EtFuturum.enableVillagerTurnsIntoWitch = configBoolean("Villagers turn into Witches when struck by lightning", true, EtFuturum.enableVillagerTurnsIntoWitch);
		
		EtFuturum.enableDragonRespawn = configBoolean("Dragon respawning", true, EtFuturum.enableDragonRespawn);
		
		//replacement
		EtFuturum.enableTileReplacement = configBoolean("Replace old Brewing Stands/Enchanting Tables/Daylight Sensors/Beacons with new one on the fly", false, EtFuturum.enableTileReplacement);
		
		EtFuturum.enableEnchants = configBoolean("Enchanting Table", true, EtFuturum.enableEnchants);
		EtFuturum.enableAnvil = configBoolean("Anvil", true, EtFuturum.enableAnvil);
		EtFuturum.enableBrewingStands = configBoolean("Brewing Stands", true, EtFuturum.enableBrewingStands);
		EtFuturum.enableColourfulBeacons = configBoolean("Colourful Beacon Beams", true, EtFuturum.enableColourfulBeacons);
		
		//client
		EtFuturum.enableDmgIndicator = configBoolean("Heart Damage Indicator", true, EtFuturum.enableDmgIndicator);
		EtFuturum.enableTransparentAmour = configBoolean("Allow non-opaque armour", true, EtFuturum.enableTransparentAmour);
		EtFuturum.enableBowRendering = configBoolean("Bows render pulling animation on inventory", true, EtFuturum.enableBowRendering);
		EtFuturum.enableFancySkulls = configBoolean("Fancy Skulls", true, EtFuturum.enableFancySkulls);
		EtFuturum.enablePlayerSkinOverlay = configBoolean("Skin overlays", true, EtFuturum.enablePlayerSkinOverlay);
		

		EtFuturum.enableNetherBlocks = configBoolean("Enable magma/netherwart blocks and red netherbrick", true, EtFuturum.enableNetherBlocks);
		EtFuturum.enableBoneBlock = configBoolean("Enable bone block", true, EtFuturum.enableBoneBlock);
		EtFuturum.enableConcrete = configBoolean("Enable concrete", true, EtFuturum.enableConcrete);
		
		if (configFile.hasChanged())
			configFile.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (Reference.MOD_ID.equals(eventArgs.modID))
			syncConfigs();
	}
}
