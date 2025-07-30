package org.example.buysellmemtoken.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_token")
public class UserTokenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long tokenId;
    private String username;
    private double count;

    public UserTokenModel(long tokenId, String username, double quantity) {
        this.tokenId = tokenId;
        this.username = username;
        this.count = quantity;
    }

    public UserTokenModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
