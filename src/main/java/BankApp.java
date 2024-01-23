import controller.BankController;
import dao.BankDAO;
import model.Account;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;



public class BankApp {
    public static void main(String[] args) {
        //라우터 설계 및 컨트롤러
        String url  = "/insert";

        //책임분리 : SRP

        //만들책임이 없는것은 메인안으로
        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao);
        Dispatcher dis = new Dispatcher(con);


        dis.route(url);
    }
}