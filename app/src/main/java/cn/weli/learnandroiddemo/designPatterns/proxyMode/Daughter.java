package cn.weli.learnandroiddemo.designPatterns.proxyMode;

/**
 * @author Grekit
 * @description
 * @date
 */
public class Daughter implements Person{

    @Override
    public void findLover() {
        System.out.println("女儿的要求...");
    }
}
