import java.util.Arrays;
//checks what the best possible poker hand (of the options) is and returns the name of the hand and how much it is worth
public class HandChecker
{
    private static String handName; // requirement 22
    private static int handWorth;

    //selection sort methods to sort the hand by numerical value (ie. 2, 3, 4...A)
    public static void sort(Hand h) // requirement 21, 25*
    {
        Card[] hand = h.getHand();
        int n = hand.length;
        for (int i = 0; i < n-1; i++)
        {
            int minIndex = i;
            for (int j = i+1; j < n; j++)
            {
                if (hand[j].getNumber() < hand[minIndex].getNumber())
                {
                    minIndex = j;
                }
            }
            Card temp = hand[minIndex];
            hand[minIndex] = hand[i];
            hand[i] = temp;
        }
    }


    // the following methods return boolean values for if a given array of cards is a poker hand (specified in method headers)
    public static boolean isFourOfAKind(Hand h) // requirement 4*
    {
        Card[] hand = h.getHand();
        return (hand[0].getNumber() == hand[3].getNumber() || hand[1].getNumber() == hand[4].getNumber()); // requirement 13
    }
    public static boolean isFullHouse(Hand h)
    {
        Card[] hand = h.getHand();
        return ((hand[0].getNumber() == hand[2].getNumber() && hand[3].getNumber() == hand[4].getNumber()) || (hand[2].getNumber() == hand[4].getNumber() && hand[0].getNumber() == hand[1].getNumber()));
    }
    public static boolean isThreeOfAKind(Hand h)
    {
        Card[] hand = h.getHand();
        return (hand[0].getNumber() == hand[2].getNumber() || hand[1].getNumber() == hand[3].getNumber() || hand[2].getNumber() == hand[4].getNumber());
    }
    public static boolean isPair(Hand h)
    {
        Card[] hand = h.getHand();
        return (hand[0].getNumber() == hand[1].getNumber() || hand[1].getNumber() == hand[2].getNumber() || hand[2].getNumber() == hand[3].getNumber() || hand[3].getNumber() == hand[4].getNumber());
    }
    public static boolean isFlush(Hand h)
    {
        Card[] hand = h.getHand();
        return (hand[0].getSuit() == hand[1].getSuit() && hand[0].getSuit() == hand[2].getSuit() && hand[0].getSuit() == hand[3].getSuit() && hand[0].getSuit() == hand[4].getSuit());
    }

    // runs the check methods to assign name and worth to hand
    public static void checkHand(Hand hand)
    {
        sort(hand);
        if (isFourOfAKind(hand))
        {
            handName = "four of a kind";
            handWorth = 10;
        }
        else if (isFullHouse(hand))
        {
            handName = "full house";
            handWorth = 7;
        }
        else if (isThreeOfAKind(hand))
        {
            handName = "three of a kind";
            handWorth = 3;
        }
        else if (isPair(hand))
        {
            handName = "pair";
            handWorth = 1;
        }
        else if (isFlush(hand))
        {
            handName = "flush";
            handWorth = 5;
        }
        else
        {
            handName = "none";
            handWorth = 0;
        }
    }

    //accessor methods
    public static String getName()
    {
        return handName;
    }
    public static int getPoints()
    {
        return handWorth;
    }

}