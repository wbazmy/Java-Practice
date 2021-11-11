package package1;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author Zhang Yang
 * @description 静态代理示例
 * @date 2021/10/10 - 19:15
 */

interface RentHouse{
    void Rent();
}

//代理类
class Meditation implements RentHouse{
    private RentHouse Customer;

    public Meditation(RentHouse customer){
        this.Customer=customer;
    }

    @Override
    public void Rent() {
        System.out.println("正在寻找房子");
        Customer.Rent();
        System.out.println("签合同");
    }
}

//被代理类
class customer implements RentHouse{

    @Override
    public void Rent() {
        System.out.println("看房");
    }
}

public class StaticProxytest {
    public static void main(String[] args) {
        customer zy=new customer();
        Meditation m=new Meditation(zy);
        m.Rent();
    }
}