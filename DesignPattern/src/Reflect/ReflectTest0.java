package Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**java.lang.Class:
 * @author lqw
 * @date 2022/3/23-9:31 上午
 */
public class ReflectTest0 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

//        *************************************************************************************

        Class<?> c = Class.forName("Reflect.User");//需要完整类名带包名字

        Object o = c.newInstance();//调用无参构造方法



//        *************************************************************************************


//        *************************************************************************************

        //获取到类的属性

//        Field[] Fields = c.getDeclaredFields();//获取到该类的全部属性名字
//
//        for (Field field : Fields) {
//
//            System.out.println(field.getName());//获取到属性的 name
//
//            System.out.println(field.getType().getSimpleName());//获取到属性的类型
//
//        }

//        *************************************************************************************

//        *************************************************************************************

        //使用反射给属性赋值--不能给私有属性进行赋值
        //但是反射可以打破封装--但是打破封装可能会给不法份子留下犯罪的机会
//        Field no = c.getDeclaredField("no");
//
//        no.set(o,111);
//
//        System.out.println(no.get(o));
//
//        Field name = c.getDeclaredField("name");
//
//        //通过反射这样设置后,在外部也是可以访问privat的
//        name.setAccessible(true);
//
//        name.set(o, "小明");
//
//        System.out.println(name.get(o));

//        *************************************************************************************

        //使用反射对对象的方法进行操作

        Method[] Methods = c.getDeclaredMethods();//获取到类的全部的方法也包括私有的


        for (Method method : Methods) {

            System.out.println(method.getName());//获取到方法的名字

            System.out.println(method.getReturnType().getSimpleName());//获取到返回值类型



        }



    }

}