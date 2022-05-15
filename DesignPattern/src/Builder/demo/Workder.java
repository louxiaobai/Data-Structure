package Builder.demo;

/**
 * @author lqw
 * @date 2022/3/15-5:51 下午
 */
//具体的建造之 工人
public class Workder extends Builder {

    private Product product;

    public Workder(){
        product=new Product();
    }
    @Override
    void buildA() {

        product.setBuildA("地基");
        System.out.println("地基");

    }

    @Override
    void bulidB() {

        product.setBuildB("钢筋工程");
        System.out.println("钢筋工程");
    }

    @Override
    void buildC() {

        product.setBuildC("铺电线");
        System.out.println("铺电线");

    }

    @Override
    void bulidD() {
        product.setBuildD("粉刷");
        System.out.println("粉刷");
    }

    @Override
    Product getProduct() {
        return product;
    }
}