package fate.saber.blogkeep.service.impl;


import fate.saber.blogkeep.entity.JobConfigInfo;
import fate.saber.blogkeep.entity.UserRequest;
import fate.saber.blogkeep.service.SchedulerServiceClient;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Component
@Slf4j(topic = "BIZ-SERVICE")
//@HSFProvider(serviceInterface = SchedulerServiceClient.class, clientTimeout = 3000)
@Validated
public class SchedulerServiceClientImpl implements SchedulerServiceClient {

    @Override
    public List<JobConfigInfo> queryJobList(String appName, String env, Integer status, String userId) {
        // 省略业务代码
        return null;
    }

    @Override
    public void objectTest(UserRequest userRequest) {

    }
}