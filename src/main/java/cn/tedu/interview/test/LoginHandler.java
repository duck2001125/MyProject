package cn.tedu.interview.test;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LoginHandler implements MethodInterceptor {
    private Object target;
    public LoginHandler(Object target){
        this.target=target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long beforeTime=System.currentTimeMillis();
        System.out.println("前置增强");
        //是对对象里边全部方法进行增强
        Object returnVal=method.invoke(target,objects);
        long afterTime=System.currentTimeMillis();
        System.out.println("后置增强");

        return returnVal;
    }
}
