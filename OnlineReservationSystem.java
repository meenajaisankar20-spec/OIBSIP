import java.util.*;

class Reservation {
    String name;
    int trainNo;
    String trainName;
    String classType;
    String date;
    String from;
    String to;

    Reservation(String name, int trainNo, String trainName, String classType, String date, String from, String to) {
        this.name = name;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.classType = classType;
        this.date = date;
        this.from = from;
        this.to = to;
    }
}

public class OnlineReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Reservation> data = new HashMap<>();
    static int pnr = 1000;

    static boolean login() {
        System.out.print("Enter Login ID: ");
        String id = sc.next();
        System.out.print("Enter Password: ");
        String pass = sc.next();
        return id.equals("admin") && pass.equals("admin123");
    }

    static String getTrainName(int trainNo) {
        if (trainNo == 101) return "Chennai Express";
        if (trainNo == 102) return "Coimbatore Express";
        if (trainNo == 103) return "Bangalore Express";
        return "Unknown Train";
    }

    static void reserve() {
        sc.nextLine();
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Train Number: ");
        int trainNo = sc.nextInt();
        String trainName = getTrainName(trainNo);
        System.out.println("Train Name: " + trainName);

        sc.nextLine();
        System.out.print("Enter Class Type: ");
        String classType = sc.nextLine();

        System.out.print("Enter Date of Journey: ");
        String date = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("To: ");
        String to = sc.nextLine();

        Reservation r = new Reservation(name, trainNo, trainName, classType, date, from, to);
        data.put(++pnr, r);

        System.out.println("Reservation Successful");
        System.out.println("PNR Number: " + pnr);
    }

    static void cancel() {
        System.out.print("Enter PNR Number: ");
        int num = sc.nextInt();

        if (data.containsKey(num)) {
            Reservation r = data.get(num);
            System.out.println("Passenger Name: " + r.name);
            System.out.println("Train: " + r.trainName);
            System.out.println("From: " + r.from + " To: " + r.to);
            System.out.print("Confirm Cancellation (yes/no): ");
            String ch = sc.next();
            if (ch.equalsIgnoreCase("yes")) {
                data.remove(num);
                System.out.println("Ticket Cancelled Successfully");
            }
        } else {
            System.out.println("Invalid PNR Number");
        }
    }

    public static void main(String[] args) {
        if (!login()) {
            System.out.println("Invalid Login");
            return;
        }

        while (true) {
            System.out.println("\n1.Reservation\n2.Cancellation\n3.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    reserve();
                    break;
                case 2:
                    cancel();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
