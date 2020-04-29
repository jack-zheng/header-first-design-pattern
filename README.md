# header-first-design-patter

设计模式读书笔记 - [豆瓣链接](https://book.douban.com/subject/2243615/)

设计规范 - design principle

1. 将改变和不变的部分分开。 Identify the aspects of your application that vary and separate them from what stays the same.
1. 面向接口编程，而非实现。 Program to an interface, not an implementation.
1. 更多的组合模式，更少的继承。 Favor composition over inheritance.
1. 处理相互作用的对象时，尽量使用松耦合的关联方式。 Strive for loosely coupled designs between objects that interact.
1. 高可扩展，而不是改动改动。 Classes should be open for extension, but closed for modification.
1. 面向接口，而非实现， 他有一个更有名的叫法，依赖反转。Depend upon abstractions. Do not depend upon concrete classes.
1. 最小单元。Principle of Least Knowledge - talk only to your immediate friends.

## Chapter01 策略模式 - Strategy pattern

> **The Strategy Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable.
> Strategy lets the algorithm vary independently from clients that use it.
>
> 定义一簇算法，封装之。在使用时，根据不同场景，只需要改变算法即可完成功能，保持其他部分不变。

从设计一个鸭子类引出这种设计模式

* v1 版本，通过在父类中添加 fly 方法，但是这回要求你在每一个特殊的子类中添加 fly 的实现，比如橡皮鸭子
* v2 版本，通过 将 fly 和 quack 通过 interface 抽离，具体的实例类通过实现这些接口来达到解耦，但是每个实体类都需要实现这两个接口，增加了代码冗余

## Chapter02 观察者模式 - Observer pattern

it is one of the most heavily used pattern in the JDK. 实现的关键点：Observable 持有一个列表变量存储注册的 Observer，Observer 实例化的时候传入 Observable 对象，调用 register 方法完成注册。
在 Observable 对象状态改变时，轮询 Observer 列表更新状态。

通过 Observer 持有 Observable 的引用，使得 **un-register** 也成为了可能

Swing, JavaBeans 也大量使用了该模式。

> **The Observer Pattern** defines a one-to-many dependency between objects so that when one object changes state, all of it's dependents are notified and updated automatically.
>
> 定义一组**一对多**的关系列表，当一的这方状态改变，多的那一方会被通知到，并作出必要的反映

这是一种松耦合(loosely coupled)的设计模式, 这种模式能尽量减少类之间的依赖。

作者通过一个气象站的例子引出场景，假设你希望气象站的数据在所有终端上得以实现，你会怎么做？自己动手实现一个观察者模式，或者使用 Java 自带的观察者模式。

self implement observer VS build-in observer

1. Observable 通过抽象类实现，不如 interface 实现解藕性好，不过由于一些历史原因，现在应该已经不可能做 Observable 的重构了
1. 只能通过继承 Observable class 实现自带的观察者模式，限制了使用，Java 不能双继承
1. Observable 中的 setChanged() 是 protected 的，也就是说，除非你继承他，不然你就不能使用他，不能通过组合模式去使用。和设计规范冲突。
1. update(obs, arg) 这个参数列表给 Observers 提供了一种**拉**数据的可能性，按照之前自己实现的那种方式，只能实现 push 的方式。

关于最后一点，书中是有提到的。如果你想要实现消息的 pull 模式，即由 Observer 决定想要提取哪些数据，可以通过 obs 提供属性的 getter 方法，然后在 update 方法中调用 getter 实现。
如果是想要 push 模式，可以通过将 attribute 通过 arg 传入。不过就是绕了一个弯而已，反正有了 obs，还有什么属性是你拿不到的？

## Chapter03 装饰模式 - Decorator pattern

> **The Decorator Pattern** attaches additional responsibilities to an object dynamically. 
> Decorators provide a flexible alternative to subclassing for extending functionality.
>
> 给对象提供额外功能，扩展很方便

Rely on inheritance, our behavior can only be determined statically at compile time. In other words, we get only whatever behavior the superclass give us or that we override.
With composition, we can mix and match decorators any way we like at runtime. 

这种模式的一个弊端是可能会有很多小类产生，装饰类

通过 YY 一个星爸爸项目引出问题，在后期还简要介绍了一下 java 自带的 I/O 的情况，这套 API 是一个典型的装饰模式使用案例。

实现要点：一个基抽象类，衍生出一批基底类，和一个装饰类的基类。基底类类似最原始的成分，类似鸡尾酒里的基酒，装饰基类衍生出装饰类来增加基类功能，类似鸡尾酒中的其他调和酒。

### 一些 Java IO 的调查

1. IO 中 stream 是万金油，所有的文件操作都可以用，reader/writer 是专门用来做字符操作的，也就是说如果你是要读取文字内容什么的用 reader/writer 之类的要更高效
1. Buffered xx 这种 IO 类带缓存，可以加速处理速度

## Chapter04 工厂模式 - Factory pattern

> **The Factory Pattern** defines an interface for creating an object, but lets subclasses decide which class to instance.
> Factory Method lets a class defer instantiation to subclass.
>

简单工厂模式与其说是一种设计模式，倒不如说是一种编程习惯。

> **The Abstract Factory Pattern** provides an interface for creating families of related or dependent objects without specifying their concrete classes.
 >

In this pattern, we always say lets subclasses decide which class to instantiate. They say 'decides' not because the pattern allows subclasses themselves to decide at runtime,
but because the creator class is written without knowledge of the actual products that will be created, which is decided purely by the choice of the subclass that is used.

Always, the decision of which to instantiate is made at runtime depending on some set of conditions.

静态方法是不能被重写的

说白了还是一种将经常改变的部分封装起来的一种行为模式

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


