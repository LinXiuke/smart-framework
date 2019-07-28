package pers.lxk.smart4j.framework.proxy;

/**
 * @Description ：
 * @date ： 2019/7/24
 */

public interface Proxy {

    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
