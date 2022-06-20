package com.github.alexthe666.iceandfire.pathfinding;

import com.github.alexthe666.iceandfire.entity.EntityDeathWorm;
import net.minecraft.block.material.Material;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PathNavigateDeathWormSand extends PathNavigate {
    private EntityDeathWorm worm;

    public PathNavigateDeathWormSand(EntityDeathWorm deathworm, World worldIn) {
        super(deathworm, worldIn);
        worm = deathworm;
    }

    protected PathFinder getPathFinder() {
        return new PathFinder(new NodeProcessorDeathWorm());
    }

    /**
     * If on ground or swimming and can swim
     */
    protected boolean canNavigate() {
        return worm.isInSand();
    }

    protected Vec3d getEntityPosition() {
        return new Vec3d(this.entity.posX, this.entity.posY + 0.5D, this.entity.posZ);
    }

    protected void pathFollow() {
        Vec3d vec3d = this.getEntityPosition();
        float f = 0.65F;
//        int i = 6;

        if (vec3d.squareDistanceTo(this.currentPath.getVectorFromIndex(this.entity, this.currentPath.getCurrentPathIndex())) < (double) f) {
            this.currentPath.incrementPathIndex();
        }

        for (int j = Math.min(this.currentPath.getCurrentPathIndex() + 6, this.currentPath.getCurrentPathLength() - 1); j > this.currentPath.getCurrentPathIndex(); --j) {
            Vec3d vec3d1 = this.currentPath.getVectorFromIndex(this.entity, j);

            if (vec3d1.squareDistanceTo(vec3d) <= 36.0D && this.isDirectPathBetweenPoints(vec3d, vec3d1, 0, 0, 0)) {
                this.currentPath.setCurrentPathIndex(j);
                break;
            }
        }

        this.checkForStuck(vec3d);
    }

    /**
     * Checks if the specified entity can safely walk to the specified location.
     */
    protected boolean isDirectPathBetweenPoints(Vec3d posVec31, Vec3d posVec32, int sizeX, int sizeY, int sizeZ) {
        RayTraceResult raytraceresult = this.world.rayTraceBlocks(posVec31, new Vec3d(posVec32.x, posVec32.y + 0.5D, posVec32.z), false, true, false);
        if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
            return entity.world.getBlockState(raytraceresult.getBlockPos()).getMaterial() == Material.SAND;
        }
        return false;
    }

    public boolean canEntityStandOnPos(BlockPos pos) {
        return this.world.getBlockState(pos).isFullBlock();
    }
}