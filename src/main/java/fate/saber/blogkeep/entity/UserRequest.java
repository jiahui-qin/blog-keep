package fate.saber.blogkeep.entity;


import fate.saber.blogkeep.entity.validationGroup.InsertUser;
import fate.saber.blogkeep.entity.validationGroup.UpdateUser;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
//paramValidation
@Data
public class UserRequest {

    // spring 提供的参数校验，由spring-boot-starter-validation引入,Spring MVC 中添加了自动校验
    @NotBlank(message = "用户ID不能为空")
    private String userId;

    @NotBlank(message = "电话号码不能为空")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", message = "电话号码格式错误")
    private String mobilePhone;

    @Min(message = "年龄必须大于0", value = 0)
    @Max(message = "年龄不能超过150", value = 150)
    private Integer age;

    //@Valid [3]注解，是 Bean Validation 所定义，可以添加在普通方法、构造方法、方法参数、方法返回、成员变量上，表示它们需要进行约束校验。
    @NotNull(message = "用户详情不能为空", groups = {UpdateUser.class, InsertUser.class})
    @Valid
    private String userDetail;

    //自定义校验注解
    @InEnum(enumType = GenderEnum.class, message = "用户性别不在枚举范围内")
    private String gender;

//    @Data
//    private class UserDetail {
//        String detail;
//    }


}