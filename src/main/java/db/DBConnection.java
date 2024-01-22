package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;
import java.util.Collections;

public class DBConnection {
    public static Connection getInstance(){
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb";

        //프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace(); // 에러난거 볼때.
        }
        return null;
    }
}
