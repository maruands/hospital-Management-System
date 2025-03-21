package com.hospital.hospital.Controller;

import com.hospital.hospital.Requests.TriageRequest;
import com.hospital.hospital.Services.TriageSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/")
public class OperationsController {

    private final TriageSevice triageService;

    @Autowired
    public OperationsController(TriageSevice triageService) {
        this.triageService = triageService;
    }

    @PostMapping("/triage")
    public ResponseEntity<?> createTriage(@RequestBody TriageRequest request){
        return triageService.createTriage(request);
    }
}
