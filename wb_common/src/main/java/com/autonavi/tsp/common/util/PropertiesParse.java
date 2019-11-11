package com.autonavi.tsp.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
  
/***
 * 加载properties配置文件工具类
 * 文件名：PropertiesParse.java  
 *
 * User : allen.yin(尹玉奎)
 * Email: yukui.yin@autonavi.com
 * 日       期: 2014年11月24日 下午3:39:18
 * 版本信息： v1.0
 * Created with Eclipse Kepler Release.
 */
public class PropertiesParse extends PropertyPlaceholderConfigurer {  
  
    private static Map<String, String> configMap;  
  
    @Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,  
            Properties props)throws BeansException {  
  
        super.processProperties(beanFactory, props);  
        //load properties to configMap  
        configMap = new HashMap<String, String>();  
        for (Object key : props.keySet()) {  
            String keyStr = key.toString();  
            String value = props.getProperty(keyStr);  
            configMap.put(keyStr, value);  
        }  
    }  
  
     /**
      * 描述：获取key对应的值
      * @param key
      * @return
      * @author: allen.yin
      * @日期: 2014年10月31日 下午2:47:28
      */
     public static String getProperty(String key) { 
        return configMap!=null?configMap.get(key):null;  
     } 
     
     /***
      * 描述：获取key对应的值，如果value为空，则返传入的回默认值
      * @param key
      * @param defaultValue
      * @return
      * @author: allen.yin
      * @日期: 2014年10月31日 下午2:49:20
      */
     public static String getProperty(String key,String defaultValue) {  
         String value= getProperty(key);  
         if(StringUtil.isNotEmpty(value)){
        	 return value;
         }else{
        	 return defaultValue; 
         }
     } 
} 