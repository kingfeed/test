package design.pattern.creational.abstractfactory;


/**
 * @author dongfei
 */
public class FactoryProducer {

    public AbstractFactory getFactory(Class type){
        if(Food.class.equals(type)){
            return new FoodFactory();
        }
        if(Computer.class.equals(type)){
            return new ComputerFactory();
        }

        return null;
    }
}
