package cofh.archersparadox.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import static cofh.archersparadox.init.ModReferences.EXPLOSIVE_ARROW_ENTITY;
import static cofh.archersparadox.init.ModReferences.EXPLOSIVE_ARROW_ITEM;

public class ExplosiveArrowEntity extends AbstractArrowEntity {

    public static float baseDamage = 0.5F;
    public static double explosionStrength = 1.9F;
    public static boolean explosionsBreakBlocks = true;
    public static boolean explosionsCauseFire = true;
    public static boolean knockbackBoost = true;

    public ExplosiveArrowEntity(EntityType<? extends ExplosiveArrowEntity> entityIn, World worldIn) {

        super(entityIn, worldIn);
        this.damage = baseDamage;
    }

    public ExplosiveArrowEntity(World worldIn, LivingEntity shooter) {

        super(EXPLOSIVE_ARROW_ENTITY, shooter, worldIn);
        this.damage = baseDamage;
    }

    public ExplosiveArrowEntity(World worldIn, double x, double y, double z) {

        super(EXPLOSIVE_ARROW_ENTITY, x, y, z, worldIn);
        this.damage = baseDamage;
    }

    @Override
    protected ItemStack getArrowStack() {

        return new ItemStack(EXPLOSIVE_ARROW_ITEM);
    }

    @Override
    protected void onHit(RayTraceResult raytraceResultIn) {

        if (raytraceResultIn.getType() != RayTraceResult.Type.MISS) {
            world.createExplosion(this, posX, posY, posZ, (float) (explosionStrength + (knockbackBoost ? knockbackStrength : 0)), explosionsCauseFire && isBurning(), explosionsBreakBlocks ? Explosion.Mode.BREAK : Explosion.Mode.NONE);
            this.remove();
        }
        super.onHit(raytraceResultIn);
    }

    @Override
    protected void func_213868_a(EntityRayTraceResult raytraceResultIn) {

        Entity entity = raytraceResultIn.getEntity();
        if (this.isBurning() && !(entity instanceof EndermanEntity)) {
            entity.setFire(5);
        }
    }

    @Override
    public void setIsCritical(boolean critical) {

    }

    @Override
    public void setPierceLevel(byte level) {

    }

    @Override
    public IPacket<?> createSpawnPacket() {

        return NetworkHooks.getEntitySpawningPacket(this);
    }

}