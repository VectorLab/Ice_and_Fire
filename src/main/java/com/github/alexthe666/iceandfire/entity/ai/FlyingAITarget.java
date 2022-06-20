package com.github.alexthe666.iceandfire.entity.ai;

import com.github.alexthe666.iceandfire.entity.EntitySeaSerpent;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;

public class FlyingAITarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T> {

    public FlyingAITarget(EntityCreature creature, Class<T> classTarget, boolean checkSight) {
        super(creature, classTarget, checkSight);
    }

    public FlyingAITarget(EntityCreature creature, Class<T> classTarget, boolean checkSight, boolean onlyNearby) {
        super(creature, classTarget, checkSight, onlyNearby);
    }

    public FlyingAITarget(EntityCreature creature, Class<T> classTarget, int chance, boolean checkSight, boolean onlyNearby, @Nullable final Predicate<T> targetSelector) {
        super(creature, classTarget, chance, checkSight, onlyNearby, targetSelector);
    }

    @Override
    protected AxisAlignedBB getTargetableArea(double targetDistance) {
        return this.taskOwner.getEntityBoundingBox().grow(targetDistance, targetDistance, targetDistance);
    }

    public boolean shouldExecute() {
        if (taskOwner instanceof EntitySeaSerpent && (((EntitySeaSerpent) taskOwner).isJumpingOutOfWater() || !taskOwner.isInWater())) {
            return false;
        }
        return super.shouldExecute();
    }

}
