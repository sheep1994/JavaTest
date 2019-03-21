package com.talent.reflect.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ISubject {
    /**
     * 吃饭是整天的核心业务
     * @param msg
     * @param num
     */
    void eat(String msg, int num);
}

class RealSubject implements ISubject {

    @Override
    public void eat(String msg, int num) {
        System.out.println("我要吃" + num + "分量的：" + msg);
    }
}

class ProxySubject implements InvocationHandler {

    /**
     * 绑定任意接口的对象，使用Object描述
     */
    private Object target;

    /**
     * 实现真实对象的绑定处理，同时返回代理对象
     * @param target 真实对象
     * @return 返回代理对象（伪对象）
     */
    public Object bind(Object target) {
        /**
         * 保存真实对象
         */
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(this.target, args);
        return ret;
    }
}

class Factory {
    private Factory () {}

    public static <T> T getInstance(String className) {
        T obj = null;
        try {
            obj = (T) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

/**
 * @author guobing
 * @Title: TestDemo
 * @ProjectName JavaTest
 * @Description: 动态代理
 * @date 2019/3/21下午3:44
 */
public class TestDemo {

    public static void main(String[] args) {
        ISubject subject = (ISubject) new ProxySubject().bind(Factory.getInstance("com.talent.reflect.proxy.dynamic.RealSubject"));
        System.out.println("准备食材");
        subject.eat("鱼香肉丝", 2);
        System.out.println("收拾碗筷");
    }
}
