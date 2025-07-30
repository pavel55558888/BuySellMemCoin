package org.example.buysellmemtoken.hibernate.service.impl;

import org.example.buysellmemtoken.hibernate.repository.UserTokenRepo;
import org.example.buysellmemtoken.hibernate.service.BuyUserToken;
import org.example.buysellmemtoken.hibernate.service.GetAllUserTokens;
import org.example.buysellmemtoken.hibernate.service.SellUserToken;
import org.example.buysellmemtoken.model.UserTokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserTokenImpl implements BuyUserToken, GetAllUserTokens, SellUserToken {
    @Autowired
    UserTokenRepo userTokenRepo;

    @Override
    public UserTokenModel buyUserToken(UserTokenModel userToken) {
        return userTokenRepo.buyUserToken(userToken);
    }

    @Override
    public List<UserTokenModel> getAllUserTokens(String username) {
        return userTokenRepo.getAllUserTokens(username);
    }

    @Override
    public <T> Object sellUserToken(UserTokenModel userToken) {
        return userTokenRepo.sellUserToken(userToken);
    }
}
