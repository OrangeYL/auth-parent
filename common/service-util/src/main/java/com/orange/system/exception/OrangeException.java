package com.orange.system.exception;

import com.orange.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author: Li ZhiCheng
 * @create: 2022-10-2022/10/28 14:56
 * @description: 自定义全局异常
 */
@Data
public class OrangeException extends RuntimeException{
    //状态码
    private Integer code;
    //返回消息
    private String message;
    /**
     * @description: 通过状态码和消息创建异常对象
     * @author: Li ZhiCheng
     * @date: 2022/10/28 14:58
     * @param: [code, message]
     * @return:
     **/
    public OrangeException(Integer code,String message){
        super(message);
        this.code=code;
        this.message=message;
    }
    /**
     * @description: 接收枚举类型对象
     * @author: Li ZhiCheng
     * @date: 2022/10/28 15:00
     * @param: [resultCodeEnum]
     * @return:
     **/
    public OrangeException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code= resultCodeEnum.getCode();
        this.message=resultCodeEnum.getMessage();
    }
    @Override
    public String toString() {
        return "OrangeException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
