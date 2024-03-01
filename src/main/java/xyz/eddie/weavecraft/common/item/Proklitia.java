package xyz.eddie.weavecraft.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.caster.SpellCaster;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;
import xyz.eddie.weavecraft.common.spell.targeter.SpellTargeter;

public class Proklitia extends Item {

    Spell spell;

    public Proklitia(Properties properties) {
        super(properties);

        spell = new Spell.SpellBuilder()
                .caster(SpellCaster.SINGLE())
                .shape(SpellShape.NO_SHAPE)
                .targeter(SpellTargeter.TOUCH)
                .effect(SpellEffect.DISINTEGRATE)
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
