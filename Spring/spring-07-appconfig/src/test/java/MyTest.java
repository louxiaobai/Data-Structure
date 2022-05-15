import com.config.Config;
import com.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lqw
 * @date 2021/10/25-8:35 下午
 */
public class MyTest {


    public static void main(String[] args) {

        //如果完全使用了配置类方式去做,我们只能通过AnnotationConfig上下文 来获取容器,通过配置类的class对象进行加载
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        User getUser = context.getBean("myService", User.class);

        System.out.println(getUser.getName());
    }
}