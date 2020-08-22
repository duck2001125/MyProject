package cn.tedu.interview.cglibproxy;

/**
 * 目标对象,模拟登录操作
 */
public class Login {

    public void login(){
        System.out.println("用户登录...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
