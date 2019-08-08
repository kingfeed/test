import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Main {

    private static <K,V> V get(K k){
        return (V) k.toString();
    }

    private static void ooo(){
        List<String> so = new ArrayList<>(Arrays.asList("we","12"));
        so.stream().sorted(Comparator.comparing(String::toString,Comparator.reverseOrder())).collect(Collectors.toList());
        List<Integer> q = new ArrayList<>(Arrays.asList(1,2,3,5,46,7,8,90));
        List sorted =  q.stream().sorted(Comparator.comparing(Integer::intValue,Comparator.reverseOrder())).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        BigDecimal productionQty = new BigDecimal("3.001");
        log.warn("show me = {}",productionQty.compareTo(new BigDecimal(String.valueOf(productionQty.intValue())))== 0?1:0) ;

        System.out.println(""+(1 << 5)+"------"+(1 << 128)+">>>>"+(1<<64)+"^^^^^"+(1<<40)+"~~~~"+(1<<63)+"===="+(1<<64));
        ooo();
        String v = get(new Object());
        System.out.println(v);
        String v1 = get(new String("ABC"));
        System.out.println(v1);
        Class c1=new ArrayList<Integer>().getClass();
        Class c2=new ArrayList<String>().getClass();
        //true
        System.out.println(c1==c2);
        System.out.println(""+(1 << 5));
        System.out.println("Hello World!");
        System.out.println(Object.class.getSuperclass());
        System.out.println(String.class.getSuperclass().getDeclaredFields());
        System.out.println(Main.class.getSuperclass().getDeclaredFields());
        Boolean bool = new Boolean(null);
        System.out.println(!bool);
        System.out.println(System.currentTimeMillis());
        for (int i=0;i<1001; i++) {
            for (int j=0;j<1001; j++) {
                long a = 8*5L;
            }
        }
        System.out.println(System.currentTimeMillis());

        char a = 'a';
        switch (a){
            case 'a':
                System.out.println("Hello World!--1");
                break;
            case 'b':
                System.out.println("Hello World!--2");
                break;
            default:
                System.out.println("Hello World!--noBody");
        }
    }
}
