package com.autonavi.tsp.mc.util;

import java.io.Serializable;

import org.springframework.ui.ModelMap;

/**
 * <pre>
 * 对于返回结果格式是JSON的封装类
 * 
 * @author haiying.deng
 * @version $Id: JsonResultFormat.java, v 0.1 2014-10-16 下午3:17:19 yingzi Exp $
 */
public class JsonResultFormat {

    //返回成功  code
    private static final int    DEFAULT_SUCESS_CODE = 0;

    private static final String STATUS_KEY          = "status";

    private static final String DATA_KEY            = "data";

    private static final String PAGE_KEY            = "page";
    //成功默认的msg
    private static final String DEFAULT_SUCCESS_MSG = "success";

    static public class Status implements Serializable {

        /**  */
        private static final long serialVersionUID = 1L;

        private int               code;

        private String            msg;

        Status(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

    }

    /**
     * <pre>
     * 对成功返回的消息格式化
     * 注意:
     * 1.data必须实现Serializable,否则结果输出会出错
     * 
     * @param data 成功返回的结果
     * @param modelMap
     */
    public static void sucess(Object data, ModelMap modelMap) {
        Status status = new Status(DEFAULT_SUCESS_CODE, DEFAULT_SUCCESS_MSG);
        modelMap.put(JsonResultFormat.STATUS_KEY, status);
        modelMap.put(JsonResultFormat.DATA_KEY, data == null ? null : data);
    }

    /**
     * <pre>
     * 对分页查询结果格式化
     * 注意:
     * 1.data必须实现Serializable,否则结果输出会出错
     * 2. page对象必须格式化
     * @param data 查询结果对象
     * @param page 分页对象 
     * @param modelMap
     */
    public static void successForPage(Object data, Object page, ModelMap modelMap) {
        Status status = new Status(DEFAULT_SUCESS_CODE, DEFAULT_SUCCESS_MSG);
        modelMap.put(JsonResultFormat.STATUS_KEY, status);
        modelMap.put(JsonResultFormat.DATA_KEY, data == null ? null : data);
        modelMap.put(JsonResultFormat.PAGE_KEY, page == null ? null : page);
    }

    /**
     * 对失败消息的格式化
     * 
     * @param exception 异常枚举
     * @param modelMap
     */
    public static void failure(ExceptionCodeEnum exception, ModelMap modelMap) {
        Status status = new Status(exception.getCode(), exception.getMessage());
        modelMap.put(JsonResultFormat.STATUS_KEY, status);
        modelMap.put(JsonResultFormat.DATA_KEY, null);
    }
    
    /**
     * 对失败消息的格式化
     * 
     * 
     * @param code 异常码
     * @param errorMessage 异常信息
     * @param modelMap
     */
    public static void failure(int code, String errorMessage,ModelMap modelMap){
        Status status = new Status(code, errorMessage);
        modelMap.put(JsonResultFormat.STATUS_KEY, status);
        modelMap.put(JsonResultFormat.DATA_KEY, null);
    }

    /**
     * 对失败消息的格式化
     * <pre>
     * 注意:
     * 1.data: 必须实现Serializable,否则结果输出会出错
     * @param code 错误码
     * @param msg  错误描述
     * @param data  错误数据
     * @param modelMap
     */
    public static void failure(int code, String msg, Object data, ModelMap modelMap) {
        Status status = new Status(code, msg);
        modelMap.put(JsonResultFormat.STATUS_KEY, status);
        modelMap.put(JsonResultFormat.DATA_KEY, data);
    }
}
