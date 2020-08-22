package cn.tedu.interview.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyFactory {
    public static void main(String[] args) {
        //创建目标对象
        Login login=new Login();
        //创建增强对象--传入目标对象
        LoginHandler handler=new LoginHandler(login);
        //通过cglib的api来创建代理对象
        //(Class type,传入目标对象的类型
        //callback 传入目标对象)
        login= (Login) Enhancer.create(login.getClass(),
                        handler);
        //通过代理对象调用目标方法
        login.login();
        System.err.println(login.getClass());

    }
}
