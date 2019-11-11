package com.autonavi.tsp.common.util;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class ObjectUtil {

	/**
	 * @param args
	 */
	public static boolean isNull (Object pInput) {  
        if (pInput == null || "".equals(pInput)) {  
            return true;  
        } else if ("java.lang.String".equals(pInput.getClass().getName())){  
  
            String tmpInput = Pattern.compile("//r|//n|//u3000")  
                                     .matcher((String)pInput).replaceAll("");  
            return Pattern.compile("^(//s)*$")  
                          .matcher(tmpInput).matches();  
        }
        return false;
	}
	
	public static Date StringToDate(String dateStr,String formatStr){
		DateFormat dd=new SimpleDateFormat(formatStr);
		Date date=null;
		try {
			date = dd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date getCurrentDate() 
	{
			String dateStr=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		   try {
			return  time.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static Date getMessageDate() 
	{
			String dateStr=new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			SimpleDateFormat time=new SimpleDateFormat("yyyyMMddHHmmss"); 
		
		   try {
			return  time.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String MessageDateToString(Date date)
	{
		SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMddHHmmss");
		return matter1.format(date);
	}
	public static String ClobToString(Clob clob) {

		String reString = "";
		Reader is=null;
		try {
					is = clob.getCharacterStream();
				 // 得到流
					BufferedReader br = new BufferedReader(is);
					String s = br.readLine();
					StringBuffer sb = new StringBuffer();
					while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
						sb.append(s);
						s = br.readLine();
					}
					reString = sb.toString();
					return reString;
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
		}
	}

}
