package Builder.demo;

/**
 * @author lqw
 * @date 2022/3/15-5:30 下午
 */
public abstract class Builder {


    abstract void buildA();//地基
    abstract void bulidB();//钢筋工程
    abstract void buildC();//地基
    abstract void bulidD();//粉刷

    //完工得到产品
    abstract Product getProduct();


}