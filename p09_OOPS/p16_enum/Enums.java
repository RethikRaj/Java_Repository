package p09_OOPS.p16_enum;

public class Enums {
    public static void main(String[] args) {
        PaymentStatus paymentStatus = PaymentStatus.FAILED;
        // 1. We get type safety
        // paymentStatus = 2; // Error

        Role role = Role.ADMIN;
        // 2. We get grouping
        // if (paymentStatus == role) {
            // Error
        // }

        System.out.println(paymentStatus);
        System.out.println(role);
    }
}

enum PaymentStatus {
    SUCCESS,
    FAILED, 
    PENDING, 
    CANCELLED;
}

enum Role {
    ADMIN,
    USER,
    GUEST;
}
