package com.github.alexthe666.iceandfire.client.render;

//import java.lang.reflect.Field;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
//import net.minecraft.client.renderer.RenderGlobal;
//import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;
//import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class RenderDreadlandsAurora extends IRenderHandler {
/*	private static final ResourceLocation AURORA_TEXTURES = new ResourceLocation("iceandfire:textures/environment/dread_aurora.png");


    private static Field CLOUD_TICK_COUNTER;
    private static Field SKY_VBO;
    private static Field SKY_2_VBO;
    private static Field STAR_VBO;
    private static Field SKY_LIST;
    private static Field SKY_2_LIST;
    private static Field STAR_LIST;

    private int skyboxList = -1;

    static {
        CLOUD_TICK_COUNTER = ReflectionHelper.findField(RenderGlobal.class, "cloudTickCounter", "field_72773_u");
        SKY_VBO = ReflectionHelper.findField(RenderGlobal.class, "skyVBO", "field_175012_t");
        SKY_2_VBO = ReflectionHelper.findField(RenderGlobal.class, "sky2VBO", "field_175011_u");
        STAR_VBO = ReflectionHelper.findField(RenderGlobal.class, "starVBO", "field_175013_s");
        SKY_LIST = ReflectionHelper.findField(RenderGlobal.class, "glSkyList", "field_72771_w");
        SKY_2_LIST = ReflectionHelper.findField(RenderGlobal.class, "glSkyList2", "field_72781_x");
        STAR_LIST = ReflectionHelper.findField(RenderGlobal.class, "starGLCallList", "field_72772_v");
    }





    private net.minecraft.client.renderer.vertex.VertexBuffer getSkyVBO() {
        try {
            return (net.minecraft.client.renderer.vertex.VertexBuffer) SKY_VBO.get(Minecraft.getMinecraft().renderGlobal);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private net.minecraft.client.renderer.vertex.VertexBuffer getSky2VBO() {
        try {
            return (net.minecraft.client.renderer.vertex.VertexBuffer) SKY_2_VBO.get(Minecraft.getMinecraft().renderGlobal);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private net.minecraft.client.renderer.vertex.VertexBuffer getStarVBO() {
        try {
            return (net.minecraft.client.renderer.vertex.VertexBuffer) STAR_VBO.get(Minecraft.getMinecraft().renderGlobal);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int getSkyCallist() {
        try {
            return (Integer) SKY_LIST.get(Minecraft.getMinecraft().renderGlobal);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int getSky2CallList() {
        try {
            return (Integer) SKY_2_LIST.get(Minecraft.getMinecraft().renderGlobal);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int getStarCallList() {
        try {
            return (Integer) STAR_LIST.get(Minecraft.getMinecraft().renderGlobal);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int getCloudTickCounter() {
        try {
            return (Integer) CLOUD_TICK_COUNTER.get(Minecraft.getMinecraft().renderGlobal);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void renderClouds(Minecraft mc) {

    }
*/
    @Override
    public void render(float partialTicks, WorldClient world, Minecraft mc) {
        //this.renderClouds(mc);
    }
}