package com.ssblur.haha;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import com.ssblur.haha.item.WeedItem;
import com.ssblur.haha.statuseffect.CoolStatusEffect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HahaMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("haha");
    public static final String MOD_ID = "haha";

    public static Item FUNNY_WEED;

    public static StatusEffect COOL_STATUS_EFFECT;

    @Override
    public void onInitialize() {
        LOGGER.info("Loading the haha funny weed mod. nice");
        
        FUNNY_WEED = Registry.register(
            Registry.ITEM, 
            new Identifier(MOD_ID, "weed"), 
            new WeedItem(
                new Item.Settings().group(ItemGroup.FOOD).rarity(Rarity.UNCOMMON)
            )
        );

        COOL_STATUS_EFFECT = Registry.register(
            Registry.STATUS_EFFECT, 
            new Identifier(MOD_ID, "cool"),
            new CoolStatusEffect()
        );
    }
}