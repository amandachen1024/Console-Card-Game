//creates card objects to store information about them and returns information for other methods to use
public class Card
{
    private int number; // requirement 18
    private int suitValue;
    private static String[] suitOptions = {"diamonds", "clubs", "hearts", "spades"};
    private String suit;
    private String cardName; // requirement 1d


    //creates a card by picking # 2-14 for value, 0-4 for suit, and using that creates the name of the card to show user
    public Card() // requirement 19
    {
        number = (int) (Math.random() * 13) + 2; // requirement 9
        suitValue = (int) (Math.random() * 4);
        if (number == 14) // requirement 10*
        {
            cardName = "A" + " of " + suitOptions[suitValue];
        }
        else if (number < 11)
        {
            cardName = number + " of " + suitOptions[suitValue];
        }
        else if (number == 11)
        {
            cardName = "J" + " of " + suitOptions[suitValue];
        }
        else if (number == 12)
        {
            cardName = "Q" + " of " + suitOptions[suitValue];
        }
        else
        {
            cardName = "K" + " of " + suitOptions[suitValue];
        }
    }
    //accessor methods
    public int getNumber() // requirement 20
    {
        return number; // requirement 5
    }
    public int getSuit()
    {
        return suitValue;
    }
    public String getCardName()
    {
        return cardName;
    }

    public String toString()
    {
        return cardName;
    }
}