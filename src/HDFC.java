import java.util.ArrayList;
import java.util.Scanner;

public class HDFC {
    private static ArrayList<Customer> customersList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to HDFC Bank");
        enterChoice();
    }

    public static void enterChoice() {
        System.out.println("Enter a choice \n"
                + "1. Create an Account \n"
                + "2. Login");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                login();
                break;
            default:
                System.out.println("Invalid entry: Please try again");
        }
        scanner.close();
    }

    public static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name");
        String name = scanner.nextLine();
        System.out.println("Enter the password");
        String password = scanner.nextLine();
        System.out.println("Enter the account number ");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter the total balance ");
        double totalBalance = scanner.nextDouble();
        scanner.nextLine();

            Customer customer = new Customer(name, password, accountNumber, totalBalance);
            customersList.add(customer);
            System.out.println("Account created successfully");
            System.out.println("The number of customers in bank are " + customersList.size());


        enterChoice();
        scanner.close();

    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the account number to login");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        boolean isAccountExist = false;
        Customer customer = null;

        for (int i = 0; i < customersList.size(); i++) {
            if (accountNumber.equals(customersList.get(i).getAccountNumber()) && password.equals(customersList.get(i).getPassword())) {
                isAccountExist = true;
                customer = customersList.get(i);
                break;
            }

        }

        if (isAccountExist) {
            System.out.println("Login Successful \n"
                    + "------------------------------------------------");
            handleCustomerLoginSuccess(customer);
        } else {
            System.out.println("Invalid credentials");
        }
        scanner.close();
    }

    private static void handleCustomerLoginSuccess(Customer customer) {
        System.out.println("Enter the choice \n"
                + "1. Deposit\n"
                + "2. Withdraw\n"
                + "3. Show Balance\n"
                +"4. Account Details");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> depositAmount(customer);
            case 2 -> withdraw(customer);
            case 3 -> showBalance(customer);
            case 4 -> AccountDetails(customer);
            default -> System.out.println("Invalid choice");
        }

    }

    private static void depositAmount(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the amount to deposit");
        double amount = scanner.nextDouble();
        customer.setDepositAmount(amount);
        System.out.println("The total balance after deposit is " + customer.getTotalBalance());
        scanner.close();
    }

    private static void withdraw(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the amount to withdraw");
        double amount = scanner.nextDouble();
        customer.withdrawAmount(amount);
        System.out.println("The total balance after withdraw is " + customer.getTotalBalance());
        scanner.close();
    }



    private static void showBalance(Customer customer) {
        System.out.println("the total balance is " + customer.getTotalBalance());
    }
    private static void AccountDetails(Customer customer){
        System.out.println("Account Number - "+customer.getAccountNumber());
        System.out.println("Name - "+customer.getName());
        System.out.println("Total Balance - "+customer.getTotalBalance());
    }


}
