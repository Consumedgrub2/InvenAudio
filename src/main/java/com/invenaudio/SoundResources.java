package com.invenaudio;

import java.util.HashMap;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.ResourceLocation;

public class SoundResources {
    //Sound hashmaps
    private static final HashMap<String, ResourceLocation> generalVanillaSoundHashMap = new HashMap<>();
    private static final HashMap<String, ResourceLocation> generalModdedSoundHashMap = new HashMap<>();
    private static final HashMap<String, ResourceLocation> specificModdedSoundHashMap = new HashMap<>();

    //Final fallback if no string sound association is found in hashmaps
    private static final ResourceLocation finalFallbackSound = new ResourceLocation("invenaudio:invenaudio_default");

    public static ResourceLocation getInventorySoundType(String itemName) {
        String[] wordsInItemName = itemName.toLowerCase().split(" ");
        ResourceLocation resourceLocationToSound = searchHashMapsInOrder(itemName.toLowerCase());
        //First check for exact string matches
        if (resourceLocationToSound != null) {
            return resourceLocationToSound;
        }
        else {
            //Secondly, for each map, check every word in the itemName (Pick the most complex sounding association)
            for (int i = 0; i < 3; i++) {
                for (String word : wordsInItemName) {
                    resourceLocationToSound = searchSingleHashMap(word, i);
                    if (resourceLocationToSound != null) {
                        return resourceLocationToSound;
                    }
                }
            }
            //Finally, if no association is found, play the default sound
            return finalFallbackSound;
        }
    }

    public static void playInventorySound(ResourceLocation resourceLocation) {
        if (resourceLocation != null) {
            EntityClientPlayerMP player = InvenAudio.MC.thePlayer;
            if (player != null && player.worldObj.isRemote) {
                player.playSound(resourceLocation.toString(), 1.0f, 1.0f);
            }
        }
    }

    private static ResourceLocation searchHashMapsInOrder(String itemName) {
        ResourceLocation[] resourceLocationArray = new ResourceLocation[] {
                specificModdedSoundHashMap.get(itemName),
                generalModdedSoundHashMap.get(itemName),
                generalVanillaSoundHashMap.get(itemName)
        };
        for (int i = 0; i < resourceLocationArray.length; i++) {
            if (resourceLocationArray[i] != null) {
                return resourceLocationArray[i];
            }
        }
        return null;
    }
    
    private static ResourceLocation searchSingleHashMap(String itemName, int hashMap) {
        HashMap<String, ResourceLocation>[] hashMapArray = new HashMap[] { specificModdedSoundHashMap, generalModdedSoundHashMap, generalVanillaSoundHashMap };
        return hashMapArray[hashMap].get(itemName);
    }

