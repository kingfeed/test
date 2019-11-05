import com.sun.deploy.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import sun.instrument.InstrumentationImpl;

import java.lang.instrument.Instrumentation;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class TestCollection {

    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }


    public static void main(String[] args) {
        testLambda2Set();
    }

    static void testLambda2Set(){
        List<String> sl = new ArrayList<>();
        sl.add("s");
        sl.add("i");
        sl.add("s");
        sl.add("t");
        sl.add("e");
        sl.add("r");
        sl.add("s");
        log.info("toString = {}", StringUtils.join(sl,""));
        log.info("set = {} ",sl.stream().collect(Collectors.toSet()));

        List<BossDimComDatYmdBase> resultList = new ArrayList<>();
        resultList.add(new BossDimComDatYmdBase("s"));
        resultList.add(new BossDimComDatYmdBase("d"));
        resultList.add(new BossDimComDatYmdBase("s"));
        resultList.add(new BossDimComDatYmdBase("i"));
        resultList.add(new BossDimComDatYmdBase("i"));
        resultList.add(new BossDimComDatYmdBase("i"));
        // log.info("size = {}",getObjectSize(new BossDimComDatYmdBase("i")));

        log.info("set = {} ",resultList.stream().map(BossDimComDatYmdBase::getDayName).collect(Collectors.toSet()));



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
