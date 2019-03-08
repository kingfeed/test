package design.pattern.creational.abstractfactory;

/**
 * @author dongfei
 */
public class FoodFactory extends AbstractFactory {

    @Override
    public Food createGoods(String foodType){
        if("salt".equals(foodType)){
            return new Salt();
        }
        if("suger".equals(foodType)){
            return new Sugar();
        }
        return null;
    }
}
