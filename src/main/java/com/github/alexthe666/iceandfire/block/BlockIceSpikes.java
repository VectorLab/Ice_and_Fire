package com.github.alexthe666.iceandfire.block;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockIceSpikes extends Block {
    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0625, 0.0D, 0.0625D, 0.9375D, 0.6875, 0.9375D);
    public Item itemBlock;

    public BlockIceSpikes() {
        super(Material.PACKED_ICE);
        this.setHardness(2.5F);
        this.setTranslationKey("iceandfire.dragon_ice_spikes");
        this.setCreativeTab(IceAndFire.TAB_BLOCKS);
        this.setSoundType(SoundType.GLASS);
        this.setHarvestLevel("pickaxe", 1);
        this.setRegistryName(IceAndFire.MODID, "dragon_ice_spikes");
    }

    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (!(entityIn instanceof EntityIceDragon)) {
            entityIn.attackEntityFrom(DamageSource.CACTUS, 1);
            if (entityIn instanceof EntityLivingBase && entityIn.motionX != 0 && entityIn.motionZ != 0) {
                ((EntityLivingBase) entityIn).knockBack(entityIn, 0.5F, entityIn.motionX, entityIn.motionZ);
            }
        }
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
