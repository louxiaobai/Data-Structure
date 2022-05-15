import com.dao.BlogMapper;
import com.pojo.Blog;
import com.utils.IDUtils;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author lqw
 * @date 2021/10/9-8:59 下午
 */
public class Mytest {

    @Test
    public void addInitBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog=new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("女大三抱金砖");
        blog.setCreateTime(new Date());
        blog.setAuthor("二蛋");
        blog.setViews(100);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("女大三十送江山");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("女大三百送仙丹");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("女大三千位列仙班");
        mapper.addBlog(blog);


        sqlSession.close();


    }

    @Test
    public void queryBlogIF(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("title", "女大三抱金砖吗");
        hashMap.put("id", "14234eac58c44f6b9dc235cf0e2bf0e3");
        List<Blog> blogs = mapper.queryBlogIF(hashMap);

        for (Blog blog : blogs) {

            System.out.println(blog);

        }


    }
    @Test
    public void  querBlogForeach(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();

        ArrayList<Integer> ids = new ArrayList<Integer>();

        ids.add(1);
        ids.add(2);

        hashMap.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();


    }
}