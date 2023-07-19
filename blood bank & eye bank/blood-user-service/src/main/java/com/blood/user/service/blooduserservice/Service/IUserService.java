package com.blood.user.service.blooduserservice.Service;

import com.blood.user.service.blooduserservice.Entity.BloodOrganizationClass;
import com.blood.user.service.blooduserservice.Entity.BloodRequestClass;
import com.blood.user.service.blooduserservice.Entity.EyeOrganizationClass;
import com.blood.user.service.blooduserservice.Entity.EyeRequestClass;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public List<Map<String, String>> findBybloodtype(String bloodtype);
    public List<BloodOrganizationClass> findByDivision(String division);
    public List<BloodOrganizationClass> findByDistric(String distric);
    public List<BloodOrganizationClass> findByUpozila(String upozila);
    public void sendRequest(BloodRequestClass bloodRequest);

    public void sendEyeRequest(EyeRequestClass eyeRequestClass);

    public List<EyeOrganizationClass> findAllEyeOrganization();
    public List<EyeOrganizationClass> findByEyeDivision(String division);
    public List<EyeOrganizationClass> findByEyeDistric(String distric);
    public List<EyeOrganizationClass> findByEyeUpazila(String upazila);




//    User blood service;
//3. Search blood
//4. Send blood request
}
