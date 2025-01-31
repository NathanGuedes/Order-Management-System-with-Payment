package entities;

import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Customer customer;
    private LocalDate date;
    private OrderStatus status;

    private Payment payment;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {
    }

    public Order(Customer customer, LocalDate date, OrderStatus status, Payment payment) {
        this.customer = customer;
        this.date = date;
        this.status = status;
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem){
        orderItems.remove(orderItem);
    }

    public Double total(){
        double sum = 0;

        for (OrderItem orderItem : orderItems){
            sum += orderItem.subtotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Cabeçalho
        sb.append("===== Order Summary =====").append("\n\n")
                .append("Customer: ").append(customer.getName()).append("\n")
                .append("Email: ").append(customer.getEmail()).append("\n")
                .append("Birth Date: ").append(formatter.format(customer.getBirthDate()))
                .append("\n\n");

        //order
        sb.append("Order Details:").append("\n")
                .append("Date: ").append(formatter.format(date)).append("\n")
                .append("Status: ").append(status.name()).append("\n\n");


        //products
        sb.append("Items:").append("\n");

        for (OrderItem orderItem : orderItems){
            sb.append(orderItem.getQuantity())
                    .append("x ")
                    .append(orderItem.getProduct().getName())
                    .append(" - $")
                    .append(String.format("%.2f", orderItem.getProduct().getPrice())).append("\n");
        }

        sb.append("-------------------------").append("\n")
                .append("Subtotal: $").append(total()).append("\n\n");

        //Payment Details:
        sb.append("Payment Details:").append("\n")
                .append("Method: ").append(payment.getMethod().name()).append("\n")
                .append("Amount Paid: $").append(String.format("%.2f", payment.getAmount()))
                .append("\n\n").append("===== Order Completed Successfully! =====");
        return sb.toString();
    }
}
