package com.talent.reflect.static_proxy;


import java.lang.reflect.Constructor;

/**
 * 代理设计的核心在于需要一个核心的操作接口
 * 静态代理
 */
interface ISubject {
    /**
     * 核心业务
     */
    void eat();
}

class RealSubject implements ISubject {

    @Override
    public void eat() {
        System.out.println("饿了一定要吃饭");
    }
}

class Factory {
    private Factory() {}
    @SuppressWarnings("unchecked")
    public static <T> T getInstance (String className) throws Exception {
        T obj = null;
        obj = (T) Class.forName(className).newInstance();
        return obj;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String proxyClassName, String realClassName) throws Exception {
        T t = null;
        // 取得真实接口对象
        T obj = getInstance(realClassName);
        Constructor<?> cons = Class.forName(proxyClassName).getConstructor(obj.getClass().getInterfaces()[0]);
        t = (T) cons.newInstance(obj);
        return t;
    }
}

class ProxySubject implements ISubject {

    private ISubject subject;

    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }

    public void prepare() {
        System.out.println("需要准备食材，收拾食材！");
    }

    public void clear() {
        System.out.println("洗刷碗筷！");
    }

    @Override
    public void eat() {
        this.prepare();
        this.subject.eat();
        this.clear();
    }
}

/**
 * @author guobing
 * @Title: TestDemo
 * @ProjectName JavaTest
 * @Description: 代理设计模式
 * @date 2019/3/18下午4:00
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        ISubject subject = Factory.getInstance("com.talent.reflect.proxy.static_proxy.ProxySubject", "com.talent.reflect.proxy.static_proxy.RealSubject");
        subject.eat();
    }
}
