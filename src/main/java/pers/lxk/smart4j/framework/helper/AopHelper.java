package pers.lxk.smart4j.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.lxk.smart4j.framework.annotation.Aspect;
import pers.lxk.smart4j.framework.proxy.AspectProxy;
import pers.lxk.smart4j.framework.proxy.Proxy;
import pers.lxk.smart4j.framework.proxy.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @Description ：AOP助手类 P152
 * @Date ： 2019/7/27
 */

public final class AopHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AopHelper.class);


    /**
     * 初始化AOP框架
     */
    static {

        try {

            Map<Class<?>, Set<Class<?>>> proxyMap = creteProxyMap();
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);

            for (Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()) {

                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                //获取代理对象
                Object proxy = ProxyManager.createProxy(targetClass, proxyList);
                BeanHelper.setBean(targetClass, proxy);

            }

        } catch (Exception e) {
            LOGGER.error("aop failure", e);
        }
    }


    /**
     * 根据代理类和目标类集合之间的关系分析出目标类和代理对象列表之间的映射关系
     * @param proxyMap
     * @return
     * @throws Exception
     */
    public static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {

        Map<Class<?>, List<Proxy>> targetMap = new HashMap<>();

        for (Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()) {

            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();

            for (Class<?> targetClass : targetClassSet) {

                Proxy proxy = (Proxy) proxyClass.newInstance();

                if (targetMap.containsKey(targetClass)) {
                    targetMap.get(targetClass).add(proxy);
                } else {
                    List<Proxy> proxyList = new ArrayList<>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass, proxyList);
                }
            }
        }

        return targetMap;
    }



    /**
     * 获取代理类（这里的代理类指切面类）和目标集合的映射关系
     * 代理类需要扩展AspectProxy抽象类，还需要带有Aspect注解
     * @return
     * @throws Exception
     */
    private static Map<Class<?>, Set<Class<?>>> creteProxyMap() throws Exception {

        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<>();

        //代理类需要扩展AspectProxy抽象类
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


    /**
     * 获取Aspect注解中的设置的注解类的目标类集合
     * @param aspect
     * @return
     * @throws Exception
     */
    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception {

        Set<Class<?>> targetClassSet = new HashSet<>();

        //获取Aspect注解中定义的注解属性
        Class<? extends Annotation> annotation = aspect.value();

        if (annotation != null && !annotation.equals(Aspect.class)) {

            //获取并添加Aspect注解中定义的注解属性对应的目标类
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }

        return targetClassSet;
    }

}
