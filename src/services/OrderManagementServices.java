package services;

public class OrderManagementServices {

    public static void showPaymentMethod() {
        System.out.println("Choose payment method:");
        System.out.println("1 - CREDIT_CARD");
        System.out.println("2 - DEBIT_CARD");
        System.out.println("3 - PAYPAL");
        System.out.println("4 - BITCOIN");
        System.out.println("5 - PIX");
    }

    public static String paymentMethodSelect(int option) {

        return switch (option) {
            case 1 -> "CREDIT_CARD";
            case 2 -> "DEBIT_CARD";
            case 3 -> "PAYPAL";
            case 4 -> "BITCOIN";
            case 5 -> "PIX";
            default -> "Opcao invalida";
        };
    }

    public static String orderStatus(int option) {
        if (option == 1 || option == 2){
            return "PENDING_PAYMENT";
        }else {
            return "PROCESSING";
        }
    }
}
