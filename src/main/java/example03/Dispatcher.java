package example03;


import example02.RequestMapping;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@AllArgsConstructor
public class Dispatcher {
    //의존성 주입

    private CustomerController con;

    public  void route(String path){
        //라우터 == 디스패쳐

        Method[] methods = con.getClass().getDeclaredMethods();

        for (Method method : methods){
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null)continue;

            if (rm.uri().equals(path)){
                try {
                    method.invoke(con); // 해당하는 메서드호출
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
