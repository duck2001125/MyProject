package cn.tedu.interview.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**增强处理类
 * 该类用于login方法增强处理
 * MethodInterceptor:对方法进行拦截的接口
 * cglib是通过对方法进行拦截的方式来增强方法代码的
 */
public class LoginHandler implements MethodInterceptor {
    private Object target;
    public LoginHandler(Object target){
        this.target=target;
    }
    /**
     *
     * @param o             目标对象
     * @param method        增强方法
     * @param objects        方法参数
     * @param methodProxy   增强后的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o,
                            Method method,
                            Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        //获取当前时间
        long beforeTime=System.currentTimeMillis();
        System.out.println("前置增强");
        /**
         * 执行目标方法
         * invoke(Object targer,Object..args)
         */
        Object returnVal=method.invoke(target,objects);
        //获取当前时间
        long afterTime=System.currentTimeMillis();
        System.out.println("后置增强");
        //获取耗时
        long time=afterTime-beforeTime;
        System.out.println("耗时: "+time);
        return returnVal;
    }
}
