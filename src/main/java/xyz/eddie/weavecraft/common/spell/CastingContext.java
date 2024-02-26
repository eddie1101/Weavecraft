package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class CastingContext {

    private Entity caster;
    private Level level;
    private ItemStack itemStack;
    private Vec3 location;

    public CastingContext(Entity caster, Level level, ItemStack itemStack, Vec3 location) {
        this.caster = caster;
        this.level = level;
        this.itemStack = itemStack;
        this.location = location;
    }

    public Entity getCaster() {
        return caster;
    }

    public Level getLevel() {
        return level;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public Vec3 getLocation() {
        return location;
    }

    public void setCaster(Entity caster) {
        this.caster = caster;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public void setLocation(Vec3 location) {
        this.location = location;
    }
}
