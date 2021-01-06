package advancedjava.finalproj.game.creature;

import java.text.DecimalFormat;

public class Utils
{
    public static double formatDouble(double d)
    {
        return Double.parseDouble(new DecimalFormat("#.0").format(d));
    }

    public static double limitRandomRange(double d)
    {
        return (d * 2) - 1;
    }
}
