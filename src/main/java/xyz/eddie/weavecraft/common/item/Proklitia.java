package xyz.eddie.weavecraft.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.effect.PushSpellEffect;
import xyz.eddie.weavecraft.common.spell.modifier.SpellModifier;

public class Proklitia extends Item {

    Spell spell;

    public Proklitia(Properties properties) {
        super(properties);
        spell = new Spell.SpellBuilder()
                .targetModifier(SpellModifier.TOUCH)
                .effect(new PushSpellEffect())
                .effectModifier(SpellModifier.INTENSITY)
                .build();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if(!level.isClientSide) {
            spell.cast(player, level, player.getItemInHand(usedHand));
            return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide);
        } else {
            return InteractionResultHolder.pass(player.getItemInHand(usedHand));
        }
    }
}
