package priv.library.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.UnsupportedEncodingException;

/**
 * @author Austin
 * @description 字节长度校验注解的实现方法
 * @date 2023/2/8 14:37
 */
public class ByteLengthValidator implements ConstraintValidator<ByteLength,Object> {
    private String charset;
    private int min;
    private int max;

    @Override
    public void initialize(ByteLength constraintAnnotation) {
        charset = constraintAnnotation.charset();
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if( value == null){
            return true;
        } else {
            int length;
            try {
                length = value.toString().getBytes( charset).length;
            } catch (UnsupportedEncodingException e) {
                return false;
            }

            return length > min && length < max;
        }
    }
}
