import java.util.Scanner;

public class BankJava {

    public static void main(String[] args) {
        
        String whichProcess = "Balance Display --> 1\n" +
                              "Withdrawal --> 2\n" +
                              "Deposit Money to Different Accounts --> 3\n" +
                              "Quit = Q";

        Scanner scanner = new Scanner(System.in);
        String Vote;
        String Name1User = "User1";
        String name1Password = "1234";
        double Money1 = 2500;
        String Name1Iban = "12 4324 2342 7675 4455 6666";
      
        String Name2User = "User2";
        String name2Password = "4321";
        double Money2 = 1250;
        String Name2Iban = "23 4444 5555 7777 4455 6666";

        System.out.println("Welcome to ATM");
        System.out.print("Please enter a username: ");
        String User = scanner.nextLine();

        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

        if (User.equals(Name1User) && password.equals(name1Password)) {
            System.out.println("Welcome, " + Name1User);
            do {
            	System.out.println(whichProcess);
                System.out.print("Please enter a number: ");
                Vote = scanner.nextLine();
			
            switch (Vote) {
                case "1":
                    System.out.println("Balance: " + Money1);
                    break;
                case "2":
                    System.out.print("How much would you like to withdraw?: ");
                    int PullMoney = scanner.nextInt();
                    if (Money1 >= PullMoney) {
                        Money1 -= PullMoney;
                        System.out.println("Remaining Balance: " + Money1);
                    } else {
                        System.out.println("You cannot withdraw more than your balance.");
                    }
                    break; 
                case "3":
                    System.out.print("Amount to be sent: ");
                    int sentMoney = scanner.nextInt();
                    if (sentMoney <= Money1) {
                        System.out.print("Enter an IBAN: ");
                        scanner.nextLine(); 
                        String sentIBAN = scanner.nextLine();
                        if (sentIBAN.equals(Name2Iban)) {
                            System.out.println("Money has been sent.");
                            Money1 -= sentMoney;
                            Money2 += sentMoney;
                        } else {
                            System.out.println("Invalid IBAN.");
                        }
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
            } while (!Vote.equalsIgnoreCase("Q"));

            
        } else if (User.equals(Name2User) && password.equals(name2Password)) {
            System.out.println("Welcome, " + Name2User);
            System.out.println(whichProcess);
        } else {
            System.out.println("Your username or password is incorrect.");
        }

        scanner.close();
    }
}
