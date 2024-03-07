package xyz.eddie.weavecraft.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.SpellSequence;
import xyz.eddie.weavecraft.common.spell.caster.SpellCaster;
import xyz.eddie.weavecraft.common.spell.effect.SpellEffect;
import xyz.eddie.weavecraft.common.spell.kinematic_profile.KinematicProfile;
import xyz.eddie.weavecraft.common.spell.shape.SpellShape;
import xyz.eddie.weavecraft.common.spell.targeter.SpellTargeter;

public class Proklitia extends Item {

    Spell spell;

    public Proklitia(Properties properties) {
        super(properties);

//        spell = new Spell(
//                SpellCaster.BIFURCATED(SpellShape.PROJECTILE,
//                        new SpellSequence(SpellEffect.INFERNO, SpellTargeter.AOE, new Spell(
//                                SpellCaster.BIFURCATED(SpellShape.PROJECTILE,
//                                        new SpellSequence(SpellEffect.INFERNO, SpellTargeter.AOE),
//                                        new SpellSequence(SpellEffect.INFERNO, SpellTargeter.AOE))
//                        )),
//                        new SpellSequence(SpellEffect.INFERNO, SpellTargeter.AOE, new Spell(
//                                SpellCaster.BIFURCATED(SpellShape.PROJECTILE,
//                                        new SpellSequence(SpellEffect.INFERNO, SpellTargeter.AOE),
//                                        new SpellSequence(SpellEffect.INFERNO, SpellTargeter.AOE))
//                        ))
//                )
//        );

        spell = new Spell(
                SpellCaster.SCATTER(7,
                        SpellShape.PROJECTILE(KinematicProfile.LINEAR_ACCELERATION),
                        new SpellSequence(SpellEffect.DETONATE, SpellTargeter.HIT,
                                new Spell(
                                        SpellCaster.SCATTER(7,
                                                SpellShape.PROJECTILE(KinematicProfile.ARCH),
                                                new SpellSequence(SpellEffect.INFERNO, SpellTargeter.AOE)
                                        )
                                )
                        )
                )
        );
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
