import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();


        try {
            String Delete = "delte from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(Delete);
            pstmt.setInt(1,1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
