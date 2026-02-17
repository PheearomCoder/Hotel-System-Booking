class Reservation {
    private Guest guest;
    private Room room;
    private int days;

    public Reservation(Guest guest, Room room, int days) {
        this.guest = guest;
        this.room = room;
        this.days = days;
        room.bookRoom();
    }

    public double generateBill() {
        return room.calculateBill(days);
    }

    public void checkout() {
        room.releaseRoom();
    }

    public void displayDetails() {
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room No: " + room.getRoomNumber());
        System.out.println("Days: " + days);
        System.out.println("Total Bill: " + generateBill());
        System.out.println("----------------------------");
    }
}
