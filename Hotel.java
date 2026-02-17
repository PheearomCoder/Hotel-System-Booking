import java.util.ArrayList;

class Hotel {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room findAvailableRoom(int roomType) {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                if (roomType == 1 && room instanceof SingleRoom) {
                    return room;
                } else if (roomType == 2 && room instanceof DoubleRoom) {
                    return room;
                }
            }
        }
        return null;
    }

    public void bookRoom(Guest guest, int days, int roomType) {
        Room room = findAvailableRoom(roomType);
        if (room != null) {
            Reservation reservation = new Reservation(guest, room, days);
            reservations.add(reservation);
            System.out.println("Room booked successfully! Assigned Room: " + room.getRoomNumber());
        } else {
            System.out.println("Sorry, no rooms available of that type!");
        }
    }

    public void checkout(int roomNumber) {
        boolean found = false;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                found = true;
                if (!room.isAvailable()) {
                    room.releaseRoom();
                    System.out.println("Check-out successful! Room " + roomNumber + " is now available.");
                } else {
                    System.out.println("Room " + roomNumber + " is already empty.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Room number " + roomNumber + " does not exist.");
        }
    }

    // --- UPDATED: List Available Rooms as a Table ---
    public void listAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");

        // Print Table Header
        System.out.println("---------------------------------------");
        System.out.printf("| %-10s | %-10s | %-8s |\n", "Room No", "Type", "Price");
        System.out.println("---------------------------------------");

        int count = 0;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                String type = (room instanceof SingleRoom) ? "Single" : "Double";
                // Assuming pricePerNight is accessible (protected in same package)
                System.out.printf("| %-10d | %-10s | $%-7.2f |\n", room.getRoomNumber(), type, room.pricePerNight);
                count++;
            }
        }

        System.out.println("---------------------------------------");

        if (count == 0) {
            System.out.println("| No rooms available.                 |");
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Total Available: " + count);
        }
    }

    public void showAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation r : reservations) {
                r.displayDetails();
            }
        }
    }
}