package com.admin.service.AdminService.externalAPI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "EYE-ORGANIZATION-SERVICE", url = "http://localhost:8082/organization/eyeorganization")
public interface IUpdateEyeDeliveryData {

    @PutMapping("/update-delivery-request")
    public String update_delivery_request(@RequestParam("deliverId") String deliverId, @RequestParam("status") String status);
}
