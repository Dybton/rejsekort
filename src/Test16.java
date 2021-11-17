public class Test16 {
    public static void main(String[] args) {
        RejseKort r;
        r = new RejseKort();
        r.checkIn(3, 4, 200);
        printCheckInStatus(r, 250);
        r.checkIn(1, 2, 300);
        printCheckInStatus(r, 350);
        r.checkIn(4, 5, 400);
        printCheckInStatus(r, 450);
        r.checkOut(3, 4, 500);
        printCheckInStatus(r, 501);
        System.out.println();
    }

    static void printCheckInStatus(RejseKort r, int time) {
        if (r.isCheckedIn(time)) {
            System.out.println("Card counts as a valid ticket at time " + time);
        } else {
            System.out.println("Card does not count as a valid ticket at time " + time);
        }
    }
}
