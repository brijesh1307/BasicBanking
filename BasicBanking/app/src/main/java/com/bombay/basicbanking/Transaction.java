package com.bombay.basicbanking;

public class Transaction {

    private String fromName;
    private String toName;
    private int amountTransferred;
    private String status;



    public Transaction(String fromName, String toName, int accountBalance, String status) {
        this.fromName = fromName;
        this.toName = toName;
        this.amountTransferred = amountTransferred;
        this.status = status;
    }

    public Transaction(String fromName, String toName, int accountBalance, int status) {

    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public int getAmountTransferred() {
        return amountTransferred;
    }

    public void setAmountTransferred(int amountTransferred) {
        this.amountTransferred = amountTransferred;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
