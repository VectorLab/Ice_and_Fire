package com.github.alexthe666.iceandfire.client.model.util;

import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/*
       Code from JurassiCraft, used with permission
       By paul101
 */
public class LegSolver {
    public final Leg[] legs;

    public LegSolver(Leg... legs) {
        this.legs = legs;
    }

    public final void update(EntityDragonBase entity, float scale) {
        this.update(entity, entity.renderYawOffset, scale);
    }

    public final void update(EntityDragonBase entity, float yaw, float scale) {
        double sideTheta = yaw / (180 / Math.PI);
        double sideX = Math.cos(sideTheta) * scale;
        double sideZ = Math.sin(sideTheta) * scale;
        double forwardTheta = sideTheta + Math.PI / 2;
        double forwardX = Math.cos(forwardTheta) * scale;
        double forwardZ = Math.sin(forwardTheta) * scale;
        for (Leg leg : this.legs) {
            leg.update(entity, sideX, sideZ, forwardX, forwardZ, scale);
        }
    }

    public static final class Leg {

        public final float forward;
        public final float side;
        private final float range;
        private float height;
        private float prevHeight;
//        private boolean isWing;

        public Leg(float forward, float side, float range, boolean isWing) {
            this.forward = forward;
            this.side = side;
            this.range = range;
//            this.isWing = isWing;
        }

        public final float getHeight(float delta) {
            return this.prevHeight + (this.height - this.prevHeight) * delta;
        }

        public void update(EntityDragonBase entity, double sideX, double sideZ, double forwardX, double forwardZ, float scale) {
            this.prevHeight = this.height;
            double posY = entity.posY;
            float settledHeight = this.settle(entity, entity.posX + sideX * this.side + forwardX * this.forward, posY, entity.posZ + sideZ * this.side + forwardZ * this.forward, this.height);
            this.height = MathHelper.clamp(settledHeight, -this.range * scale, this.range * scale);
        }


        private float settle(EntityDragonBase entity, double x, double y, double z, float height) {
            BlockPos pos = new BlockPos(x, y + 1e-3, z);
            float dist = this.getDistance(entity.world, pos);
            if (1 - dist < 1e-3) {
                dist = this.getDistance(entity.world, pos.down()) + (float) y % 1;
            } else {
                dist -= 1 - (y % 1);
            }
            if (entity.onGround && height <= dist) {
                return height == dist ? height : Math.min(height + this.getFallSpeed(), dist);
            } else if (height > 0) {
                return Math.max(height - this.getRiseSpeed(), dist);
            }
            return height;
        }

        private float getDistance(World world, BlockPos pos) {
            IBlockState state = world.getBlockState(pos);
            AxisAlignedBB aabb = state.getCollisionBoundingBox(world, pos);
            return aabb == null ? 1 : 1 - Math.min((float) aabb.maxY, 1);
        }

        protected float getFallSpeed() {
            return 0.25F;
        }

        protected float getRiseSpeed() {
            return 0.25F;
        }
    }
}