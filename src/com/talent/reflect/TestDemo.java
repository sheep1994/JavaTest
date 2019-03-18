package com.talent.reflect;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义的的类，这个类一定在CLASSPATH之中
 */
class MyClassLoader extends ClassLoader {

    /**
     * 实现一个自定义的类加载器的操作，传入类的名称，要通过指定的文件路径加载
     * @param className
     * @return
     * @throws Exception
     */
    public Class<?> loadData(String className) throws Exception {
        byte[] bytes = this.loadClassData();
        return super.defineClass(className, bytes, 0, bytes.length);
    }

    /**
     * 通过指定的问题件路径进行类的文件加载，就是进行二进制读取
     * @return
     * @throws Exception
     */
    private byte[] loadClassData() throws Exception {
        String property = System.getProperty("user.home");
        InputStream input = new FileInputStream(new File(property + File.separator + "temp" + File.separator + "imooc" + File.separator + "Member.class"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[20];
        int temp = 0;
        while( (temp = input.read(data)) != -1) {
            bos.write(data, 0 ,temp);
        }
        byte[] ret = bos.toByteArray();
        input.close();;
        bos.close();
        return ret;
    }

}
/**
 * @author guobing
 * @Title: TestDemo
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18上午11:15
 */
public class TestDemo {

    public static void main(String[] args) throws Exception {
        Class<?> cls = new MyClassLoader().loadData("com.talent.vo.Member");
        System.out.println(cls.newInstance());
    }
}
