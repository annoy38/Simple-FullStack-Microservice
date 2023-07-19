package com.blood.user.service.blooduserservice.externalAPI;

import com.blood.user.service.blooduserservice.Entity.BloodRequestClass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "BLOOD-ORGANIZATION-SERVICE", url = "http://localhost:8081/organization/bloodorganization")
public interface ISendRequest {
    @PostMapping("/send-request")
    public String sendBloodRequest(@RequestBody BloodRequestClass bloodRequestClass);
}
