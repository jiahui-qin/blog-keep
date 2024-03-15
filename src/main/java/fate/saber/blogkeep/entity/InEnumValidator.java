package fate.saber.blogkeep.entity;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class InEnumValidator implements ConstraintValidator<InEnum, Object> {
    private Class<? extends Enum> enumType;

    @Override
    public void initialize(InEnum inEnum) {
        enumType = inEnum.enumType();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) {
            return true;
        }

        if (enumType == null || !enumType.isEnum()) {
            return false;
        }

        for (Enum basicEnum : enumType.getEnumConstants()) {
            if (basicEnum.toString().equals(object.toString())){
                System.out.println("!!");
                return true;
            }
        }
        return false;
    }
}