package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClassUtil {
    public java.util.Date convertDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.parse(date);
    }
    public String toLowerCase(String string){
        return string.toLowerCase();
    }
}
