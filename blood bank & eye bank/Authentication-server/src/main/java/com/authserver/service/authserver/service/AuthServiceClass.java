package com.authserver.service.authserver.service;

import com.authserver.service.authserver.entity.OrganizationAccountClass;
import com.authserver.service.authserver.entity.OrganizationClass;
import com.authserver.service.authserver.externalAPI.ISendBloodOrganizationDetails;
import com.authserver.service.authserver.externalAPI.ISendEyeOrganizationDetails;
import com.authserver.service.authserver.externalAPI.ISendOrganizationDetailsToAdmin;
import com.authserver.service.authserver.repository.IOrganizationAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@Transactional
public class AuthServiceClass {

    String message = "Registration successful";
    @Autowired
    private IOrganizationAccountRepository iOrganizationAccountRepository;

    @Autowired
    private JwtServiceClass jwtServiceClass;

    @Autowired
    private ISendBloodOrganizationDetails iSendBloodOrganizationDetails;

    @Autowired
    private ISendOrganizationDetailsToAdmin iSendOrganizationDetailsToAdmin;

    @Autowired
    private ISendEyeOrganizationDetails iSendEyeOrganizationDetails;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Pattern EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public String bloodRegistration(OrganizationAccountClass accountClass) {
        String randomUUID = UUID.randomUUID().toString();
        accountClass.setOrgAccountId(randomUUID);
        if (isValidEmail(accountClass.getOrgEmail())) {
            if(isAccountExit(accountClass.getOrgNumber())) {
                String encodedPassword = passwordEncoder.encode(accountClass.getOrgPassword());
                accountClass.setOrgPassword(encodedPassword);
                System.out.println("User Name is: "+accountClass.getOrgDistric());
                iOrganizationAccountRepository.save(accountClass);
                OrganizationClass organizationClass = new OrganizationClass(
                        accountClass.getOrgAccountId(),
                        accountClass.getOrgName(),
                        accountClass.getOrgNumber(),
                        accountClass.getOrgEmail(),
                        accountClass.getOrgDivision(),
                        accountClass.getOrgDistric(),
                        accountClass.getOrgUpazila(),
                        accountClass.getOrgType());
                iSendBloodOrganizationDetails.registrationAccount(organizationClass);
                iSendOrganizationDetailsToAdmin.saveOrganization(organizationClass);
                return message;
            }
            else {
                return "Account Already Register";
            }
        }
        return "Invalid Email";
    }

    public String eyeRegistration(OrganizationAccountClass accountClass) {
        String randomUUID = UUID.randomUUID().toString();
        accountClass.setOrgAccountId(randomUUID);
        if (isValidEmail(accountClass.getOrgEmail())) {
            if(isAccountExit(accountClass.getOrgNumber())) {
                String encodedPassword = passwordEncoder.encode(accountClass.getOrgPassword());
                accountClass.setOrgPassword(encodedPassword);
                iOrganizationAccountRepository.save(accountClass);
                OrganizationClass organizationClass = new OrganizationClass(
                        accountClass.getOrgAccountId(),
                        accountClass.getOrgName(),
                        accountClass.getOrgNumber(),
                        accountClass.getOrgEmail(),
                        accountClass.getOrgDivision(),
                        accountClass.getOrgDistric(),
                        accountClass.getOrgUpazila(),
                        accountClass.getOrgType()
                );
                iSendEyeOrganizationDetails.registration(organizationClass);
                iSendOrganizationDetailsToAdmin.saveEyeOrganizationInfo(organizationClass);
                return message;
            }
            else {
                return "Account Already Register";
            }
        }
        return "Invalid Email";
    }

    private boolean isAccountExit(String orgNumber){
        if(iOrganizationAccountRepository.findByOrgNumber(orgNumber)!=null){
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email){
        return EMAIL.matcher(email).matches();
    }

    public String generateToken(String orgEmail) {
        return jwtServiceClass.generateToken(orgEmail);
    }

    public void validateToken(String token) {
        jwtServiceClass.validateToken(token);
    }

    public void deleteOrgAccount(String orgEmail){
        iOrganizationAccountRepository.deleteByOrgEmail(orgEmail);
    }

}
