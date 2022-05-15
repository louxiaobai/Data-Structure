import com.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lqw
 * @date 2021/10/25-8:12 обнГ
 */
public class MyTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = context.getBean("user", User.class);

        System.out.println(user.name);
    }
}