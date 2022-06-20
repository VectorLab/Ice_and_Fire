package com.github.alexthe666.iceandfire.entity;

import java.util.ArrayList;
import java.util.List;

import net.ilexiconn.llibrary.server.entity.EntityProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;

public class MiscEntityProperties extends EntityProperties<EntityLivingBase> {

    public boolean hasDismountedDragon;
    public int deathwormLungeTicks = 0;
    public int prevDeathwormLungeTicks = 0;
    public int specialWeaponDmg = 0;
    public boolean deathwormLaunched = false;
    public boolean deathwormReceded = false;
    public boolean isBeingGlaredAt = false;
    public int lastEnteredDreadPortalX = 0;
    public int lastEnteredDreadPortalY = 0;
    public int lastEnteredDreadPortalZ = 0;
    public List<Entity> glarers = new ArrayList<>();
    public List<Entity> entitiesWeAreGlaringAt = new ArrayList<>();
    public int inLoveTicks;

    @Override
    public int getTrackingTime() {
        return 20;
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        compound.setBoolean("DismountedDragon", hasDismountedDragon);
        compound.setInteger("GauntletDamage", specialWeaponDmg);
        compound.setInteger("DreadPortalX", lastEnteredDreadPortalX);
        compound.setInteger("DreadPortalY", lastEnteredDreadPortalY);
        compound.setInteger("DreadPortalZ", lastEnteredDreadPortalZ);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        this.hasDismountedDragon = compound.getBoolean("DismountedDragon");
        this.specialWeaponDmg = compound.getInteger("GauntletDamage");
        this.lastEnteredDreadPortalX = compound.getInteger("DreadPortalX");
        this.lastEnteredDreadPortalY = compound.getInteger("DreadPortalY");
        this.lastEnteredDreadPortalZ = compound.getInteger("DreadPortalZ");
    }

    @Override
    public void init() {
        hasDismountedDragon = false;
        lastEnteredDreadPortalX = 0;
        lastEnteredDreadPortalY = 0;
        lastEnteredDreadPortalZ = 0;
    }

    @Override
    public String getID() {
        return "Ice and Fire - Player Property Tracker";
    }

    @Override
    public Class<EntityLivingBase> getEntityClass() {
        return EntityLivingBase.class;
    }
}
