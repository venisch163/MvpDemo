#dagger2

依赖对象 A
注入对象 B
B 中包含 A 的实例

dagger2 api
@Module
@Component
@Subcomponent
@Providers
@MapKey

JSR 330 api
@Inject
@Scope
@Qalifer

@inject : 标注依赖对象的构造方法等
@Component : 连接依赖对象与注入对象
@Module ： 通过@Providers

#### 普通的提供方式  

1，构造方法添加注解@Inject来申明被依赖对象 A,
2，通过@component注解申明要注入对象 B 
3，build代码生成Dagger+注入对象，并在需要注入对象B的类中申明
4，使用@Inject 引入非私有的依赖对象

public class A{
    // 最多一个带Inject的构造方法
    @Inject
    public A{}
}

@Component
public interface BComponent{
    void inject(XXActivity)
}

public class B{
    @Inject
    A a;

    public void inject(){
        DaggerBComponent.Builder().build().inject(this);
    }
    // 带参数时
    public void inject(){
            DaggerBComponent.Builder().build().inject(this);
        }
}



#### 使用Module提供
运用场景：依赖对象A构造方法不能添加@Inject注解

@Module
public class BModule{
    @Providers
    public A providerA(){
        return new A();
    }
} 

@Component(module = BModule.class)
public interface BComponent{
    void inject(B b);
}

依赖已有的组建,需要已有的component主动提供出来
@Component(dependencies = DComponent.class)
public interface CComponent{
    void inject(C c)
}

@Component(module = BModule.class)
public interface DComponent{
    void inject(D b);
    A providerA();
}

继承已有的组建,

方式一：不需要和依赖一样主动提供，只需将子组建提供出来
这种方式会忽略子component的构造方法
@Component(module = BModule.class)
public interface DComponent{
    void inject(D b);
    EComponent eComponent();
}

@Subcomponent
public interface EComponent{
    void inject(E e) 
}



方式二：调用子component的构造方法,创建builder，在父组建中申明，子组建中添加module关系并重写builder
@Component(module = BModule.class)
public interface DComponent{
    void inject(D b);
    EComponent.EBuilder eBuilder();
}


@Subcomponent(module = CModule.class)
public interface EComponent{
    void inject(E e) 
    
    @Subcomponent.Builder
    public interface EBuilder{
        EBuilder EBuilderModule(CModule cModule);
        EComponent build();
    }
}

@Singleton 单列-scope作用域
@Inject 与 @Component 需要同时添加
@Inject 与 @Module中的@Provides 需要同时添加

总结：
1，Module并不是必须的，Component是必须的
2，编译后生成的Component实现类的名称是Dagger+我们所定义的Component接口的名称。
3、Dagger2的依赖注入思想重在理解

名称定义规范
1、定义的Component和Module的名字是无所谓的，但是一般遵照以Component或Module结尾的名称；

2、Module中用@Provides标注的方法的方法名是无所谓的，返回值是最重要的，但是一般遵照以provide开头的方法名；

3、Component中返回值为void且有参的方法，方法名是无所谓的，参数是最重要的代表的是要注入的目标位置，但是方法名一般为inject；

4、Component中返回值不为void且无参的方法，方法名是无所谓的，返回值是最重要的代表的是暴露给子Component使用的依赖或者是获取的子Component的类型。

扩展的dagger.android最新api
dagger.android使用总结：

1、在AppComponent中将dagger2库里的AndroidInjectionModule注入到Application中，并将Application实现相应的接口（例如：HasActivityInjector、HasFragmentInjector、HasServiceInjector、HasBroadcastReceiverInjector等等很多），并返回相应的方法，返回值参照以上App中的方式；

2、子Component继承AndroidInjector，内部的Builder使用抽象类并继承AndroidInjector.Builder；

3、父Module使用@Module(subcomponents={})的方式关联子Component，并在父Module中编写返回值为AndroidInjector.Factory、参数为子Component.Builder的抽象方法（如果有其他被@Provides标注的方法，应将方法改为static，否则报错）；

4、最后在Acitivity的onCreate()中第一行代码的位置使用AndroidInjection注入，如果是Fragment则是在onAttach()方法中，其他的请自行查阅。

5、dagger.android库也提供了其他实现方式，诸如DaggerApplication、DaggerActivity、DaggerFragment、DaggerService、DaggerBroadcastReceiver等实现类，有兴趣的小伙伴自己研究一下吧。


参考链接：https://www.jianshu.com/p/22c397354997