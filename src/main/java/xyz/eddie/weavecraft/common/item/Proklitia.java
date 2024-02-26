package xyz.eddie.weavecraft.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.amplifier.SpellAmplifier;
import xyz.eddie.weavecraft.common.spell.effect.effects.IgnitionSpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.effects.PushSpellEffect;

public class Proklitia extends Item {

    Spell spell;

    public Proklitia(Properties properties) {
        super(properties);
        spell = new Spell.SpellBuilder(TargetGatherer.TOUCH)
                .effect(PushSpellEffect::new)
                .amplifyEffect(SpellAmplifier.INTENSITY, 2)
                .effect(IgnitionSpellEffect::new)
                .amplifyEffect(SpellAmplifier.DURATION, 2)
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
