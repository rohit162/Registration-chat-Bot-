package bot;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConProvider {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bot","root","");

        }
        catch (Exception e){
            System.out.println(e);

        }
        return con;
    }
}
