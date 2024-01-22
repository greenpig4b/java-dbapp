package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class DBConnectionTest {

    //자바 테스트 도구 junit
    //리턴타입을 적을 수 없다.
    //매게변수를 적을 수 없다
    //@Test 를 붙이면 매서드 별로 실행가능

    @Test
    public void getInstance_test(){

        //given = 파라미터

        //when = 본코드 실행
        Connection conn = DBConnection.getInstance();

        //then = 눈 검증
        if (conn == null){
            System.out.println("실패");
        }else{
            System.out.println("성공");
        }
    }
}
