package Builder;

import Builder.demo.Product;

/**
 * @author lqw
 * @date 2022/3/15-7:33 下午
 */
public class Test {

    public static void main(String[] args) {


        Work work = new Work();

        Product product = work.getProduct();

        product.setBuildB("全家桶");

        System.out.println(product.toString());
    }



}