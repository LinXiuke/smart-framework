package pers.lxk.smart4j.framework;

import pers.lxk.smart4j.framework.helper.*;
import pers.lxk.smart4j.framework.util.ClassUtil;

/**
 * @Description: 加载相应的helper类 P98
 */
public final class HelperLoader {

    public static void init() {

        // AopHelper要在IocHelper之前加载，先获取代理对象才能进行依赖注入
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> cls: classList)
            ClassUtil.loadClass(cls.getName());
    }
}
