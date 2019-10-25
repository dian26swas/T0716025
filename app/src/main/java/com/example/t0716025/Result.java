package com.example.t0716025;

public class Result {
    protected String[] result;
    protected String error;

    public Result(String[] result) {
        this.result = result;
    }

    public String[] getResult() {
        return result;
    }

    public void setResult(String[] result) {
        this.result = result;
    }
}
