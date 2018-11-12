package com.linkcircle.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: DateUtils
 * @Description: 日期时间工具类
 * @author youngder
 * @date 2018年1月20日 下午10:43:23
 */
public class DateUtil {
    /** 
     * 将日期格式转换成yyyy-MM-dd的字符串格式 
     * 返回值如：2010-10-06 
     * @param time 要转换的日期 
     * @return 
     */  
    private static  String dateToString(Date time)  {  
        SimpleDateFormat formatter = new  SimpleDateFormat ("yyyy-MM-dd"); //定义将日期格式要换成的格式  
        String stringTime  =  formatter.format(time);  
        return  stringTime;  
      }  
    /** 
     * 将日期格式转换成yyyyMMdd的字符串格式 
     * 返回值如：2010-10-06 
     * @param time 要转换的日期 
     * @return 
     */  
    public static  String dateTimeToString(Date time)  {  
        SimpleDateFormat formatter = new  SimpleDateFormat ("yyyyMMdd"); //定义将日期格式要换成的格式  
        String stringTime  =  formatter.format(time);  
        return  stringTime;  
      }  
       
    /** 
     * 将日期格式转换成yyyy-MM-dd的字符串格式 
     * 返回值如：2010-10-06 
     * @param time 要转换的日期 
     * @return 
     */  
    public static  Date dateToDate(Date time)  {  
          
        SimpleDateFormat formatter = new  SimpleDateFormat ("yyyy-MM-dd"); //定义将日期格式要换成的格式  
        String stringTime  =  formatter.format(time);  
     Date date = null;  
    try {  
        date = formatter.parse(stringTime);  
    } catch (ParseException e) {  
        e.printStackTrace();  
    }  
        return  date;  
    }  
}
