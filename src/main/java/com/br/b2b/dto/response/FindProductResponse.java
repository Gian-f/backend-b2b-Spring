package com.br.b2b.dto.response;

import com.br.b2b.model.Product;

import java.util.Optional;

public class FindProductResponse {

    private String message;
    private Optional<Product> result;
    private boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Optional<Product> getResult() {
        return result;
    }

    public void setResult(Optional<Product> result) {
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

