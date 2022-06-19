package com.github.alexthe666.iceandfire.client.model;

import com.github.alexthe666.iceandfire.client.model.util.HideableModelRenderer;
import com.github.alexthe666.iceandfire.entity.EntityDreadQueen;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelDreadQueen extends ModelDragonBase {
    public HideableModelRenderer body;
    public HideableModelRenderer chestplate;
    public HideableModelRenderer head;
    public HideableModelRenderer armRight;
    public HideableModelRenderer legRight;
    public HideableModelRenderer armLeft;
    public HideableModelRenderer legLeft;
    public HideableModelRenderer cloak;
    public HideableModelRenderer necklace;
    public HideableModelRenderer crown;
    public HideableModelRenderer sleeveRight;
    public HideableModelRenderer robeLowerRight;
    public HideableModelRenderer sleeveLeft;
    public HideableModelRenderer robeLowerLeft;
    public ModelBiped.ArmPose leftArmPose;
    public ModelBiped.ArmPose rightArmPose;
    public boolean isSneak;
    private ModelAnimator animator;
//    private boolean armor = false;

    public ModelDreadQueen(float modelSize, boolean armorArms) {
        this.textureWidth = 128;
        this.textureHeight = 64;
//        this.armor = armorArms;
        this.leftArmPose = ModelBiped.ArmPose.EMPTY;
        this.rightArmPose = ModelBiped.ArmPose.EMPTY;
        this.body = new HideableModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.crown = new HideableModelRenderer(this, 58, 0);
        this.crown.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.crown.addBox(-4.5F, -12.5F, -4.5F, 9, 13, 9, 0.0F);
        this.legRight = new HideableModelRenderer(this, 0, 16);
        this.legRight.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.legRight.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.sleeveLeft = new HideableModelRenderer(this, 36, 33);
        this.sleeveLeft.mirror = true;
        this.sleeveLeft.setRotationPoint(-0.5F, -0.1F, 0.0F);
        this.sleeveLeft.addBox(-0.5F, -2.1F, -2.4F, 5, 6, 5, 0.0F);
        this.robeLowerLeft = new HideableModelRenderer(this, 58, 33);
        this.robeLowerLeft.setRotationPoint(0.0F, -0.2F, 0.0F);
        this.robeLowerLeft.addBox(-1.9F, 0.0F, -2.5F, 4, 7, 5, 0.0F);
        this.chestplate = new HideableModelRenderer(this, 1, 32);
        this.chestplate.setRotationPoint(0.0F, 0.1F, 0.0F);
        this.chestplate.addBox(-4.5F, -0.3F, -2.5F, 9, 12, 5, 0.0F);
        this.robeLowerRight = new HideableModelRenderer(this, 58, 33);
        this.robeLowerRight.mirror = true;
        this.robeLowerRight.setRotationPoint(0.0F, -0.2F, 0.0F);
        this.robeLowerRight.addBox(-2.1F, 0.0F, -2.5F, 4, 7, 5, 0.0F);
        this.sleeveRight = new HideableModelRenderer(this, 36, 33);
        this.sleeveRight.setRotationPoint(0.5F, -0.1F, 0.0F);
        this.sleeveRight.addBox(-4.5F, -2.1F, -2.4F, 5, 6, 5, 0.0F);
        this.cloak = new HideableModelRenderer(this, 81, 37);
        this.cloak.setRotationPoint(0.0F, 0.1F, 0.0F);
        this.cloak.addBox(-4.5F, 0.0F, 2.3F, 9, 21, 1, 0.0F);
        this.setRotateAngle(cloak, 0.045553093477052F, 0.0F, 0.0F);
        this.armRight = new HideableModelRenderer(this, 40, 16);
        this.armRight.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.armRight.addBox(-2.5F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.setRotateAngle(armRight, 0.0F, 0.0F, 0.10000736613927509F);
        this.necklace = new HideableModelRenderer(this, 1, 52);
        this.necklace.setRotationPoint(0.0F, 0.1F, 0.0F);
        this.necklace.addBox(-4.5F, -0.3F, -2.8F, 9, 7, 5, 0.0F);
        this.setRotateAngle(necklace, 0.032114058236695664F, 0.0F, 0.0F);
        this.armLeft = new HideableModelRenderer(this, 40, 16);
        this.armLeft.mirror = true;
        this.armLeft.setRotationPoint(5.0F, 2.0F, -0.0F);
        this.armLeft.addBox(-0.5F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.setRotateAngle(armLeft, -0.0F, 0.0F, -0.10000736613927509F);
        this.head = new HideableModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.legLeft = new HideableModelRenderer(this, 0, 16);
        this.legLeft.mirror = true;
        this.legLeft.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.legLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.head.addChild(this.crown);
        this.body.addChild(this.legRight);
        this.armLeft.addChild(this.sleeveLeft);
        this.legLeft.addChild(this.robeLowerLeft);
        this.body.addChild(this.chestplate);
        this.legRight.addChild(this.robeLowerRight);
        this.armRight.addChild(this.sleeveRight);
        this.body.addChild(this.cloak);
        this.body.addChild(this.armRight);
        this.chestplate.addChild(this.necklace);
        this.body.addChild(this.armLeft);
        this.body.addChild(this.head);
        this.body.addChild(this.legLeft);
        this.updateDefaultPose();
        animator = ModelAnimator.create();
    }

    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        this.rightArmPose = ModelBiped.ArmPose.EMPTY;
        this.leftArmPose = ModelBiped.ArmPose.EMPTY;
//        ItemStack itemstack = entitylivingbaseIn.getHeldItem(EnumHand.MAIN_HAND);
        
        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.resetToDefaultPose();
        animate((IAnimatedEntity) entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
//        ItemStack itemstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
        EntityDreadQueen thrall = (EntityDreadQueen) entityIn;
        this.faceTarget(netHeadYaw, headPitch, 1.0F, head);
        float f = 1.0F;
        this.armRight.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
        this.armLeft.rotateAngleX += MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        this.legRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        this.legLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
        this.legRight.rotateAngleY = 0.0F;
        this.legLeft.rotateAngleY = 0.0F;
        this.legRight.rotateAngleZ = 0.0F;
        this.legLeft.rotateAngleZ = 0.0F;

        if (this.isRiding) {
            this.armRight.rotateAngleX += -((float) Math.PI / 5F);
            this.armLeft.rotateAngleX += -((float) Math.PI / 5F);
            this.legRight.rotateAngleX = -1.4137167F;
            this.legRight.rotateAngleY = ((float) Math.PI / 10F);
            this.legRight.rotateAngleZ = 0.07853982F;
            this.legLeft.rotateAngleX = -1.4137167F;
            this.legLeft.rotateAngleY = -((float) Math.PI / 10F);
            this.legLeft.rotateAngleZ = -0.07853982F;
        }
        if (this.swingProgress > 0.0F) {
            EnumHandSide enumhandside = this.getMainHand(entityIn);
            ModelRenderer modelrenderer = this.getArmForSide(enumhandside);
            float f1 = this.swingProgress;
            this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;

            if (enumhandside == EnumHandSide.LEFT) {
                this.body.rotateAngleY *= -1.0F;
            }

            this.armRight.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
            this.armRight.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
            this.armLeft.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
            this.armLeft.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
            this.armRight.rotateAngleY += this.body.rotateAngleY;
            this.armLeft.rotateAngleY += this.body.rotateAngleY;
            this.armLeft.rotateAngleX += this.body.rotateAngleY;
            f1 = 1.0F - this.swingProgress;
            f1 = f1 * f1;
            f1 = f1 * f1;
            f1 = 1.0F - f1;
            float f2 = MathHelper.sin(f1 * (float) Math.PI);
            float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            modelrenderer.rotateAngleX = (float) ((double) modelrenderer.rotateAngleX - ((double) f2 * 1.2D + (double) f3));
            modelrenderer.rotateAngleY += this.body.rotateAngleY * 2.0F;
            modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
        }
        if (this.isSneak) {
            this.body.rotateAngleX = 0.5F;
            this.armRight.rotateAngleX += 0.4F;
            this.armLeft.rotateAngleX += 0.4F;
            this.legRight.rotationPointZ = 4.0F;
            this.legLeft.rotationPointZ = 4.0F;
            this.legRight.rotationPointY = 9.0F;
            this.legLeft.rotationPointY = 9.0F;
            this.head.rotationPointY = 1.0F;
        } else {
            this.body.rotateAngleX = 0.0F;
            this.legRight.rotationPointZ = 0.1F;
            this.legLeft.rotationPointZ = 0.1F;
            this.legRight.rotationPointY = 12.0F;
            this.legLeft.rotationPointY = 12.0F;
            this.head.rotationPointY = 0.0F;
        }

        this.armRight.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.armLeft.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.armRight.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.armLeft.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
//        float speed_walk = 0.6F;
//        float speed_idle = 0.05F;
//        float degree_walk = 1F;
//        float degree_idle = 0.5F;
        if (thrall.getAnimation() == EntityDreadQueen.ANIMATION_SPAWN) {
            //this.walk(armRight, 1.5F, 0.4F, false, 2, -0.3F, thrall.ticksExisted, 1);
            //this.walk(armLeft, 1.5F,  0.4F, true, 2, 0.3F, thrall.ticksExisted, 1);
            if (thrall.getAnimationTick() < 30) {
                this.flap(armRight, 0.5F, 0.5F, false, 2, -0.7F, thrall.ticksExisted, 1);
                this.flap(armLeft, 0.5F, 0.5F, true, 2, -0.7F, thrall.ticksExisted, 1);
                this.walk(armRight, 0.5F, 0.5F, true, 1, 0, thrall.ticksExisted, 1);
                this.walk(armLeft, 0.5F, 0.5F, true, 1, 0, thrall.ticksExisted, 1);
            }
        }

    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        GlStateManager.pushMatrix();
        this.body.render(scale);
        GlStateManager.popMatrix();
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animator.update(entity);
        animator.setAnimation(EntityDreadQueen.ANIMATION_SPAWN);
        animator.startKeyframe(0);
        animator.move(this.body, 0, 35, 0);
        rotate(animator, this.armLeft, -180, 0, 0);
        rotate(animator, this.armRight, -180, 0, 0);
        animator.endKeyframe();
        animator.startKeyframe(30);
        animator.move(this.body, 0, 0, 0);
        rotate(animator, this.armLeft, -180, 0, 0);
        rotate(animator, this.armRight, -180, 0, 0);
        animator.endKeyframe();
        animator.resetKeyframe(5);
    }

    public void postRenderArm(float scale, EnumHandSide side) {
        this.body.postRender(scale);
        this.getArmForSide(side).postRender(scale);
    }

    protected ModelRenderer getArmForSide(EnumHandSide side) {
        return side == EnumHandSide.LEFT ? this.armLeft : this.armRight;
    }

    protected EnumHandSide getMainHand(Entity entityIn) {
        if (entityIn instanceof EntityLivingBase) {
            EntityLivingBase entitylivingbase = (EntityLivingBase) entityIn;
            EnumHandSide enumhandside = entitylivingbase.getPrimaryHand();
            return entitylivingbase.swingingHand == EnumHand.MAIN_HAND ? enumhandside : enumhandside.opposite();
        } else {
            return EnumHandSide.RIGHT;
        }
    }

    public void setModelAttributes(ModelBase model) {
        super.setModelAttributes(model);
        if (model instanceof ModelBiped) {
            ModelBiped modelbiped = (ModelBiped) model;
            this.leftArmPose = modelbiped.leftArmPose;
            this.rightArmPose = modelbiped.rightArmPose;
            this.isSneak = modelbiped.isSneak;
        }
    }

    public void setVisible(boolean visible) {
        this.head.invisible = !visible;
        this.body.invisible = !visible;
        this.armRight.invisible = !visible;
        this.armLeft.invisible = !visible;
        this.legRight.invisible = !visible;
        this.legLeft.invisible = !visible;
    }

    @Override
    public void renderStatue() {
        this.body.render(0.0625F);
    }
}
