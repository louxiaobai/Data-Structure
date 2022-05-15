import com.pojo.Student;
import com.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lqw
 * @date 2021/10/18-9:10 ÏÂÎç
 */
public class MyTest {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml");

        Student student = (Student)context.getBean("student");
        System.out.println(student);

    }
    @Test
    public void userTest(){

        ApplicationContext context = new ClassPathXmlApplicationContext("userbean.xml");

        final User user = context.getBean("user", User.class);

        System.out.println(user);

    }


}