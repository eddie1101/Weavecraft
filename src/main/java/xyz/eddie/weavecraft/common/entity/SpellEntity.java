package xyz.eddie.weavecraft.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class SpellEntity extends Projectile {

    public SpellEntity(EntityType<? extends SpellEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected void defineSynchedData() {

    }
}
