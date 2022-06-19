package com.github.alexthe666.iceandfire.client.render.tile;

import com.github.alexthe666.iceandfire.entity.tile.TileEntityLectern;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderLectern extends TileEntitySpecialRenderer<TileEntity> {

    private static final ResourceLocation ENCHANTMENT_TABLE_BOOK_TEXTURE = new ResourceLocation("iceandfire:textures/models/lectern_book.png");
    private ModelBook book = new ModelBook();

    @Override
    public void render(TileEntity entity, double x, double y, double z, float f, int yee, float alpha) {
        TileEntityLectern lectern = (TileEntityLectern) entity;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.07F, (float) z + 0.5F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.rotate(this.getRotation(lectern), 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(112.5F, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(180F, 1.0F, 0.0F, 0.0F);
        this.bindTexture(ENCHANTMENT_TABLE_BOOK_TEXTURE);
        float f4 = lectern.pageFlipPrev + (lectern.pageFlip - lectern.pageFlipPrev) * yee + 0.25F;
        float f5 = lectern.pageFlipPrev + (lectern.pageFlip - lectern.pageFlipPrev) * yee + 0.75F;
        f4 = (f4 - MathHelper.fastFloor(f4)) * 1.6F - 0.3F;
        f5 = (f5 - MathHelper.fastFloor(f5)) * 1.6F - 0.3F;

        if (f4 < 0.0F) {
            f4 = 0.0F;
        }

        if (f5 < 0.0F) {
            f5 = 0.0F;
        }

        if (f4 > 1.0F) {
            f4 = 1.0F;
        }

        if (f5 > 1.0F) {
            f5 = 1.0F;
        }

        GlStateManager.enableCull();
        this.book.render(null, 0, f4, f5, 1, 0.0F, 0.0625F);
        GlStateManager.popMatrix();
    }

    private float getRotation(TileEntityLectern lectern) {
        switch (lectern.getBlockMetadata()) {
            default:
                return 90;
            case 1:
                return 0;
            case 2:
                return -90;
            case 3:
                return 180;

        }
    }

}
