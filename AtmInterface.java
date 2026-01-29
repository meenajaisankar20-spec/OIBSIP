import java.util.*;

class User {
    int userId;
    int pin;
    double balance;

    User(int userId, int pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }
}

class TransactionHistory {
    ArrayList<String> history = new ArrayList<>();

    void add(String msg) {
        history.add(msg);
    }

    void show() {
        if (history.isEmpty()) {
            System.out.println("No Transactions Found");
        } else {
            for (String s : history) {
                System.out.println(s);
            }
        }
    }
}

class ATMOperations {
    Scanner sc = new Scanner(System.in);
    TransactionHistory th;

    ATMOperations(TransactionHistory th) {
        this.th = th;
    }

    void withdraw(User u) {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        if (amt <= u.balance) {
            u.balance -= amt;
            th.add("Withdrawn: " + amt);
            System.out.println("Please collect your cash");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void deposit(User u) {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        u.balance += amt;
        th.add("Deposited: " + amt);
        System.out.println("Amount Deposited Successfully");
    }

    void transfer(User u) {
        System.out.print("Enter receiver account number: ");
        int acc = sc.nextInt();
        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();
        if (amt <= u.balance) {
            u.balance -= amt;
            th.add("Transferred " + amt + " to Account " + acc);
            System.out.println("Transfer Successful");
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

class ATM {
    Scanner sc = new Scanner(System.in);
    ATMOperations ops;
    TransactionHistory th;

    ATM(ATMOperations ops, TransactionHistory th) {
        this.ops = ops;
        this.th = th;
    }

    void menu(User u) {
        while (true) {
            System.out.println("\n1.Transaction History");
            System.out.println("2.Withdraw");
            System.out.println("3.Deposit");
            System.out.println("4.Transfer");
            System.out.println("5.Quit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    th.show();
                    break;
                case 2:
                    ops.withdraw(u);
                    break;
                case 3:
                    ops.deposit(u);
                    break;
                case 4:
                    ops.transfer(u);
                    break;
                case 5:
                    System.out.println("Thank you for using ATM");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User user = new User(1234, 1111, 10000);
        TransactionHistory th = new TransactionHistory();
        ATMOperations ops = new ATMOperations(th);
        ATM atm = new ATM(ops, th);

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (id == user.userId && pin == user.pin) {
            System.out.println("Login Successful");
            atm.menu(user);
        } else {
            System.out.println("Invalid Credentials");
        }
    }
}
