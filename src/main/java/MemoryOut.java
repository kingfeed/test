
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoryOut {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<Person>();
        //List<Person> set = new ArrayList<>();
        Person p1 = new Person("唐僧","pwd1",25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变
        //hash值匹配，List就没有问题 只匹配对象
        System.out.println(set.contains(p3));
        System.out.println(set.contains(p1));
        set.remove(p3); //此时remove不掉，造成内存泄漏（remove不掉的原因是重写了equals 和hashCode方法，并且age作为其中的equals判断中的一员）

        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
        set.add(p3); //重新添加，居然添加成功
        System.out.println(set.contains(p3));
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
        for (Person person : set)
        {
            System.out.println(person);
        }
    }
}

class Person {

    int age;
    String name;
    String password;

    public Person(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }





}