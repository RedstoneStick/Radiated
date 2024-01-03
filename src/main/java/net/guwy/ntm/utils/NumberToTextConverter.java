package net.guwy.ntm.utils;

import net.minecraft.network.chat.Component;

public class NumberToTextConverter {
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;


    public static String EnergyToText(int energy){
        String text;
        double val;

        if(energy >= BILLION){
            val = (double) energy / BILLION;
            val = (Math.floor(val * 10)) / 10;

            text = Double.toString(val);
            text = text + "B";
        }

        else if(energy >= MILLION){
            val = (double) energy / MILLION;
            val = (Math.floor(val * 10)) / 10;

            text = Double.toString(val);
            text = text + "M";
        }

        else if(energy >= THOUSAND){
            val = (double) energy / THOUSAND;
            val = (Math.floor(val * 10)) / 10;

            text = Double.toString(val);
            text = text + "k";
        }

        else {
            val = energy;
            text = Integer.toString((int) val);
        }
        return text;
    }

    public static String TicksToYMD(long ticks){
        int years = (int) (ticks / 8760000);
        ticks = ticks % 8760000;
        int days = (int) (ticks / 24000);
        ticks =  ticks % 24000;
        double hours = ticks / 1200.0;
        hours = Math.round(hours * 100) / 100.0;

        String text = Integer.toString(years) + " " + Component.translatable("tooltip.ntm.generic.year_symbol").getString() + ", "
                + Integer.toString(days) + " " + Component.translatable("tooltip.ntm.generic.day_symbol").getString() + ", "
                + Double.toString(hours) + " " + Component.translatable("tooltip.ntm.generic.hour_symbol").getString();
        return text;
    }
}
