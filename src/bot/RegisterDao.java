package bot;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDao {
    public static int save(String name, String email, long aadhar, String city, String state, long contact, String username, String password) {
        Connection con=null;
        int status = 0;
        try{
            con=ConProvider.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into bot_user (Name,Email,Aadhar,City,State,Contact,Username,Password,RegisteredDate) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setLong(3,aadhar);
            ps.setString(4,city);
            ps.setString(5,state);
            ps.setLong(6,contact);
            ps.setString(7,username);
            ps.setString(8,password);
            ps.setDate(9,Formatter.getCurrentDate());
            ps.executeUpdate();
            status =1;
        }
       catch (Exception e){
            System.out.println(e);
       }
        return status;
    }
}
