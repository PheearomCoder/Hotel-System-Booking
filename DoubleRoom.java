class DoubleRoom extends Room {

    public DoubleRoom(int roomNumber) {
        super(roomNumber, 40);
    }

    @Override
    public double calculateBill(int days) {
        return days * pricePerNight;
    }
}
