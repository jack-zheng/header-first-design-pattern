# header-first-design-patter

设计模式读书笔记 - [豆瓣链接](https://book.douban.com/subject/2243615/)

## Chapter01 策略模式 - Strategy pattern

> **The Strategy Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable.
> Strategy lets the algorithm vary independently from clients that use it.
>
> 定义一簇算法，封装之。在使用时，根据不同场景，只需要改变算法即可完成功能，保持其他部分不变。

从设计一个鸭子类引出这种设计模式

* v1 版本，通过在父类中添加 fly 方法，但是这回要求你在每一个特殊的子类中添加 fly 的实现，比如橡皮鸭子
* v2 版本，通过 将 fly 和 quack 通过 interface 抽离，具体的实例类通过实现这些接口来达到解耦，但是每个实体类都需要实现这两个接口，增加了代码冗余

设计规则 - design principle

1. 将改变和不变的部分分开。 Identify the aspects of your application that vary and separate them from what stays the same.
1. 面向接口编程，而非实现。 Program to an interface, not an implementation.
1. 更多的组合模式，更少的继承。 Favor composition over inheritance.