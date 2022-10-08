package cn.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateCalculate {
static Logger logger = LoggerFactory.getLogger(DateCalculate.class);
    public static void main(String[] args)throws Exception {
     //   System.out.println("2016-02-01".length());
   /*     String start = "2016-02-01";
        String end = "2017-01-02";
        List<String> list = findDates("M", start, end,"yyyy-MM-dd");
        for (String str :list){
            System.out.println(str);
        }*/

        String lastday = getLastday("2012", "12");
        System.out.println(lastday);
    }

    /**获取月初*/
    public static String getBeginning(String date_str,String formatType){
        try {
            Calendar cale = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat(formatType);
            cale.setTime(formatter.parse(date_str));
            cale.add(Calendar.MONTH, 0);
            cale.set(Calendar.DAY_OF_MONTH, 1);
            return formatter.format(cale.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取月末
     * @param year 年 2022
     * @param month  月 12
     * @return  2022-12-31
     */
    public  static String getLastday(String year,String month){
        Calendar cal= Calendar.getInstance();
        cal.set(Calendar.YEAR ,Integer.parseInt(year));
        cal.set(Calendar.MONTH ,Integer.parseInt(month)-1);
        cal.set(Calendar.DAY_OF_MONTH ,cal.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**获取时间区间*/
    public static List<String> findDates(String dateType,String start, String end,String formatType){
        List<String> listDate = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formatType);
            Date dBegin = sdf.parse(start);
            Date dEnd = sdf.parse(end);
            Calendar calBegin = Calendar.getInstance();
            calBegin.setTime(dBegin);
            calBegin.add(Calendar.MONTH, -1);
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(dEnd);
            while (calEnd.after(calBegin)) {
                switch (dateType) {
                    case "M":
                        calBegin.add(Calendar.MONTH, 1);
                        break;
                    case "D":
                        calBegin.add(Calendar.DAY_OF_YEAR, 1);break;
                    case "H":
                        calBegin.add(Calendar.HOUR, 1);break;
                    case "N":
                        calBegin.add(Calendar.SECOND, 1);break;
                }
                if (calEnd.after(calBegin))
                    listDate.add(new SimpleDateFormat("yyyy-MM-dd").format(calBegin.getTime()));
                else
                    listDate.add(new SimpleDateFormat("yyyy-MM-dd").format(calEnd.getTime()));
            }
            return listDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return listDate;
    }
}