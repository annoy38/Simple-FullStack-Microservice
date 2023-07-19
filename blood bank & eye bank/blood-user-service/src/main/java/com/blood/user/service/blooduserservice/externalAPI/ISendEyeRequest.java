package com.blood.user.service.blooduserservice.externalAPI;

import com.blood.user.service.blooduserservice.Entity.EyeRequestClass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "EYE-ORGANIZATION-SERVICE", url = "http://localhost:8082/organization/eyeorganization")
public interface ISendEyeRequest {

    @PostMapping("/send-eye-request")
    public String sendEyeRequest(@RequestBody EyeRequestClass eyeRequestClass);
}
