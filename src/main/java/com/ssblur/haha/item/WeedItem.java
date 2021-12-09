package com.ssblur.haha.item;

import java.util.List;

import com.ssblur.haha.HahaMod;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;

public class WeedItem extends Item {
    public WeedItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        tooltip.add(new TranslatableText("tooltip.haha.peacepipe").setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GREEN))));
        tooltip.add(new TranslatableText("tooltip.haha.peacepipe_details").setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GRAY))));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) { 
        ItemStack stack = user.getStackInHand(hand);
        TypedActionResult<ItemStack> result = super.use(world, user, hand);
        if(result.getResult() != ActionResult.FAIL) {
            user.addStatusEffect(new StatusEffectInstance(HahaMod.COOL_STATUS_EFFECT, 600));
            stack.decrement(1);
        }
        return result;
    }
}