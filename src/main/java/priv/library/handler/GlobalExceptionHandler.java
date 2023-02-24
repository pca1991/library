package priv.library.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;
import priv.library.domain.base.CommonResult;
import priv.library.domain.base.ErrorCode;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * @author Austin
 * @description 全局异常捕获
 * @date 2021/8/16 2:17 下午
 */
@Slf4j
@ResponseBody
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    /**
     * mvc body 转换异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CommonResult<?> jsonParseException(HttpMessageNotReadableException e) {
        return CommonResult.failed(ErrorCode.PARAM_UNPACKAGE_FAILED);
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public CommonResult<?> violationHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(","));

        return CommonResult.validateFailed( message);
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<?> paramsException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ":" + fieldError.getDefaultMessage())
                .collect(Collectors.joining(","));

        return CommonResult.validateFailed( message);
    }

    /**
     * sa-token权限校验异常
     */
    @ExceptionHandler(NotPermissionException.class)
    public CommonResult<?> notPermissionException(NotPermissionException e) {
        return CommonResult.failed(ErrorCode.NOT_PERMISSION_FAILED);
    }

    /**
     * sa-token权限校验异常
     */
    @ExceptionHandler(NotLoginException.class)
    public CommonResult<?> notPermissionException(NotLoginException e) {
        return CommonResult.failed(ErrorCode.NOT_LOGIN_FAILED);
    }

    @ExceptionHandler(JsonMappingException.class)
    public CommonResult<?> jsonParseError(JsonMappingException e) {
        return CommonResult.failed( ErrorCode.PARAM_REQ_FORMAT_FAILED);
    }

    /**
     * 数据库异常
     */
    @ExceptionHandler({SQLException.class, DuplicateKeyException.class})
    public CommonResult<?> sqlException(Exception e) {
        log.error("SQL error: " + e.getMessage(), e);
        if (e instanceof DuplicateKeyException) {
            return CommonResult.failed( ErrorCode.DB_DUPLICATE_KEY_FAILED);
        }
        return CommonResult.failed( ErrorCode.DB_SQL_FAILED);
    }

    /**
     * 运行时异常
     *
     * @param e Exception
     * @return vo
     */
    @ExceptionHandler(RuntimeException.class)
    public CommonResult<?> otherException(RuntimeException e) {
        log.error("运行时异常:", e);
        return CommonResult.failed( ErrorCode.SYS_FAILED);
    }

    /**
     * 其他未捕获异常
     *
     * @param e Exception
     * @return Result
     */
    @ExceptionHandler(Throwable.class)
    public CommonResult<?> otherException(Throwable e) {
        e.printStackTrace();
        log.error("未捕获的全局异常:{}, {} ", e.getClass().getSimpleName(), e.getMessage());
        log.error("错误堆栈:", e);
        return CommonResult.failed( ErrorCode.SYS_FAILED);
    }
}
