package com.blood.user.service.blooduserservice.externalAPI;

import com.blood.user.service.blooduserservice.Entity.BloodOrganizationClass;
import com.blood.user.service.blooduserservice.Entity.EyeOrganizationClass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "ADMIN-SERVICE", url = "http://localhost:8085/api/admin")
public interface ISearchBloodAndEye {
    @GetMapping("/all-blood-organization-in-division")
    public List<BloodOrganizationClass> getAllBloodOrganization_in_division(@RequestParam("division") String division);

    @GetMapping("/all-blood-organization-in-distric")
    public List<BloodOrganizationClass> getAllBloodOrganization_in_distric(@RequestParam("distric") String distric);

    @GetMapping("/all-blood-organization-in-upazila")
    public List<BloodOrganizationClass> getAllBloodOrganization_in_upazila(@RequestParam("upazila") String upazila);

    @GetMapping("/all-blood-organization-in-bloodtype")
    public List<Map<String, String>> getAllBloodOrganization_by_bloodType(@RequestParam("bloodtype") String bloodtype);

    @GetMapping("/all-eye-organization-in-division")
    public List<EyeOrganizationClass> getAllEyeOrganization_in_division(@RequestParam("eyeOrganizationDivision") String eyeOrganizationDivision);

    @GetMapping("/all-eye-organization-in-distric")
    public List<EyeOrganizationClass> getAllEyeOrganization_in_distric(@RequestParam("eyeOrganizationDistric") String eyeOrganizationDistric);

    @GetMapping("/all-eye-organization-in-upazila")
    public List<EyeOrganizationClass> getAllEyeOrganization_in_upazila(@RequestParam("eyeOrganizationUpazila") String eyeOrganizationUpazila);

    @GetMapping("/all-eye-organization")
    public List<EyeOrganizationClass> getAllEyeOrganization();
}
