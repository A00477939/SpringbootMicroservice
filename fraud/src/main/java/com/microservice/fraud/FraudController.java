package com.microservice.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud_check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId){
       boolean isFraudulentCustomer = fraudCheckService.
               isFraudulentCustomer(customerId);
       return new FraudCheckResponse(isFraudulentCustomer);

    }
}
