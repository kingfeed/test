import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestStream {

   public static void main(String[] args){
       List<String> list = Collections.emptyList();
       //list.stream().findFirst().get().equals("12"); NoSuchElementException
       String a = list.stream().map(s -> s.equals("q")).reduce(new StringBuilder(), (sb, d) -> sb.append(d),StringBuilder::append).toString();

    }
}
