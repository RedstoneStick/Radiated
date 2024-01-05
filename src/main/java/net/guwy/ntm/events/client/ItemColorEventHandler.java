package net.guwy.ntm.events.client;

import net.guwy.ntm.content.items.MultiColorItem;
import net.guwy.ntm.index.NTMResourcesAndParts;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

import java.util.Arrays;

public class ItemColorEventHandler {
    public static void init(RegisterColorHandlersEvent.Item event){

        Arrays.stream(NTMResourcesAndParts.DYE_CHEM).forEach(dye -> {
            MultiColorItem color = (MultiColorItem) dye.get();
            event.register(color, dye.get());
        });

        Arrays.stream(NTMResourcesAndParts.DYE_CRAYON).forEach(dye -> {
            MultiColorItem color = (MultiColorItem) dye.get();
            event.register(color, dye.get());
        });

        Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK).forEach(ore -> {
            MultiColorItem color = (MultiColorItem) ore.get();
            event.register(color, ore.get());
        });

        Arrays.stream(NTMResourcesAndParts.ORE_BEDROCK_BYPRODUCT).forEach(ore -> {
            MultiColorItem color = (MultiColorItem) ore.get();
            event.register(color, ore.get());
        });
    }
}
