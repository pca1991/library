package priv.library.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Austin
 * @description 接口日志切面
 * @date 2023/2/20 20:56
 */
@Component
@Aspect
@Slf4j
public class WebLogAspect {
    @Pointcut("execution(public * priv.library.controller.*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        String methodName = point.getSignature().toShortString();

        Object[] params = point.getArgs();

        if (log.isInfoEnabled()) {
            log.info("method = {}, request={}", methodName, params);
        }

        Object result = point.proceed();

        if (log.isInfoEnabled()) {
            log.info("method = {}, result={}", methodName, JSON.toJSONString( result));
        }
        return result;

    }
}
