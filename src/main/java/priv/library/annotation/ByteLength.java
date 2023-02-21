package priv.library.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Austin
 * @description 字节长度校验注解
 * @date 2023/2/8 14:34
 */
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ByteLengthValidator.class})
@Documented
public @interface ByteLength {
    String message() default "字节长度超限";

    int min() default  0;

    int max() default Integer.MAX_VALUE;

    String charset() default "UTF-8";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
