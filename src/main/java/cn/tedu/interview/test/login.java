package cn.tedu.interview.test;

public class login {
    public void login(){
        System.out.println("用户登录..");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
