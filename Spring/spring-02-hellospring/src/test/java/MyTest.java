import com.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lqw
 * @date 2021/10/14-8:19 ����
 */
public class MyTest {

    public static void main(String[] args) {

        //��ȡSpring�������Ķ���
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //���ǵĶ������ڶ���Spring�н��й�����,����Ҫʹ��,ֱ��ȥ����ȡ�Ϳ�����

        Hello hello = (Hello) context.getBean("hello");

        System.out.println(hello.toString());


    }
}