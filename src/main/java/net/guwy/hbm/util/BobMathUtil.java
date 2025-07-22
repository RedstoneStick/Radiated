package net.guwy.hbm.util;

import javax.annotation.Nonnegative;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class BobMathUtil {
    // Removed some things, will add them if there ever is a need

    // The good old arduino map function
    public static double mapDouble(double x, double inMin, double inMax, double outMin, double outMax) {
        return (x - inMin) * (outMax - outMin) / (inMax - inMin) + outMin;
    }

    public static String toPercentage(float amount, float total) {
        return NumberFormat.getPercentInstance().format(amount / total);
    }

    public static String[] ticksToDate(long ticks) {

        int tickDay = 48000;
        int tickYear = tickDay * 100;

        final String[] dateOut = new String[3];
        long year = Math.floorDiv(ticks, tickYear);
        byte day = (byte) Math.floorDiv(ticks - tickYear * year, tickDay);
        float time = ticks - (tickYear * year + tickDay * day);
        time = (float) mapDouble(time, 0, tickDay, 0, 10f);
        dateOut[0] = String.valueOf(year);
        dateOut[1] = String.valueOf(day);
        dateOut[2] = String.valueOf(time);
        return dateOut;
    }

    /**
     * Rounds a number to so many significant digits
     * @param num The number to round
     * @param digits Amount of digits
     * @return The rounded double
     */
    public static double roundDecimal(double num, @Nonnegative int digits) {
        return new BigDecimal(num).setScale(digits, RoundingMode.HALF_UP).doubleValue();
    }

    public static String getShortNumber(long l) {

        if(l >= Math.pow(10, 18)) {
            double res = l / Math.pow(10, 18);
            res = Math.round(res * 100.0) / 100.0;
            return res + "E";
        }
        if(l >= Math.pow(10, 15)) {
            double res = l / Math.pow(10, 15);
            res = Math.round(res * 100.0) / 100.0;
            return res + "P";
        }
        if(l >= Math.pow(10, 12)) {
            double res = l / Math.pow(10, 12);
            res = Math.round(res * 100.0) / 100.0;
            return res + "T";
        }
        if(l >= Math.pow(10, 9)) {
            double res = l / Math.pow(10, 9);
            res = Math.round(res * 100.0) / 100.0;
            return res + "G";
        }
        if(l >= Math.pow(10, 6)) {
            double res = l / Math.pow(10, 6);
            res = Math.round(res * 100.0) / 100.0;
            return res + "M";
        }
        if(l >= Math.pow(10, 3)) {
            double res = l / Math.pow(10, 3);
            res = Math.round(res * 100.0) / 100.0;
            return res + "k";
        }

        return Long.toString(l);
    }

    /**
     * Until someone tells me why we need to squirt so much this function will act as a normal sqrt
     *
     * Adjusted sqrt, approaches standard sqrt but sqrt(x) is never bigger than x
     *
     *      ____________
     *     /       1    |     1
     * _  / x + ―――――  - ―――――
     *  \/      (x + 2)²    x + 2
     *
     * @param x
     * @return
     */
    public static double squirt(double x) {
        //return Math.sqrt(x + 1D / ((x + 2D) * (x + 2D))) - 1D / (x + 2D);
        return Math.sqrt(x);
    }

    /** Soft peak sine */
    public static double sps(double x) {
        return Math.sin(Math.PI / 2D * Math.cos(x));
    }

    /** Square wave sine, make sure squarination is [0;1] */
    public static double sws(double x, double squarination) {
        double s = Math.sin(x);
        return Math.pow(Math.abs(s), 2 - squarination) / s;
    }
}
