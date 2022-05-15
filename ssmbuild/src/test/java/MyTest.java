import com.pojo.Books;
import com.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lqw
 * @date 2021/11/10-10:50 上午
 */
public class MyTest {

    @Test
    public void test(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookServiceImp = (BookService)context.getBean("BookServiceImp");

        for (Books books : bookServiceImp.queryAllBook()) {

            System.out.println(books);

        }

    }


}