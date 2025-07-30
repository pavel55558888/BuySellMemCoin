package org.example.buysellmemtoken.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BuySellDTO {
    @NotNull(message = "Токен должен существовать")
    private long idToken;
    @Min(value = 1, message = "Минимальное количество для продажи - 1")
    private double count;
    @NotBlank(message = "Необходимо передавать пользователя, который продает/покупает")
    private String username;

    public BuySellDTO(long idToken, double rate, String username) {
        this.idToken = idToken;
        this.count = rate;
        this.username = username;
    }

    public BuySellDTO() {
    }

    public long getIdToken() {
        return idToken;
    }

    public void setIdToken(long idToken) {
        this.idToken = idToken;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
