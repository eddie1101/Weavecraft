package xyz.eddie.weavecraft.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.caster.casters.ScatterCaster;
import xyz.eddie.weavecraft.common.spell.caster.casters.SingleCaster;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;
import xyz.eddie.weavecraft.common.spell.effect.effects.DetonateSpellEffect;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;
import xyz.eddie.weavecraft.common.spell.type.SpellType;

public class Proklitia extends Item {

    Spell spell;

    public Proklitia(Properties properties) {
        super(properties);

        SpellEffect recursiveDetonate = new DetonateSpellEffect().setShape(SpellShape.TOUCH);
        spell = new Spell(
                new SingleCaster(SpellType.INSTANT, recursiveDetonate)
        );
        recursiveDetonate.setTrigger(spell);

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
