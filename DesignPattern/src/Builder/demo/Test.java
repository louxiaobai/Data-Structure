package Builder.demo;

/**
 * @author lqw
 * @date 2022/3/15-5:59 下午
 */
public class Test {


    public static void main(String[] args) {


        Director director = new Director();

        Product build = director.build(new Workder());

        System.out.println(build.toString());


    }



}