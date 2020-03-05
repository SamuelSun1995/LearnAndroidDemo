package cn.weli.learnandroiddemo.designPatterns;

import cn.weli.learnandroiddemo.designPatterns.proxyMode.Daughter;
import cn.weli.learnandroiddemo.designPatterns.proxyMode.DynamicFather;
import cn.weli.learnandroiddemo.designPatterns.proxyMode.Father;
import cn.weli.learnandroiddemo.designPatterns.proxyMode.Person;
import cn.weli.learnandroiddemo.designPatterns.proxyMode.Son;

/**
 * @author Grekit
 * @description
 * @date
 */
public class TestProxy {

    public static void main(String[] args) {
//        Father father = new Father(new Daughter());
//        father.findLover();


        Person person = (Person) new DynamicFather().getInstance(new Son());
        person.findLover();

    }
}
