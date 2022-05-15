import com.mapper.UserMapper;
import com.mapper.UserMapperIml2;
import com.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


/**
 * @author lqw
 * @date 2021/10/27-9:20 обнГ
 */
public class Mytest {

    @Test
    public void test01() throws IOException {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = context.getBean("userMapper2", UserMapperIml2.class);

        for (User user : userMapper.selectUser()) {

            System.out.println(user);

        }


    }
}