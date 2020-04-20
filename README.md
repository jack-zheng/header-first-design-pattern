# header-first-design-patter

设计模式读书笔记 - [豆瓣链接](https://book.douban.com/subject/2243615/)

设计理念 - design principle

1. 将改变和不变的部分分开。 Identify the aspects of your application that vary and separate them from what stays the same.
1. 面向接口编程，而非实现。 Program to an interface, not an implementation.
1. 更多的组合模式，更少的继承。 Favor composition over inheritance.
1. 最小单元。Principle of Least Knowledge - talk only to your immediate friends.

## Chapter01 策略模式 - Strategy pattern

> **The Strategy Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable.
> Strategy lets the algorithm vary independently from clients that use it.
>
> 定义一簇算法，封装之。在使用时，根据不同场景，只需要改变算法即可完成功能，保持其他部分不变。

从设计一个鸭子类引出这种设计模式

* v1 版本，通过在父类中添加 fly 方法，但是这回要求你在每一个特殊的子类中添加 fly 的实现，比如橡皮鸭子
* v2 版本，通过 将 fly 和 quack 通过 interface 抽离，具体的实例类通过实现这些接口来达到解耦，但是每个实体类都需要实现这两个接口，增加了代码冗余

## Chapter07 适配器和外观模式 - Adaptor & Facade pattern

> **The Adapter Pattern** converts the interface of a class into another interface the clients expected.
> Adapter lets classes work together that couldn't otherwise because of incompatible interface.
>
> 转换接口使得兼容客户端使用

从鸭子类的设计引出，现在鸭子类不够了，想要使用一个火鸡类来伪装成鸭子类，我们可以怎么做？

通过一个适配器类作为两个类的转化工具，在 client 调用过过程中，通过接口的方式来隐藏火鸡的实现

还有一个例子是怎么通过添加 adaptor 是的客户端可以通过 iterator 接口操作老得 enumeration 类，也挺有意思的

    对象适配器和类适配器，由于类适配器需要从两个类继承，Java 语法层面是做不到的，我就没有深入了

> **The Facade Pattern** provides a unified interface to a set of interfaces in a subsystem.
> Facade defines a higher-level interface that makes the subsystem easier to use.
>
> 该模式通过提供一个简单接接口来使客户端和系统隔离，达到简化使用的目的

通过家庭影院的管理来引出这一概念。

Adapter 和 Facade 的区别并不是管理 class 的多少，而是意图。Adaptor 是用来实现 interface 转化，来兼容客户端的使用，而 Facade 是用来简化客户端的使用，个人感觉更像是 Util 一般的东西。


