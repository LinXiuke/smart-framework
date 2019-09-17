package pers.lxk.smart4j.framework.proxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description ：
 * @Date ： 2019/9/17
 */

public class Client {

    public static void main(String[] args) {

        List<Proxy> proxyList = new ArrayList<>();
        proxyList.add(new BeforeProxy());
        proxyList.add(new AfterProxy());


        Hello hello = ProxyManager.createProxy(Hello.class, proxyList);
        hello.sayHello();
    }
}

class Hello {

    public void sayHello() {
        System.out.println("hello");
    }
}

class BeforeProxy extends AspectProxy {

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        System.out.println("before");
    }
}

class AfterProxy extends AspectProxy {

    @Override
    public void after(Class<?> cls, Method method, Object[] params) throws Throwable {
        System.out.println("after");
    }
}
