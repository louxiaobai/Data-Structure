package Builder;

import Builder.demo.Product;
/**
 * @author lqw
 * @date 2022/3/15-7:23 下午
 */
//具体的创建者
public class Work extends  Builder {


    private Product product;

    public Work() {
       product = new Product();
    }

    @Override
    Builder buildA(String msg) {
        product.setBuildA(msg);
        return this;
    }

    @Override
    Builder bulidB(String msg) {
        product.setBuildB(msg);
        return this;
    }

    @Override
    Builder buildC(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    Builder bulidD(String msg) {
        product.setBuildD(msg);
        return this;

    }

    @Override
    Product getProduct() {

        return product;

    }
}