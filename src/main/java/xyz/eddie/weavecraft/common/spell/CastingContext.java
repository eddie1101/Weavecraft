package xyz.eddie.weavecraft.common.spell;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CastingContext {

    private Entity originalCaster;
    private Entity caster;
    private Level level;
    private ItemStack itemStack;
    private Vec3 location;

    //Used exclusively for expulsive spells
    public Optional<List<HitResult>> hits;

    public CastingContext(Entity originalCaster, Entity caster, Level level, ItemStack itemStack, Vec3 location) {
        this.originalCaster = originalCaster;
        this.caster = caster;
        this.level = level;
        this.itemStack = itemStack;
        this.location = location;
        hits = Optional.empty();
    }

    public CastingContext(Entity caster, Level level, ItemStack itemStack, Vec3 location) {
        this(caster, caster, level, itemStack, location);
    }

    public CastingContext(CastingContext o) {
        this(o.originalCaster, o.caster, o.level, o.itemStack, o.location);
        this.hits = o.hits;
    }

    public Entity getOriginalCaster() {
        return originalCaster;
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

    public Optional<List<HitResult>> getHits() {
        return hits;
    }

    public void setOriginalCaster(Entity originalCaster) {
        this.originalCaster = originalCaster;
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

    public void setHits(List<HitResult> hits) {
        this.hits = Optional.of(hits);
    }

    public void addHit(HitResult hit) {
        if(this.hits.isEmpty()) {
            hits = Optional.of(new ArrayList<>(List.of(hit)));
        } else {
            hits.get().add(hit);
        }
    }
}
