public class Test01 {
    public static void main(String[] args) {
        RejseKort r;
        r = new RejseKort();
        printCheckInStatus(r, 10);
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