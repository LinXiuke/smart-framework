package pers.lxk.smart4j.framework.helper;

import pers.lxk.smart4j.framework.annotation.Aspect;
import pers.lxk.smart4j.framework.proxy.AspectProxy;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description ：AOP助手类 P152
 * @Date ： 2019/7/27
 */

public final class AopHelper {


    /**
     * 获取Aspect注解的目标类集合
     * @param aspect
     * @return
     * @throws Exception
     */
    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception {
        Set<Class<?>> targetClassSet = new HashSet<>();
        Class<? extends Annotation> annotation = aspect.value();
        if (annotation != null && !annotation.equals(Aspect.class)) {
            targetClassSet.addAll(ClassHelper.getClassSetBYAnnotation(annotation));
        }

        return targetClassSet;
    }


    /**
     * 获取代理类和目标集合的映射关系
     * @return
     * @throws Exception
     */
    private static Map<Class<?>, Set<Class<?>>> creteProxyMap() throws Exception {
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<>();
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for(Class<?> proxyClass: proxyClassSet) {
            if (proxyClass.isAnnotationPresent(Aspect.class)) {
                Aspect aspect = proxyClass.getAnnotation(Aspect.class);
                Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
                proxyMap.put(proxyClass, targetClassSet);
            }
        }

        return proxyMap;
    }

}
