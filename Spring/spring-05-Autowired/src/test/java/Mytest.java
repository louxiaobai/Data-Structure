import com.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lqw
 * @date 2021/10/20-9:00 обнГ
 */
public class Mytest {

    @Test
    public void  test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        People people = context.getBean("people", People.class);

        people.getCat().show();
        people.getDog().show();



    }
}