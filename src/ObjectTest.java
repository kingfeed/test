import java.util.ArrayList;
import java.util.List;

public class ObjectTest {
    private static List<User> userList= new ArrayList<>();
    public static void main(String[] args){
        User user = new User();
        user.userName = "1";
        userList.add(user);
        user.userName = "2";
        userList.add(user);
        user.userName = "3";
        userList.add(user);
        userList.add(new User("a"));
        userList.add(new User("b"));
        userList.add(new User("1"));
        userList.add(new User("d"));
        userList.add(new User("c"));
        userList.add(new User("2"));
        for (User u :userList) {
            System.out.println(u.userName);
        }
    }


    private static class User{
        public User(){

        }
        public User(String userName) {
            this.userName = userName;
        }
        public String userName;
    }
}
