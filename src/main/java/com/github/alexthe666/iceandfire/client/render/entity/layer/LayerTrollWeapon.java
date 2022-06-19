package com.github.alexthe666.iceandfire.client.render.entity.layer;

import com.github.alexthe666.iceandfire.client.render.entity.RenderTroll;
import com.github.alexthe666.iceandfire.entity.EntityGorgon;
import com.github.alexthe666.iceandfire.entity.EntityTroll;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerTrollWeapon<T extends EntityLivingBase> implements LayerRenderer<T> {
    private final RenderTroll renderer;

    public LayerTrollWeapon(RenderTroll renderer) {
        this.renderer = renderer;
    }

    public void doRenderLayer(EntityTroll entity, float f, float f1, float i, float f2, float f3, float f4, float f5) {
        if (entity.getWeaponType() != null && !EntityGorgon.isStoneMob(entity)) {
            this.renderer.bindTexture(entity.getWeaponType().TEXTURE);
            this.renderer.getMainModel().render(entity, f, f1, f2, f3, f4, f5);
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

    @Override
    public void doRenderLayer(T entity, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
        this.doRenderLayer((EntityTroll) entity, f, f1, f2, f3, f4, f5, f6);
    }
}