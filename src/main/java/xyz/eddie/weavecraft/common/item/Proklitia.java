package xyz.eddie.weavecraft.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.effects.IgnitionSpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.effects.PushSpellEffect;
import xyz.eddie.weavecraft.common.spell.targeter.targeters.SpellTargeters;

public class Proklitia extends Item {

    Spell spell;

    public Proklitia(Properties properties) {
        super(properties);
        spell = new Spell.SpellBuilder()
                .targeter(SpellTargeters.AOE)
                .amplifyTargeter(Amplifier.RANGE, 5)
                .effect(PushSpellEffect::new)
                .amplifyEffect(Amplifier.INTENSITY, 5)
                .effect(IgnitionSpellEffect::new)
                .amplifyEffect(Amplifier.DURATION, 2)
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
