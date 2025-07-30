package org.example.buysellmemtoken.hibernate.service;

import org.example.buysellmemtoken.model.UserTokenModel;

public interface SellUserToken {
    public <T> Object sellUserToken(UserTokenModel userToken);
}
