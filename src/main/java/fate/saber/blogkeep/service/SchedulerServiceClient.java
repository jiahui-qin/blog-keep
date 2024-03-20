package fate.saber.blogkeep.service;

import fate.saber.blogkeep.entity.JobConfigInfo;
import fate.saber.blogkeep.entity.UserRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface SchedulerServiceClient {
    /**
     * 获取应用不同环境的所有定时任务
     * @param appName 应用名称
     * @param env 环境
     * @param status 任务状态
     * @param userId 用户工号
     * @return
     */

    /*
    * 如果入参是平铺的参数
    * 首先需要在父类/接口的方法入参里增加注解约束，然后用 @Validated 修饰我们的实现类。校验失败，就会抛出一个 ConstraintViolationException 异常
    * 如果入参是对象，首先需要在方法入参类里增加 @NotNull 等注解约束，然后在父类/接口的方法入参里增加 @Valid（便于嵌套校验），最后用 @Validated 修饰我们的实现类。
    * */
    List<JobConfigInfo> queryJobList(@NotBlank(message = "应用名称不能为空")String appName,
                                     @NotBlank(message = "环境不能为空")String env,
                                     Integer status,
                                     @NotBlank(message = "用户id不能为空")String userId);


    void objectTest(@Valid UserRequest userRequest);

}