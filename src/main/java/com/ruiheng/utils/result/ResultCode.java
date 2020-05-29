package com.ruiheng.utils.result;

/**
 * @author : Hyh
 * @creationDate : 2019/6/6 11:30
 * @program : com.hyh.hsrlproject.util.Code.ResultCode
 * @description : 返回参数状态码类
 */
public class  ResultCode {

    //用户友好提示
    public static int CODE_VALUE_SUCCESS = 0;
    public static ResultCode SUCCESS = new ResultCode(100, "成功");
    public static ResultCode FAILURE = new ResultCode(10000, "数据处理错误");
    public static ResultCode UNAUTHENTICATED =  new ResultCode(10001,"您还未登录");
    public static ResultCode UNAUTHORISE =  new ResultCode(10002,"权限不足");
    public static ResultCode USEREXISTS =  new ResultCode(10003,"用户账号已存在");
    public static ResultCode ENTERPRISEPHONEEXISTS =  new ResultCode(10004,"企业账号手机号已存在");
    public static ResultCode ENTERPRISENAMEEXISTS =  new ResultCode(10005,"企业名称已存在");
    public static ResultCode FALLBACK_FAILURE = new ResultCode(99999999, "无法访问服务");
    public static ResultCode MICROSERVICE_DISABLED = new ResultCode(99999998, "微服务没有启用");
    /**
     * 返回状态码
     */
    private int code;
    /**
     * 返回消息描述
     */
    public String msg;

    public static ResultCode newInstance(ResultCode errorCode, String msg) {
        return new ResultCode(errorCode.getCode(), msg);
    }

    public ResultCode() {
    }

    public ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
