package Single;

/**
 * @author lqw
 * @date 2022/3/13-3:03 下午
 */
public class SIngletonPattern {

}


class Singleton{//饿汉式单例模式

    public static Singleton singleton=new Singleton();//在类加载的时候立马进行实例化

    private Singleton(){}

    public static Singleton getInstance(){

        return singleton;
    }

}


class Singleton2{//懒汉式实例化


    private static Singleton2 singleton2;

    private Singleton2(){}

    //加锁的目的防止多线程下 singleton2 同步实现多次
    public synchronized static Singleton2 getSingleton2(){

        if (singleton2==null) new Singleton2();

        return singleton2;


    }

}


class Singleton3{//双重检查锁

    private  volatile static Singleton3 singleton3;

    private Singleton3(){}

    public  static synchronized Singleton3 getInstance(){

        if (singleton3==null){

            synchronized (Singleton3.class){

                if (singleton3==null){

                    singleton3=new Singleton3();

                }
            }
        }
        return singleton3;
    }

}