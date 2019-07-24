import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 参考
 * https://stackoverflow.com/questions/33015274/sorting-a-collection-using-fluent-chaining-in-java-8
 */

/**
 * @author dongfei
 */
public class TestStreamSorted {

    public static void main(String[] args) {
        sort(init());
    }

    @Data
    static class Entity {

        private Long id;
        private String prodName;
        private BigDecimal price;

    }

    public static void sort(List<Entity> list){
        /**
         * 排序规则，先按照价格降序，再按照名称降序，再按照ID排序
         * 这种写法比较符合思维惯性
         * 先按照价格降序排，如果相等再按照名称降序排，如果相等按照ID升序排，好理解
         */
        // 比较器，比较规则针对本次比较
        Comparator<Entity> comparator = Comparator.comparing(Entity::getPrice,Comparator.reverseOrder());
        comparator = comparator.thenComparing(Entity::getProdName,Comparator.reverseOrder());
        comparator = comparator.thenComparingLong(Entity::getId);
        list = list.stream().sorted(comparator).collect(Collectors.toList());
        list = list.stream().sorted(Comparator.comparing(Entity::getPrice,Comparator.reverseOrder())
                .thenComparing(Entity::getProdName,Comparator.reverseOrder())
                .thenComparingLong(Entity::getId)).collect(Collectors.toList());
        /**
         * You're reversing the whole comparator every time you call reversed(). Instead, just do as your description says
         *          * 错误写法
         *          * 排序完成后，对结果进行反向 直接反转对整个排序结果Comparator<Entity> comparator = Comparator.comparing(Entity::getPrice).reversed();
         *          * 直接反转对整个排序结果comparator = comparator.thenComparing(Entity::getProdName).reversed();
         *          * comparator = comparator.thenComparingLong(Entity::getId);
         */
        /**
         * 这种排序个人感觉是不对的 但是还没找时间找论证，也有可能能行
         * 说明：先按照ID有序，再按照名称有序，最后按照价格有序，总感觉再这过程中之前的排序规则存在打乱的可能性，不可取
        list = list.stream().sorted(Comparator.comparing(Entity::getId))
                .sorted(Comparator.comparing(Entity::getProdName,Comparator.reverseOrder()))
                .sorted(Comparator.comparing(Entity::getPrice,Comparator.reverseOrder())).collect(Collectors.toList());
         **/
        list.stream().forEachOrdered(l -> System.out.println(l.getId() + " : " + l.getPrice() + " : " + l.getProdName()));
    }

    public static List<Entity> init(){
        List<Entity> list = new ArrayList<>();

        Entity entity = new Entity();
        entity.setId(1L);
        entity.setProdName("A");
        entity.setPrice(new BigDecimal(10));
        list.add(entity);
        entity = new Entity();
        entity.setId(2L);
        entity.setProdName("D");
        entity.setPrice(new BigDecimal(20));
        list.add(entity);
        entity.setId(2L);
        entity.setProdName("D");
        entity.setPrice(new BigDecimal(40));
        list.add(entity);
        entity.setId(2L);
        entity.setProdName("D");
        entity.setPrice(new BigDecimal(60));
        list.add(entity);
        entity = new Entity();
        entity.setId(2L);
        entity.setProdName("B");
        entity.setPrice(new BigDecimal(20));
        list.add(entity);
        entity = new Entity();
        entity.setId(4L);
        entity.setProdName("D");
        entity.setPrice(new BigDecimal(50));
        list.add(entity);
        entity = new Entity();
        entity.setId(3L);
        entity.setProdName("C");
        entity.setPrice(new BigDecimal(30));
        list.add(entity);
        entity = new Entity();
        entity.setId(3L);
        entity.setProdName("C");
        entity.setPrice(new BigDecimal(50));
        list.add(entity);

        entity = new Entity();
        entity.setId(4L);
        entity.setProdName("D");
        entity.setPrice(new BigDecimal(40));
        list.add(entity);
        entity = new Entity();
        entity.setId(4L);
        entity.setProdName("D");
        entity.setPrice(new BigDecimal(60));
        list.add(entity);

        entity = new Entity();
        entity.setId(5L);
        entity.setProdName("E");
        entity.setPrice(new BigDecimal(50));
        list.add(entity);
        entity = new Entity();
        entity.setId(6L);
        entity.setProdName("E");
        entity.setPrice(new BigDecimal(50));
        list.add(entity);
        entity = new Entity();
        entity.setId(2L);
        entity.setProdName("E");
        entity.setPrice(new BigDecimal(50));
        list.add(entity);
        list.add(entity);
        entity = new Entity();
        entity.setId(7L);
        entity.setProdName("E");
        entity.setPrice(new BigDecimal(60));
        list.add(entity);

        entity = new Entity();
        entity.setId(6L);
        entity.setProdName("F");
        entity.setPrice(new BigDecimal(60));
        list.add(entity);

        entity = new Entity();
        entity.setId(6L);
        entity.setProdName("E");
        entity.setPrice(new BigDecimal(60));
        list.add(entity);

        entity = new Entity();
        entity.setId(7L);
        entity.setProdName("F");
        entity.setPrice(new BigDecimal(60));
        list.add(entity);
        entity = new Entity();
        entity.setId(7L);
        entity.setProdName("F");
        entity.setPrice(new BigDecimal(20));
        list.add(entity);
        return list;
    }
}
