import java.util.Scanner;

public class TaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            clearScreen();
            displayMainMenu();
            option = getValidOption(scanner, 6);

            switch (option) {
                case 1:
                    withholdingTaxMenu(scanner);
                    break;
                case 2:
                    payableTax(scanner);
                    break;
                case 3:
                    incomeTax(scanner);
                    break;
                case 4:
                    SSCLTax(scanner);
                    break;
                case 5:
                    leasingPaymentMenu(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 6);

        scanner.close();
    }

    private static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing the screen.");
        }
    }

    private static void displayMainMenu() {
        System.out.println(" /$$$$$$  /$$$$$$  /$$$$$$$$ /$$$$$$$$");
        System.out.println("|_  $$_/ /$$__  $$| $$_____/|__  $$__/");
        System.out.println("  | $$  | $$  \\__/| $$         | $$   ");
        System.out.println("  | $$  | $$      | $$$$$      | $$   ");
        System.out.println("  | $$  | $$      | $$__/      | $$   ");
        System.out.println("  | $$  | $$    $$| $$         | $$   ");
        System.out.println(" /$$$$$$|  $$$$$$/| $$$$$$$$   | $$   ");
        System.out.println("|______/ \\______/ |________/   |__/   ");
        System.out.println("");
        System.out.println("  _______       __   __   _____          _      _____ _    _ _            _______ ____  _____  ");
        System.out.println(" |__   __|/\\    \\ \\ / /  / ____|   /\\   | |    / ____| |  | | |        /\\|__   __/ __ \\|  __ \\ ");
        System.out.println("    | |  /  \\    \\ V /  | |       /  \\  | |   | |    | |  | | |       /  \\  | | | |  | | |__) |");
        System.out.println("    | | / /\\ \\    > <   | |      / /\\ \\ | |   | |    | |  | | |      / /\\ \\ | | | |  | |  _  / ");
        System.out.println("    | |/ ____ \\  / . \\  | |____ / ____ \\| |___| |____| |__| | |____ / ____ \\| | | |__| | | \\ \\ ");
        System.out.println("    |_/_/    \\_\\/_/ \\_\\  \\_____/_/    \\_\\______\\_____\\____/|______/_/    \\_\\_|  \\____/|_|  \\_\\" );
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("\n[1] Withholding Tax");
        System.out.println("[2] Payable Tax");
        System.out.println("[3] Income Tax");
        System.out.println("[4] Social Security Contribution Levy (SSCL) Tax");
        System.out.println("[5] Leasing Payment");
        System.out.println("[6] Exit");
        System.out.println("");
        System.out.print("Enter an option to continue -> ");
    }

    private static int getValidOption(Scanner scanner, int maxOption) {
        int option;
        while (true) {
            try {
                option = Integer.parseInt(scanner.next());
                if (option >= 1 && option <= maxOption) {
                    return option;
                } else {
                    System.out.print("Invalid option. Please enter a number between 1 and " + maxOption + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static void withholdingTaxMenu(Scanner scanner) {
        int option;
        do {
            clearScreen();
            System.out.println("\n+----------------------------+");
            System.out.println("|       WITHHOLDING TAX      |");
            System.out.println("+----------------------------+");
            System.out.println("");
            System.out.println("[1] Rent Tax");
            System.out.println("[2] Bank Interest Tax");
            System.out.println("[3] Dividend Tax");
            System.out.println("[4] Exit");
            System.out.println("");
            System.out.print("Enter an option to continue -> ");
            option = getValidOption(scanner, 4);

            switch (option) {
                case 1:
                    calculateRentTax(scanner);
                    break;
                case 2:
                    calculateBankInterestTax(scanner);
                    break;
                case 3:
                    calculateDividendTax(scanner);
                    break;
                case 4:
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 4);
    }

    private static void calculateRentTax(Scanner scanner) {
        double paymentAmount;
        String choice;

        do {
            clearScreen();
            System.out.println("\n+---------------------------------------------+");
            System.out.println("|                RENT TAX                     |");
            System.out.println("+---------------------------------------------+");
            System.out.println("");
            paymentAmount = getValidDouble(scanner, "Enter your rent: ");

            if (paymentAmount <= 100000) {
                System.out.println("You don't have to pay rent tax.");
            } else {
                double rentTax = (paymentAmount - 100000) * 0.10;
                System.out.printf("You have to pay Rent Tax: Rs. %.2f\n", rentTax);
            }

            System.out.print("Do you want to enter another value (Y/N): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Returning to Withholding Tax menu...");
    }

    private static void calculateBankInterestTax(Scanner scanner) {
        double interestAmount;
        String choice;

        do {
            clearScreen();
            System.out.println("\n+---------------------------------------------+");
            System.out.println("|                BANK INTEREST TAX           |");
            System.out.println("+---------------------------------------------+");
            System.out.println("");
            interestAmount = getValidDouble(scanner, "Enter your bank interest per year: ");

            double bankInterestTax = interestAmount * 0.05;
            System.out.printf("You have to pay Bank Interest Tax per year: Rs. %.2f\n", bankInterestTax);

            System.out.print("Do you want to calculate another Bank Interest Tax (Y/N): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Returning to Withholding Tax menu...");
    }

    private static void calculateDividendTax(Scanner scanner) {
        double dividendAmount;
        String choice;

        do {
            clearScreen();
            System.out.println("\n+---------------------------------------------+");
            System.out.println("|                DIVIDEND TAX                 |");
            System.out.println("+---------------------------------------------+");
            System.out.println("");
            dividendAmount = getValidDouble(scanner, "Enter your total dividend per year: ");

            if (dividendAmount <= 100000) {
                System.out.println("You don't have to pay Dividend Tax.");
            } else {
                double dividendTax = (dividendAmount - 100000) * 0.14;
                System.out.printf("You have to pay Dividend Tax per year: Rs. %.2f\n", dividendTax);
            }

            System.out.print("Do you want to calculate another Dividend Tax (Y/N): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Returning to Withholding Tax menu...");
    }

    private static void payableTax(Scanner scanner) {
        double salary;
        String choice;

        do {
            clearScreen();
            System.out.println("\n+---------------------------------------------+");
            System.out.println("|                PAYABLE TAX                  |");
            System.out.println("+---------------------------------------------+");
            System.out.println("");
            salary = getValidDouble(scanner, "Enter your employee payment per month: ");

            double payableTax = 0;

            if (salary <= 100000) {
                System.out.println("You don't have to pay Payable Tax.");
            } else {
                if (salary > 100000) {
                    double slab1 = Math.min(salary - 100000, 41667);
                    payableTax += slab1 * 0.06;
                }
                if (salary > 141667) {
                    double slab2 = Math.min(salary - 141667, 41667);
                    payableTax += slab2 * 0.12;
                }
                if (salary > 183333) {
                    double slab3 = Math.min(salary - 183333, 41667);
                    payableTax += slab3 * 0.18;
                }
                if (salary > 225000) {
                    double slab4 = salary - 225000;
                    payableTax += slab4 * 0.24;
                }
                System.out.printf("You have to pay Payable Tax: Rs. %.2f\n", payableTax);
            }

            System.out.print("Do you want to enter another value (Y/N): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Returning to main menu...");
    }

    private static void incomeTax(Scanner scanner) {
        double income;
        String choice;

        do {
            clearScreen();
            System.out.println("\n+---------------------------------------------+");
            System.out.println("|                INCOME TAX                  |");
            System.out.println("+---------------------------------------------+");
            System.out.println("");
            income = getValidDouble(scanner, "Enter your income per year: ");

            double tax = 0;

            if (income <= 300000) {
                System.out.println("You don't have to pay Income Tax.");
            } else {
                if (income > 300000) {
                    double slab1 = Math.min(income - 300000, 300000);
                    tax += slab1 * 0.03;
                }
                if (income > 600000) {
                    double slab2 = Math.min(income - 600000, 300000);
                    tax += slab2 * 0.10;
                }
                if (income > 900000) {
                    double slab3 = Math.min(income - 900000, 300000);
                    tax += slab3 * 0.15;
                }
                if (income > 1200000) {
                    double slab4 = income - 1200000;
                    tax += slab4 * 0.20;
                }
                System.out.printf("You have to pay Income Tax: Rs. %.2f\n", tax);
            }

            System.out.print("Do you want to calculate another Income Tax (Y/N): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Returning to main menu...");
    }

    private static void SSCLTax(Scanner scanner) {
        double salary;
        String choice;

        do {
            clearScreen();
            System.out.println("\n+---------------------------------------------+");
            System.out.println("|     SOCIAL SECURITY CONTRIBUTION LEVY (SSCL)|");
            System.out.println("+---------------------------------------------+");
            System.out.println("");
            salary = getValidDouble(scanner, "Enter your salary per month: ");

            double ssclTax = salary * 0.02 * 12;
            System.out.printf("You have to pay SSCL Tax per year: Rs. %.2f\n", ssclTax);

            System.out.print("Do you want to calculate another SSCL Tax (Y/N): ");
            choice = scanner.next();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Returning to main menu...");
    }

    private static void leasingPaymentMenu(Scanner scanner) {
        int option;
        double principal, rate, payment;
        int years;

        do {
            clearScreen();
            System.out.println("\n+-------------------------------+");
            System.out.println("|     LEASING PAYMENT MENU      |");
            System.out.println("+-------------------------------+");
            System.out.println("");
            System.out.println("[1] Monthly Payments");
            System.out.println("[2] Quarterly Payments");
            System.out.println("[3] Annual Payments");
            System.out.println("[4] Exit");
            System.out.println("");
            System.out.print("Enter an option to continue -> ");
            option = getValidOption(scanner, 4);

            switch (option) {
                case 1:
                    System.out.println("\n+------------------------------------+");
                    System.out.println("|        LEASING PAYMENT MENU       |");
                    System.out.println("+------------------------------------+");
                    System.out.print("Enter principal amount: ");
                    principal = scanner.nextDouble();
                    System.out.print("Enter annual interest rate (in percentage): ");
                    rate = scanner.nextDouble() / 100;
                    System.out.print("Enter number of years: ");
                    years = scanner.nextInt();
                    payment = principal * (rate / 12) / (1 - Math.pow(1 + (rate / 12), -12 * years));
                    System.out.printf("Monthly Payment: Rs. %.2f\n", payment);
                    break;

                case 2:
                    System.out.println("\n+------------------------------------+");
                    System.out.println("|        LEASING PAYMENT MENU       |");
                    System.out.println("+------------------------------------+");
                    System.out.print("Enter principal amount: ");
                    principal = scanner.nextDouble();
                    System.out.print("Enter annual interest rate (in percentage): ");
                    rate = scanner.nextDouble() / 100;
                    System.out.print("Enter number of years: ");
                    years = scanner.nextInt();
                    payment = principal * (rate / 4) / (1 - Math.pow(1 + (rate / 4), -4 * years));
                    System.out.printf("Quarterly Payment: Rs. %.2f\n", payment);
                    break;

                case 3:
                    System.out.println("\n+------------------------------------+");
                    System.out.println("|        LEASING PAYMENT MENU       |");
                    System.out.println("+------------------------------------+");
                    System.out.print("Enter principal amount: ");
                    principal = scanner.nextDouble();
                    System.out.print("Enter annual interest rate (in percentage): ");
                    rate = scanner.nextDouble() / 100;
                    System.out.print("Enter number of years: ");
                    years = scanner.nextInt();
                    payment = principal * (rate / 1) / (1 - Math.pow(1 + (rate / 1), -1 * years));
                    System.out.printf("Annual Payment: Rs. %.2f\n", payment);
                    break;

                case 4:
                    System.out.println("Returning to the main menu...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 4);
    }

    private static double getValidDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(scanner.next());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Invalid input. Please enter a positive amount.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
