package xyz.eddie.weavecraft.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.effects.*;
import xyz.eddie.weavecraft.common.spell.targeter.targeters.SpellTargeters;

public class Proklitia extends Item {

    Spell spell;

    public Proklitia(Properties properties) {
        super(properties);
        spell = new Spell.SpellBuilder()
                .targeter(SpellTargeters.TOUCH)
                .amplifyTargeter(Amplifier.RANGE, 5)
                .effect(SpellEffects.DETONATE)
                .amplifyEffect(Amplifier.INTENSITY, 3)
                .addTrigger(new Spell.SpellBuilder()
                        .targeter(SpellTargeters.AOE)
                        .amplifyTargeter(Amplifier.RANGE, 5)
                        .effect(SpellEffects.INFERNO)
                        .amplifyEffect(Amplifier.DURATION, 3)
                        .build())
                .build();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if(!level.isClientSide) {
            spell.cast(player, level, player.getItemInHand(usedHand));
            return InteractionResultHolder.success(player.getItemInHand(usedHand));
        } else {
            return InteractionResultHolder.pass(player.getItemInHand(usedHand));
        }
    }
}
