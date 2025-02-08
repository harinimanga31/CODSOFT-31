import java.util.HashMap;
import java.util.Scanner;

public class currency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined exchange rates (Example: USD to other currencies)
        HashMap<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD_TO_INR", 83.0);
        exchangeRates.put("USD_TO_EUR", 0.92);
        exchangeRates.put("USD_TO_GBP", 0.79);
        exchangeRates.put("INR_TO_USD", 0.012);
        exchangeRates.put("EUR_TO_USD", 1.09);
        exchangeRates.put("GBP_TO_USD", 1.27);

        // Get user input
        System.out.print("Enter base currency (USD, INR, EUR, GBP): ");
        String baseCurrency = scanner.next().toUpperCase();
        
        System.out.print("Enter target currency (USD, INR, EUR, GBP): ");
        String targetCurrency = scanner.next().toUpperCase();
        
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        // Generate key for exchange rate lookup
        String key = baseCurrency + "_TO_" + targetCurrency;

        // Perform conversion
        if (exchangeRates.containsKey(key)) {
            double convertedAmount = amount * exchangeRates.get(key);
            System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Exchange rate not available for selected currencies.");
        }

        scanner.close();
    }
}
