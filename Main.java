import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Initialize 15 Single Rooms (101-115)
        for (int i = 1; i <= 15; i++) {
            hotel.addRoom(new SingleRoom(100 + i));
        }

        // Initialize 15 Double Rooms (201-215)
        for (int i = 1; i <= 15; i++) {
            hotel.addRoom(new DoubleRoom(200 + i));
        }

        int choice;

        do {
            System.out.println("\n--- PHEAROM HOTEL SYSTEM ---");
            System.out.println("1. Book Room");
            System.out.println("2. Checkout Room");
            System.out.println("3. List Available Rooms");
            System.out.println("4. Show Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                sc.nextLine();
                choice = 0;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter guest name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter guest phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter number of days: ");
                    int days = sc.nextInt();

                    System.out.println("Select Room Type: 1. Single  2. Double");
                    int type = sc.nextInt();

                    hotel.bookRoom(new Guest(name, phone), days, type);
                    break;

                case 2:
                    System.out.print("Enter Room Number to Checkout: ");
                    int roomNum = sc.nextInt();
                    hotel.checkout(roomNum);
                    break;

                case 3:
                    hotel.listAvailableRooms();
                    break;

                case 4:
                    hotel.showAllReservations();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}