package xyz.eddie.weavecraft.common.spell.effect;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class CastingContext {

    public Entity caster;
    public Level level;
    public ItemStack itemStack;

    public CastingContext(Entity caster, Level level, ItemStack itemStack) {
        this.caster = caster;
        this.level = level;
        this.itemStack = itemStack;
    }

}
