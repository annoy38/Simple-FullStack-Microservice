package com.blood.user.service.blooduserservice.Service;

import com.blood.user.service.blooduserservice.Entity.BloodOrganizationClass;
import com.blood.user.service.blooduserservice.Entity.BloodRequestClass;
import com.blood.user.service.blooduserservice.Entity.EyeOrganizationClass;
import com.blood.user.service.blooduserservice.Entity.EyeRequestClass;
import com.blood.user.service.blooduserservice.externalAPI.ISearchBloodAndEye;
import com.blood.user.service.blooduserservice.externalAPI.ISendEyeRequest;
import com.blood.user.service.blooduserservice.externalAPI.ISendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ImpUserServiceClass implements IUserService {

    @Autowired
    private ISendRequest iSendRequest;

    @Autowired
    private ISearchBloodAndEye iSearchBloodAndEye;

    @Autowired
    private ISendEyeRequest iSendEyeRequest;

    @Override
    public List<BloodOrganizationClass> findByDivision(String division) {
        return iSearchBloodAndEye.getAllBloodOrganization_in_division(division);
    }

    @Override
    public List<BloodOrganizationClass> findByDistric(String distric) {
        return iSearchBloodAndEye.getAllBloodOrganization_in_distric(distric);
    }

    @Override
    public List<BloodOrganizationClass> findByUpozila(String upozila) {
        return iSearchBloodAndEye.getAllBloodOrganization_in_upazila(upozila);
    }

    @Override
    public List<Map<String, String>> findBybloodtype(String bloodtype) {
        return iSearchBloodAndEye.getAllBloodOrganization_by_bloodType(bloodtype);
    }

    @Override
    public void sendRequest(BloodRequestClass bloodRequest) {
        iSendRequest.sendBloodRequest(bloodRequest);
    }

    @Override
    public void sendEyeRequest(EyeRequestClass eyeRequestClass) {
        iSendEyeRequest.sendEyeRequest(eyeRequestClass);
    }

    @Override
    public List<EyeOrganizationClass> findAllEyeOrganization() {
        return iSearchBloodAndEye.getAllEyeOrganization();
    }

    @Override
    public List<EyeOrganizationClass> findByEyeDivision(String division) {
        return iSearchBloodAndEye.getAllEyeOrganization_in_division(division);
    }

    @Override
    public List<EyeOrganizationClass> findByEyeDistric(String distric) {
        return iSearchBloodAndEye.getAllEyeOrganization_in_distric(distric);
    }

    @Override
    public List<EyeOrganizationClass> findByEyeUpazila(String upazila) {
        return iSearchBloodAndEye.getAllEyeOrganization_in_upazila(upazila);
    }

}
