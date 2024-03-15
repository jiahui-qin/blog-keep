package fate.saber.blogkeep.entity;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InEnumValidator.class)
public @interface InEnum {
    /**
     * 枚举类型
     *
     * @return
     */
    Class<? extends Enum> enumType();

    String message() default "枚举类型不匹配";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
