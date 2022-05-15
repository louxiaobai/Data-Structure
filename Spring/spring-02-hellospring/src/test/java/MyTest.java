import com.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lqw
 * @date 2021/10/14-8:19 下午
 */
public class MyTest {

    public static void main(String[] args) {

        //获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象现在都在Spring中进行管理了,我们要使用,直接去里面取就可以了

        Hello hello = (Hello) context.getBean("hello");

        System.out.println(hello.toString());


    }
}