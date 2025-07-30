package org.example.buysellmemtoken.controller;

import org.example.buysellmemtoken.hibernate.service.GetAllUserTokens;
import org.example.buysellmemtoken.hibernate.service.GetTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class ControllerAdmin {

    @Autowired
    GetTransaction getTransaction;
    @Autowired
    GetAllUserTokens getAllUserTokens;

    @GetMapping("/transaction/{username}")
    private ResponseEntity getTransactionUsername(@PathVariable String username) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getTransaction.getTransaction(username));
    }

    @GetMapping("/user/token/{username}")
    private ResponseEntity getTokenUser(@PathVariable String username) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getAllUserTokens.getAllUserTokens(username));
    }
}
