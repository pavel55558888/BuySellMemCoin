package org.example.buysellmemtoken.hibernate.service;

import org.example.buysellmemtoken.model.UserTokenModel;

import java.util.List;

public interface GetAllUserTokens {
    public List<UserTokenModel> getAllUserTokens(String username);
}
