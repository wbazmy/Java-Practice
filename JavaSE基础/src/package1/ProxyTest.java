package package1;

import javax.print.attribute.HashDocAttributeSet;
import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Zhang Yang
 * @description 动态代理示例
 * @date 2021/10/10 - 19:51
 */
public class ProxyTest {
    public static void main(String[] args) {
        Human human=new Superman();
        Human proxyInstance= (Human) ProxyFactory.getProxyInstance(human);
        //代理类对象
        proxyInstance.getEducation("Phd");
        proxyInstance.getPower(10000);
        //当通过代理类对象调用方法时，会自动的调用被代理类中的同名方法
    }

}

interface Human{
    void getEducation(String g);
    void getPower(int i);
}

class Superman implements Human{ //被代理类

    @Override
    public void getEducation(String g) {
        System.out.println("My education background is "+g);
    }

    @Override
    public void getPower(int i) {
        System.out.println("My power is "+i);
    }
}

class ProxyFactory{
    //调用此方法，返回一个代理类对象
    public static Object getProxyInstance(Object obj){ //obj:被代理类的对象
        MyInvocationHandler handler=new MyInvocationHandler(obj);
       return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj; //被代理类对象

    public MyInvocationHandler(Object obj){
        this.obj=obj;
    }

    @Override
    //当通过代理类对象调用方法a时会自动调用invoke方法
    //将被代理类要执行的方法a的功能声明在invoke()中
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类要调用的方法
        //obj:被代理类对象
        System.out.println("代理类正在调用");
        Object Value=method.invoke(obj,args); //要调用的被代理类的方法的返回值
        return Value;

    }
}