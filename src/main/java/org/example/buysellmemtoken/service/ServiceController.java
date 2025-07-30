package org.example.buysellmemtoken.service;

import org.example.buysellmemtoken.model.dto.BuySellDTO;
import org.example.buysellmemtoken.model.TransactionalModel;
import org.example.buysellmemtoken.model.enums.TypeTransaction;
import org.springframework.stereotype.Service;

@Service
public class ServiceController {
    public TransactionalModel buildModel(BuySellDTO buySellDTO, double course, TypeTransaction typeTransaction) {
        return new TransactionalModel(buySellDTO.getUsername(),  true,  typeTransaction.toString(), System.currentTimeMillis(),
                buySellDTO.getIdToken(),  buySellDTO.getCount(), buySellDTO.getCount()*course, course);
    }
}
