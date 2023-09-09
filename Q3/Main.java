package Q3;

// this program gets the users to book seats for a movie in which we check based onw here they want to
//sit if its available or not and validate it and also give them their balance and print the map.
import java.util.Scanner; // import for user input

public class Main {
    public static void main(String[] args) {

        System.out.println("--------------------------------------------");
        System.out.println("------COMP248 Concert IS BACK IN TOWN-------");
        System.out.println("       Hurry book your ticket Now ! !      " );
        System.out.println("--------------------------------------------");
        //display welcome message

        System.out.println("1 A B C D E F G");
        System.out.println("2 A B C D E F G");
        System.out.println("3 A B C D E F G");
        System.out.println("4 A B C D E F G");
        System.out.println("5 A B C D E F G");
        System.out.println("6 A B C D E F G");

        System.out.println("Rows 1 & 2 Gold   100 CAD/ticket");
        System.out.println("Rows 3 & 4 Gold   70 CAD/ticket");
        System.out.println("Rows 5 & 6 Gold   40 CAD/ticket");
        System.out.println("Available seats 42");
        // info for user to see

        boolean continueBooking = true; // initializing
        Scanner scanner = new Scanner(System.in);// calling for user input

        int[][] seats = {
                {0, 0, 0, 0, 0, 0, 0},  // Row 1
                {0, 0, 0, 0, 0, 0, 0},  // Row 2
                {0, 0, 0, 0, 0, 0, 0},  // Row 3
                {0, 0, 0, 0, 0, 0, 0},  // Row 4
                {0, 0, 0, 0, 0, 0, 0},  // Row 5
                {0, 0, 0, 0, 0, 0, 0}   // Row 6
        };
        // 2D array of the seats which are at 0 to say theres nobody in it

        int availableSeats = 42; // initializing ; how many seats there are to begin

        while (continueBooking) { // continue executing until the user decides not to so remains true
            int totalTickets = 0;
            int totalBalance = 0;
            // initializing tickets total and balance to begin


            System.out.println("How many tickets do you need: ");
            int numTickets = scanner.nextInt();
            // get user input for tickets

            if (numTickets > availableSeats) { // check if tickets asked is more than seats
                System.out.println("Not enough seats available. Please try again.");
                continue;
            }

            for (int i = 0; i < numTickets; i++) { // iterates tickets so can book more
                System.out.println("Input your seat selection");
                System.out.println("Enter the row and then the seat letter (example: 3B): ");
                String seatSelection = scanner.next();
                // get seat selection

                int row = Integer.parseInt(seatSelection.substring(0, 1));
                // gets out row number from seatselection and uses substring to int and assign to row variable
                char seat = seatSelection.charAt(1);
                // gets out seat letter from seatSelection and assign to seat

                if (row >= 1 && row <= 6 && seat >= 'A' && seat <= 'G') { // check user is within bound
                    int seatIndex = seat - 'A'; // see index of A so 0 as A. subtracting A from seat character to get index
                    if (seats[row - 1][seatIndex] == 0) { // checks if selected seat is available
                        seats[row - 1][seatIndex] = 1;
                        totalTickets++; // increment tickets booked
                        int ticketPrice = getTicketPrice(row); // ticket price based on row
                        totalBalance += ticketPrice;// adds ticket price to the balance
                        System.out.println("Your seat is reserved. Your balance is " + totalBalance + " CAD.");
                        printSeatMap(seats);
                        // confirmation seats
                        availableSeats--; // decrement seats available
                    } else {
                        System.out.println("The seat is already taken. Please choose another seat.");
                        i--;
                    }
                } else {
                    System.out.println("Invalid seat selection. Please enter a valid seat.");
                    i--;
                }
            }



            System.out.println("Reservation is complete.");
            System.out.print("Do you wish to start a new booking? (y/n): ");
            String continueChoice = scanner.next();
            // see if user wants to book another

            if (continueChoice.equalsIgnoreCase("y")) {
                System.out.println("New booking started.");
            } else {
                continueBooking = false;
            }

            System.out.println("Available seats:");
            printSeatMap(seats);
        }
    }

    private static int getTicketPrice(int row) {
        if (row <= 2) {
            return 100;
        } else if (row <= 4) {
            return 70;
        } else {
            return 40;
        }
    }
    // check row to see what price it will cost and if else to see how much based on the row
    private static void printSeatMap(int[][] seats) {
        System.out.println("Current seat map:");
        System.out.println("  A B C D E F G");
        for (int i = 0; i < seats.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    // this prints out the seat map so A to G in rows then iterate each row of seats array using for loop
    //i is current row index n j is the seat n inside checks seats[i][j] if 0 or not






}