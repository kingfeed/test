import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class TestListGroup {



    @Data
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
    }

    private void  test(){

        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple("123","苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple("456","苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple("123","香蕉",new BigDecimal("2.89"),30);
        Apple apple21 =  new Apple("123","香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple("null","荔枝",new BigDecimal("9.99"),40);
        Apple apple4 =  new Apple("null","荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple21);
        appleList.add(apple3);
        appleList.add(apple4);
        Map<String, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

        System.out.println(groupBy.get("123").size());
        //System.err.println("groupBy:"+ JSON.toJSONString(groupBy));
        for(Apple apple : groupBy.get("123")){
            System.err.println("apple:"+ JSON.toJSONString(apple));
            System.out.println(apple.name);
        }
        // 错误 java.lang.IllegalStateException: Duplicate key
        // Map<String, Apple> map = appleList.stream().collect(Collectors.toMap(Apple::getId,apple -> apple));
    }
public static void main(String[] args) {
    TestListGroup group = new TestListGroup();
    group.test();
    log.info("{}",NumberUtils.isCreatable(""));;
    log.info("{}",NumberUtils.isCreatable("2019-19-10"));;
    log.info("{}",NumberUtils.isCreatable("" + System.currentTimeMillis()));
    log.info("{}", NumberUtils.isCreatable("-" + System.currentTimeMillis()));
}
    }
