/**
 * 
 */
package com.linkcircle.utils;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;


/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
    private static final char SEPARATOR = '_';
    private static final String CHARSET_NAME = "UTF-8";
    
    /**
     * 转换为字节数组
     * @param str
     * @return
     */
    public static byte[] getBytes(String str){
    	if (str != null){
    		try {
				return str.getBytes(CHARSET_NAME);
			} catch (UnsupportedEncodingException e) {
				return null;
			}
    	}else{
    		return null;
    	}
    }
    
    /**
     * 转换为字节数组
     * @param str
     * @return
     */
    public static String toString(byte[] bytes){
    	try {
			return new String(bytes, CHARSET_NAME);
		} catch (UnsupportedEncodingException e) {
			return EMPTY;
		}
    }
    
    /**
     * 是否包含字符串
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inString(String str, String... strs){
    	if (str != null){
        	for (String s : strs){
        		if (str.equals(trim(s))){
        			return true;
        		}
        	}
    	}
    	return false;
    }
    
	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)){
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}
	
	/**
	 * 替换为手机识别的HTML，去掉样式及属性，保留回车。
	 * @param html
	 * @return
	 */
	public static String replaceMobileHtml(String html){
		if (html == null){
			return "";
		}
		return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
	}
	

	/**
	 * 缩略字符串（不区分中英文字符）
	 * @param str 目标字符串
	 * @param length 截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val){
		if (val == null){
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val){
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val){
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val){
		return toLong(val).intValue();
	}
	
	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request){
		String remoteAddr = request.getHeader("X-Real-IP");
        if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (isNotBlank(remoteAddr)) {
        	remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	/**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld" 
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld" 
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
    /**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld" 
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }
 
    /**
     * 转换为JS获取对象值，生成三目运算返回结果
     * @param objectString 对象串
     *   例如：row.user.id
     *   返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
     */
    public static String jsGetVal(String objectString){
    	StringBuilder result = new StringBuilder();
    	StringBuilder val = new StringBuilder();
    	String[] vals = split(objectString, ".");
    	for (int i=0; i<vals.length; i++){
    		val.append("." + vals[i]);
    		result.append("!"+(val.substring(1))+"?'':");
    	}
    	result.append(val.substring(1));
    	return result.toString();
    }
    
	/**
	* 修改人：	@author lyhace   
	* 修改时间：	2016-8-9 下午02:14:52   
	* 修改备注：   判断字符串是否为空
	 */
	public static boolean isNotEmpty(String str) {
		if(str == null || "".equals(str) || str.length() == 0){
			return false;
		}else{
			return true;
		}
		
	}
	/**
	 * @Description(获取request内容) @param request
	 * @return
	 */
	public static String getReqMsg(HttpServletRequest request) {
		InputStream in;
		StringBuffer msg = null;
		try {
			in = request.getInputStream();
			msg = new StringBuffer();
			byte[] b = new byte[4096];
			for (int n; (n = in.read(b)) != -1;) {
				msg.append(new String(b, 0, n));
			}
			return msg.toString();
		} catch (Exception e) {
			msg.append("");
		}
		return msg.toString();
	}
	
	
	/**
	 * @author youngder
	 * @Title: getDate
	 * @Description: 生成指定格式的时间
	 */
	public static String getRegDate(String regular){
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat(regular);
		return sdf.format(date);
	}	
	
	
	/**
	 * @author youngder
	 * @Title: getDate
	 * @Description: 生成yyy-MM-dd hh:mm:ss 格式的时间
	 */
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}	
	
	
	/**
	 * @author youngder
	 */
	public static String getSplitResult(String str,String req,int index){
		String result = "";
		try {
			String[] s = str.split(req);
			result = s[index];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	
	/**获取下拉选ID*/
	public static String getSplitId(String str){
		String result = "";
		try {
			String[] s = str.split(",");
			result = s[0];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	/**获取下拉选Name*/
	public static String getSplitName(String str){
		String result = "";
		try {
			String[] s = str.split(",");
			result = s[1];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	/**
	 * @author youngder
	 */
	public static String[] getSplitByMark(String str,String mark){
		return str.split(mark);
	}	
	
	
    /**
     * @author youngder
     * 随机获集合中的一个元素
     * @return
     */
    public static String getOneFromList(List<String> list) {
		 Random rand= new Random();
		 int tmp = Math.abs(rand.nextInt());
		 tmp=tmp % (list.size() - 1 + 1) + 1;
	     return list.get(tmp-1);
	    }
	
    
    
	/**
	 * @author youngder
	 * @Description(去掉换行，空格，制表符) @param dest
	 * @return
	 */
	public static String deleteN(String dest) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(dest);
		dest = m.replaceAll("");
		return dest;
	}
	
	/** 
	 * @Title: getUUID 
	 * @Description: 生成uuid
	 * @return
	 * @return: String
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
	/**
	 * @author youngder
	* 将10 or 13 位时间戳转为时间字符串 
	* convert the number 1407449951 1407499055617 to date/time format timestamp 
	*/  
	public static String timestamp2Date(String str_num) {  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	    if (str_num.length() == 13) {  
	        String date = sdf.format(new Date(Long.parseLong(str_num)));  
	        return date;  
	    } else {  
	        String date = sdf.format(new Date(Integer.parseInt(str_num) * 1000L));  
	        return date;  
	    }  
	}
	
	
	/**
	 * @author youngder
	 * @Title: getDate
	 * @Description: 生成指定格式的时间
	 */
	public static String date2Date(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}	
 
}
