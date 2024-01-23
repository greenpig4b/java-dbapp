package example02;

import example01.UserController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        String path = "/192.168.0.58";

        UserContainer con = new UserContainer();

        //매서드가 가지고 있는 개수호출
        Method[] methods = con.getClass().getDeclaredMethods();

        for (Method method : methods){
           RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

           if (rm == null) continue;
           if (rm.uri().equals(path)){
               try {
                   method.invoke(con); // invoke : 해당하는 매서드 호출
                   break;
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
        }

    }
}
