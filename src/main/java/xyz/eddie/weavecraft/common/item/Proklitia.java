package xyz.eddie.weavecraft.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.amplifier.Amplifier;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;
import xyz.eddie.weavecraft.common.spell.expulsive.aspect.ExpulsiveAspect;
import xyz.eddie.weavecraft.common.spell.expulsive.aspect.KineticAspect;
import xyz.eddie.weavecraft.common.spell.targeter.targeters.SpellTargeter;

public class Proklitia extends Item {

    Spell spell;

    public Proklitia(Properties properties) {
        super(properties);

        // Now we're cookin'
        // Dear god save me from builder hell
        spell = new Spell.ExpulsiveSpellBuilder()
                .kineticAspect(KineticAspect.LINEAR)
                .expulsiveAspect(ExpulsiveAspect.CONSTANT(
                        new Spell.SpellBuilder()
                                .targeter(SpellTargeter.AOE)
                                .effect(SpellEffect.DISINTEGRATE)
                                .build()))
                .targeter(SpellTargeter.REFLEX)
                .effect(SpellEffect.DETONATE)
                .amplifyEffect(Amplifier.INTENSITY, 3)
                .addTrigger(
                        new Spell.ExpulsiveSpellBuilder()
                                .kineticAspect(KineticAspect.STATIONARY)
                                .expulsiveAspect(ExpulsiveAspect.CONSTANT(
                                        new Spell.SpellBuilder()
                                                .targeter(SpellTargeter.AOE)
                                                .amplifyTargeter(Amplifier.RANGE, 5)
                                                .effect(SpellEffect.INFERNO)
                                                .build()))
                                .targeter(SpellTargeter.REFLEX)
                                .effect(SpellEffect.DETONATE)
                                .amplifyEffect(Amplifier.INTENSITY, 5)
                                .build())
                .build();

    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        if(!level.isClientSide) {
            spell.cast(player, level, player.getItemInHand(usedHand));
            return InteractionResultHolder.success(player.getItemInHand(usedHand));
        } else {
            return InteractionResultHolder.pass(player.getItemInHand(usedHand));
        }
    }
}