    public static void registerStringSoundAssociations() {
        //[Searched last] General vanilla strings (Basic items, materials and tools in the vanilla game)
        generalVanillaSoundHashMap.put("stone", new ResourceLocation("invenaudio:invenaudio_stone"));
        generalVanillaSoundHashMap.put("cobble", new ResourceLocation("invenaudio:invenaudio_cobble"));
        generalVanillaSoundHashMap.put("grass", new ResourceLocation("invenaudio:invenaudio_grass"));
        generalVanillaSoundHashMap.put("dirt", new ResourceLocation("invenaudio:invenaudio_dirt"));
        generalVanillaSoundHashMap.put("wood", new ResourceLocation("invenaudio:invenaudio_wood"));
        generalVanillaSoundHashMap.put("planks", new ResourceLocation("invenaudio:invenaudio_planks"));
        generalVanillaSoundHashMap.put("rock", new ResourceLocation("invenaudio:invenaudio_rock"));
        generalVanillaSoundHashMap.put("sand", new ResourceLocation("invenaudio:invenaudio_sand"));
        generalVanillaSoundHashMap.put("gravel", new ResourceLocation("invenaudio:invenaudio_gravel"));
        generalVanillaSoundHashMap.put("ore", new ResourceLocation("invenaudio:invenaudio_ore"));
        generalVanillaSoundHashMap.put("pane", new ResourceLocation("invenaudio:invenaudio_pane"));
        generalVanillaSoundHashMap.put("glass", new ResourceLocation("invenaudio:invenaudio_glass"));
        generalVanillaSoundHashMap.put("window", new ResourceLocation("invenaudio:invenaudio_window"));
        generalVanillaSoundHashMap.put("wool", new ResourceLocation("invenaudio:invenaudio_wool"));
        generalVanillaSoundHashMap.put("block of gold", new ResourceLocation("invenaudio:invenaudio_block_gold"));
        generalVanillaSoundHashMap.put("block of diamond", new ResourceLocation("invenaudio:invenaudio_block_diamond"));
        generalVanillaSoundHashMap.put("block of iron", new ResourceLocation("invenaudio:invenaudio_block_iron"));
        generalVanillaSoundHashMap.put("bricks", new ResourceLocation("invenaudio:invenaudio_bricks"));
        generalVanillaSoundHashMap.put("ice", new ResourceLocation("invenaudio:invenaudio_ice"));
        generalVanillaSoundHashMap.put("snow", new ResourceLocation("invenaudio:invenaudio_snow"));
        generalVanillaSoundHashMap.put("plant", new ResourceLocation("invenaudio:invenaudio_plant"));
        generalVanillaSoundHashMap.put("sapling", new ResourceLocation("invenaudio:invenaudio_sapling"));
        generalVanillaSoundHashMap.put("bars", new ResourceLocation("invenaudio:invenaudio_bars"));
        generalVanillaSoundHashMap.put("carpet", new ResourceLocation("invenaudio:invenaudio_carpet"));
        generalVanillaSoundHashMap.put("bucket", new ResourceLocation("invenaudio:invenaudio_bucket"));
        generalVanillaSoundHashMap.put("pickaxe", new ResourceLocation("invenaudio:invenaudio_pickaxe"));
        generalVanillaSoundHashMap.put("sword", new ResourceLocation("invenaudio:invenaudio_sword"));
        generalVanillaSoundHashMap.put("shovel", new ResourceLocation("invenaudio:invenaudio_shovel"));
        generalVanillaSoundHashMap.put("hoe", new ResourceLocation("invenaudio:invenaudio_hoe"));
        generalVanillaSoundHashMap.put("axe", new ResourceLocation("invenaudio:invenaudio_axe"));
        generalVanillaSoundHashMap.put("helmet", new ResourceLocation("invenaudio:invenaudio_helmet"));
        generalVanillaSoundHashMap.put("chestplate", new ResourceLocation("invenaudio:invenaudio_chestplate"));
        generalVanillaSoundHashMap.put("leggings", new ResourceLocation("invenaudio:invenaudio_leggings"));
        generalVanillaSoundHashMap.put("boots", new ResourceLocation("invenaudio:invenaudio_boots"));
        generalVanillaSoundHashMap.put("bottle", new ResourceLocation("invenaudio:invenaudio_bottle"));
        generalVanillaSoundHashMap.put("potion", new ResourceLocation("invenaudio:invenaudio_potion"));
        generalVanillaSoundHashMap.put("nugget", new ResourceLocation("invenaudio:invenaudio_nugget"));
        generalVanillaSoundHashMap.put("coal", new ResourceLocation("invenaudio:invenaudio_coal"));
        generalVanillaSoundHashMap.put("diamond", new ResourceLocation("invenaudio:invenaudio_diamond"));
        generalVanillaSoundHashMap.put("iron", new ResourceLocation("invenaudio:invenaudio_iron"));
        generalVanillaSoundHashMap.put("gold", new ResourceLocation("invenaudio:invenaudio_gold"));
        generalVanillaSoundHashMap.put("stick", new ResourceLocation("invenaudio:invenaudio_stick"));
        generalVanillaSoundHashMap.put("string", new ResourceLocation("invenaudio:invenaudio_string"));
        generalVanillaSoundHashMap.put("powder", new ResourceLocation("invenaudio:invenaudio_powder"));
        generalVanillaSoundHashMap.put("seeds", new ResourceLocation("invenaudio:invenaudio_seeds"));
        generalVanillaSoundHashMap.put("flint", new ResourceLocation("invenaudio:invenaudio_flint"));
        generalVanillaSoundHashMap.put("leather", new ResourceLocation("invenaudio:invenaudio_leather"));
        generalVanillaSoundHashMap.put("brick", new ResourceLocation("invenaudio:invenaudio_brick"));
        generalVanillaSoundHashMap.put("clay", new ResourceLocation("invenaudio:invenaudio_clay"));
        generalVanillaSoundHashMap.put("emerald", new ResourceLocation("invenaudio:invenaudio_emerald"));
        generalVanillaSoundHashMap.put("star", new ResourceLocation("invenaudio:invenaudio_star"));
        generalVanillaSoundHashMap.put("quartz", new ResourceLocation("invenaudio:invenaudio_quartz"));
        generalVanillaSoundHashMap.put("redstone", new ResourceLocation("invenaudio:invenaudio_redstone"));
        generalVanillaSoundHashMap.put("obsidian", new ResourceLocation("invenaudio:invenaudio_obsidian"));
        generalVanillaSoundHashMap.put("ingot", new ResourceLocation("invenaudio:invenaudio_ingot"));

        //LOL
        generalVanillaSoundHashMap.put("anvil", new ResourceLocation("invenaudio:invenaudio_anvil"));

        //[Searched second] General modded strings (Basic items, materials and tools that most mods add)
        generalModdedSoundHashMap.put("copper", new ResourceLocation("invenaudio:invenaudio_copper"));
        generalModdedSoundHashMap.put("tin", new ResourceLocation("invenaudio:invenaudio_tin"));
        generalModdedSoundHashMap.put("aluminum", new ResourceLocation("invenaudio:invenaudio_aluminum"));
        generalModdedSoundHashMap.put("silver", new ResourceLocation("invenaudio:invenaudio_silver"));
        generalModdedSoundHashMap.put("lead", new ResourceLocation("invenaudio:invenaudio_lead"));
        generalModdedSoundHashMap.put("iridium", new ResourceLocation("invenaudio:invenaudio_iridium"));
        generalModdedSoundHashMap.put("osmium", new ResourceLocation("invenaudio:invenaudio_osmium"));
        generalModdedSoundHashMap.put("uranium", new ResourceLocation("invenaudio:invenaudio_uranium"));
        generalModdedSoundHashMap.put("cobalt", new ResourceLocation("invenaudio:invenaudio_cobalt"));
        generalModdedSoundHashMap.put("ardite", new ResourceLocation("invenaudio:invenaudio_ardite"));
        generalModdedSoundHashMap.put("sulfur", new ResourceLocation("invenaudio:invenaudio_sulfur"));
        generalModdedSoundHashMap.put("bronze", new ResourceLocation("invenaudio:invenaudio_bronze"));
        generalModdedSoundHashMap.put("electrum", new ResourceLocation("invenaudio:invenaudio_electrum"));
        generalModdedSoundHashMap.put("invar", new ResourceLocation("invenaudio:invenaudio_invar"));
        generalModdedSoundHashMap.put("signalum", new ResourceLocation("invenaudio:invenaudio_signalum"));
        generalModdedSoundHashMap.put("enderium", new ResourceLocation("invenaudio:invenaudio_enderium"));
        generalModdedSoundHashMap.put("manyullyn", new ResourceLocation("invenaudio:invenaudio_manyullyn"));
        generalModdedSoundHashMap.put("steel", new ResourceLocation("invenaudio:invenaudio_steel"));
        generalModdedSoundHashMap.put("tungsten", new ResourceLocation("invenaudio:invenaudio_tungsten"));
        generalModdedSoundHashMap.put("rubber", new ResourceLocation("invenaudio:invenaudio_rubber"));
        generalModdedSoundHashMap.put("oil", new ResourceLocation("invenaudio:invenaudio_oil"));
        generalModdedSoundHashMap.put("gas", new ResourceLocation("invenaudio:invenaudio_gas"));
        generalModdedSoundHashMap.put("dust", new ResourceLocation("invenaudio:invenaudio_dust"));
        generalModdedSoundHashMap.put("gem", new ResourceLocation("invenaudio:invenaudio_gem"));
        generalModdedSoundHashMap.put("crystal", new ResourceLocation("invenaudio:invenaudio_crystal"));
        generalModdedSoundHashMap.put("saltpeter", new ResourceLocation("invenaudio:invenaudio_saltpeter"));
        generalModdedSoundHashMap.put("niter", new ResourceLocation("invenaudio:invenaudio_niter"));
        generalModdedSoundHashMap.put("shard", new ResourceLocation("invenaudio:invenaudio_shard"));

        //[Searched first] Specific modded strings (Modded items like components, end game things and specialties)
        specificModdedSoundHashMap.put("rod", new ResourceLocation("invenaudio:invenaudio_rod"));
        specificModdedSoundHashMap.put("screw", new ResourceLocation("invenaudio:invenaudio_screw"));
        specificModdedSoundHashMap.put("plate", new ResourceLocation("invenaudio:invenaudio_plate"));
        specificModdedSoundHashMap.put("cog", new ResourceLocation("invenaudio:invenaudio_cog"));
        specificModdedSoundHashMap.put("gear", new ResourceLocation("invenaudio:invenaudio_gear"));
        specificModdedSoundHashMap.put("wire", new ResourceLocation("invenaudio:invenaudio_wire"));
        specificModdedSoundHashMap.put("cable", new ResourceLocation("invenaudio:invenaudio_cable"));
        specificModdedSoundHashMap.put("circuit", new ResourceLocation("invenaudio:invenaudio_circuit"));
        specificModdedSoundHashMap.put("bar", new ResourceLocation("invenaudio:invenaudio_bar"));
        specificModdedSoundHashMap.put("binding", new ResourceLocation("invenaudio:invenaudio_binding"));
        specificModdedSoundHashMap.put("coil", new ResourceLocation("invenaudio:invenaudio_coil"));
        specificModdedSoundHashMap.put("capacitor", new ResourceLocation("invenaudio:invenaudio_capacitor"));
        specificModdedSoundHashMap.put("battery", new ResourceLocation("invenaudio:invenaudio_battery"));
        specificModdedSoundHashMap.put("motor", new ResourceLocation("invenaudio:invenaudio_motor"));
        specificModdedSoundHashMap.put("servo", new ResourceLocation("invenaudio:invenaudio_servo"));
        specificModdedSoundHashMap.put("actuator", new ResourceLocation("invenaudio:invenaudio_actuator"));
        specificModdedSoundHashMap.put("chassis", new ResourceLocation("invenaudio:invenaudio_chassis"));
        specificModdedSoundHashMap.put("frame", new ResourceLocation("invenaudio:invenaudio_frame"));
        specificModdedSoundHashMap.put("machine", new ResourceLocation("invenaudio:invenaudio_machine"));
        specificModdedSoundHashMap.put("conduit", new ResourceLocation("invenaudio:invenaudio_conduit"));
        specificModdedSoundHashMap.put("pipe", new ResourceLocation("invenaudio:invenaudio_pipe"));
        specificModdedSoundHashMap.put("tube", new ResourceLocation("invenaudio:invenaudio_tube"));
        specificModdedSoundHashMap.put("casing", new ResourceLocation("invenaudio:invenaudio_casing"));
        specificModdedSoundHashMap.put("component", new ResourceLocation("invenaudio:invenaudio_component"));
        specificModdedSoundHashMap.put("lens", new ResourceLocation("invenaudio:invenaudio_lens"));
        specificModdedSoundHashMap.put("filter", new ResourceLocation("invenaudio:invenaudio_filter"));
        specificModdedSoundHashMap.put("upgrade", new ResourceLocation("invenaudio:invenaudio_upgrade"));
        specificModdedSoundHashMap.put("chip", new ResourceLocation("invenaudio:invenaudio_chip"));
        specificModdedSoundHashMap.put("board", new ResourceLocation("invenaudio:invenaudio_board"));
        specificModdedSoundHashMap.put("processor", new ResourceLocation("invenaudio:invenaudio_processor"));
        specificModdedSoundHashMap.put("cell", new ResourceLocation("invenaudio:invenaudio_cell"));
        specificModdedSoundHashMap.put("tank", new ResourceLocation("invenaudio:invenaudio_tank"));
        specificModdedSoundHashMap.put("barrel", new ResourceLocation("invenaudio:invenaudio_barrel"));
        specificModdedSoundHashMap.put("core", new ResourceLocation("invenaudio:invenaudio_core"));
        specificModdedSoundHashMap.put("catalyst", new ResourceLocation("invenaudio:invenaudio_catalyst"));
        specificModdedSoundHashMap.put("resonator", new ResourceLocation("invenaudio:invenaudio_resonator"));
        specificModdedSoundHashMap.put("turbine", new ResourceLocation("invenaudio:invenaudio_turbine"));
        specificModdedSoundHashMap.put("chamber", new ResourceLocation("invenaudio:invenaudio_chamber"));
        specificModdedSoundHashMap.put("fan", new ResourceLocation("invenaudio:invenaudio_fan"));
        specificModdedSoundHashMap.put("pole", new ResourceLocation("invenaudio:invenaudio_pole"));
    }
}