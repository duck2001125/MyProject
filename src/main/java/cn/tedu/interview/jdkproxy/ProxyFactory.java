package cn.tedu.interview.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * 针对某个目标对象生成代理对象
 *
 * 目标对象-通过增强变成增强类对象,输出的方法变为增强后方法
 */
public class ProxyFactory {
    public static void main(String[] args) {
        //创建目标对象
        UserLogin userLogin=new UserLoginImpl();
        //创建增强类对象
        LoginHandler handler=new LoginHandler(userLogin);
        //生成代理对象--JDK的api
        /**
         * 传3个参数,以第一个获得目标对象的类加载器,
         * 第二个获得对象的接口,
         * 第三个是增强类对象
         */
        userLogin=(UserLogin)Proxy.newProxyInstance(userLogin.getClass().getClassLoader(),
                                userLogin.getClass().getInterfaces(),
                                handler);

        //通过代理对象调用目标方法,调用到的是增强后的方法代码
        userLogin.login();
        System.err.println(userLogin.getClass());
    }
}
