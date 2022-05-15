import com.mapper.UserMapper;
import com.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lqw
 * @date 2021/11/2-7:42 обнГ
 */
public class Mytest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        for (User user : userMapper.selectUser()) {

            System.out.println(user);
        }
    }
}