
// this program has two players roll a dice and try to fullfill
//an elephants parts by having the rolled number correspond to the
//parts of the elephant. First to get all parts wins.

public class Random {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------");
        System.out.println("       Nancy's Elephant Drawing Game");
        System.out.println("--------------------------------------------");
        // welcome message

        java.util.Random random = new java.util.Random(); // create object to generate random numbers

        // Initialize player elephants array 1D has 7 elements
        int[] p1Elephant = new int[7]; // body, head, ears, trunk, tail, legs, points
        int[] p2Elephant = new int[7];

        int round = 1; // initialize and declare round starting number

        while (true) { // always loops until a player wins ( until hits break )
            System.out.println("Status after round " + round + ":"); // displays which round were on

            // rolling the dice for each player and declaring int variable to assign #
            int p1RandomNumber = random.nextInt(6) + 1; // from 0 to 5 get value and the +1 goes to 1 to 6
            int p2RandomNumber = random.nextInt(6) + 1;
            System.out.println("\tPlayer 1 rolled a " + p1RandomNumber + " while Player 2 rolled a " + p2RandomNumber + ".");
            // displays what each player rolled

            // updating the elephants parts based on dice rolled numbers
            updateElephantParts(p1Elephant, p1RandomNumber);
            updateElephantParts(p2Elephant, p2RandomNumber);
            // use printElephantParts() method to get p1 & p2 array with corresponding number generated for each player


            printElephantStatus("Player 1's elephant", p1Elephant);
            printElephantStatus("Player 2's elephant", p2Elephant);
            // use printElephantStatus() method to get the present info of the body parts and also get string of player1&2
            // it basically calls the other class to print the parts


            // to see if player has won so if true then player 1 wins n if false its player 2 that wins
            // break statement stops the while loops
            if (hasPlayerWon(p1Elephant)) { // checks if user has the right body parts for each dice roll 1-6
                System.out.println("Player 1 wins!");
                break;
            } else if (hasPlayerWon(p2Elephant)) {
                System.out.println("Player 2 wins!");
                break;
            }

            round++; // increment the amount of rounds until a player wins
            System.out.println(); // empty line to space between rounds
        }
        System.out.print("\nHope you enjoyed drawing elephants!");
        //closing message
    }


    // Update the elephant parts based on dice number
    public static void updateElephantParts(int[] elephant, int rolledNumber) {
        if (rolledNumber == 3 && elephant[0] == 0) { // if player rolls 3 and body part is at 0
            elephant[0] = 1; // Body
            // if true then it doesnt have a body yet so we assign 1
        } else if (elephant[0] == 1 && rolledNumber == 2 && elephant[1] == 0) {
            // if already have body part, roll 2, and head of elephant (elephant[1] is already 0.
            elephant[1] = 1; // Head - give the elephant a head so assign elephant[1] with 1
        } else if (elephant[1] == 1) { // check if head elephant is already there
            if (rolledNumber == 6 && elephant[2] < 2) { // if roll 6, and elephant[2] is less than 2
                elephant[2]++; // Ears
            } else if (rolledNumber == 1 && elephant[3] == 0) {
                elephant[3] = 1; // Trunk
            } else if (rolledNumber == 4 && elephant[4] == 0) {
                elephant[4] = 1; // Tail
            } else if (rolledNumber == 5 && elephant[5] < 4) {
                elephant[5]++; // Legs
            }
        }
    }

    public static boolean hasPlayerWon(int[] elephant) {
        return elephant[0] == 1 && elephant[1] == 1 && elephant[2] == 2 && elephant[3] == 1 && elephant[4] == 1 && elephant[5] == 4;
    }
    //boolean method checks if player won by taking integer array elephant to respresent present body parts
    // return checks values at elephant array to see when all true
    // 0 = body, 1 = head, 2 = ears, 3 = trunk, 4 = tails, 5 = legs

    // Print the elephant status for a player
    public static void printElephantStatus(String playerName, int[] elephant) {
        System.out.println(playerName + " has:");
        System.out.println(elephant[0] + " body part(s), " + elephant[1] + " head(s), " + elephant[2] + " ear(s), " +
                elephant[3] + " trunk(s), " + elephant[4] + " tail(s), and " + elephant[5] + " leg(s).");
        // this prints out the elephants body parts


    }
}
