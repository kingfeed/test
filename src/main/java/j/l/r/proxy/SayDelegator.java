package j.l.r.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

/**
 * InvocationHandler JDK 动态代理的核心接口
 * 目标类的方法回调，通过实现 InvocationHandler 的 invoke方法实现
 * invoke 方法参数：1.代理对象,2.目标方法,3.目标参数
 * @author dongfei
 */
public class SayDelegator implements InvocationHandler {
    private Say target;

    public SayDelegator(Say target){
        this.target = target;
    }

    public SayDelegator(){

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        for(Parameter p :method.getParameters()){
            System.out.println(p.getName()+"-"+p.getType());
        }
        for(Class t :method.getParameterTypes()){
            System.out.println(t.getName()+"-"+t.getClassLoader());
        }
        System.out.println(method.getParameterCount());
        System.out.println(args[0]+","+args[1]);
        if(args != null && args.length>0){
           if(args[0] instanceof String) {
               args[0] = "delegator";
           }
        }
        return new Date()+"  ["+method.invoke(target,args)+"]";
    }
}
