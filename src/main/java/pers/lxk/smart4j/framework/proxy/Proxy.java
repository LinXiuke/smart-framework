package pers.lxk.smart4j.framework.proxy;

/**
 * @Description ：
 * @date ： 2019/7/24
 */

public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
