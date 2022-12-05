package com.example.enumentity;

/**
 * 此枚举定义如果不合适或定义缺失，可自行实现ResultCodeInterface
 *
 * @author roc
 */
public enum ResultCodeEnum implements ResultCodeInterface {


    PARAMETER_ERROR (-1, "请求参数有误"),
    AUTHORIZATION_ERROR (-1,"权限不足"),
    RESOURCE_NOT_FOUND (-1, "资源未找到"),
    TIME_OUT (-1, "请求超时"),
    SYSTEM_ERROR (-1, "系统错误"),
    ERROR(-1, "操作失败"),
    DATA_TOO_MUSH(-1, "时间区间过大, 建议线下处理"),
    TOO_MANY_REQUEST(-1,"系统繁忙,请稍后再试"),
    UNAUTHORIZED(-1,"请求未认证"),
    ILLEGAL_ARGUMENT(-1,"无效的参数"),
    FORBIDDEN(-1, "请求未授权"),
    SYS_FORBIDDEN(-1, "系统未授权"),
    NOT_FOUND(-1,"找不到请求"),
    EXPIRED(-1,"请求已失效"),
    WRONG_IMAGE_CODE(-1,"验证码错误"),
    NEED_RAND_CODE(-1, "请输入验证码"),
    SERVER_ERROR(-1, "服务异常，请联系管理员"),
    WRONG_PASSWORD_OR_USERNAME(-1,"用户或密码错误"),
    EXCEL_IMPORT_ERROR(-1,"导入数据失败"),
    ;

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}