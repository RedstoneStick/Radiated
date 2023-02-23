package net.guwy.radiated.utils;

public class NumberToTextConverter {
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;


    public static String ConvertEnergyToText(int energy){
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
            text = Double.toString(val);
        }
        return text;
    }
}
