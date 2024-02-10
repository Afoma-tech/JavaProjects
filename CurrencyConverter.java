import java.util.Scanner;

// Currency class representing each type of currency
class Currency {
    private String name;
    private double conversionRateToCAD;

    public Currency(String name, double conversionRateToCAD) {
        this.name = name;
        this.conversionRateToCAD = conversionRateToCAD;
    }

    // Convert amount from this currency to CAD
    public double convertToCAD(double amount) {
        return amount / conversionRateToCAD;
    }

    // Convert amount from CAD to this currency
    public double convertFromCAD(double amountInCAD) {
        return amountInCAD * conversionRateToCAD;
    }

    public String getName() {
        return name;
    }
}

public class CurrencyConverter {
    public static void main(String[] args) {
        // Define currencies with their conversion rates to CAD
        Currency cad = new Currency("CAD", 1.0);
        Currency usd = new Currency("USD", 0.78);
        Currency eur = new Currency("EUR", 0.67);
        Currency gbp = new Currency("GBP", 0.56);

        // Present user with options
        System.out.println("Select the currency to convert from:");
        System.out.println("1. CAD");
        System.out.println("2. USD");
        System.out.println("3. EUR");
        System.out.println("4. GBP");

        Scanner scanner = new Scanner(System.in);
        int fromCurrencyChoice = scanner.nextInt();

        System.out.println("Select the currency to convert to:");
        System.out.println("1. CAD");
        System.out.println("2. USD");
        System.out.println("3. EUR");
        System.out.println("4. GBP");

        int toCurrencyChoice = scanner.nextInt();

        System.out.println("Enter the amount to convert:");
        double amount = scanner.nextDouble();

        // Perform conversion
        double amountInCAD = 0;
        switch (fromCurrencyChoice) {
            case 1:
                amountInCAD = amount;
                break;
            case 2:
                amountInCAD = usd.convertToCAD(amount);
                break;
            case 3:
                amountInCAD = eur.convertToCAD(amount);
                break;
            case 4:
                amountInCAD = gbp.convertToCAD(amount);
                break;
            default:
                System.out.println("Invalid choice for 'from' currency.");
                System.exit(0);
        }

        double convertedAmount = 0;
        switch (toCurrencyChoice) {
            case 1:
                convertedAmount = amountInCAD;
                break;
            case 2:
                convertedAmount = usd.convertFromCAD(amountInCAD);
                break;
            case 3:
                convertedAmount = eur.convertFromCAD(amountInCAD);
                break;
            case 4:
                convertedAmount = gbp.convertFromCAD(amountInCAD);
                break;
            default:
                System.out.println("Invalid choice for 'to' currency.");
                System.exit(0);
        }

        System.out.println("Converted amount: " + convertedAmount + " " + getCurrencyName(toCurrencyChoice));
    }

    // Helper method to get currency name from choice
    private static String getCurrencyName(int choice) {
        switch (choice) {
            case 1:
                return "CAD";
            case 2:
                return "USD";
            case 3:
                return "EUR";
            case 4:
                return "GBP";
            default:
                return "";
        }
    }
}

