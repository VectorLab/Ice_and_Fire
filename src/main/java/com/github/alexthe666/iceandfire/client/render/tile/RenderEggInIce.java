package com.github.alexthe666.iceandfire.client.render.tile;

import org.lwjgl.opengl.GL11;

import com.github.alexthe666.iceandfire.client.model.ModelDragonEgg;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityEggInIce;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderEggInIce extends TileEntitySpecialRenderer<TileEntity> {

    @Override
    public void render(TileEntity entity, double x, double y, double z, float f, int f1, float alpha) {
        ModelDragonEgg model = new ModelDragonEgg();
        TileEntityEggInIce egg = (TileEntityEggInIce) entity;
        if (egg.type != null) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y - 0.75F, (float) z + 0.5F);
            GL11.glPushMatrix();
            this.bindTexture(RenderPodium.getEggTexture(egg.type));
            GL11.glPushMatrix();
            model.renderFrozen(egg);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
    }

}
