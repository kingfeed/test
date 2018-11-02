public class TestOperation {

    public static void main(String[] args) {
        boolean go = true;
        boolean stay = false;
        boolean leave = false;
        boolean stop = true;
        System.out.println(go & stay);
        System.out.println(go ^ stay);
        System.out.println(go | stay);

        System.out.println(stay & leave);
        System.out.println(stay ^ leave);
        System.out.println(stay | leave);

        System.out.println(go & stop);
        System.out.println(go ^ stop);
        System.out.println(go | stop);

        System.out.println(16>>2);
        System.out.println(64>>>3);
        System.out.println(-64>>3);
        System.out.println(-64>>>3);
        System.out.println(16>>>3);
        System.out.println(16<<3);
        System.out.println(16<<2);
    }
}
