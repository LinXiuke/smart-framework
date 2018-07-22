package pers.lxk.smart4j.framework;

import pers.lxk.smart4j.framework.helper.BeanHelper;
import pers.lxk.smart4j.framework.helper.ClassHelper;
import pers.lxk.smart4j.framework.helper.ControllerHelper;
import pers.lxk.smart4j.framework.helper.IocHelper;
import pers.lxk.smart4j.framework.util.ClassUtil;

/**
 * @Description: 加载相应的helper类
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> cls: classList)
            ClassUtil.loadClass(cls.getName());
    }
}
