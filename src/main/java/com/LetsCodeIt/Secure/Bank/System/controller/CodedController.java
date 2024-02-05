package com.LetsCodeIt.Secure.Bank.System.controller;

import com.LetsCodeIt.Secure.Bank.System.bo.CreateAddContactRequest;
import com.LetsCodeIt.Secure.Bank.System.bo.CreateFareWellRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("API/A-Z/")
public class CodedController {

    List<CreateAddContactRequest> allContact = new ArrayList<>();
    @GetMapping("/greet")
    @ResponseBody
    public String sayHi(@RequestParam String name){
        return "Hello " + name;
    }

@PostMapping("/farewell")
    public String farewell(@RequestBody CreateFareWellRequest createFareWellRequest){

    return "GoodeBye" + createFareWellRequest.getName();
}

@PostMapping("/addContact")
public ResponseEntity<String> addContact(@RequestBody CreateAddContactRequest createAddContactRequest){
        for(int i = 0; i < allContact.size(); i++){
            if(allContact.get(i).getEmail().equals(createAddContactRequest.getEmail())){
                return ResponseEntity.badRequest().body("Contact already exists");
            }
        }
        allContact.add(createAddContactRequest);
        return ResponseEntity.ok("Contact added successfully");
    }

    @GetMapping("/getContactDetails")
    public ResponseEntity<?> getContactDetails(@RequestParam String name){
        for(int i = 0; i<allContact.size(); i++){
            if(allContact.get(i).getName().equals(name)){
                return ResponseEntity.ok(allContact.get(i));
            }
        }
        return ResponseEntity.badRequest().body("Contact not founded");
    }
}
