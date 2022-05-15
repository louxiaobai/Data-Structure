package com.dao;

import com.pojo.Student;
import com.pojo.Teacher;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lqw
 * @date 2021/9/27-9:17 下午
 */
public class MyTest {
    @Test
    public void testTeacher(){


        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();


    }
    @Test
    public void testTeacher2(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);

        sqlSession.close();


    }

    @Test
    public void test(){

        String text="<group>" +
                "                <sdl:cxts>\n" +
                "                    <sdl:cxt id=\"57\" />\n" +
                "                    <sdl:cxt id=\"45\" />\n" +
                "                </sdl:cxts>\n" +
                "                <trans-unit id=\"ab598035-b388-44ac-bf33-085c6dae487f\">\n" +
                "                    <source>\n" +
                "                    <g id=\"379\">1. INTRODUCTION</g>\n" +
                "                    </source>\n" +
                "                    <seg-source>\n" +
                "                        <g id=\"379\">\n" +
                "                            <mrk mtype=\"seg\" mid=\"49\">1.</mrk>\n" +
                "                            <mrk mtype=\"seg\" mid=\"50\">INTRODUCTION</mrk>\n" +
                "                        </g>\n" +
                "                    </seg-source>\n" +
                "                    <target>\n" +
                "                        <g id=\"379\">\n" +
                "                            <mrk mtype=\"seg\" mid=\"49\">1.</mrk>\n" +
                "                            <mrk mtype=\"seg\" mid=\"50\">测试翻译结果</mrk>\n" +
                "                        </g>\n" +
                "                    </target>\n" +
                "                    <sdl:seg-defs>\n" +
                "                        <sdl:seg id=\"49\" locked=\"true\">\n" +
                "                            <sdl:rep id=\"kvDb2IoakeVV5COiU7UJZ5iVYjA=\" />\n" +
                "                            <sdl:prev-origin>\n" +
                "                                <sdl:rep id=\"kvDb2IoakeVV5COiU7UJZ5iVYjA=\" />\n" +
                "                                <sdl:value key=\"SegmentIdentityHash\">kvDb2IoakeVV5COiU7UJZ5iVYjA=</sdl:value>\n" +
                "                            </sdl:prev-origin>\n" +
                "                            <sdl:value key=\"SegmentIdentityHash\">kvDb2IoakeVV5COiU7UJZ5iVYjA=</sdl:value>\n" +
                "                        </sdl:seg>\n" +
                "                        <sdl:seg id=\"50\" locked=\"true\">\n" +
                "                            <sdl:rep id=\"2UttsJllA6H20fa/iPIfC744M24=\" />\n" +
                "                            <sdl:prev-origin>\n" +
                "                                <sdl:rep id=\"2UttsJllA6H20fa/iPIfC744M24=\" />\n" +
                "                                <sdl:value key=\"SegmentIdentityHash\">2UttsJllA6H20fa/iPIfC744M24=</sdl:value>\n" +
                "                            </sdl:prev-origin>\n" +
                "                            <sdl:value key=\"SegmentIdentityHash\">2UttsJllA6H20fa/iPIfC744M24=</sdl:value>\n" +
                "                        </sdl:seg>\n" +
                "                    </sdl:seg-defs>\n" +
                "                </trans-";

        String replace = text.replace('\n', ' ')
                .replace(" ", "");//去掉字符串中换行和空格
        System.out.println(replace);
        String reg="<seg-source>(.*?)</seg-source>";//首次匹配得到seg-source标签中的内容
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(replace);
        ArrayList<Integer> mids = new ArrayList<Integer>();
        ArrayList<Integer> gids = new ArrayList<Integer>();

        //创建一个map去存储gid 和mid
        new LinkedMultiValueMap();
        if(matcher.find()){//匹配到所有的<seg-source></set-source>标签
            String targetOne=matcher.group(1);//得到目标标签中的值
            System.out.println(targetOne);
            //匹配gid的值
            Pattern patternTwo = Pattern.compile("<gid=\"(.*?)\">");
            Matcher matcherTwo = patternTwo.matcher(targetOne);
            while (matcherTwo.find()){
                System.out.println(matcherTwo.group(1));
                gids.add(Integer.parseInt(matcherTwo.group(1)));
            }
            //匹配mid的值
            Pattern patternThree = Pattern.compile("mid=\"(.*?)\">");
            Matcher matcherThree = patternThree.matcher(targetOne);
            while (matcherThree.find()){
                System.out.println(matcherThree.group(1));
                //使用Arraylist进行保存mid的值
                mids.add(Integer.parseInt(matcherThree.group(1)));
            }
        }
        System.out.println(gids);
        System.out.println(mids);
        //得到 mid 和gid 的值 进行查询数据库中的值-得到需要的值


        //从数据库中得到值--进行字符串拼接

        String source="<target><gid="+gids.get(0)+"></target>";


    }
}