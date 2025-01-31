package entities;

import entities.enums.PaymentMethod;

import java.time.LocalDate;

public class Payment {
    private LocalDate date;
    private Double amount;
    private PaymentMethod method;

    public Payment(){
    }

    public Payment(LocalDate date, Double amount, PaymentMethod method) {
        this.date = date;
        this.amount = amount;
        this.method = method;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }
}
