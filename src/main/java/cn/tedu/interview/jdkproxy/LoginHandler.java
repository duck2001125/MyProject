package cn.tedu.interview.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 演示JDK动态代理,,对目标方法login进行增强
 * LoginHandler是增强类(保存的是如何对目标代码进行增强)
 * 实现jdk反射包下的InvocationHandler
 * InvocationHandler: 表示对某方法进行增强处理
 */
public class LoginHandler implements InvocationHandler {
    private Object targer;//目标对象

    public LoginHandler(Object targer){
        this.targer=targer;
    }

    /**对目标方法的性能统计
     *
     * @param proxy 代理对象
     * @param method 目标方法
     * @param args  代理对象参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取当前时间
        Long beforeTime=System.currentTimeMillis();
        System.out.println("前置增强");
        /**
         * 让目标方法执行,invoke方法需要2个参数
         * Object obj:该方法所属的目标对象
         * Object..args:该方法的参数列表
         */
        Object returnVal=method.invoke(targer,args);
        //结束计时
        Long afterTime=System.currentTimeMillis();
        System.out.println("后置增强");
        Long time=afterTime-beforeTime;
        System.out.println("该操作耗时: "+time+"毫秒");
        return returnVal;
    }
}
