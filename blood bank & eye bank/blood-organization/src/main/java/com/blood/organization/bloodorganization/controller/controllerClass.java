package com.blood.organization.bloodorganization.controller;

import com.blood.organization.bloodorganization.entity.*;
import com.blood.organization.bloodorganization.service.ImpServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization/bloodorganization")
public class controllerClass {

    @Autowired
    private ImpServiceClass impServiceClass;

    @GetMapping("/message")
    public String message(){
        return "API Working...........!";
    }


    @PostMapping("/blood-registration")
    public void registrationAccount(@RequestBody AccountClass accountClass){
        impServiceClass.bloodOrgRegistration(accountClass);
    }

    @DeleteMapping("/delete-account")
    public ResponseEntity<String> deleteAccount(@RequestHeader("loggedInUser") String accountEmail){
        impServiceClass.delete_account(accountEmail);
        return new ResponseEntity<>("Delete Account", HttpStatus.OK);
    }

    @PutMapping("/update-account")
    public ResponseEntity<String> updateAccount(@RequestBody AccountClass accountClass, @RequestHeader("loggedInUser") String accountEmail){
        impServiceClass.update_account(accountClass, accountEmail);
        return new ResponseEntity<>("Account Updated", HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ProfileClass seeProfile(@RequestHeader("loggedInUser") String accountEmail){
        return impServiceClass.profile(accountEmail);
    }


    @PostMapping("/save-donor")
    public ResponseEntity<String> saveDonorInfo(@RequestBody DonarInfoClass donarInfoClass, @RequestHeader("loggedInUser") String accountEmail){
        impServiceClass.save_donar_info(donarInfoClass, accountEmail);
        return new ResponseEntity<>("Save donor Information", HttpStatus.CREATED);
    }

    @GetMapping("/get-all-donors")
    public List<DonarInfoClass> getAllDonors(@RequestHeader("loggedInUser") String accountEmail){
        return impServiceClass.getAllDonors(accountEmail);
    }

    @DeleteMapping("/delete-donor")
    public ResponseEntity<String> deleteDonorInfo(@RequestParam("donarId") String donarId){
        impServiceClass.delete_donor(donarId);
        return new ResponseEntity<>("Donor Information Deleted", HttpStatus.OK);
    }

    @GetMapping("/four-month-complete-donors")
    public List<DonarInfoClass> fourMonthCompleteDonors(@RequestHeader("loggedInUser") String accountEmail){
        return impServiceClass.four_month_completed_donor(accountEmail);
    }

    //this API not working

    @PostMapping("/send-message-to-donors")
    public ResponseEntity<String> sendMessagesToDonors(@RequestHeader("loggedInUser") String accountEmail){
        impServiceClass.send_message_donar(accountEmail);
        return new ResponseEntity<>("Send Email to 4 month completed donors", HttpStatus.OK);
    }

    @PostMapping("/delivery-request")
    public ResponseEntity<String> send_delivery_request(@RequestBody DeliveryRequestClass deliveryRequestClass, @RequestHeader("loggedInUser") String accountEmail){
        String response =  impServiceClass.deliveryrequest(deliveryRequestClass, accountEmail);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-delivery-request")
    public String update_delivery_request(@RequestParam("deliverId") String deliverId, @RequestParam("status") String status){
        impServiceClass.updateDeliveryRequest(deliverId, status);
        return "update Status";
    }

    @GetMapping("/all-delivery-requests")
    public List<DeliveryRequestClass> allRequest(@RequestHeader("loggedInUser") String accountEmail){
        return impServiceClass.allDeliveryRequest(accountEmail);
    }

    @PostMapping("/send-request")
    public ResponseEntity<String> sendBloodRequest(@RequestBody BloodRequestClass bloodRequestClass){
        impServiceClass.sendBloodRequest(bloodRequestClass);
        return new ResponseEntity<>("request sended", HttpStatus.OK);
    }

    @GetMapping("/blood-request")
    public List<NotificationClass> all_request(@RequestHeader("loggedInUser") String accountEmail){
        return impServiceClass.notification(accountEmail);
    }
}
