public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Object.class.getSuperclass());
        System.out.println(String.class.getSuperclass().getDeclaredFields());
        System.out.println(Main.class.getSuperclass().getDeclaredFields());
        Boolean bool = new Boolean(null);
        System.out.println(!bool);
        System.out.println(System.currentTimeMillis());
        for (int i=0;i<1001; i++) {
            for (int j=0;j<1001; j++) {
                long a = 8*5l;
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
        }
    }
}
