package com.eye.organization.eyeorganization.service;

import com.eye.organization.eyeorganization.entity.*;
import com.eye.organization.eyeorganization.externalAPI.IAccountDeleteAndUpdate;
import com.eye.organization.eyeorganization.externalAPI.IEyeOrganizationInfo;
import com.eye.organization.eyeorganization.repository.IAccountRegistrationRepository;
import com.eye.organization.eyeorganization.repository.IDeliveryRequestRepository;
import com.eye.organization.eyeorganization.repository.IDonorRepository;
import com.eye.organization.eyeorganization.repository.IEyeRequestRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class EyeServiceClass implements IEyeService{

//    int code = ThreadLocalRandom.current().nextInt();
//    String varificationCode = String.valueOf(code);
    @Autowired
    private IAccountRegistrationRepository iAccountRegistrationRepository;

    @Autowired
    private IDonorRepository iDonorRepository;

    @Autowired
    private IDeliveryRequestRepository deliveryRequestRepository;

    @Autowired
    private IEyeOrganizationInfo iEyeOrganizationInfo;

    @Autowired
    private IEyeRequestRepository iEyeRequestRepository;

    @Autowired
    private IAccountDeleteAndUpdate iAccountDeleteAndUpdate;

    @Override
    public void RegistrationAccount(EyeOrganizationAccountClass accountClass) {
                iAccountRegistrationRepository.save(accountClass);
    }

    @Override
    public AccountProfileClass AccountProfile(String accountEmail) {
       EyeOrganizationAccountClass accountClass =  getDetails(accountEmail);
       AccountProfileClass accountProfileClass = new AccountProfileClass(accountClass.getAccountName(),
               accountClass.getAccountNumber(), accountClass.getAccountEmail(), accountClass.getAccountDivision(),
               accountClass.getAccountDistric(), accountClass.getAccountUpazila());
       return accountProfileClass;
    }

    @Override
    public void deleteAccount(String accountEmail) {

        iAccountDeleteAndUpdate.deleteAccount(accountEmail);

        iEyeOrganizationInfo.deleteEyeOrganizationAccount(accountEmail);
        iEyeOrganizationInfo.deleteEyeDonors(getDetails(accountEmail).getAccountId());

        iDonorRepository.deleteAllByEyeOrganizationId(getDetails(accountEmail).getAccountId());
        iAccountRegistrationRepository.deleteByAccountEmail(accountEmail);

    }

    @Override
    public void updateAccount(EyeOrganizationAccountClass accountClass, String accountEmail) {
        EyeOrganizationAccountClass accountClass1 = getDetails(accountEmail);
        accountClass1.setAccountName(accountClass.getAccountName());
        accountClass1.setAccountNumber(accountClass.getAccountNumber());
        accountClass1.setAccountEmail(accountClass.getAccountEmail());
        accountClass1.setAccountDivision(accountClass.getAccountDivision());
        accountClass1.setAccountDistric(accountClass.getAccountDistric());
        accountClass1.setAccountUpazila(accountClass.getAccountUpazila());
        iAccountRegistrationRepository.save(accountClass1);
    }

    @Override
    public void saveDonorInfo(EyeDonarClass eyeDonarClass, String accountEmail) {
        String randomUUID = UUID.randomUUID().toString();
        eyeDonarClass.setDonorId(randomUUID);
        eyeDonarClass.setEyeOrganizationId(getDetails(accountEmail).getAccountId());
        iDonorRepository.save(eyeDonarClass);
        iEyeOrganizationInfo.saveEyeDonor(eyeDonarClass);
    }

    @Override
    public List<EyeDonarClass> getAllDonors(String accountEmail) {
        EyeOrganizationAccountClass accountClass = getDetails(accountEmail);
        List<EyeDonarClass> eyeDonarClasses = iDonorRepository.findByEyeOrganizationId(accountClass.getAccountId());
//        EyeOrganizationDonorDetailsClass donorDetailsClass = new EyeOrganizationDonorDetailsClass(
//                accountClass.getAccountName(),
//                accountClass.getAccountNumber(),
//                accountClass.getAccountEmail(),
//                accountClass.getAccountDivision(),
//                accountClass.getAccountDistric(),
//                accountClass.getAccountUpazila(),
//                eyeDonarClasses.stream().map(d-> new EyeDonarClass(
//                        d.getDonorId(),
//                        d.getEyeOrganizationId(),
//                        d.getDonorName(),
//                        d.getDonorEmail(),
//                        d.getDonorAge(),
//                        d.getDonorAddress(),
//                        d.getDonorBloodType(),
//                        d.getDonorGender()
//                )).collect(Collectors.toList())
//        );
        return eyeDonarClasses;
    }

    @Override
    public void deleteAllDonor() {
        iDonorRepository.deleteAll();
    }

    @Override
    public void sendDeliveryRequest(DeliveryRequestClass deliveryRequestClass, String accountEmail) {
        String randomUUID = UUID.randomUUID().toString();
        deliveryRequestClass.setDeliverId(randomUUID);
        deliveryRequestClass.setOrganizationId(getDetails(accountEmail).getAccountId());
        deliveryRequestClass.setOrganizationName(getDetails(accountEmail).getAccountName());
        deliveryRequestClass.setOrganizationNumber(getDetails(accountEmail).getAccountNumber());
        deliveryRequestClass.setOrganizationLocation(getDetails(accountEmail).getAccountDistric());
        deliveryRequestClass.setDeliverItem("Eye");
        deliveryRequestClass.setStatus("Incomplete");
        deliveryRequestRepository.save(deliveryRequestClass);
        iEyeOrganizationInfo.send_delivery_request(deliveryRequestClass);
    }

    @Override
    public void updateDeliveryRequest(String deliverId, String status) {
        System.out.println(deliverId+" "+status);
    DeliveryRequestClass deliveryRequestClass = deliveryRequestRepository.findByDeliverId(deliverId);
        System.out.println(deliveryRequestClass);
        deliveryRequestClass.setStatus(status);
    deliveryRequestRepository.save(deliveryRequestClass);
    }

    @Override
    public List<DeliveryRequestClass> allRequest(String accountEmail) {

        return deliveryRequestRepository.findByOrganizationId(getDetails(accountEmail).getAccountId());
    }

    @Override
    public void sendEyeRequest(EyeRequestClass eyeRequestClass) {
        iEyeRequestRepository.save(eyeRequestClass);
    }

    @Override
    public List<EyeNotificationClass> SeeNotification(String accountEmail) {
       List<EyeNotificationClass> eyeNotificationClasses = iEyeRequestRepository.findAllByEyeOrganizationEmail(accountEmail)
               .stream()
               .map(n-> new EyeNotificationClass(
                       n.getEyeRequestId(),
                       n.getPatientName(),
                       n.getPatientNumber(),
                       n.getPatientAddress(),
                       n.getPatientGender(),
                       n.getPatientAge(),
                       n.getPatientBloodType()
               )).collect(Collectors.toList());
        return eyeNotificationClasses;
    }

    private EyeOrganizationAccountClass getDetails(String accountEmail){
        return iAccountRegistrationRepository.findByAccountEmail(accountEmail);
    }
}
