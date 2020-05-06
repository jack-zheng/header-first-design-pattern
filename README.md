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
1. 别调用我，我来调用你。The Holly wood principle, Don't call us, I'll call you.
1. A class should have only one reason to change.

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

## Chapter05 单例模式 - Singleton pattern

> **The Singleton Factory Pattern** ensure a class has only one instance, and provides a global point of access to it.
>

静态变量 + 静态方法 + 私有构造函数

`public static synchronized Singleton getInstance()` 这种解决方案开销挺大的，就实际使用情况来说，我们就一开始使用的时候需要用到这个关键字，一旦初始化成功，后续的使用其实不需要这个下限制。

解决方案：

1. 如果没什么性能缺陷的话，无视他。这种写法很直截了当，而且有效。性能降低大概 100 倍，重度使用时注意一下。
2. 通过主动 new 来绕过这个缺陷，通过 JVM 机制确保只有一个对象实例化。
3. 通过双重检查锁(double-check locking)达到只在第一次初始化的时候上锁。使用 volatile 和 synchronized 关键字。这种机制 java 1.4 之前是不 work 的。

## Chapter06 命令模式 - Command pattern

> **The Command Pattern** encapsulate a request as an object, thereby let you parameterize other objects with different requests,
> queue or log requests, and support undoable operations.
>

这种通过 command 封装处理对象，然后处理的模式在一些队列，log 之类的应用的也很广泛

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

## Chapter08 模版方法模式 - Template method pattern

> **The Template Method Pattern** defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
> Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
>
> 将处理过程抽象，子类中分别实现有差异的方法，感觉是一个很常见的处理方式

通过一个整合咖啡因饮料的例子引出定义

方法用 final 修饰, 使用 hook 方法是的方法体具有扩展性

通过 JDK 中 Arrays 中对 sort 的实现进一步说明该 API 的使用方法

## Chapter09 迭代器和混合模式 - Iterator & Composite pattern

> **The Iterator Pattern** provides a way to access the element of an aggregate object sequentially without exposing it's underlying representation.
>
> 提供一种在不暴露底层实现的情况下，顺序访问元素的接口

> **The Composite Pattern** allows you to compose object into tree structure to present part-whole hierarchies.
> Composite let client treat individual objects and compositions of objects uniformly.
> 
> 提供一种遍历树形接口的对象的方法

用餐厅和并的例子来引出主题

Java 1.5 提供了 for/in 的语法支持

Composite 对象实现 Iterator 的时候，使用 NullIterator 这种方式可以使得代码更优雅， NullIterator 就是 hasNext 都会返回 false。

混合模式中通过 stack 这种数据结构实现了 iterator 的管理，很巧妙，暂时理解的不是很到位，等全部看完了再复习一下。

使用 `instanceof` 这种语法其实已经使得你的代码在面向实现编程了，不是很可取

## Chapter10 状态模式 - State pattern

> **The State Pattern** allows an object to alter it's behavior and it's internal state changes.
> The object will appear to change it's class.
> 
> 提供一种遍历树形接口的对象的方法

从糖果机的实现来引出主题

细看才发现，这个状态机的实现里面，状态变量和外部的实体是互相包裹的关系。。。有点意思，很少见。状态根据对象内部 context 改变。

## Chapter11 代理模式 - Proxy pattern

> **The Proxy Pattern** provides a surrogate or placeholder for another object to control access to it.
> 

* remote proxy controls access to a remote object
* proxy controls access to a resource that is expensive to create
* protection proxy controls access to a resource based on access rights

从远程控制糖果机引出主题, 通过使用 RMI 实现这个设想

How to make a remote service

1. make a remote interface
1. make a remote implementation
1. generate the stubs and skeletons using rmic
1. start the rmi registry
1. start the remote service

以上代码案例存储在 `rmisample` 文件夹中，实现方式和书本上的略有出入，当 idea 编译完成时，在 target 文件夹下会出现目标 .class 文件。

1. 右键 target 下的 classes 文件夹， open in terminal, 输入命令 `start rmiregistry` 启动服务
1. 重复以上打开终端操作，运行命令 `java chapter11.rmisample.MyRemoteImpl` 启动服务端程序, 也可以直接右键运行类文件
1. 重复以上打开终端操作，运行命令 `java chapter11.rmisample.Client` 运行客户端程序，得到结果，也可以直接右键运行该类文件

Virtual Proxy: it acts as a representative for an object that may be expensive to create. it acts as a surrogate for the object before and while it is being created.
After that, the proxy delegates requests directly to the RealSubject.

本章节算然介绍了两种 proxy, 但是他们的实现都是 JDK 自带我，学习过程中我最多只是了解了一下这种模式的存在和使用了一下现成的 API 而已。

java 的 reflect 包有提供 dynamic proxy 的支持。可以使用它来实现一个访问控制的 proxy.

## Chapter12 混合模式 - Compound pattern

> **The Compound Pattern** A Compound pattern combines two or more patterns into a solution that solves a recurring or general problems.
> 

到观察者模式实践的时候，我就跟不上了，对这个模式还是不熟悉。。。

通过混合模式引出 MVC