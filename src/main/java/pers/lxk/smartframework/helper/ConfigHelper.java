package pers.lxk.smartframework.helper;

import pers.lxk.smartframework.ConfigConstant;
import pers.lxk.smartframework.util.PropsUtil;

import java.util.Properties;

/**
 * @Description: 属性文件助手类
 * @Author: linxiuke
 * @Date: Create in 2017/11/7
 */

public final class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取JDBC驱动
     *
     * @return
     */
    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取JDBC URL
     * @return
     */
    public static String getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * 获取JDBC用户名
     * @return
     */
    public static String getJdbcUsername() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAMW);
    }

    /**
     * 获取JDBC密码
     * @return
     */
    public static String getJdbcPassword() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包名
     * @return
     */
    public static String getAppBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取应用JSP路径
     * @return
     */
    public static String getAPPJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB/INF/view/");
    }

    /**
     * 获取应用静态资源路径
     * @return
     */
    public static String getAPPAsserPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/");
    }

}
