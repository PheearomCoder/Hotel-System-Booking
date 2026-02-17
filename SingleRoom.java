class SingleRoom extends Room {

    public SingleRoom(int roomNumber) {
        super(roomNumber, 20);
    }

    @Override
    public double calculateBill(int days) {
        return days * pricePerNight;
    }
}
