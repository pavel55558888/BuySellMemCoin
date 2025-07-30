package org.example.buysellmemtoken.hibernate.service;

import org.example.buysellmemtoken.model.TransactionalModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SaveTransaction {
    public void saveTransaction(TransactionalModel transactionalModel);
}
