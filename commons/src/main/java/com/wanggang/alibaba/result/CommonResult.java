package com.wanggang.alibaba.result;

/**
 * @ClassName : ResultBuilder
 * @Description :
 * @Author : wanggang
 * @Date: 2020-09-21 18:03
 * @Version 1.0
 **/

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private int code;

    private String message;

    private T result;

    private String responseTime;

    public CommonResult(T data, int code, String message) {
        this.result = data;
        this.code = code;
        this.message = message;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public CommonResult(T data, com.wanggang.alibaba.result.StatusCode statusCode) {
        this.result = data;
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public CommonResult(T data, com.wanggang.alibaba.result.StatusCode statusCode, String extendMsg) {
        this.result = data;
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage() + extendMsg;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public CommonResult(com.wanggang.alibaba.result.StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public CommonResult(com.wanggang.alibaba.result.StatusCode statusCode, String extendMsg) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage() + extendMsg;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public CommonResult(int code) {
        this.code = code;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public JSONObject toJSONObject() {
        JSONObject out = new JSONObject();
        out.put("code", code);
        out.put("message", message);
        out.put("result", result);
        out.put("responseTime", responseTime);
        return out;
    }

    //测试
    public static void main(String[] args) {
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "wanggang");
        jsonData.put("age", 136);
        CommonResult<JSONObject> commonResult = new CommonResult<>(jsonData, com.wanggang.alibaba.result.StatusCode.SUCCESS);
        System.out.println(commonResult);
    }

}
