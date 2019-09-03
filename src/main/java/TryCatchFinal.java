/**
 * @author dongfei
 */
public class TryCatchFinal {

    public static void main(String[] args) {
        try {
            int i = 1/0;
        }catch (Exception ex){
            throw ex;
        }finally {
            System.out.println("go go go");
        }

    }

    /**
     * go go go
     * Exception in thread "main" java.lang.ArithmeticException: / by zero
     * 	at TryCatchFinal.main(TryCatchFinal.java:8)
     *
     * Process finished with exit code 1
     */
}
