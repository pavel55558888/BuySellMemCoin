package org.example.buysellmemtoken.hibernate.repository;

import org.example.buysellmemtoken.model.TransactionalModel;
import org.example.buysellmemtoken.model.UserTokenModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TransactionRepo {
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void saveTransaction(TransactionalModel transactionalModel);
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<TransactionalModel> getTransaction(String username);
}
