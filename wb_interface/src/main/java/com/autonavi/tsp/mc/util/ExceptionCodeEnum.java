/**
 * autonavi.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.autonavi.tsp.mc.util;

/**
 *定义系统所有异常
 * @author haiying.deng
 * @version $Id: ExceptionCodeEnum.java, v 0.1 2014-10-16 下午3:57:48 yingzi Exp $
 */
public enum ExceptionCodeEnum {
    UNKNOW_EXCEPTION(1001, "服务器忙,请稍后再试!"),
    TAOBAOID_VIN_ISNULL(1002, "淘宝id和vin不能都为空!"),
    HISPOIID_MUST_INPUT(1003, "历史poi的id,为必输条件!"),
    PARAM_MUST_INPUT(1004, "参数%s不能为空!"),  //使用String.format(,)格式化.
    PARAM_MUST_NUMBER(1005, "参数%s必须为正数!"),   //使用String.format(,)格式化.
    ISFREE_MUST_IN_0_1_2(1006, "参数isFree必须为0/1/2中的一个!"),
    ID_ISNOTEXIST_INPUT(1007,"参数%s不存在"),
    TAOBAOID_VIN_IS_BIND(1008,"该淘宝id和vin已绑定,请勿重复提交!"),
    VEHICLE_INFO_IS_NULL(1009,"该vin对应的车辆信息未找到,暂无法绑定!"),
    SEND_TO_CAR_EXCEPTION(1010, "SEND TO CAR FAILED!")
    ;

    ExceptionCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int    code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 根据异常码获取异常
     * 
     * @param code 异常code
     * @return
     */
    public static ExceptionCodeEnum get(int code) {
        for (ExceptionCodeEnum exceptionEnum : ExceptionCodeEnum.values()) {
            if (exceptionEnum.getCode() == code) {
                return exceptionEnum;
            }
        }
        return null;
    }

    /**
     * 根据异常码获取异常信息
     * 
     * @param code 异常code
     * @return
     */
    public static String getMessageByCode(int code) {
        for (ExceptionCodeEnum exceptionEnum : ExceptionCodeEnum.values()) {
            if (exceptionEnum.getCode() == code) {
                return exceptionEnum.getMessage();
            }
        }
        return null;
    }
}
