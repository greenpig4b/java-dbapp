package example03;

import dao.BankDAO;

public class CustomerApp {
    public static void main(String[] args) {
        // 라우터 설계 및 컨트롤러
        String url = "/insert";

        //책임분리 : SRP

        //만들책임 없는것은 메인으로 옮김

        BankDAO dao = new BankDAO();
        CustomerController con = new CustomerController(dao);

        Dispatcher result = new Dispatcher(con);

        result.route(url);

    }
}
