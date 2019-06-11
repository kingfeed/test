package design.pattern.creational.factory;

/**
 * @author dongfei
 */
public class ShapeFactory {

    public static AbstractShape createShape(String type){
        if("triangle".equals(type)){
            return new Triangle();
        }else if("rectangle".equals(type)){
            return new Rectangle();
        }else {
            return new AbstractShape() {
                @Override
                public void draw() {
                    System.out.println("I don't know how to do it!");
                }
            };
        }
    }

    public static void main(String[] args){
        ShapeFactory.createShape("triangle").draw();
        ShapeFactory.createShape("circle").draw();
        ShapeFactory.createShape("rectangle").draw();
    }
}
