package com.autonavi.tsp.common.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil { 
	
	public static boolean isEmpty(String s) {
		if (null == s || s.length() == 0 || s.equals("")) {
			return true;
		}
		return false;
	}
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
	
	public static boolean isArrayEmpty(String[] ss) {
		if (null == ss || ss.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isOneEmpty(String... s) {
		boolean result = isArrayEmpty(s);
		if (result) {
			return result;
		}
		for (String each : s) {
			if (isEmpty(each)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isNumeric(String str){
		   boolean isNumeric=false;
		   if(!isEmpty(str)){
			   Pattern pattern = Pattern.compile("[0-9]*"); 
			   Matcher isNum = pattern.matcher(str);
			   if(isNum.matches() ){
				   isNumeric=true; 
			   }  
		   } 
		   return isNumeric;
		}
	public static String arrayToString(String strs[]){
		StringBuffer sbuf=new StringBuffer("[");
		if(!isArrayEmpty(strs)){
			for(int i=0;i<strs.length;i++){
				if(i==strs.length-1){
					sbuf.append(strs[i]);
				}else{
					sbuf.append(strs[i]+", ");
				}
			}
		}
		sbuf.append("]");
		return sbuf.toString();
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List ls){
		   boolean isEmpty=true;
		   if(ls!=null&&ls.size()>0){
			   isEmpty=false;
		   }
		   return isEmpty;
		}
    
	/**
	 * 过滤特殊字符
	 * 
	 * @param s
	 * @return
	 * @author siquan.lv
	 * @date 2013-5-27
	 */
	public static String specialCharFilter(String s) {
//		String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|; |or|-|+|,";

		return s.replaceAll(".*([';]+|(--)+).*", " ");
	}
	
	public static void main(String args[]){
		System.out.println(isNumeric("55"));
		System.out.println(isNumeric("55号"));
	}

}
