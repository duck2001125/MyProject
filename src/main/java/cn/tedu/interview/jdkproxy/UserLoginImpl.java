package cn.tedu.interview.jdkproxy;

public class UserLoginImpl implements UserLogin{

    @Override
    public void login() {
        //登录操作的业务代码
        System.out.println("用户登录...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
