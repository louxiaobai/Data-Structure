package Builder;

import Builder.demo.Product;

/**
 * @author lqw
 * @date 2022/3/15-7:13 下午
 */
//建造者
public abstract class Builder {


    abstract Builder buildA(String msg);//汉堡
    abstract Builder bulidB(String msg);//可乐
    abstract Builder buildC(String msg);//薯条
    abstract Builder bulidD(String msg);//甜点

    //完工得到产品
    abstract Product getProduct();


}