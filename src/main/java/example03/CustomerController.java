package example03;


import dao.BankDAO;
import example02.RequestMapping;
import lombok.AllArgsConstructor;

/*
* 책임 : 유효성검사 , 파싱, 적절한 DAO 찾기
* 디스패쳐 == 라우터
*
* */
@AllArgsConstructor

public class CustomerController {

    private BankDAO dao;

    @RequestMapping(uri = "/insert")
    public void insert(){
        System.out.println("Controller : 인서트들어옴");
    }
    @RequestMapping(uri = "/delete")
    public void delete(){
        System.out.println("Controller : 딜리트들어옴");
    }

}
