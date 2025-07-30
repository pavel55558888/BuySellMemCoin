package org.example.buysellmemtoken.model.dto;

import org.example.buysellmemtoken.model.TransactionalModel;
import org.example.buysellmemtoken.model.UserTokenModel;

public class ResponseTransactionDTO<T> {
    private TransactionalModel transactionalModel;
    private T statusOrUserToken;

    public ResponseTransactionDTO() {
    }

    public ResponseTransactionDTO(T statusOrUserToken, TransactionalModel transactionalModel) {
        this.statusOrUserToken = statusOrUserToken;
        this.transactionalModel = transactionalModel;
    }

    public TransactionalModel getTransactionalModel() {
        return transactionalModel;
    }

    public void setTransactionalModel(TransactionalModel transactionalModel) {
        this.transactionalModel = transactionalModel;
    }

    public T getStatusOrUserToken() {
        return statusOrUserToken;
    }

    public void setStatusOrUserToken(T statusOrUserToken) {
        this.statusOrUserToken = statusOrUserToken;
    }
}
