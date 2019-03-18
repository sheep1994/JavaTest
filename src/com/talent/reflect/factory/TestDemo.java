package com.talent.reflect.factory;

/**
 * 水果接口
 */
interface Fruit {
    void eat();
}

/**
 * 苹果实现类
 */
class Apple implements Fruit {

    @Override
    public void eat() {
        System.out.println("【Apple】吃苹果");
    }

}

class Factory {
    private Factory() {}
    public static <T> T getInstance(String className) throws Exception {
        T obj = null;
        obj = (T) Class.forName(className).newInstance();
        return obj;
    }
}

/**
 * @author guobing
 * @Title: TestDemo
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18下午3:49
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        Fruit fruit = Factory.getInstance("com.talent.reflect.factory.Apple");
        fruit.eat();
    }
}
