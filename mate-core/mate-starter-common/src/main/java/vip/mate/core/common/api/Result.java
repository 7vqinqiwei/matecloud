package vip.mate.core.common.api;

import com.alibaba.cola.exception.result.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import vip.mate.core.common.constant.MateConstant;

import java.io.Serializable;

/**
 * 统一响应消息报文
 *
 * @param <T> 　T对象
 * @author pangu
 */
@Data
@Getter
@Schema(description = "统一响应消息报文")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "状态码", required = true)
    private int code;

    @Schema(description = "消息内容", required = true)
    private String msg;

    @Schema(description = "时间戳", required = true)
    private long time;

    @Schema(description = "业务数据")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private Result() {
        this.time = System.currentTimeMillis();
    }

    private Result(ErrorCode resultCode) {
        this(resultCode, null, resultCode.getMsg());
    }

    private Result(ErrorCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private Result(ErrorCode resultCode, T data) {
        this(resultCode, data, resultCode.getMsg());
    }

    private Result(ErrorCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.time = System.currentTimeMillis();
    }

    /**
     * 返回状态码
     *
     * @param resultCode 状态码
     * @param <T>        泛型标识
     * @return ApiResult
     */
    public static <T> Result<T> success(ErrorCode resultCode) {
        return new Result<>(resultCode);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(ErrorCode.OK, msg);
    }

    public static <T> Result<T> success(ErrorCode resultCode, String msg) {
        return new Result<>(resultCode, msg);
    }

    public static <T> Result<T> data(T data) {
        return data(data, MateConstant.DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> data(T data, String msg) {
        return data(ErrorCode.OK.getCode(), data, msg);
    }

    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result<>(code, data, data == null ? MateConstant.DEFAULT_NULL_MESSAGE : msg);
    }

    public static <T> Result<T> fail() {
        return new Result<>(ErrorCode.BAD_REQUEST, ErrorCode.BAD_REQUEST.getMsg());
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<>(ErrorCode.BAD_REQUEST, msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, null, msg);
    }

    public static <T> Result<T> fail(ErrorCode resultCode) {
        return new Result<>(resultCode);
    }

    public static <T> Result<T> fail(ErrorCode resultCode, String msg) {
        return new Result<>(resultCode, msg);
    }

    public static <T> Result<T> condition(boolean flag) {
        return flag ? success(MateConstant.DEFAULT_SUCCESS_MESSAGE) : fail(MateConstant.DEFAULT_FAIL_MESSAGE);
    }
}
