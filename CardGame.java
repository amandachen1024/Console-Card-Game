import java.util.Scanner;
//runs the game, taking user input and acting accordingly
public class CardGame
{
    // runs methods from different classes and prints info for the game, updates player's score accordingly
    public static void playerTurn() // requirement 3
    {
        Hand hand2 = new Hand();
        System.out.println("Your hand is:");
        hand2.printHand();
        HandChecker.checkHand(hand2);
        System.out.println("Your best poker hand is: " + HandChecker.getName()); // requirement 6
        System.out.println("That is worth " + HandChecker.getPoints() + " point(s)");
        playerScore += HandChecker.getPoints();
        System.out.println("You now have " + playerScore + " point(s) in total");
        System.out.println();
    }
    //same as playerTurn() but for computer
    public static void computerTurn()
    {
        Hand hand1 = new Hand();
        System.out.println("The computer's hand is:");
        hand1.printHand();
        HandChecker.checkHand(hand1);
        System.out.println("The computer's best poker hand is: " + HandChecker.getName());
        System.out.println("That is worth " + HandChecker.getPoints() + " point(s)");
        computerScore += HandChecker.getPoints();
        System.out.println("The computer now has " + computerScore + " point(s) in total");
        System.out.println();
    }

    static int playerScore = 0; // requirement 1a
    static int computerScore = 0;

    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        String answer = "yes"; // requirement 1b
        System.out.println("In this game you and the computer will each be dealt 5 cards from a deck. You will each be assigned a number of points based on the best pokerhand (out of pair, 3 of a kind, 4 of a kind, full house, and flush) that can be created using your cards. After each round, you can either stop playing or keep going (unless there are not enough cards left in the deck).");
        System.out.println("Let's play!");

        //while loop to keep the game going as long as user wants to play and there are enough cards left
        while (answer.toLowerCase().equals("yes") && (52 - Hand.getNumCardsUsed()) >= 10) // requirement 7, 16
        {
            playerTurn();
            computerTurn();

            System.out.print("Would you like to keep going (type yes to keep playing, anything else to stop)? ");
            answer = input.next();
        }
        if (answer.toLowerCase().equals("yes") && (52 - Hand.getNumCardsUsed()) < 10)
        {
            System.out.println("Sorry not enough cards left.");
        }
        if (playerScore > computerScore)
        {
            System.out.println("You win!");
        }
        else if (playerScore == computerScore)
        {
            System.out.println("It's a tie.");
        }
        else
        {
            System.out.println("You lose :(");
        }

    }
}