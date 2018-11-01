import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TestListGroup {



    public class Apple {
        private String id;
        private String name;
        private BigDecimal money;
        private Integer num;

        public Apple(String id, String name, BigDecimal money, Integer num) {
            this.id = id;
            this.name = name;
            this.money = money;
            this.num = num;
        }

        public String getId(){
            return id;
        }
    }

    private void  test(){

        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple("123","苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple("456","苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple("123","香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple("78","荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);
        Map<String, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

        System.err.println("groupBy:"+groupBy);
    }
public static void main(String[] args) {
    TestListGroup group = new TestListGroup();
    group.test();
}
    }
