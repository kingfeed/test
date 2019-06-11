package j.l.r.proxy;

import java.lang.reflect.Proxy;

/**
 * @author dongfei
 */
public class DynamicProxyMain {
    public static void main(String[] args){
        Say hello = new JavaSayHello();
       Say proxyHello = (Say) Proxy.newProxyInstance(Say.class.getClassLoader(),new Class[]{Say.class},new SayDelegator(hello));
       System.out.println(proxyHello.say("k","'hello-java-world'"));
    }
}
