import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class TestCollection {

    public static void main(String[] args) {
        testStream();
    }

    static void testStream(){
        List<String> stringList = new ArrayList<>();

        Map<Integer,String> integerStringMap = stringList.stream().collect(Collectors.toMap(String::length,s -> s ));
        for(Integer i : integerStringMap.keySet()){
            log.info("{}={}",i,integerStringMap.get(i));
        }

    }

    private static void testArrayListInitial() {
        System.out.println(System.currentTimeMillis());
        List<Integer> s1 = new ArrayList<>(1000);
        for (int i = 0 ; i< 1000;i++){
            s1.add(i);
        }
        System.out.println(System.currentTimeMillis());

        System.out.println(System.currentTimeMillis());
        List<Integer> s2= new ArrayList<>();
        for (int i = 0 ; i< 1000;i++){
            s2.add(i);
        }
        System.out.println(System.currentTimeMillis());
    }

    private static void testHashMapInitial() {
        System.out.println(System.currentTimeMillis());
        Map<Integer,Integer> m1 = new HashMap<Integer,Integer>(10000);
        for (int i = 0 ; i< 10000;i++){
            m1.put(i,i);
        }
        System.out.println(System.currentTimeMillis());

        System.out.println(System.currentTimeMillis());
        Map<Integer,Integer> m3 = new HashMap<Integer,Integer>();
        for (int i = 0 ; i< 10000;i++){
            m3.put(i,i);
        }
        System.out.println(System.currentTimeMillis());
    }
}
