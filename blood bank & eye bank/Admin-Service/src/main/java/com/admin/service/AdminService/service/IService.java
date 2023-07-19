package com.admin.service.AdminService.service;

import com.admin.service.AdminService.entity.*;

import java.util.List;
import java.util.Map;

public interface IService {

    public List<BloodOrganizationClass> allOrganization();

    public void getRequest(DeliveryRequestsClass deliveryRequestsClass);

    public List<DeliveryRequestsClass> getAllRequest();
    public void updateDeliveryRequest(String deliverId, String status);
    public void saveOrganizationInfo(OrganizationsInfoClass organizationsInfoClass);
    public void deleteBloodOrg(String accountEmail);
    public void saveDonorsInfo(DonorInfoClass donorInfoClass);
    public void deleteAllDonors(String bloodOrganizationId);
    public List<BloodOrganizationClass> getAllOrganization();
    public List<BloodOrgModel> getDivisionOrganizations(String division);
    public List<BloodOrgModel> getDistricOrganizations(String distric);
    public List<BloodOrgModel> getUpazilaOrganizations(String upazila);
    public List<Map<String, String>> findBlood(String donarBloodType);
    public long totalNumberOfBloodOrganizations();
    public long totalNumberOfBloodDonors();


    public void saveEyeOrganizationInfo(EyeOrganizationInfoClass organizationInfoClass);
    public void deleteEyeOrganization(String accountEmail);
    public void saveEyeDonorInfo(EyeDonorInfoClass eyeDonorInfoClass);
    public void deleteEyeDonors(String eyeOrganizationId);

    public List<EyeOrgClass> getAllEyeOrganization();
    public List<EyeOrgClass> getDivisionEyeOrganizations(String division);
    public List<EyeOrgClass> getDistricEyeOrganizations(String distric);
    public List<EyeOrgClass> getUpazilaEyeOrganizations(String upazila);

    public Long totalNumberOfEyeOrg();
    public Long totalNumberOfEyeDonors();

    void deleteDonorbyId(String donarId);


//    Admin Service:
//   1. Show total number of blood organization register in system and their details
//   2. Show total number of eye orgganization register in system and their details
//   3. Blood organization data analysis
//   4. Eye organization data analysis
//   5. See delivery request

}
