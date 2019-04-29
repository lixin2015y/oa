package com.lee.common;


/**
 * @author lee
 */
public class Result {

    public static ResponseMessage success() {
        return new ResponseMessage("0", "成功", null);
    }

    public static ResponseMessage success(Object data) {
        return new ResponseMessage("0", "成功", data);
    }

    public static ResponseMessage error() {
        return new ResponseMessage("-1", "失败", null);
    }

    public static ResponseMessage error(String code, String message) {
        return new ResponseMessage(code, message, null);
    }

    public static ResponseMessage error(Object data) {
        return new ResponseMessage("-1", "失败", data);
    }

    public static ResponseMessage error(String message) {
        return new ResponseMessage("-1", message, null);
    }

}










