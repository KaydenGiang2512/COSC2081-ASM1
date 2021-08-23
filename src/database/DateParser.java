package database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    private DateParser(){

    }

    public static Date parse(String s) throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("dd/MM/yyyy");
        time.setLenient(false);
        return time.parse(s);
    }

    public static String format(Date d){
        if (d == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(d);
    }
}
