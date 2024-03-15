package fate.saber.blogkeep.controller;

import fate.saber.blogkeep.entity.BaseResult;
import fate.saber.blogkeep.entity.validationGroup.UpdateUser;
import fate.saber.blogkeep.entity.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//ParamValidation
@RestController
public class ParamValidationController {

    //Controller 相应方法中，使用 @Valid/@Validated 注解开启数据校验功能
    //为了优化错误显示，使用GlobalExceptionHandler捕捉错误并进行了显示优化
    //@Validated [4]注解，是 Spring Validation 所定义，可以添加在类、方法参数、普通方法上，表示它们需要进行约束校验。
    @RequestMapping(value = "/api/saveUser", method = RequestMethod.POST)
    public ResponseEntity<BaseResult> saveUser(@Validated @RequestBody UserRequest user) {


        // 省略其他业务代码
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //指定分组校验，只在UpdateUser.class下对userDetail字段进行校验
    @PostMapping(value = "/api/updateUser")
    public ResponseEntity<BaseResult> updateUser(@Validated(UpdateUser.class) @RequestBody UserRequest userRequest) {
        // 更新用户逻辑
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
