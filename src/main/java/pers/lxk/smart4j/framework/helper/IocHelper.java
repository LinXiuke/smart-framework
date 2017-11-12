package pers.lxk.smart4j.framework.helper;

import org.apache.commons.collections4.CollectionUtils;
import pers.lxk.smart4j.framework.annotation.Inject;
import pers.lxk.smart4j.framework.util.ArrayUtil;
import pers.lxk.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * @Description: 依赖注入助手类
 * @Author: linxiuke
 * @Date: Create in 2017/11/12
 */
public final class IocHelper {

    static {
        //获取所有的Bean类与Bean实例之间的映射关系（简称BeanMap）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        
        if (CollectionUtils.isNotEmpty((Collection<?>) beanMap)) {
            //遍历BeanMap
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类定义的所有成员变量
                Field[] beanFields = beanClass.getFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //遍历
                    for (Field beanField : beanFields) {
                        //判断当前Bean是否有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在BeanMap中获取实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldClass != null) {
                                //通过反射初始化
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
