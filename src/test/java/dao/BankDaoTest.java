package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.List;


public class BankDaoTest {
    @Test
    public void selectAll_test(){
        //given

        //when

        BankDAO dao = new BankDAO();
        List<Account> accountList = dao.selectAll();

        //System.out.println(accountList.size());
        System.out.println(accountList);
        //then
    }

    @Test
    public void selectByNumber_test(){
        //given
        int number = 2;

        //when
        BankDAO dao = new BankDAO();
        Account account = dao.selectByNumber(number);

        //then
        if (account == null) {
            System.out.println(number + "로 조회된 값이 없습니다");
        }else{
              System.out.println(account.toString());
//            System.out.println(account.getNumber());
//            System.out.println(account.getBalance());
//            System.out.println(account.getPassword());
//            System.out.println(account.getCreatedAt());
        }
    }

    @Test
    public void deleteBynumber_test(){
        //given
        int number = 10;
        //when
        BankDAO dao = new BankDAO();
        int result = dao.deleteBynumber(number);

        //then
        if (result == 1){
            System.out.println("삭제");
        }else if(result == 0) {
            System.out.println(number + "를 찾을수가 없습니다");
        }else{
            System.out.println("삭제실패");
        }
    }

    @Test
    public void insert_test(){
        //given
        String password = "비밀번호888";
        int balance = 5000;

        //when
        BankDAO dao = new BankDAO();
        int resultInsert = (int)dao.insert(password,balance);

        //then
        if (resultInsert == 1){
            System.out.println("00");
        }

    }


}
