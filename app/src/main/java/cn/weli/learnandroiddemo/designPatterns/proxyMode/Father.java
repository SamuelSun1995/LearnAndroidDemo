package cn.weli.learnandroiddemo.designPatterns.proxyMode;

/**
 * @author Grekit
 * @description
 * @date
 */
public class Father implements Person{

    private Person person = null;
    public Father(Person person){
        this.person = person;
    }

    @Override
    public void findLover() {
        System.out.println("父母物色对象...");
        this.person.findLover();
        System.out.println("双方同意！");
    }

}
