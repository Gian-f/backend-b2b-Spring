package com.br.b2b.dto.response;

import com.br.b2b.model.Category;

import java.util.List;

public class CategoryResponse {
    private String message;
    private List<Category> result;
    private boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Category> getResult() {
        return result;
    }

    public void setResult(List<Category> result) {
        this.result = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
