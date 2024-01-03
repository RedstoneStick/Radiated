package net.guwy.ntm.events.client;

import net.guwy.ntm.content.items.DyeItem;
import net.guwy.ntm.index.NTMResourcesAndParts;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

import java.util.Arrays;

public class ItemColorEventHandler {
    public static void init(RegisterColorHandlersEvent.Item event){

        Arrays.stream(NTMResourcesAndParts.DYE_CHEM).forEach(dye -> {
            DyeItem color = (DyeItem) dye.get();
            event.register(color, dye.get());
        });

        Arrays.stream(NTMResourcesAndParts.DYE_CRAYON).forEach(dye -> {
            DyeItem color = (DyeItem) dye.get();
            event.register(color, dye.get());
        });
    }
}
