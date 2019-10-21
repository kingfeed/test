import lombok.extern.slf4j.Slf4j;

/**
 * @author dongfei
 */
@Slf4j
public class TryCatchFinal {

    public static void main(String[] args) {
        System.out.println(go());

    }

    public static int go(){
        Integer a = null;
        log.info("value = {}",a/10);
        try {
            int i = 1/1;
            return i;
        }catch (Exception ex){
            //throw ex;
        }finally {
            System.out.println("go go go");
        }
        return -100;
    }

    /**
     * go go go
     * Exception in thread "main" java.lang.ArithmeticException: / by zero
     * 	at TryCatchFinal.main(TryCatchFinal.java:8)
     *
     * Process finished with exit code 1
     */
}
