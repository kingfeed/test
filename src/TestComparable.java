import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestComparable {

    public static void main(String[] args){
        ArrayList<User> userList = new ArrayList<>();
        for (int i=20; i <22;i++) {
            for (int j=1; j < 3; j++){
                User user = new User(java.util.UUID.randomUUID().toString(),j,i);
                userList.add(user);
            }
        }

        for (User user:userList){
            System.out.println(user);
        }
        Collections.sort(userList);

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        for (User user:userList){
            System.out.println(user);
        }
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        Collections.reverse(userList);
        for (User user:userList){
            System.out.println(user);
        }
    }

    private static class User implements java.lang.Comparable<User>{
        private String id;
        private int level;
        private int age;


        public User(String id,int level,int age){
            this.age = age;
            this.level = level;
            this.id = id;
        }

        @Override
        public String toString() {
            return "age:"+this.age+",level:"+this.level+",id:"+this.id;
        }

        @Override
        public int compareTo(User o) {
            if(this == o) return 0;
            int levelCompare = Integer.compare(this.level,o.level);
            return  levelCompare == 0 ?
                    Integer.compare(this.age,o.age):levelCompare;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if(obj instanceof User) {
                User user = (User) obj;
                return this.level == user.level && user.age == user.age && this.id.equals(user.id);
            }
            return false;
        }
    }
}
