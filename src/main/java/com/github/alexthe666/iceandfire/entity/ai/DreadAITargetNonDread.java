package com.github.alexthe666.iceandfire.entity.ai;

import javax.annotation.Nullable;

import com.github.alexthe666.iceandfire.entity.DragonUtils;
import com.github.alexthe666.iceandfire.entity.IDreadMob;
import com.google.common.base.Predicate;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class DreadAITargetNonDread extends EntityAINearestAttackableTarget<EntityLivingBase> {

    public DreadAITargetNonDread(EntityCreature entityIn, Class<EntityLivingBase> classTarget, boolean checkSight, Predicate<? super EntityLivingBase> targetSelector) {
        super(entityIn, classTarget, 0, checkSight, false, targetSelector);
    }

    protected boolean isSuitableTarget(@Nullable EntityLivingBase target, boolean includeInvincibles) {
        if(super.isSuitableTarget(target, includeInvincibles)){
            if(target instanceof IDreadMob || !DragonUtils.isAlive(target)){
                return false;
            }
            return true;
        }
        return false;
    }


}
