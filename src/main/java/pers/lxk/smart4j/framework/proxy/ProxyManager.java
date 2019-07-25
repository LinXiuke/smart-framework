package pers.lxk.smart4j.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.List;

/**
 * @Description ： 代理管理器  P146
 * @Date ： 2019/7/25
 */

public abstract class ProxyManager implements Proxy {


    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
        return (T) Enhancer.create(targetClass,
                (MethodInterceptor) (targetObject, targetMethod, methodParams, methodProxy) -> new ProxyChain(targetClass, targetObject, targetMethod, methodProxy, methodParams, proxyList));
    }
}
