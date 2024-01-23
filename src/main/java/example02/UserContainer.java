package example02;

public class UserContainer {

    //login
    @RequestMapping(uri = "/login")
    public void login(){
        System.out.println("로그인 호출됐습니다");
    }

    //join
    @RequestMapping(uri = "/join")
    public  void join(){
        System.out.println("회원가입이 호출됐습니다");
    }

    //updatepassword
    @RequestMapping(uri = "/updatePassword")
    public void updatePassword(){
        System.out.println("비밀번호 변경이 완료되었습니다");
    }

    //updateName
    @RequestMapping(uri = "/updateName")
    public void updateName(){
        System.out.println("닉네임이 변경되었습니다");
    }

    //다른계정 접속
    @RequestMapping(uri = "/192.168.0.58")
    public void input(){
        System.out.println("다른계정으로 접속되었습니다");
    }

}
