import controller.BankController;
import controller.RequestMapping;
import lombok.AllArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.reflect.Method;

/*
* 책임 : 라우팅
* */

@AllArgsConstructor
public class Dispatcher {

    //의존성 주입
    private BankController con;

    public void route(String path){

        //라우터,디스패쳐
        Method[] methods = con.getClass().getDeclaredMethods();
        //System.out.println(methods.length);

        for(Method method : methods){
            // System.out.println(method.getName());
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null) continue;

            if (rm.uri().equals(path)){
                try {
                    method.invoke(con); //invoke 매서드호출
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
