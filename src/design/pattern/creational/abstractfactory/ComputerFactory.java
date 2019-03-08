package design.pattern.creational.abstractfactory;

/**
 * @author dongfei
 */
public class ComputerFactory extends AbstractFactory{


    @Override
    public Goods createGoods(String brand) {
        if("dell".equals(brand)){
            return  new DellComputer();
        }
        if("lenovo".equals(brand)){
            return  new LenovoComputer();
        }
        return null;
    }
}
