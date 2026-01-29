import java.util.*;

class User {
    String username;
    String password;

    User() {
        username = "student";
        password = "exam123";
    }
}

class Profile {
    Scanner sc = new Scanner(System.in);

    void update(User u) {
        System.out.print("Enter new username: ");
        u.username = sc.next();
        System.out.print("Enter new password: ");
        u.password = sc.next();
        System.out.println("Profile Updated Successfully");
    }
}

class Exam {
    Scanner sc = new Scanner(System.in);
    int score = 0;

    void start() {
        long startTime = System.currentTimeMillis();
        long timeLimit = 60000;

        System.out.println("\nExam Started (60 seconds)");

        System.out.println("\nQ1. Java is a?");
        System.out.println("1. OS  2. Language  3. Browser  4. Device");
        if (sc.nextInt() == 2) score++;

        if (timeOver(startTime, timeLimit)) return;

        System.out.println("\nQ2. Which keyword is used to inherit a class?");
        System.out.println("1. implement  2. extends  3. inherit  4. super");
        if (sc.nextInt() == 2) score++;

        if (timeOver(startTime, timeLimit)) return;

        System.out.println("\nQ3. JVM stands for?");
        System.out.println("1. Java Variable Machine  2. Java Virtual Machine");
        if (sc.nextInt() == 2) score++;

        if (timeOver(startTime, timeLimit)) return;

        System.out.println("\nQ4. Data type for true/false?");
        System.out.println("1. int  2. char  3. boolean  4. float");
        if (sc.nextInt() == 3) score++;

        if (timeOver(startTime, timeLimit)) return;

        System.out.println("\nQ5. Entry point of Java program?");
        System.out.println("1. start()  2. run()  3. main()  4. init()");
        if (sc.nextInt() == 3) score++;

        submit();
    }

    boolean timeOver(long start, long limit) {
        if (System.currentTimeMillis() - start > limit) {
            System.out.println("\nTime Over! Auto Submitting...");
            submit();
            return true;
        }
        return false;
    }

    void submit() {
        System.out.println("\nExam Submitted");
        System.out.println("Score: " + score + "/5");
    }
}

class Menu {
    Scanner sc = new Scanner(System.in);

    void show(User u, Profile p, Exam e) {
        while (true) {
            System.out.println("\n1.Update Profile");
            System.out.println("2.Start Exam");
            System.out.println("3.Logout");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1)
                p.update(u);
            else if (ch == 2)
                e.start();
            else if (ch == 3) {
                System.out.println("Logged Out");
                return;
            } else
                System.out.println("Invalid Choice");
        }
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User u = new User();
        Profile p = new Profile();
        Exam e = new Exam();
        Menu m = new Menu();

        System.out.print("Enter Username: ");
        String un = sc.next();
        System.out.print("Enter Password: ");
        String pw = sc.next();

        if (un.equals(u.username) && pw.equals(u.password)) {
            System.out.println("Login Successful");
            m.show(u, p, e);
        } else {
            System.out.println("Invalid Login");
        }
    }
}
