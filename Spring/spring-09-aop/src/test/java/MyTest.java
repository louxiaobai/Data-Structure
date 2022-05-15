import com.service.UserService;
import com.service.UserServiceImp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lqw
 * @date 2021/10/26-8:34 ����
 */
public class MyTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContex.xml");
        //��̬���������ǽӿ�
        UserService userService = context.getBean("userService", UserService.class);
        userService.delete();
    }
}