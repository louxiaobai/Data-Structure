import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lqw
 * @date 2021/12/3-3:53 下午
 */
public class test {
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
        String replace = text.replace('\n', ' ')//去掉字符串中换行
                 ;//去掉字符串中换行和空格
        //System.out.println(replace);
        String reg="<seg-source>(.*?)</seg-source>";//首次匹配得到seg-source标签中的内容
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(replace);
//        ArrayList<Integer> mids = new ArrayList<Integer>();
//        ArrayList<Integer> gids = new ArrayList<Integer>();
        int gid = 0;
        //创建一个LinkedMultiValueMap存储一对多的关系
        LinkedMultiValueMap<Integer,Integer> map = new LinkedMultiValueMap<Integer,Integer>();
        if(matcher.find()){//匹配到所有的<seg-source></set-source>标签
            String targetOne=matcher.group(1);//得到目标标签中的值
            System.out.println(targetOne);
            //匹配gid的值
            Pattern patternTwo = Pattern.compile("<g id=\"(.*?)\">");
            Matcher matcherTwo = patternTwo.matcher(targetOne);
            while (matcherTwo.find()){
                System.out.println(matcherTwo.group(1));
                gid=Integer.parseInt(matcherTwo.group(1));
                System.out.println(gid);
//                gids.add(Integer.parseInt(matcherTwo.group(1)));
            }
            //匹配mid的值
            Pattern patternThree = Pattern.compile("mid=\"(.*?)\">");
            Matcher matcherThree = patternThree.matcher(targetOne);
            while (matcherThree.find()){
                System.out.println(matcherThree.group(1));
                //使用Arraylist进行保存mid的值
                map.add(gid,Integer.parseInt(matcherThree.group(1)));
                //mids.add(Integer.parseInt(matcherThree.group(1)));
            }
        }
        System.out.println(map);
        System.out.println(map.keySet().toArray()[0]);//得到gid的值
        System.out.println(map.get(map.keySet().toArray()[0]).get(0));//得到mid的值
        //得到 mid 和gid 的值 进行查询数据库中的值-得到需要的值
        //从数据库中得到值--进行字符串拼接
        //String source="<target><gid="+map.keySet().toArray()[0]+"></target>";
        //进行拼接mrk
        String mrk="";
        for (int i = 0; i <map.get(map.keySet().toArray()[0]).size() ; i++) {
            //取出mid的值
            int mid=map.get(map.keySet().toArray()[0]).get(i);
            mrk+="<mrk mtype="+'"'+"seg"+'"'+" mid="+'"'+mid+'"'+">"+"翻译的结果"+"</mrk>";
        }
        //拼接target和gid
        String source="<target>"+"<g id="+'"'+map.keySet().toArray()[0]+'"'+">"+mrk+"<g id></target>";
        //对文本进行分割(按照</seg-source>进行分割)
        String[] str = replace.split("</seg-source>");
        //进行拼接字符串得到想要的结果
        String target=str[0]+"</seg-source>"+mrk+str[1];
        System.out.println(target);
    }
}