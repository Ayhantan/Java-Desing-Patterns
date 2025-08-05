package Behavioral;

import java.util.ArrayList;
import java.util.List;

// 1. Strategy Arayüzü
interface PaymentStrategy {
    void pay(int amount);
}

// 2. Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid with Credit Card [" + cardNumber + "] by " + name);
    }
}

class PaypalPayment implements PaymentStrategy {
    private String email;

    public PaypalPayment(String email) {
        this.email = email;
    }

    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal account: " + email);
    }
}

// 3. Context
class ShoppingCart {
    private List<Integer> items = new ArrayList<>();

    public void addItem(int price) {
        items.add(price);
    }

    public int calculateTotal() {
        int sum = 0;
        for (int price : items) {
            sum += price;
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}

// 4. Client
public class StrategyPatternExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(100);
        cart.addItem(300);

        // Strategy 1: PayPal
        cart.pay(new PaypalPayment("user@example.com"));

        // Strategy 2: Credit Card
        cart.pay(new CreditCardPayment("1234-5678-9876-5432", "Ali Veli"));
    }
}
