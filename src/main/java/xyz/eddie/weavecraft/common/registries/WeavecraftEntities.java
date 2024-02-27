package xyz.eddie.weavecraft.common.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.eddie.weavecraft.common.entity.SpellEntity;

import static xyz.eddie.weavecraft.Weavecraft.MODID;

public class WeavecraftEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<SpellEntity>> SPELL_ENTITY = ENTITIES.register("spell_entity", () -> EntityType.Builder.of(SpellEntity::getSpellEntityForRegistry, MobCategory.MISC).sized(0.25f, 0.25f).build("spell_entity"));

}
