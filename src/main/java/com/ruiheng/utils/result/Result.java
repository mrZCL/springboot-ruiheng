package com.ruiheng.utils.result;

/**
 * @author : Administrator
 * @creationDate : 2019/6/6 11:20
 * @program : com.hyh.hsrlproject.util.Code.Result
 * @description : 返回参数实体类
 * @param <T>
 */
public class Result<T> {

    /**
     * @Fields code : 返回状态码
     */
    private int code;

    /**
     * @Fields msg : 返回消息描述
     */
    private String msg;

    /**
     * @Fields data : 返回实体数据
     */
    private T data;

    /**
     * 返回参数状态码类
     */
    private ResultCode resultCode;

    public Result(){

    }

    /**
     * <p>Title: </p>
     * <p>Description: 异常返回时的返回构造描述</p>
     * @param resultCode
     * @param data
     */
    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public Result(T data){
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = "";
        this.data = data;
    }

    public Result(ResultCode resultCode) {
        this(resultCode, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
