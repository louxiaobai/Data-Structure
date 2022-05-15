package Factory.SimpleFactory;

/**
 * @author lqw
 * @date 2022/3/10-3:42 下午
 */
public class SimpleFactory {

    public static Product createProduct(String  type){


        if (type.equals("A")){

            return new ProductA();

        }else {

            return new ProductB();

        }


    }

    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("A");

        product.print();
    }


}

abstract class Product{

    public abstract void print();
}

class ProductA extends Product{

    @Override
    public void print() {
        System.out.println("产品A");
    }
}

class ProductB extends Product{


    @Override
    public void print() {
        System.out.println("产品B");
    }
}