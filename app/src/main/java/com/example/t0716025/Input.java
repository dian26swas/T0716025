package com.example.t0716025;

public class Input {
    protected String[] expr;
    protected int precision;

    public Input(String[] expr, int precision)
    {
        this.expr=expr;
        this.precision=precision;
    }

    public String[] getExpr() {
        return expr;
    }

    public int getPrecision() {
        return precision;
    }

    public void setExpr(String[] expr) {
        this.expr = expr;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }
}
