// creates the hand of cards stored in an array to be used by other methods
import java.util.Arrays;
import java.util.ArrayList;
public class Hand
{
    private Card[] hand = new Card[5];
    private static ArrayList<String> usedCards = new ArrayList<String>(); // keeps track of cards that have already been generated via their name

    //generates a hand of 5 unique and unused cards
    public Hand()
    {
        Card card1 = new Card();
       for (int i = 0; i < 5; i++) // requirement 17
       {
           //checks to see if card is already used and if it is, generates a new one
           while (usedCards.contains(card1.getCardName())) // requirement 24*
           {
               card1 = new Card();
           }
           //adds the newly generated card to the used cards and the hand
           usedCards.add(card1.getCardName());
           hand[i] = card1;
       }
    }

    //accessor methods
    public Card[] getHand()
    {
        return hand;
    }
    public static int getNumCardsUsed()
    {
        return usedCards.size();
    }

    //basically a toString method but I made it like this for some reasono
    public void printHand()
    {

        for (Card c: hand) // requirement 23* - a for each loop is technically a for loop right
        {
            System.out.print(c + ", ");
        }
        System.out.println();
    }
}