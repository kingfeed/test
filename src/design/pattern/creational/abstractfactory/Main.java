package design.pattern.creational.abstractfactory;

/**
 * @author dongfei
 */
public class Main {
    public static void main(String[] args){
        FactoryProducer  factoryProducer= new FactoryProducer();
        AbstractFactory foodFactory = factoryProducer.getFactory(Food.class);
        foodFactory.createGoods("salt");
        foodFactory.createGoods("lenovo");
        AbstractFactory computerFactory = factoryProducer.getFactory(Computer.class);
        computerFactory.createGoods("lenovo");
        computerFactory.createGoods("dell");
        computerFactory.createGoods("sugar");
    }
}
