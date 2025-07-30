package org.example.buysellmemtoken.hibernate.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.buysellmemtoken.hibernate.repository.UserTokenRepo;
import org.example.buysellmemtoken.model.UserTokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserTokenRepoImpl implements UserTokenRepo {
    @Autowired
    EntityManager entityManager;
    @Override
    public UserTokenModel buyUserToken(UserTokenModel userToken) {
        UserTokenModel userTokenModelDB = getUserTokenByTokenIdUsername(userToken.getUsername(), userToken.getTokenId());

        if (userTokenModelDB != null) {
            userTokenModelDB.setCount(userTokenModelDB.getCount() + userToken.getCount());
            return entityManager.merge(userTokenModelDB);
        }else {
            entityManager.persist(userToken);
        }

        return getUserTokenByTokenIdUsername(userToken.getUsername(), userToken.getTokenId());
    }

    @Override
    public <T> Object sellUserToken(UserTokenModel userToken) {
        UserTokenModel userTokenModelDB = getUserTokenByTokenIdUsername(userToken.getUsername(), userToken.getTokenId());
        if (userTokenModelDB == null || userTokenModelDB.getCount() - userToken.getCount() < 0) {
            return false;
        }else{
            userTokenModelDB.setCount(userTokenModelDB.getCount() - userToken.getCount());
            entityManager.merge(userTokenModelDB);
            return getUserTokenByTokenIdUsername(userToken.getUsername(), userToken.getTokenId());
        }
    }

    @Override
    public List<UserTokenModel> getAllUserTokens(String username) {
        return entityManager.createQuery("from UserTokenModel where username = :param1").setParameter("param1", username).getResultList();
    }

    public UserTokenModel getUserTokenByTokenIdUsername(String username, long tokenId) {
        return entityManager.createQuery(
                        "from UserTokenModel where username = :param1 and tokenId = :param2",
                        UserTokenModel.class)
                .setParameter("param1", username)
                .setParameter("param2", tokenId)
                .getResultStream()
                .findFirst()
                .orElse(null);

    }
}
