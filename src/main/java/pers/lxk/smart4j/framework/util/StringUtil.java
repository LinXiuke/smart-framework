package pers.lxk.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:字符串工具类
 * @Author: linxiuke
 * @Date: Create in 2017/11/7
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否为非空
     * @param string
     * @return
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }
}
