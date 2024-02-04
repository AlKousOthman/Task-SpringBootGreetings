package com.LetsCodeIt.Secure.Bank.System.controller;

import com.LetsCodeIt.Secure.Bank.System.bo.CreateFareWellRequest;
import org.springframework.web.bind.annotation.*;

@RestController("API/A-Z/")
public class CodedController {

    @GetMapping("/greet")
    @ResponseBody
    public String sayHi(@RequestParam String name){
        return "Hello " + name;
    }

@PostMapping("/farewell")
    public String farewell(@RequestBody CreateFareWellRequest createFareWellRequest){

    return "GoodeBye" + createFareWellRequest.getName();
}


}
