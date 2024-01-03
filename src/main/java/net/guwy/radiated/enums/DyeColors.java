package net.guwy.radiated.enums;

public enum DyeColors {
    BLACK(1973019, "black"),
    RED(11743532, "red"),
    GREEN(3887386, "green"),
    BROWN(5320730, "brown"),
    BLUE(2437522, "blue"),
    PURPLE(8073150, "purple"),
    CYAN(2651799, "cyan"),
    SILVER(11250603, "light_gray"),
    GRAY(4408131, "gray"),
    PINK(14188952, "pink"),
    LIME(4312372, "lime"),
    YELLOW(14602026, "yellow"),
    LIGHT_BLUE(6719955, "light_blue"),
    MAGENTA(12801229, "magenta"),
    ORANGE(15435844, "orange"),
    WHITE(15790320, "white");

    public int color;
    public String dictName;

    DyeColors(int color, String name) {
        this.color = color;
        this.dictName = name;
    }
}
