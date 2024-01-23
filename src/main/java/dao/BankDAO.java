package dao;


/*
* DAO - Data Access Object
* SRP - 단일책임의 원칙
* */

import db.DBConnection;
import model.Account;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankDAO {

    //delete
    public int deleteBynumber(int number){
        Connection conn = DBConnection.getInstance();

        try {

            String sql = "delete from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    //insert
    public Object insert(String password,int balance){
        Connection conn = DBConnection.getInstance();

        try {

            String sql = "insert into account_tb(password,balance,created_at)values(?,?,now())";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setInt(2, balance);
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    //update
    public int updateBynumber(int balance,int number){
        Connection conn = DBConnection.getInstance();

        try {

            String sql = "update account_tb set balance = ? where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, balance);
            pstmt.setInt(2, number);

            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    //select
    public Account selectByNumber(int number){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            ResultSet rs = pstmt.executeQuery();

            boolean isRow = rs.next(); // 커서 한칸 내리기

            if(isRow){
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                return account;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //all
    public List<Account> selectAll(){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb order by number desc"; //조회시에는 거꾸로 내림차순
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            List<Account> accountList = new ArrayList<>();

            while(rs.next()){
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                accountList.add(account);
            }
            return accountList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
