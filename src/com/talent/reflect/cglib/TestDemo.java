package com.talent.reflect.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理
 */
class Message {
    public void send() {
        System.out.println("www.baidu.com");
    }
}

class MyProxy implements MethodInterceptor {

    /**
     * 真实对象
     */
    private Object target;

    public MyProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        return method.invoke(this.target, args);
    }
}

/**
 * @author guobing
 * @Title: TestDemo
 * @ProjectName JavaTest
 * @Description: 基于CGLIB实现动态代理，基于类实现
 * @date 2019/3/22下午4:00
 */
public class TestDemo {

    public static void main(String[] args) {
        Message msg = new Message();
        // 代理处理类
        Enhancer enhancer = new Enhancer();
        // 把本类的类型作为描述
        enhancer.setSuperclass(msg.getClass());
        enhancer.setCallback(new MyProxy(msg));
        Message temp = (Message) enhancer.create();
        temp.send();
    }
}
