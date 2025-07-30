package org.example.buysellmemtoken.controller;

import jakarta.validation.Valid;
import org.example.buysellmemtoken.hibernate.service.*;
import org.example.buysellmemtoken.model.dto.BuySellDTO;
import org.example.buysellmemtoken.model.dto.ResponseTransactionDTO;
import org.example.buysellmemtoken.model.TransactionalModel;
import org.example.buysellmemtoken.model.UserTokenModel;
import org.example.buysellmemtoken.model.enums.TypeTransaction;
import org.example.buysellmemtoken.service.ServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class ControllerUser {
    @Value("${percent.sell}")
    private double percentSell;
    @Autowired
    ServiceController serviceController;
    @Autowired
    SaveTransaction saveTransaction;
    @Autowired
    BuyUserToken buyUserToken;
    @Autowired
    SellUserToken sellUserToken;

    @PostMapping("/buy/token")
    private ResponseEntity buyToken(@Valid @RequestBody BuySellDTO buySellDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(Map.of("errors", errors));
        }

        double price = 2;//поход в смежный сервис за курсом

        UserTokenModel userTokenModel = buyUserToken.buyUserToken(new UserTokenModel(buySellDTO.getIdToken(), buySellDTO.getUsername(), buySellDTO.getCount()));

        TransactionalModel transactionalModel =  serviceController.buildModel(buySellDTO,price, TypeTransaction.BUY);
        saveTransaction.saveTransaction(transactionalModel);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ResponseTransactionDTO(userTokenModel, transactionalModel));
    }

    @PostMapping("/sell/token")
    private ResponseEntity sellToken(@Valid @RequestBody BuySellDTO buySellDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(Map.of("errors", errors));
        }

        double price = 2;//поход в смежный сервис за курсом
        double finalPriceSell = percentSell*(price/100);
        TransactionalModel transactionalModel = new TransactionalModel();

        Object obj = sellUserToken.sellUserToken(new UserTokenModel(buySellDTO.getIdToken(), buySellDTO.getUsername(), buySellDTO.getCount()));

        if (obj instanceof UserTokenModel) {
            transactionalModel =  serviceController.buildModel(buySellDTO, finalPriceSell, TypeTransaction.SELL);
            saveTransaction.saveTransaction(transactionalModel);
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ResponseTransactionDTO(obj, transactionalModel));
    }

}
