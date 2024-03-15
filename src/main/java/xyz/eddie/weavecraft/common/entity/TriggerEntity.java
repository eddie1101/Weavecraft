package xyz.eddie.weavecraft.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import xyz.eddie.weavecraft.common.spell.CastingContext;
import xyz.eddie.weavecraft.common.spell.Spell;
import xyz.eddie.weavecraft.common.spell.caster.SpellCaster;
import xyz.eddie.weavecraft.common.spell.effect.effects.BlankSpellEffect;
import xyz.eddie.weavecraft.common.spell.type.SpellType;

public class TriggerEntity extends Entity {

    int timestamp;
    Spell trigger;
    CastingContext ctx;
    public TriggerEntity(EntityType<TriggerEntity> type, CastingContext ctx, Spell trigger) {
        super(type, ctx.getLevel());
        timestamp = tickCount;
        this.ctx = ctx;
        this.trigger = trigger;
    }

    private TriggerEntity(EntityType<TriggerEntity> type, Level level) {
        super(type, level);
        timestamp = tickCount;
        ctx = new CastingContext(this, level, null, this.position());
        trigger = new Spell(SpellCaster.SINGLE(SpellType.INSTANT, new BlankSpellEffect()));
    }

    public static TriggerEntity getTriggerEntityForRegistry(EntityType<TriggerEntity> type, Level level) {
        return new TriggerEntity(type, level);
    }

    @Override
    public void tick() {
        if(tickCount - timestamp > 20) {
            trigger.cast(ctx);
            this.discard();
        }
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

}
