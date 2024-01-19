package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

public class DBConnection {

    //자바 테스트 도구 junit
    //리턴타입을 적을 수 없다.
    //매게변수를 적을 수 없다
    //@Test 를 붙이면 매서드 별로 실행가능

    @Test
    public void getInstance_test(){
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb";

        //프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
