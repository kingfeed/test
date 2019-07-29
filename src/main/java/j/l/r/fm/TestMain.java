package j.l.r.fm;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

import javax.management.ReflectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dongfei
 */
@Slf4j
public class TestMain {
    public static void main(String[] args) throws Exception {
        Cat c = new Cat();
        c.setColor("back");
        c.setWeight(10D);
        c.setAge(10);
        log.warn("c instanceof Cat = {}",c instanceof Cat);
        log.warn("c instanceof Animal = {}",c instanceof Animal);
        Garfield g = new Garfield();
        for(int i = 0; i < g.getClass().getDeclaredFields().length; i++){
            log.warn("g DeclaredFields = {}",g.getClass().getDeclaredFields()[i].getName());
        }
        for(int i = 0; i < g.getClass().getFields().length; i++){
            log.warn("g Fields = {}",g.getClass().getFields()[i].getName());
        }
        for(int i = 0; i < g.getClass().getDeclaredMethods().length; i++){
            log.warn("g DeclaredMethods = {}",g.getClass().getDeclaredMethods()[i].getName());
        }
        for(int i = 0; i < g.getClass().getMethods().length; i++){
            log.warn("g Methods = {}",g.getClass().getMethods()[i].getName());
        }
        BeanUtils.setProperty(c,"habitat","美洲");
        log.info("habitat = {}",c.getHabitat());
        // 当注释掉getter时，Exception in thread "main" java.lang.NoSuchMethodException: Unknown property 'color' on class 'class j.l.r.fm.Cat'
        //BeanUtils.getProperty(c,"color");
        //log.info("color = {}",c.getColor());
        //当注释掉gettere,setter时,没有异常,但是赋值也不成功
        BeanUtils.setProperty(c,"color","green");
        //即使不存在的field也不抛出异常呢
        BeanUtils.setProperty(c,"master","green");
        //当注释掉getter时，与 BeanUtils 一致 Exception in thread "main" java.lang.NoSuchMethodException: Unknown property 'color' on class 'class j.l.r.fm.Cat'
        //PropertyUtils.getProperty(c,"color");
        //当注释掉setter时，PropertyUtils的方法 Exception in thread "main" java.lang.NoSuchMethodException: Property 'color' has no setter method in class 'class j.l.r.fm.Cat'
        //PropertyUtils.setProperty(c,"color","green");
        //PropertyUtils.setProperty(c,"color","green");
        //PropertyUtils.setSimpleProperty(c,"color","green");
        log.info("color = {}",c.getColor());
        //调用方法
        log.info("age = {}",MethodUtils.invokeMethod(c, "getAge",null));
        Method method = MethodUtils.getAccessibleMethod(c.getClass(),"setColor",String.class);
        method.invoke(c,"yellow");
        log.info("color = {}",c.getColor());
    }
}
