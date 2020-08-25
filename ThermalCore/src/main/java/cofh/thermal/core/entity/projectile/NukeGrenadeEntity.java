package cofh.thermal.core.entity.projectile;

import cofh.lib.entity.AbstractGrenadeEntity;
import cofh.lib.util.Utils;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import static cofh.lib.util.Utils.HORZ_MAX;
import static cofh.thermal.core.init.TCoreReferences.NUKE_GRENADE_ENTITY;
import static cofh.thermal.core.init.TCoreReferences.NUKE_GRENADE_ITEM;
import static net.minecraft.potion.Effects.WITHER;

public class NukeGrenadeEntity extends AbstractGrenadeEntity {

    public static int effectAmplifier = 2;
    public static int effectDuration = 400;

    public static double explosionStrength = 8.0;
    public static boolean explosionsBreakBlocks = true;

    public NukeGrenadeEntity(EntityType<? extends ProjectileItemEntity> type, World worldIn) {

        super(type, worldIn);
    }

    public NukeGrenadeEntity(World worldIn, double x, double y, double z) {

        super(NUKE_GRENADE_ENTITY, x, y, z, worldIn);
    }

    public NukeGrenadeEntity(World worldIn, LivingEntity livingEntityIn) {

        super(NUKE_GRENADE_ENTITY, livingEntityIn, worldIn);
    }

    @Override
    protected Item getDefaultItem() {

        return NUKE_GRENADE_ITEM;
    }

    @Override
    protected void onImpact(RayTraceResult result) {

        if (Utils.isServerWorld(world)) {
            world.setBlockState(this.getPosition(), Blocks.AIR.getDefaultState());
            destroyBlocks(this, world, this.getPosition(), radius);
            damageNearbyEntities(this, world, this.getPosition(), radius);
            world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), (float) explosionStrength, true, explosionsBreakBlocks ? Explosion.Mode.BREAK : Explosion.Mode.NONE);
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }
        if (result.getType() == RayTraceResult.Type.ENTITY && this.ticksExisted < 10) {
            return;
        }
        this.world.addParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosY(), this.getPosZ(), 1.0D, 0.0D, 0.0D);
        this.world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 0.5F, (1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F, false);
    }

    public static void destroyBlocks(Entity entity, World worldIn, BlockPos pos, int radius) {

        if (radius <= 0) {
            return;
        }
        float f = (float) Math.min(HORZ_MAX, radius);
        float maxResistance = 400F * radius * radius;
        float f2 = f * f;

        for (BlockPos iterPos : BlockPos.getAllInBoxMutable(pos.add(-f, -f / 2, -f), pos.add(f, f, f))) {
            double distance = iterPos.distanceSq(entity.getPositionVec(), true);
            if (distance < f2) {
                BlockState state = worldIn.getBlockState(iterPos);
                if (!state.isAir(worldIn, iterPos) && state.getBlock().getExplosionResistance(state, worldIn, iterPos, entity, null) < maxResistance - (maxResistance * distance / f2)) {
                    worldIn.setBlockState(iterPos, Blocks.AIR.getDefaultState());
                }
            }
        }
    }

    public static void damageNearbyEntities(Entity entity, World worldIn, BlockPos pos, int radius) {

        AxisAlignedBB area = new AxisAlignedBB(pos.add(-radius, -radius, -radius), pos.add(1 + radius, 1 + radius, 1 + radius));
        worldIn.getEntitiesWithinAABB(LivingEntity.class, area, EntityPredicates.IS_ALIVE)
                .forEach(livingEntity -> livingEntity.addPotionEffect(new EffectInstance(WITHER, effectDuration, effectAmplifier, false, false)));
    }

}

