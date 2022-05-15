package Builder.demo;

/**
 * @author lqw
 * @date 2022/3/15-5:56 下午
 */

//指挥:核心,负责指挥构建一个工程,工程如何构建,由它决定
public class Director {


    //指挥工人按照顺序构建房子

    public Product build(Builder builder){

        builder.buildA();
        builder.bulidB();
        builder.buildC();
        builder.bulidD();

        return builder.getProduct();


    }

}