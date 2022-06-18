package com.github.alexthe666.iceandfire.client.render.entity;

import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNothing<T extends Entity> extends Render<T> {

    public RenderNothing(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return null;
    }

    @Override
    public void doRender(T entity, double x, double y, double z, float yee, float partialTicks) {

    }

    public boolean shouldRender(T livingEntity, ICamera camera, double camX, double camY, double camZ) {
        return false;
    }

}
