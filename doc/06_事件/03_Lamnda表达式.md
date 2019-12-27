# [lambda表达式](https://blog.csdn.net/a13935302660/article/details/96437703)

### lambda介绍

- 匿名：没有一个确定的名称
- 函数：lambda不属于一个特定的类，但是却有参数列表、函数主体、返回类型、异常列表
- 传递：可以作为参数传递给方法、或者存储在变量中
- 简洁：不需要写很多模板代码

##### 基本语法

```
(parameters) -> expression
(parameters) -> (statements)
```

```java
根据上述语法规则，以下哪个不是有效的Lambda表达式？
(1) () -> {}
(2) () -> "Raoul"
(3) () -> {return "Mario";}
(4) (Integer i) -> return "Alan" + i;
(5) (String s) -> {"IronMan";}
答案：只有4和5是无效的Lambda。
(1) 这个Lambda没有参数，并返回void。 它类似于主体为空的方法： public void run() {}。
(2) 这个Lambda没有参数，并返回String作为表达式。
(3) 这个Lambda没有参数，并返回String（利用显式返回语句）。
(4) return是一个控制流语句。要使此Lambda有效，需要使花括号，如下所示：
(Integer i) -> {return "Alan" + i;}。
(5)“Iron Man”是一个表达式，不是一个语句。要使此Lambda有效，你可以去除花括号
和分号，如下所示： (String s) -> "Iron Man"。或者如果你喜欢，可以使用显式返回语
句，如下所示： (String s)->{return "IronMan";}
```

### 哪里使用lambda

- 你可以在函数式接口上使用Lambda表达式
- 函数式接口就是只定义一个抽象方法的接口。你已经知道了Java API中的一些
  其他函数式接口，如我们在第2章中谈到的Comparator和Runnable。

```java
下面哪些接口是函数式接口？
public interface Adder{
int add(int a, int b);
}
public interface SmartAdder extends Adder{
int add(double a, double b);
}
public interface Nothing{
}
答案：只有Adder是函数式接口。
SmartAdder不是函数式接口，因为它定义了两个叫作add的抽象方法（其中一个是从Adder那里继承来的）。
Nothing也不是函数式接口，因为它没有声明抽象方法。
```

