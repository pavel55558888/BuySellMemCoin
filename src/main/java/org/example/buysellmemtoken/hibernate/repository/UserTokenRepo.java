package org.example.buysellmemtoken.hibernate.repository;

import org.example.buysellmemtoken.model.UserTokenModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface UserTokenRepo {
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public UserTokenModel buyUserToken(UserTokenModel userToken);
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public <T> Object sellUserToken(UserTokenModel userToken);
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<UserTokenModel> getAllUserTokens(String username);
}
