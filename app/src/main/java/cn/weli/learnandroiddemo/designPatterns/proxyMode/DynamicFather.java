package cn.weli.learnandroiddemo.designPatterns.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Grekit
 * @description
 * @date
 */
public class DynamicFather implements InvocationHandler {

    private Person person;

    public Object getInstance(Person person){
        this.person = person;
        Class<? extends Person> clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("打印前...");
        method.invoke(person,args);
        System.out.println("打印后...");

        return null;
    }
}
