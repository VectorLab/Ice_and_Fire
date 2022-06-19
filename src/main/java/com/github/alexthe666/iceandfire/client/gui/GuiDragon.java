package com.github.alexthe666.iceandfire.client.gui;

import com.github.alexthe666.iceandfire.client.StatCollector;
import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import com.github.alexthe666.iceandfire.inventory.ContainerDragon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDragon extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("iceandfire:textures/gui/dragon.png");
//    private IInventory playerInventory;
//    private IInventory dragonInv;
    private EntityDragonBase dragon;
    private float mousePosx;
    private float mousePosY;

    public GuiDragon(IInventory playerInv, EntityDragonBase dragon) {
        super(new ContainerDragon(dragon, Minecraft.getMinecraft().player));
//        this.playerInventory = playerInv;
//        this.dragonInv = dragon.dragonInventory;
        this.dragon = dragon;
        this.allowUserInput = false;
        this.ySize = 214;
    }

    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityDragonBase entity) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(posX, posY, 50.0F);
        GlStateManager.scale((-scale), scale, scale);
        float dragonscale = entity.getRenderSize() / 3;
        GlStateManager.scale(1 / dragonscale, 1 / dragonscale, 1 / dragonscale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f2 = entity.renderYawOffset;
        float f3 = entity.rotationYaw;
        float f4 = entity.rotationPitch;
        float f5 = entity.prevRotationYawHead;
        float f6 = entity.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float) Math.atan(mouseY / 40.0F)) * 20.0F, 1.0F, 0.0F, 0.0F);
        entity.renderYawOffset = (float) Math.atan(mouseX / 40.0F) * 20.0F;
        entity.rotationYaw = (float) Math.atan(mouseX / 40.0F) * 40.0F;
        entity.rotationPitch = -((float) Math.atan(mouseY / 40.0F)) * 20.0F;
        entity.rotationYawHead = entity.rotationYaw;
        entity.prevRotationYawHead = entity.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntity(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        rendermanager.setRenderShadow(true);
        entity.renderYawOffset = f2;
        entity.rotationYaw = f3;
        entity.rotationPitch = f4;
        entity.prevRotationYawHead = f5;
        entity.rotationYawHead = f6;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s1 = dragon.getName();
        this.fontRenderer.drawString(s1, this.xSize / 2 - this.fontRenderer.getStringWidth(s1) / 2, 6, 4210752);
        String s3 = dragon.getCustomNameTag().length() == 0 ? StatCollector.translateToLocal("dragon.unnamed") : StatCollector.translateToLocal("dragon.name") + dragon.getCustomNameTag();
        this.fontRenderer.drawString(s3, this.xSize / 2 - this.fontRenderer.getStringWidth(s3) / 2, 75, 0XFFFFFF);
        String s2 = StatCollector.translateToLocal("dragon.health") + Math.min(dragon.getHealth(), dragon.getMaxHealth()) + "/" + dragon.getMaxHealth();
        this.fontRenderer.drawString(s2, this.xSize / 2 - this.fontRenderer.getStringWidth(s2) / 2, 84, 0XFFFFFF);
        String s5 = StatCollector.translateToLocal("dragon.gender") + StatCollector.translateToLocal((dragon.isMale() ? "dragon.gender.male" : "dragon.gender.female"));
        this.fontRenderer.drawString(s5, this.xSize / 2 - this.fontRenderer.getStringWidth(s5) / 2, 93, 0XFFFFFF);
        String s6 = StatCollector.translateToLocal("dragon.hunger") + dragon.getHunger() + "/100";
        this.fontRenderer.drawString(s6, this.xSize / 2 - this.fontRenderer.getStringWidth(s6) / 2, 102, 0XFFFFFF);
        String s4 = StatCollector.translateToLocal("dragon.stage") + dragon.getDragonStage() + " " + StatCollector.translateToLocal("dragon.days.front") + dragon.getAgeInDays() + " " + StatCollector.translateToLocal("dragon.days.back");
        this.fontRenderer.drawString(s4, this.xSize / 2 - this.fontRenderer.getStringWidth(s4) / 2, 111, 0XFFFFFF);
        String s7 = dragon.getOwner() != null ? StatCollector.translateToLocal("dragon.owner") + dragon.getOwner().getName() : StatCollector.translateToLocal("dragon.untamed");
        this.fontRenderer.drawString(s7, this.xSize / 2 - this.fontRenderer.getStringWidth(s7) / 2, 120, 0XFFFFFF);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        drawEntityOnScreen(k + 88, l + (int) (0.5F * (dragon.flyProgress)) + 55, 23, k + 51 - this.mousePosx, l + 75 - 50 - this.mousePosY, this.dragon);

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.mousePosx = mouseX;
        this.mousePosY = mouseY;
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

}