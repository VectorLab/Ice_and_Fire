package com.github.alexthe666.iceandfire.entity.ai;

import com.github.alexthe666.iceandfire.entity.DragonUtils;
import com.github.alexthe666.iceandfire.entity.EntityStymphalianBird;
import com.github.alexthe666.iceandfire.entity.StoneEntityProperties;

import net.ilexiconn.llibrary.server.entity.EntityPropertiesHandler;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class StymphalianBirdAIAirTarget extends EntityAIBase {
    private EntityStymphalianBird bird;
//    private World theWorld;

    public StymphalianBirdAIAirTarget(EntityStymphalianBird bird) {
        this.bird = bird;
//        this.theWorld = bird.world;
    }

    public static BlockPos getNearbyAirTarget(EntityStymphalianBird bird) {
        if (bird.getAttackTarget() == null) {
            BlockPos pos = DragonUtils.getBlockInViewStymphalian(bird);
            if (pos != null && bird.world.getBlockState(pos).getMaterial() == Material.AIR) {
                return pos;
            }
            if (bird.flock != null && bird.flock.isLeader(bird)) {
                bird.flock.setTarget(bird.airTarget);
            }
        } else {
            return new BlockPos((int) bird.getAttackTarget().posX, (int) bird.getAttackTarget().posY + bird.getAttackTarget().getEyeHeight(), (int) bird.getAttackTarget().posZ);
        }
        return bird.getPosition();
    }

    public boolean shouldExecute() {
        if (bird != null) {
            if (!bird.isFlying()) {
                return false;
            }
            if (bird.isChild()) {
                return false;
            }
            if (bird.doesWantToLand()) {
                return false;
            }
            if (bird.airTarget != null && (bird.isTargetBlocked(new Vec3d(bird.airTarget)))) {
                bird.airTarget = null;
            }

            if (bird.airTarget != null) {
                return false;
            } else {
                Vec3d vec = this.findAirTarget();

                if (vec == null) {
                    return false;
                } else {
                    bird.airTarget = new BlockPos(vec.x, vec.y, vec.z);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean continueExecuting() {
        StoneEntityProperties properties = EntityPropertiesHandler.INSTANCE.getProperties(bird, StoneEntityProperties.class);
        if (!bird.isFlying()) {
            return false;
        }
        if (bird.isChild()) {
            return false;
        }
        if (properties != null && properties.isStone) {
            return false;
        }
        return bird.airTarget != null;
    }

    public Vec3d findAirTarget() {
        return new Vec3d(getNearbyAirTarget(bird));
    }
}