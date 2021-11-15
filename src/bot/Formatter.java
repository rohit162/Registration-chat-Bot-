package bot;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Formatter {
    public static Date getsqlDate(String dob) {
        Date d=null;
        try{
            SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dt=f.parse(dob);
            d=new Date(dt.getTime());

        }
        catch(ParseException e){
            System.out.println(e);

        }
        return d;

    }

    public static Date getCurrentDate() {
        Date d=null;
        try{
            java.util.Date dt=java.util.Calendar.getInstance().getTime();
            d=new Date(dt.getTime());
        }
        catch (Exception e){

        }
        return d;
    }
}
