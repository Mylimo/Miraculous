package com.mylimo.miraculous.event;

import com.mylimo.miraculous.init.ModItems;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler
{
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void shotgunCrafted(net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent event)
    {
        if(event.crafting.getItem() == ModItems.SHOTGUN)
        {

            event.crafting.setItemDamage(2);

        }
    }
}
