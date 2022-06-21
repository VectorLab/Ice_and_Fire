package com.github.alexthe666.iceandfire.api.event;

import net.minecraft.entity.EntityLiving;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * GenericGriefEvent is fired right before a non-Dragon destroys or modifies blocks in some aspect. <br>
 * {@link #targetX} x coordinate being targeted for modification. <br>
 * {@link #targetY} y coordinate being targeted for modification. <br>
 * {@link #targetZ} z coordinate being targeted for modification. <br>
 * <br>
 * This event is {@link Cancelable}.<br>
 * If this event is canceled, no block destruction or explosion will follow.<br>
 * <br>
 * This event does not have a result. {@link HasResult}<br>
 * <br>
 * If you only want to deal with the damage caused by dragon fire, see {@link DragonFireDamageWorldEvent} <br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.
 **/
@Cancelable
public class DragonGriefPreEvent extends LivingEvent {
    //public int xs,xe,ys,ye,zs,ze;

    public DragonGriefPreEvent(EntityLiving griefer){
        super(griefer);
    }

}
