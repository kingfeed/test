package j.l.r.proxy;

/**
 * @author dongfei
 */
public class JavaSayHello implements Say {
    @Override
    public String say(String who, String what) {
        return "Hello,Java World:"+who+" say "+what;
    }
}
