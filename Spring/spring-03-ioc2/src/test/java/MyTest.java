import com.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lqw
 * @date 2021/10/14-9:14 обнГ
 */
public class MyTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml");


        User user = (User) context.getBean("others");
        user.show();

    }
}