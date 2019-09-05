import lombok.Data;
import lombok.Getter;

public class TestEquals {
    public static void main(String[] args){
        int i =1;
        Integer k = new Integer(1);
        Integer j = new Integer(1);
        A a = new A();
        a.setA(1);
        A b = new A();
        b.setA(1);
        System.out.println(a.getA() == B.B.getB());//true
        System.out.println(a.getA() == b.getA());//true
        System.out.println(i == j);//true
        System.out.println(k == j);//false
        System.out.println(j.equals(i));//true
    }

    @Data
    public static class A{
        private Integer a;
    }

    @Getter
    protected enum B{
        B(1);
        Integer b;
       B(int c){
            this.b = c;
       }
    }
}
