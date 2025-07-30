package org.example.buysellmemtoken.hibernate.service.impl;

import org.example.buysellmemtoken.hibernate.repository.TransactionRepo;
import org.example.buysellmemtoken.hibernate.service.*;
import org.example.buysellmemtoken.model.TransactionalModel;
import org.example.buysellmemtoken.model.UserTokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements SaveTransaction, GetTransaction {
    @Autowired
    TransactionRepo transactionRepo;

    @Override
    public List<TransactionalModel> getTransaction(String username) {
        return transactionRepo.getTransaction(username);
    }

    @Override
    public void saveTransaction(TransactionalModel transactionalModel) {
        transactionRepo.saveTransaction(transactionalModel);
    }
}
