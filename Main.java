//Name:Devan Patel
//Date: 11/13/2024
//Program: Conversion Program
//Purpose:  Convert various data sets with ease

import java.util.Scanner;

class Main {
    public static void clearScreen() { // clear screen function
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Conversion for measurements (cups, oz, ml, tbls)
    static void Measurements() {
        Scanner reply = new Scanner(System.in);
        double amount;
        String fromUnit = "", toUnit;

        while (true) {
            clearScreen();
            System.out.println("Measurements (cup/s, oz, ml, tbls)");
            System.out.print("Enter amount and unit (e.g., '2 oz'): ");
            String input = reply.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 2) {
                try {
                    amount = Double.parseDouble(parts[0]);
                    fromUnit = parts[1].toLowerCase();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please try again.");
                }
            } else {
                System.out.println("Invalid input format. Use 'number unit'.");
            }
        }

        while (true) {
            System.out.print("Convert to (cup/s, oz, ml, tbls): ");
            toUnit = reply.nextLine().toLowerCase();

            double convertedAmount = amount;
            boolean validConversion = true;

            // Conversion logic
            if (toUnit.equals("cup") || toUnit.equals("cups")) {
                if (fromUnit.equals("ml")) {
                    convertedAmount = amount / 240;
                } else if (fromUnit.equals("oz")) {
                    convertedAmount = amount / 8;
                } else if (fromUnit.equals("tbls")) {
                    convertedAmount = amount / 16;
                } else if (fromUnit.equals("cup") || fromUnit.equals("cups")) {
                    // No conversion needed
                } else {
                    validConversion = false;
                }
            } else if (toUnit.equals("ml")) {
                if (fromUnit.equals("cup") || fromUnit.equals("cups")) {
                    convertedAmount = amount * 240;
                } else if (fromUnit.equals("oz")) {
                    convertedAmount = amount * 30;
                } else if (fromUnit.equals("tbls")) {
                    convertedAmount = amount * 15;
                } else if (fromUnit.equals("ml")) {
                    // No conversion needed
                } else {
                    validConversion = false;
                }
            } else if (toUnit.equals("oz")) {
                if (fromUnit.equals("cup") || fromUnit.equals("cups")) {
                    convertedAmount = amount * 8;
                } else if (fromUnit.equals("ml")) {
                    convertedAmount = amount / 30;
                } else if (fromUnit.equals("tbls")) {
                    convertedAmount = amount / 2;
                } else if (fromUnit.equals("oz")) {
                    // No conversion needed
                } else {
                    validConversion = false;
                }
            } else if (toUnit.equals("tbls")) {
                if (fromUnit.equals("cup") || fromUnit.equals("cups")) {
                    convertedAmount = amount * 16;
                } else if (fromUnit.equals("ml")) {
                    convertedAmount = amount / 15;
                } else if (fromUnit.equals("oz")) {
                    convertedAmount = amount * 2;
                } else if (fromUnit.equals("tbls")) {
                    // No conversion needed
                } else {
                    validConversion = false;
                }
            } else {
                validConversion = false;
            }

            if (validConversion) {
                System.out.printf("%.2f %s is %.2f %s\n", amount, fromUnit, convertedAmount, toUnit);
                break;
            } else {
                System.out.println("Invalid conversion. Please enter a valid unit to convert to.");
            }
        }
    }

    // Conversion for temperature (Fahrenheit, Celsius)
    static void Temperature() {
        Scanner reply = new Scanner(System.in);
        double temperature;
        String fromUnit, toUnit;

        while (true) {
            clearScreen();
            System.out.println("Temperature (F for Fahrenheit, C for Celsius)");
            System.out.print("Enter amount and unit (e.g., '100 F'): ");
            String input = reply.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 2) {
                try {
                    temperature = Double.parseDouble(parts[0]);
                    fromUnit = parts[1].toUpperCase();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please try again.");
                }
            } else {
                System.out.println("Invalid input format. Use 'number unit'.");
            }
        }

        while (true) {
            System.out.print("Convert to (F for Fahrenheit, C for Celsius): ");
            toUnit = reply.nextLine().toUpperCase();

            if (fromUnit.equals("F") && toUnit.equals("C")) {
                double celsius = (temperature - 32) * 5 / 9;
                System.out.printf("%.2f °F is %.2f °C\n", temperature, celsius);
                break;
            } else if (fromUnit.equals("C") && toUnit.equals("F")) {
                double fahrenheit = (temperature * 9 / 5) + 32;
                System.out.printf("%.2f °C is %.2f °F\n", temperature, fahrenheit);
                break;
            } else if (fromUnit.equals(toUnit)) {
                System.out.printf("%.2f %s is %.2f %s\n", temperature, fromUnit, temperature, toUnit);
                break;
            } else {
                System.out.println("Invalid conversion. Please enter a valid unit to convert to.");
            }
        }
    }

    // Conversion for weight (imperial, metric)
    static void Weight() {
        Scanner reply = new Scanner(System.in);
        double weight;
        String fromUnit, toUnit;

        while (true) {
            clearScreen();
            System.out.println("Weight (lb, oz, g)");
            System.out.print("Enter amount and unit (e.g., '16 oz'): ");
            String input = reply.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 2) {
                try {
                    weight = Double.parseDouble(parts[0]);
                    fromUnit = parts[1].toLowerCase();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please try again.");
                }
            } else {
                System.out.println("Invalid input format. Use 'number unit'.");
            }
        }

        while (true) {
            System.out.print("Convert to (lb, oz, g): ");
            toUnit = reply.nextLine().toLowerCase();

            double convertedWeight = weight;
            boolean validConversion = true;

            if (fromUnit.equals("lb")) {
                if (toUnit.equals("oz")) {
                    convertedWeight = weight * 16;
                } else if (toUnit.equals("g")) {
                    convertedWeight = weight * 453.6;
                } else if (toUnit.equals("lb")) {
                    // No conversion needed
                } else {
                    validConversion = false;
                }
            } else if (fromUnit.equals("oz")) {
                if (toUnit.equals("lb")) {
                    convertedWeight = weight / 16;
                } else if (toUnit.equals("g")) {
                    convertedWeight = weight * 28.35;
                } else if (toUnit.equals("oz")) {
                    // No conversion needed
                } else {
                    validConversion = false;
                }
            } else if (fromUnit.equals("g")) {
                if (toUnit.equals("lb")) {
                    convertedWeight = weight / 453.6;
                } else if (toUnit.equals("oz")) {
                    convertedWeight = weight / 28.35;
                } else if (toUnit.equals("g")) {
                    // No conversion needed
                } else {
                    validConversion = false;
                }
            } else {
                validConversion = false;
            }

            if (validConversion) {
                System.out.printf("%.2f %s is %.2f %s\n", weight, fromUnit, convertedWeight, toUnit);
                break;
            } else {
                System.out.println("Invalid conversion. Please enter a valid unit to convert to.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner reply = new Scanner(System.in);

        while (true) {
            System.out.println("What form of data do you wish to convert?");
            System.out.println("(1) Measurements");
            System.out.println("(2) Temperature");
            System.out.println("(3) Weight");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(reply.nextLine());
                if (choice == 1) {
                    Measurements();
                    break;
                } else if (choice == 2) {
                    Temperature();
                    break;
                } else if (choice == 3) {
                    Weight();
                    break;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
