package org.example.buysellmemtoken.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Transactional")
public class TransactionalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;;
    private boolean status;
    private String type;
    private long timestamp;
    private long tokenId;
    private double count;
    private double rate;
    private double course;

    public TransactionalModel(String username, boolean status, String type, long timestamp, long tokenId, double count, double rate, double course) {
        this.username = username;
        this.status = status;
        this.type = type;
        this.timestamp = timestamp;
        this.tokenId = tokenId;
        this.count = count;
        this.rate = rate;
        this.course = course;
    }

    public TransactionalModel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }
}
