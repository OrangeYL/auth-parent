package com.orange.common.result;

import lombok.Getter;

/**
 * @author: Li ZhiCheng
 * @create: 2022-10-2022/10/27 18:46
 * @description: 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(202, "服务异常"),
    DATA_ERROR(203, "数据异常"),
    ILLEGAL_REQUEST(204, "非法请求"),
    REPEAT_SUBMIT(205, "重复提交"),
    ARGUMENT_VALID_ERROR(206, "参数校验异常"),

    LOGIN_AUTH(207, "未登陆"),
    PERMISSION(208, "没有权限"),
    ACCOUNT_ERROR(209, "账号不正确"),
    PASSWORD_ERROR(210, "密码不正确"),
    USERNAME_ERROR( 211, "账号不正确"),
    ACCOUNT_STOP( 212, "账号已停用"),
    NODE_ERROR( 213, "该节点下有子节点，不可以删除")
    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
