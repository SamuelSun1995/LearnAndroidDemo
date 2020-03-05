package cn.weli.learnandroiddemo.designPatterns.proxyMode;

/**
 * @author Grekit
 * @description
 * @date 2020/01/02
 */
public class Son implements Person {
    @Override
    public void findLover() {
        System.out.println("儿子要求...");
    }
}
