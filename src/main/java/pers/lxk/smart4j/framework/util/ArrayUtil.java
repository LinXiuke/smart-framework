package pers.lxk.smart4j.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @Description: 数组工具类
 * @Author: linxiuke
 * @Date: Create in 2017/11/12
 */
public final class ArrayUtil {

    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}