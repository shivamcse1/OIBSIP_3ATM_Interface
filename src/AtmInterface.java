import java.util.Scanner;
    class BankAccount {

        String Name;
        String UserName;
        String password;
        String AccountNumber;
        float balance = 1000000f;
        int tr = 0;
        String trHistory = "";

        // for Withdraw amount
        public void withdraw() {
            System.out.print("\nEnter amount Which you want to withdraw : ");
            Scanner sc = new Scanner(System.in);
            float amount = sc.nextFloat();
            try {
                if ( balance >= amount ) {
                    tr++;
                    balance -= amount;
                    System.out.println("\nWithdraw Successfully");
                    String str = amount + " Rs Withdraw\n";
                    trHistory = trHistory.concat(str);
                }
                else {
                    System.out.println("\nYou Have Not Sufficient Balance !");
                }
            }
            catch ( Exception e) {
            }
        }

        // for deposit amount
        public void deposit() {

            System.out.print("\nEnter amount which you want to deposit : ");
            Scanner sc = new Scanner(System.in);
            float amount = sc.nextFloat();
            try {
                if ( amount <= 1000000f ) {
                    tr++;
                    balance += amount;
                    System.out.println("\nYour Money Has Successfully Deposited !");
                    String str = amount + " Rs deposited\n";
                    trHistory = trHistory.concat(str);
                }
                else {
                    System.out.println("\nSorry. Your Limit is 1000000.00 Rs.");
                }
            }
            catch ( Exception e) {
            }
        }

        // this is for user Registration
        public void Register() {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter Your Name : ");
            this.Name = sc.nextLine();
            System.out.print("Enter Your Username : ");
            this.UserName = sc.nextLine();
            System.out.print("Enter Your password : ");
            this.password = sc.nextLine();
            System.out.print("Enter Your Account Number : ");
            this.AccountNumber = sc.nextLine();
            System.out.println("\nYour Registration Is Completed. Please Login!");
        }

        // this is for user login
        public boolean Login() {
            boolean Lg = false;
            Scanner sc = new Scanner(System.in);
            while ( !Lg ) {
                System.out.print("\nPlease Enter Your Username : ");
                String Username = sc.nextLine();
                if ( Username.equals(UserName) ) {
                    while ( !Lg ) {
                        System.out.print("Please Enter Your password : ");
                        String password = sc.nextLine();
                        if ( password.equals(password) ) {
                            System.out.print("\nYou have Login successfully!");
                            Lg = true;
                        }
                        else {
                            System.out.println("\nIncorrect password!");
                        }
                    }
                }
                else {
                    System.out.println("\nThis Username not found!");
                }
            }
            return Lg;
        }


        // for transfer the money
        public void transfer() {

            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter Receipent's Name : ");
            String receipent = sc.nextLine();
            System.out.print("\nEnter amount to transfer : ");
            float amount = sc.nextFloat();

            try {
                if ( balance >= amount ) {
                    if ( amount <= 50000f ) {
                        tr++;
                        balance -= amount;
                        System.out.println("\nSuccessfully Transfered to " + receipent);
                        String str = amount + " Rs transfered to " + receipent + "\n";
                        trHistory = trHistory.concat(str);
                    }
                    else {
                        System.out.println("\nSorry.. Your Limit is 50000.00");
                    }
                }
                else {
                    System.out.println("\nYou Have Not Sufficient Balance ");
                }
            }
            catch ( Exception e) {
            }
        }

        // for check user balance
        public void checkBalance() {

            System.out.println("\nYour Available Balance is = " + balance + " Rs");
        }

        // user transaction history
        public void TrHistory() {
            if ( tr == 0 ) {
                System.out.println("\nEmpty");
            }
            else {
                System.out.println("\n" + trHistory);
            }
        }
    }

    // This section for Atminterface
    public class AtmInterface {
        public static int takeInput(int limit) {
            int input = 0;
            boolean flag = false;

            while ( !flag ) {
                try {
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextInt();
                    flag = true;

                    if ( flag && input > limit || input < 1 ) {
                        System.out.println("Choose the number between 1 to " + limit);
                        flag = false;
                    }
                }
                catch ( Exception e ) {
                    System.out.println("Enter only integer value : ");
                    flag = false;
                }
            };
            return input;
        }

        // main function of program
        public static void main(String[] args) {

            System.out.println("\nWelcome to Kotak Mahindra Bank Atm\n");
            System.out.println("1.Press 1 for Registration!");
            System.out.println("2.Press 2 for Exit!");
            System.out.print("Enter Your Choice: ");
            int choice = takeInput(2);

            if ( choice == 1 ) {
                BankAccount b = new BankAccount();
                b.Register();
                while(true) {
                    System.out.println("\n1.Press 1 for Login \n2.Press 2 for Exit");
                    System.out.print("Enter Your Choice:");
                    int ch = takeInput(2);
                    if ( ch == 1 ) {
                        if (b.Login()) {
                            System.out.println("\n\nYour Most Welcome! " + b.Name + "\n");
                            boolean isFinished = false;
                            while (!isFinished) {
                                System.out.println("1.Transaction History");
                                System.out.println("2.Withdraw Money");
                                System.out.println("3.Deposit Amount");
                                System.out.println("4.Transfer Money");
                                System.out.println("5.Check Balance");
                                System.out.println("6.Exit");
                                System.out.print("Enter Your Choice: ");
                                int c = takeInput(6);
                                switch(c) {
                                    case 1:
                                        b.TrHistory();
                                        break;
                                    case 2:
                                        b.withdraw();
                                        break;
                                    case 3:
                                        b.deposit();
                                        break;
                                    case 4:
                                        b.transfer();
                                        break;
                                    case 5:
                                        b.checkBalance();
                                        break;
                                    case 6:
                                        isFinished = true;
                                        break;
                                }
                            }
                        }
                    }
                    else {
                        System.exit(0);
                    }
                }
            }
            else {
                System.exit(0);
            }
        }
    }
