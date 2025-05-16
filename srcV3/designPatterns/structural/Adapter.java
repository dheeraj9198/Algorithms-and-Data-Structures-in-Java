package designPatterns.structural;

/**
 * Adapter pattern works as a bridge between two incompatible interfaces.
 */
public class Adapter {
    public interface PaymentProcessor {
        void pay(double amount);
    }

    public static class StripePaymentProcessor implements PaymentProcessor {
        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using Stripe.");
        }
    }

    //Third-party SDK Class (Can’t be modified)
    public static class PayPalSDK {
        public void makePayment(double amountInDollars) {
            System.out.println("Paid $" + amountInDollars + " using PayPal SDK.");
        }
    }

    public static class PayPalAdapter implements PaymentProcessor {
        private PayPalSDK payPalSDK;

        public PayPalAdapter(PayPalSDK payPalSDK) {
            this.payPalSDK = payPalSDK;
        }

        @Override
        public void pay(double amount) {
            payPalSDK.makePayment(amount);  // Delegate to the incompatible SDK
        }
    }
    public class PaymentService {
        public static void main(String[] args) {
            PaymentProcessor stripe = new StripePaymentProcessor();
            stripe.pay(100.0);

            PaymentProcessor paypal = new PayPalAdapter(new PayPalSDK());
            paypal.pay(200.0);
        }
    }

}
