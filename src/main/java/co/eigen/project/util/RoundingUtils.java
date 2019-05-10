package co.eigen.project.util;

import java.math.BigDecimal;

public class RoundingUtils {

    public static Float round(Float value){
        BigDecimal bd = new BigDecimal(Float.toString(value));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
