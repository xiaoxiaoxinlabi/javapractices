//单例模式
//
//这两个名字很形象：饿汉主动找食物吃，懒汉躺在地上等着人喂。
//
//懒汉模式：如果单例初始值为null，还为构建，则构建单例对象并返回。
//饿汉模式：如果单例对象一开始就被 new Singleton() 主动构建，则不再需要判断空操作


//就是一个应用程序中，某个类的实例对象只有一个，你没有办法去new，因为构造器是被private修饰的，一般通过getInstance()的方法来获取它们的实例。
//确保一个类只有一个实例，并提供一个全局变量去访问它
//   1， Ensure a class has only one instance, and
//   2，provide a global point of access to it.（不安全）

//    Encapsulated "just-in-time initialization" or "initialization on first use".


//1，基本写法(懒汉式，线程不安全)

  //优点： 简单明了，使用了懒加载模式
//  缺点：当有多个线程并行调用 getInstance() 的时候，就会创建多个实例。也就是说在多线程下不能正常工作。

//public class Singleton {
//
//  private static Singleton singleton;
//
//  private Singleton(){
//
//  }
//
////  getInstance()的返回值是一个对象的引用，并不是一个新的实例
//  public static Singleton getInstance(){
//
//    if (singleton == null){
//      singleton = new Singleton();
//    }
//
//    return singleton;
//  }
//
//}



////2,懒汉式写法（线程安全）     内部类只在需要的时候才会被类加载器加载，实现了懒加载
//
//注意：为了代码1中的问题，最简单的方法是将整个 getInstance() 方法设为同步（synchronized）。

//优点：做到了线程安全，并解决了多实例的问题
//缺点：不高效，因为在任何时候只能有一个线程调用getinstance()方法，所以每次调用getinstance都需要进行同步，造成不必要的开销

//public class Singleton{
//
//  private  static Singleton instance;
//
//  private Singleton{
//
//  }
//
////  加锁
//  public static  synchronized  Singleton getInstance(){
//
//    if (instance == null){
//      instance = new Singleton();
//    }
//    return instance;
//
//  }
//}



////3,饿汉式写法（线程安全）

//    优点：代码简单，在类第一次加载时，就完成了初始化，所以类加载较慢，单获取对象的速度快； 基于类加载避免了多线程同步的问题
//    缺点： 不是懒加载模式，单例会在加载类后一开始就被初始化，及时客户端没有调用getinstance 方法，在一些场景中无法使用（singleton 实例的创建依赖于参数或配置文件，在getinstance 之前必须调用某个方法设置参数给它，此时就没法使用）

//    这种方式在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快。 这种方式基于类加载机制避免了多线程的同步问题，
//    但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance显然没有达到懒加载的效果。
//
//public class Singleton{
//
//        单例的实例被声明成static，final ，则在第一次加载类到内存中时，就会初始化
//  private static final  Singleton instance = new Singleton();
//
//  private Singleton(){}
//
//  public static  Singleton getInstance(){
//
//    return instance;
//  }
//}


////4,静态内部类写法

//优点：使用JVM本身即止保证了线程安全问题，由于SingleHolder 类是 private， 除了getInstance（） 之外没有办法访问它，因此是懒汉式的；同时读取实例的时候不会进行同步；没有性能缺陷，也不依赖JDK版本

//    第一次加载Singleton类时并不会初始化sInstance，只有第一次调用getInstance方法时虚拟机加载SingletonHolder 并初始化sInstance ，
//    这样不仅能确保线程安全也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式。
//
//
//    1.从外部无法访问静态内部类SingleHolder，只有当调用Singleton.getInstance方法的时候，才能得到单例对象INSTANCE。
//    2.INSTANCE对象初始化的时机并不是在单例类Singleton被加载的时候，而是在调用getInstance方法，使得静态内部类SingleHolderr被加载的时候。因此这种实现方式是利用classloader的加载机制来实现懒加载，并保证构建单例的线程安全。

//public class Singleton{
//
//  private static class SingleHolder{
//    private static final Singleton INSTANCE = new Singleton();
//  }
//
//  public Singleton(){}
//
//  public static final Singleton getInstance(){
//    return SingleHolder.INSTANCE;
//  }
//}


//5,枚举写法

//    它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊
//    不过，个人认为由于1.5中才加入enum特性，用这种方式写不免让人感觉生疏。

//访问方式：Singleton.INSTANCE

//public enum Singleton{
//
//  INSTANCE;
//  public void whateverMethod(){
//
//  }
//}


//6,双重校验锁：使用同步块加锁的方法

//优点：解决了不需要时时同步
//缺点：

//注意：为什么要检查两次 singleton == null
//        因为可能会有多个线程一起进入同步块外的if， 如果不在同步块内进行二次检查会生成多个实例

//   volatile :这里必须加，否则会出现JVM 指令重排现象； 保证了指令的执行顺序
//JVM 的执行顺序：
//    memory =allocate(); //1：分配对象的内存空间
//    ctorInstance(memory); //2：初始化对象
//    instance =memory; //3：设置instance指向刚分配的内存地址

//    但是这些指令顺序并非一成不变，有可能会经过JVM和CPU的优化，指令重排成下面的顺序：
//
//    memory =allocate(); //1：分配对象的内存空间
//    instance =memory; //3：设置instance指向刚分配的内存地址
//    ctorInstance(memory); //2：初始化对象




public class Singleton {

  private volatile static Singleton singleton;

  private Singleton(){}

  public static Singleton getInstance(){

//    同步块外检查
//    为了防止new Singleton被执行多次，因此在new操作之前加上Synchronized 同步锁，锁住整个类（注意，这里不能使用对象锁）。
    if (singleton == null){
      synchronized (Singleton.class){

//        同步块内检查
        if (singleton == null){

          singleton = new Singleton();
        }
      }
    }
    return singleton;
  }

}
