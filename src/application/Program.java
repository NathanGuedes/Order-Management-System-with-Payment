package application;

import entities.*;
import entities.enums.OrderStatus;
import entities.enums.PaymentMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import static services.OrderManagementServices.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)){

            System.out.println("===== Order Management System =====\n");
            System.out.println("Enter customer details:");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Birth Date (DD/MM/YYYY): ");
            String dateInput = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dateInput, formatter);

            Customer customer = new Customer(name, email, date);

            System.out.println();
            System.out.println("Enter order details: ");
            System.out.print("How many items in the order? ");
            int n = sc.nextInt();
            sc.nextLine();

            Order order = new Order();

            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.printf("Product %d%n", i + 1);
                System.out.print("Name: ");
                name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                sc.nextLine();
                System.out.print("Quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine();

                Product product = new Product(name, price);
                OrderItem orderItem = new OrderItem(quantity, product);
                order.addOrderItem(orderItem);
                System.out.println();
            }

            showPaymentMethod();

            int option = 0;
            do {
                System.out.print("Option: ");
                option = sc.nextInt();
                sc.nextLine();
            }while (option < 1 || option > 5);

            PaymentMethod paymentMethod = PaymentMethod.valueOf(paymentMethodSelect(option));

            OrderStatus status = OrderStatus.valueOf(orderStatus(option));

            order.setCustomer(customer);
            order.setDate(LocalDate.now());
            order.setStatus(status);
            order.setPayment(new Payment(LocalDate.now(), order.total(), paymentMethod));

            System.out.println();
            System.out.println(order);
        }
    }
}
