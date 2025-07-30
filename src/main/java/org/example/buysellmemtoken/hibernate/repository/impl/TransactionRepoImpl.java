package org.example.buysellmemtoken.hibernate.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.buysellmemtoken.hibernate.repository.TransactionRepo;
import org.example.buysellmemtoken.model.TransactionalModel;
import org.example.buysellmemtoken.model.UserTokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepoImpl implements TransactionRepo {
    @Autowired
    private EntityManager entityManager;
    @Override
    public void saveTransaction(TransactionalModel transactionalModel) {
        entityManager.persist(transactionalModel);
    }

    @Override
    public List<TransactionalModel> getTransaction(String username) {
        return entityManager.createQuery("from TransactionalModel where username = :param1").setParameter("param1", username).getResultList();
    }

}
