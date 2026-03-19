package p09_OOPS.p16_enum;

public class WithoutEnum {
    public static void main(String[] args) {
        // Problems :
        // 1. We don't get type safety;
        int paymentStatus = PaymentStatus.FAILED;
        paymentStatus = 4; // no meaning but still allowed since it is an integer value.

        String paymentStatusString = PaymentStatusString.SUCCESS;
        paymentStatusString = "no meaning string";

        // 2. We don't get any form of grouping since everything is either integer or string .
        if(paymentStatus == Role.ADMIN) {
            // we are able to compare to different enums => DANGER => No logical grouping
        }

        // 3. Duplicate values are allowed . See PaymentStatus class down.

        // 4. While using strings : 
        // 4.1) string comparison is slower
        // 4.2) case mismatch bugs can happen.
        if (paymentStatusString == "success") {

        } 
    }
}

class PaymentStatus {
    public static final int SUCCESS = 0;
    public static final int FAILED = 1;
    public static final int PENDING = 2;
    public static final int CANCELLED = 2; // Duplicate value but no error. Now we don't know 2 means pending or cancelled.
}

class PaymentStatusString {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String PENDING = "PENDING";
}

class Role {
    public static final int ADMIN = 0;
    public static final int USER = 1;
    public static final int GUEST = 2;
}



