import java.util.Arrays;

/**
 * @author dongfei
 */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] m = split(a);
        int[] n = split(b);
        int p = m[0] * n[0] - m[1] * n[1];
        int q = m[0] * n[1] + m[1] * n[0];

        return new StringBuilder().append(p).append("+").append(q).append("i").toString();
    }

    private int[] split(String a) {
        int[] m = new int[2];
        int index = a.indexOf("+");
        m[0] = Integer.valueOf(a.trim().substring(0,index));
        m[1] = Integer.valueOf(a.trim().substring(index+1,a.length()-1));
        return m;
    }

}
