import com.config.Config;
import com.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lqw
 * @date 2021/10/25-8:35 ����
 */
public class MyTest {


    public static void main(String[] args) {

        //�����ȫʹ���������෽ʽȥ��,����ֻ��ͨ��AnnotationConfig������ ����ȡ����,ͨ���������class������м���
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        User getUser = context.getBean("myService", User.class);

        System.out.println(getUser.getName());
    }
}