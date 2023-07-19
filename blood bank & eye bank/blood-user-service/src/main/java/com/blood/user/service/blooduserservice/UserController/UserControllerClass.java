package com.blood.user.service.blooduserservice.UserController;

import com.blood.user.service.blooduserservice.Entity.BloodOrganizationClass;
import com.blood.user.service.blooduserservice.Entity.BloodRequestClass;
import com.blood.user.service.blooduserservice.Entity.EyeOrganizationClass;
import com.blood.user.service.blooduserservice.Entity.EyeRequestClass;
import com.blood.user.service.blooduserservice.Service.ImpUserServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/bloodusers")
public class UserControllerClass {

    @Autowired
    private ImpUserServiceClass impBloodUserService;

    @GetMapping("/message")
    public String message(){
        return "API working";
    }

    @GetMapping("/all-blood-organization-in-division")
    public List<BloodOrganizationClass> allBloodOrganization_in_division(@RequestParam("division") String division){
        return impBloodUserService.findByDivision(division);
    }

    @GetMapping("/all-blood-organization-in-distric")
    public List<BloodOrganizationClass> allBloodOrganization_in_distric(@RequestParam("distric") String distric){
        return impBloodUserService.findByDistric(distric);
    }

    @GetMapping("/all-blood-organization-in-upazila")
    public List<BloodOrganizationClass> allBloodOrganization_in_upazila(@RequestParam("upazila") String upazila){
        return impBloodUserService.findByUpozila(upazila);
    }

    @GetMapping("/all-blood-organization-in-bloodtype")
    public List<Map<String, String>> allBloodOrganization_by_bloodType(@RequestParam("bloodtype") String bloodtype){
        return impBloodUserService.findBybloodtype(bloodtype);
    }

    @PostMapping("/send-request")
    public ResponseEntity<String> sendBloodRequest(@RequestBody BloodRequestClass bloodRequestClass){
        impBloodUserService.sendRequest(bloodRequestClass);
        return new ResponseEntity<>("request sended", HttpStatus.OK);
    }

    @PostMapping("/sendeyerequest")
    public ResponseEntity<String> sendEyeRequest(@RequestBody EyeRequestClass eyeRequestClass){
        impBloodUserService.sendEyeRequest(eyeRequestClass);
        return new ResponseEntity<>("Send Eye Request", HttpStatus.OK);
    }

    @GetMapping("/all-eye-organization")
    public List<EyeOrganizationClass> findAllEyeOrganization(){
        return impBloodUserService.findAllEyeOrganization();
    }

    @GetMapping("/all-eye-organization-in-division")
   public List<EyeOrganizationClass> findEyeOrganization_in_division(@RequestParam("eyeOrganizationDivision") String eyeOrganizationDivision){
        return impBloodUserService.findByEyeDivision(eyeOrganizationDivision);
   }

   @GetMapping("/all-eye-organization-in-distric")
    public List<EyeOrganizationClass> findEyeOrganization_in_distric(@RequestParam("eyeOrganizationDistric") String eyeOrganizationDistric){
        return impBloodUserService.findByEyeDistric(eyeOrganizationDistric);
    }

    @GetMapping("/all-eye-organization-in-upazila")
    public List<EyeOrganizationClass> findEyeOrganization_in_upazila(@RequestParam("eyeOrganizationUpazila") String eyeOrganizationUpazila){
        return impBloodUserService.findByEyeUpazila(eyeOrganizationUpazila);
    }
}
