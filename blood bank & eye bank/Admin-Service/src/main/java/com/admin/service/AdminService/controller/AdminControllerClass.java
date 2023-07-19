package com.admin.service.AdminService.controller;

import com.admin.service.AdminService.entity.*;
import com.admin.service.AdminService.service.ImpServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminControllerClass {

    @Autowired
    private ImpServiceClass impServiceClass;

    @GetMapping("/message")
    public String messageApi(){
        return "Admin Api Working";
    }

    @PostMapping("/delivery-request")
    public String send_delivery_request(@RequestBody DeliveryRequestsClass deliveryRequestsClass){
        impServiceClass.getRequest(deliveryRequestsClass);
        return "Delivery Request send to admin";
    }

        @GetMapping("/get-all-delivery-request")
    public List<DeliveryRequestsClass> getAll(){
        return impServiceClass.getAllRequest();
    }

    @GetMapping("/update-delivery-request")
    public String updateDeliveryReq(@RequestParam("deliverId") String deliverId, @RequestParam("status") String status){
        impServiceClass.updateDeliveryRequest(deliverId, status);
        return "Delivery complete";
    }

    @PostMapping("/blood-registration")
    public void saveOrganization(@RequestBody OrganizationsInfoClass organizationsInfoClass){
        impServiceClass.saveOrganizationInfo(organizationsInfoClass);
    }

    @DeleteMapping("/delete-blood-organization")
    public void deleteBloodOrganization(@RequestParam("accountEmail") String accountEmail){
        impServiceClass.deleteBloodOrg(accountEmail);
    }


    @PostMapping("/save-donors")
    public String saveDonors(@RequestBody DonorInfoClass donorInfoClass){
        impServiceClass.saveDonorsInfo(donorInfoClass);
        return "Donor Info save";
    }

    @DeleteMapping("/delete-blood-donors")
    public void deleteAllBloodDonors(@RequestParam("accountId") String accountId){
        impServiceClass.deleteAllDonors(accountId);
    }

    @DeleteMapping("/delete-donor-by-id")
    public void deleteDonorbyId(@RequestParam("donarId") String donarId){
        impServiceClass.deleteDonorbyId(donarId);
    }

    @PostMapping("/eye-registration")
    public void saveEyeOrganizationInfo(@RequestBody EyeOrganizationInfoClass eyeOrganizationInfoClass){
        impServiceClass.saveEyeOrganizationInfo(eyeOrganizationInfoClass);
    }

    @DeleteMapping("/delete-account")
    public void deleteEyeOrganizationAccount(@RequestParam("accountEmail") String accountEmail){
        impServiceClass.deleteEyeOrganization(accountEmail);
    }

    @PostMapping("/save-eye-donor")
    public String saveEyeDonorInfo(@RequestBody EyeDonorInfoClass eyeDonorInfoClass){
        impServiceClass.saveEyeDonorInfo(eyeDonorInfoClass);
        return "Eye donor info save";
    }

    @DeleteMapping("/delete-eye-donors")
    public void deleteEyeDonors(@RequestParam("eyeOrganizationId") String eyeOrganizationId){
        impServiceClass.deleteEyeDonors(eyeOrganizationId);
    }

    @GetMapping("/all-blood-organization")
    public List<BloodOrganizationClass> getAllBloodOrganization(){
        return impServiceClass.getAllOrganization();
    }

    @GetMapping("/all-blood-organization-in-division")
    public List<BloodOrgModel> getAllBloodOrganization_in_division(@RequestParam("division") String division){
        return impServiceClass.getDivisionOrganizations(division);
    }

    @GetMapping("/all-blood-organization-in-distric")
    public List<BloodOrgModel> getAllBloodOrganization_in_distric(@RequestParam("distric") String distric){
        return impServiceClass.getDistricOrganizations(distric);
    }

    @GetMapping("/all-blood-organization-in-upazila")
    public List<BloodOrgModel> getAllBloodOrganization_in_upazila(@RequestParam("upazila") String upazila){
        return impServiceClass.getUpazilaOrganizations(upazila);
    }

    @GetMapping("/all-blood-organization-in-bloodtype")
    public List<Map<String, String>> getAllBloodOrganization_by_bloodType(@RequestParam("bloodtype") String bloodtype){
        return impServiceClass.findBlood(bloodtype);
    }

    @GetMapping("/total-number-of-blood-organization")
    public long numberOfBloodOrganization(){
        return impServiceClass.totalNumberOfBloodOrganizations();
    }

    @GetMapping("/total-number-of-blood-donors")
    public long numberOfBloodDonors(){
        return impServiceClass.totalNumberOfBloodDonors();
    }

    @GetMapping("/total-number-of-eye-organization")
    public long numberOfEyeOrg(){
        return impServiceClass.totalNumberOfEyeOrg();
    }

    @GetMapping("/total-number-of-eye-donors")
    public long numberOfEyeDonor(){
        return impServiceClass.totalNumberOfEyeDonors();
    }

    @GetMapping("/all-eye-organization-in-division")
    public List<EyeOrgClass> getAllEyeOrganization_in_division(@RequestParam("eyeOrganizationDivision") String eyeOrganizationDivision){
        return impServiceClass.getDivisionEyeOrganizations(eyeOrganizationDivision);
    }

    @GetMapping("/all-eye-organization-in-distric")
    public List<EyeOrgClass> getAllEyeOrganization_in_distric(@RequestParam("eyeOrganizationDistric") String eyeOrganizationDistric){
        return impServiceClass.getDistricEyeOrganizations(eyeOrganizationDistric);
    }

    @GetMapping("/all-eye-organization-in-upazila")
    public List<EyeOrgClass> getAllEyeOrganization_in_upazila(@RequestParam("eyeOrganizationUpazila") String eyeOrganizationUpazila){
        return impServiceClass.getUpazilaEyeOrganizations(eyeOrganizationUpazila);
    }

    @GetMapping("/all-eye-organization")
    public List<EyeOrgClass> getAllEyeOrganization(){
        return impServiceClass.getAllEyeOrganization();
    }
}
