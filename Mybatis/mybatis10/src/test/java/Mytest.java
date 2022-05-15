import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author lqw
 * @date 2021/10/10-7:50 ÏÂÎç
 */
public class Mytest {

    @Test
    public void test(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUsers(2);

        System.out.println(user);

        System.out.println("====");
        User user2 = mapper.queryUsers(2);
        System.out.println(user2);

        System.out.println(user==user2 );
        sqlSession.close();


    }
}