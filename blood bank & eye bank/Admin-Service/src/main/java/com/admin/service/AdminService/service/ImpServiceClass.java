package com.admin.service.AdminService.service;

import com.admin.service.AdminService.entity.*;
import com.admin.service.AdminService.externalAPI.IUpdateBloodDeliveryData;
import com.admin.service.AdminService.externalAPI.IUpdateEyeDeliveryData;
import com.admin.service.AdminService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImpServiceClass implements IService{

    @Autowired
    private IDeliveryRequestRepository deliveryRequestRepository;

    @Autowired
    private IOrganizationInfoRepository iOrganizationInfoRepository;

    @Autowired
    private IDonorsInfoRepository iDonorsInfoRepository;

    @Autowired
    private IEyeOrganizationInfoRepository iEyeOrganizationInfoRepository;

    @Autowired
    private IEyeDonorRepository iEyeDonorRepository;

    @Autowired
    private IUpdateBloodDeliveryData iUpdateBloodDeliveryData;
    @Autowired
    private IUpdateEyeDeliveryData iUpdateEyeDeliveryData;

    public ImpServiceClass() {
    }

    @Override
    public List<BloodOrganizationClass> allOrganization() {
        return null;
    }

    @Override
    public void getRequest(DeliveryRequestsClass deliveryRequestsClass) {
        deliveryRequestRepository.save(deliveryRequestsClass);
    }

    @Override
    public List<DeliveryRequestsClass> getAllRequest() {
        return deliveryRequestRepository.findAll();
    }

    @Override
    public void updateDeliveryRequest(String deliverId, String status) {
        System.out.println(deliverId+" "+status);
        DeliveryRequestsClass deliveryRequestsClass = deliveryRequestRepository.findByDeliverId(deliverId);
        if(deliveryRequestsClass.getDeliverItem().equals("Blood")){
            iUpdateBloodDeliveryData.update_delivery_request(deliverId, status);
            deliveryRequestsClass.setStatus(status);
            deliveryRequestRepository.save(deliveryRequestsClass);

            //call blood-organization service
        }
        else {
            iUpdateEyeDeliveryData.update_delivery_request(deliverId, status);
            deliveryRequestsClass.setStatus(status);
            deliveryRequestRepository.save(deliveryRequestsClass);
            //call eye-organization service
        }

    }


    @Override
    public void saveOrganizationInfo(OrganizationsInfoClass organizationsInfoClass) {
        iOrganizationInfoRepository.save(organizationsInfoClass);
    }

    @Override
    public void deleteBloodOrg(String accountEmail) {
        iOrganizationInfoRepository.deleteByAccountEmail(accountEmail);
    }

    @Override
    public void saveDonorsInfo(DonorInfoClass donorInfoClass) {
        iDonorsInfoRepository.save(donorInfoClass);
    }

    @Override
    public void deleteAllDonors(String bloodOrganizationId) {
        iDonorsInfoRepository.deleteAllByBloodOrganizationId(bloodOrganizationId);
    }

    @Override
    public void deleteDonorbyId(String donarId) {
        iDonorsInfoRepository.deleteByDonarId(donarId);
    }

    @Override
    public List<BloodOrganizationClass> getAllOrganization() {
         List<OrganizationsInfoClass> organizationsInfoClass = iOrganizationInfoRepository.findAll();
        return getBloodOrganizationClasses(organizationsInfoClass);
    }

    @Override
    public List<BloodOrgModel> getDivisionOrganizations(String organizationDivision) {
        List<OrganizationsInfoClass> organizationsInfoClasses = iOrganizationInfoRepository.findByAccountDivision(organizationDivision);
        return getBloodOrgModels(organizationsInfoClasses);
    }

    @Override
    public List<BloodOrgModel> getDistricOrganizations(String organizationDistric) {
        List<OrganizationsInfoClass> organizationsInfoClasses =  iOrganizationInfoRepository.findByAccountDistric(organizationDistric);
        return getBloodOrgModels(organizationsInfoClasses);
    }

    @Override
    public List<BloodOrgModel> getUpazilaOrganizations(String organizationUpazila) {
        List<OrganizationsInfoClass> organizationsInfoClasses = iOrganizationInfoRepository.findByAccountUpazila(organizationUpazila);
        return getBloodOrgModels(organizationsInfoClasses);
    }

    @Override
    public List<Map<String, String>> findBlood(String donarBloodType) {

        List<Map<String, String>> response = new ArrayList<>();
        List<DonorInfoClass> donors = iDonorsInfoRepository.findByDonarBloodTypeLike(donarBloodType);
//
        for (DonorInfoClass donor : donors) {
            String orgInfo = donor.getBloodOrganizationId();
            Map<String, String> bloodInfo = new HashMap<>();
            bloodInfo.put("bloodOrganizationId", iOrganizationInfoRepository.findByAccountId(orgInfo).getAccountId());
            bloodInfo.put("bloodOrganizationName", iOrganizationInfoRepository.findByAccountId(orgInfo).getAccountName());
            bloodInfo.put("bloodOrganizationEmail", iOrganizationInfoRepository.findByAccountId(orgInfo).getAccountEmail());
            bloodInfo.put("bloodOrganizationDivision", iOrganizationInfoRepository.findByAccountId(orgInfo).getAccountDivision());
            bloodInfo.put("bloodOrganizationDistric", iOrganizationInfoRepository.findByAccountId(orgInfo).getAccountDistric());
            bloodInfo.put("bloodOrganizationUpozila", iOrganizationInfoRepository.findByAccountId(orgInfo).getAccountUpazila());
            bloodInfo.put("bloods", donor.getDonarBloodType());
            response.add(bloodInfo);

        }
        return response;
    }
//


    @Override
    public long totalNumberOfBloodOrganizations() {
        long totalOrganization=0;
        totalOrganization = iOrganizationInfoRepository.findAll().stream().count();
        return totalOrganization;
    }

    @Override
    public long totalNumberOfBloodDonors() {
        long totalDonors = 0;
        totalDonors = iDonorsInfoRepository.findAll().stream().count();
        return totalDonors;
    }

    @Override
    public void saveEyeOrganizationInfo(EyeOrganizationInfoClass eyeOrganizationInfoClass) {
        iEyeOrganizationInfoRepository.save(eyeOrganizationInfoClass);
    }

    @Override
    public void deleteEyeOrganization(String accountEmail) {
        iEyeOrganizationInfoRepository.deleteByAccountEmail(accountEmail);
    }

    @Override
    public void saveEyeDonorInfo(EyeDonorInfoClass eyeDonorInfoClass) {
        iEyeDonorRepository.save(eyeDonorInfoClass);
    }

    @Override
    public void deleteEyeDonors(String eyeOrganizationId) {
        iEyeDonorRepository.deleteAllByEyeOrganizationId(eyeOrganizationId);
    }

    @Override
    public List<EyeOrgClass> getAllEyeOrganization() {
        List<EyeOrganizationInfoClass> eyeOrganizationInfoClasses = iEyeOrganizationInfoRepository.findAll();
        return getEyeOrgClasses(eyeOrganizationInfoClasses);
    }

    @Override
    public List<EyeOrgClass> getDivisionEyeOrganizations(String division) {
        List<EyeOrganizationInfoClass> eyeOrganizationInfoClasses = iEyeOrganizationInfoRepository.findByAccountDivision(division);
        return getEyeOrgClasses(eyeOrganizationInfoClasses);
    }

    @Override
    public List<EyeOrgClass> getDistricEyeOrganizations(String distric) {
        List<EyeOrganizationInfoClass> eyeOrganizationInfoClasses = iEyeOrganizationInfoRepository.findByAccountDistric(distric);
        return getEyeOrgClasses(eyeOrganizationInfoClasses);
    }

    @Override
    public List<EyeOrgClass> getUpazilaEyeOrganizations(String upazila) {
        List<EyeOrganizationInfoClass> eyeOrganizationInfoClasses = iEyeOrganizationInfoRepository.findByAccountUpazila(upazila);
        return getEyeOrgClasses(eyeOrganizationInfoClasses);
    }

    @Override
    public Long totalNumberOfEyeOrg() {
        long totalEyeOrg=0;
        totalEyeOrg = iEyeOrganizationInfoRepository.findAll().stream().count();
        return totalEyeOrg;
    }

    @Override
    public Long totalNumberOfEyeDonors() {
        long totalEyeDonors=0;
        totalEyeDonors = iEyeDonorRepository.findAll().stream().count();
        return totalEyeDonors;
    }


    private List<BloodOrganizationClass> getBloodOrganizationClasses(List<OrganizationsInfoClass> organizationsInfoClasses) {
        List<BloodOrganizationClass> bloodOrganizationClasses = organizationsInfoClasses
                .stream()
                .map(organizationsInfoClass1 -> new BloodOrganizationClass(
                        organizationsInfoClass1.getAccountId(),
                        organizationsInfoClass1.getAccountName(),
                        organizationsInfoClass1.getAccountEmail(),
                        organizationsInfoClass1.getAccountDivision(),
                        organizationsInfoClass1.getAccountDistric(),
                        organizationsInfoClass1.getAccountUpazila(),
                        iDonorsInfoRepository.findAllByBloodOrganizationId(organizationsInfoClass1.getAccountId())
                                .stream()
                                .map(DonorInfoClass::getDonarBloodType)
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
        return bloodOrganizationClasses;
    }

    private List<EyeOrgClass> getEyeOrgClasses(List<EyeOrganizationInfoClass> eyeOrganizationInfoClasses) {
        List<EyeOrgClass> eyeOrgClasses = eyeOrganizationInfoClasses
                .stream()
                .map(eyeOrganizationInfoClass1 -> new EyeOrgClass(
                        eyeOrganizationInfoClass1.getAccountId(),
                        eyeOrganizationInfoClass1.getAccountName(),
                        eyeOrganizationInfoClass1.getAccountEmail(),
                        eyeOrganizationInfoClass1.getAccountDivision(),
                        eyeOrganizationInfoClass1.getAccountDistric(),
                        eyeOrganizationInfoClass1.getAccountUpazila()
//                        iEyeDonorRepository.findAllByEyeOrganizationId(eyeOrganizationInfoClass1.getAccountId())
//                                .stream()
//                                .map(EyeDonorInfoClass::getDonorBloodType)
//                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
        return eyeOrgClasses;
    }
    private List<BloodOrgModel> getBloodOrgModels(List<OrganizationsInfoClass> organizationsInfoClasses) {
        List<BloodOrganizationClass> rawPayload = getBloodOrganizationClasses(organizationsInfoClasses);
        List<BloodOrgModel> newModel = new ArrayList<BloodOrgModel>();
        BloodOrgModel temp;
        for(BloodOrganizationClass obj: rawPayload) {
            for(String blood: obj.getBloods()) {
                temp = new BloodOrgModel();
                temp.setBloodOrganizationId(obj.getBloodOrganizationId());
                temp.setBloodOrganizationName(obj.getBloodOrganizationName());
                temp.setBloodOrganizationEmail(obj.getBloodOrganizationEmail());
                temp.setBloodOrganizationDivision(obj.getBloodOrganizationDivision());
                temp.setBloodOrganizationDistric(obj.getBloodOrganizationDistric());
                temp.setBloodOrganizationUpozila(obj.getBloodOrganizationUpozila());
                temp.setBloods(blood);
                newModel.add(temp);
            }
        }
        return newModel;
    }

}
