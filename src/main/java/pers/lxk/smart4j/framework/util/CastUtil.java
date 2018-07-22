package pers.lxk.smart4j.framework.util;

/**
 * @Description: 转型操作工具类 P36
 */

public class CastUtil {

    /**
     * 转型为String
     *
     * @param object
     * @return
     */
    public static String castString(Object object) {
        return CastUtil.castString(object, "");
    }

    /**
     * 转为String，提供默认值
     *
     * @param object
     * @param defaultString
     * @return
     */
    public static String castString(Object object, String defaultString) {
        return object != null ? String.valueOf(object) : defaultString;
    }

    /**
     * 转为double
     *
     * @param object
     * @return
     */
    public static double castDouble(Object object) {
        return CastUtil.castDouble(object, 0);
    }

    /**
     * 转为double，默认值为0
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object object, double defaultValue) {
        double doubleValue = defaultValue;
        if (object != null) {
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转为long型，默认为0
     *
     * @param object
     * @return
     */
    public static long castLong(Object object) {
        return CastUtil.castLong(object, 0);
    }

    /**
     * 转为long型，可指定默认值
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static long castLong(Object object, long defaultValue) {
        long value = defaultValue;
        if (object != null) {
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    value = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
     * 转为int型，默认为0
     *
     * @param object
     * @return
     */
    public static int castInt(Object object) {
        return CastUtil.castInt(object, 0);
    }

    /**
     * 转为int型，可指定默认值
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static int castInt(Object object, int defaultValue) {
        int value = defaultValue;
        if (object != null) {
            String strValue = castString(object);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    value = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
     * 转为boolean型，默认为false
     *
     * @param object
     * @return
     */
    public static boolean castBoolean(Object object) {
        return CastUtil.castBoolean(object, false);
    }

    /**
     * 转为boolean型，可指定默认值
     *
     * @param object
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object object, boolean defaultValue) {
        boolean value = defaultValue;
        if (object != null) {
            value = Boolean.parseBoolean(castString(object));
        }
        return value;
    }
}
