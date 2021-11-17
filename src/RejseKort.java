public class RejseKort {
    private int balance = 100;
    private int minX, minY, maxX, maxY;
    private int lastCheckIn;
    private boolean checkedIn = false;

    // Constructor
    public RejseKort() {
    }

    // public void depositMoney(int dkk) {
    public void depositMoney(int dkk) {
        if (dkk < 0) {
            System.out.println("Error: Cannot deposit negative amount");
        } else {
            balance += dkk;
            System.out.println(dkk + " DKK deposited. New balance: " + balance + " DKK");
        }
    }

    // Checks if user has checked in within the last 2 hours
    public boolean isCheckedIn(int timeStamp) {
        if (checkedIn) {
            if ((timeStamp - lastCheckIn) > 120) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    // Checks the user in
    public void checkIn(int x, int y, int timeStamp) {
        if (checkInAllowed()) {
            if (!checkedIn) {
                System.out.println("Checked in");
                this.lastCheckIn = timeStamp;
                setCoordinates(x, y, x, y);
            } else if (isCheckedIn(timeStamp)) {
                int travelTime = timeStamp - lastCheckIn;
                this.lastCheckIn = timeStamp;
                determineMinMax(x, y);
                System.out.println("Continued journey (" + travelTime + " minutes since last check in)");
            }
            checkedIn = true;
        }
    }

    // Checks the user out
    public void checkOut(int x, int y, int timeStamp) {
        if (isCheckedIn(timeStamp)) {
            determineMinMax(x, y);
            int travelTime = timeStamp - lastCheckIn;
            int price = calculatePrice();
            this.balance = balance - price;
            this.checkedIn = false;
            // Once user checks out the coordinates are set to 0.
            setCoordinates(0, 0, 0, 0);
            System.out.println("Checked out! " + travelTime + " minutes since last check in. " + "Price is " + price
                    + " DKK, remaining balance is " + balance + " DKK");
        } else {
            System.out.println("Error: Cannot check out; Not currently checked in");
        }
    }

    // Helper functions

    // Calculate the ticket price
    public int calculatePrice() {
        int price = (12 + (maxX - minX + maxY - minY) * 3);
        if (price > 50) {
            price = 50;
        }
        return price;
    }

    // Checks if the user has enough money to check in
    public boolean checkInAllowed() {
        if (balance < 100) {
            System.out.println(
                    "Not enough money in account to check in. Please deposit at least " + (100 - balance) + " DKK");
            return false;
        } else {
            return true;
        }
    }

    // Determines which coordinates to change
    public void determineMinMax(int x, int y) {
        if (x < this.minX) {
            setCoordinates(x, minY, maxX, maxY);
        }
        if (x > this.maxX) {
            setCoordinates(minX, minY, x, maxY);
        }
        if (y < this.minY) {
            setCoordinates(minX, y, maxX, maxY);
        }
        if (y > this.maxY) {
            setCoordinates(minX, minY, maxX, y);
        }
    }

    // Sets the min/max coordinates
    public void setCoordinates(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

}
