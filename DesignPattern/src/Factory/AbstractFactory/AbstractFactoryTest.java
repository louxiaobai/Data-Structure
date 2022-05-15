package Factory.AbstractFactory;

/**
 * @author lqw
 * @date 2022/3/11-5:50 下午
 */
public class AbstractFactoryTest {


}

//抽象工厂

interface AbstractFactory{

    Phone createPhone(String param);


    Mask createMask(String parm);


}
//具体工厂

class SuperFactory implements AbstractFactory{


    @Override
    public Phone createPhone(String param) {
        return new Iphone();
    }

    @Override
    public Mask createMask(String parm) {
        return new N95();
    }
}

//产品大类手机

interface Phone{}

class Iphone implements Phone{}

//产品大类-口罩

interface Mask{}

class N95 implements Mask{}

