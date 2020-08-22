package cn.tedu.interview.test;

import cn.tedu.interview.cglibproxy.Login;
import net.sf.cglib.proxy.Enhancer;

public class CglibProxyFactory {
    public static void main(String[] args) {
        login login=new login();
        LoginHandler loginHandler=new LoginHandler(login);
        login= (cn.tedu.interview.test.login) Enhancer.create(login.getClass(),loginHandler);
        login.login();
        System.out.println(login.getClass());
    }


}
