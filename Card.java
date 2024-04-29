import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card extends Actor
{
    private static final double SCALE = 0.6;
    private Rank rank;
    private Suit suit;
    private GreenfootImage backImage;
    private GreenfootImage faceImage;
    private boolean isFaceUp;
    
    /**
     * Constructor that initializes an instance of Card to the specified rank and suit.
     * 
     * @param rank Rank to set this instance of Card
     * @param suit Suit to set this instance of Card
     */
    public Card(Rank rank, Suit suit)
    {
        this(rank, suit, false);
    }
    
    /**
     * Constructor that initializes an instance of Card to the specified rank and suit.
     * if isFaceUp is true, then the card is shown face up with the rank and suit exposed.
     * 
     * @param rank Rank to set this instance of Card
     * @param suit Suit to set this instance of Card
     * @param isFaceUp a boolean value.  If true this card is shown face up; otherwise face down.
     */
    public Card(Rank rank, Suit suit, Boolean isFaceUp){
        this.isFaceUp = isFaceUp;
        this.rank = rank;
        this.suit = suit;
        backImage = new GreenfootImage("cardBack-abstract.png");
        String suitName = "Clubs/clubs";
        switch (suit){
            case DIAMOND:
                suitName = "Diamonds/diamonds";
                break;
            case SPADE:
                suitName = "Spades/spades";
                break;
            case HEART:
                suitName = "Hearts/hearts";
                break;
        }
        faceImage = new GreenfootImage(suitName+"_"+rank.getRank()+".png");
        if (isFaceUp){
            setImage(faceImage);
        } else {
            setImage(backImage);
        }
    }
    
    /**
     * Sets this card to face up and sets it's image to display the rank and suit.
     */
    public void show()
    {
        isFaceUp = true;
        setImage(faceImage);
    }

    /**
     * Sets this card to face down and sets it's image to display the back of the card.
     */
    public void hide()
    {
        isFaceUp = false;
        setImage(backImage);
    }

    /**
     * Returns if this card is face up or down.
     * 
     * @returns true if face up; otherwise false.
     */
    public boolean isFaceUp()
    {
        return isFaceUp;
    }

    /**
     * Returns the rank of this card.
     * 
     * @returns the rank of this card
     */
    public Rank getRank()
    {
        return rank;
    }

    /**
     * Returns the suit of this card.
     * 
     * @returns the suit of this card
     */
    public Suit getSuit(){
        return suit;
    }
    
    @Override
    public String toString(){
        if (isFaceUp){
            return ""+rank+suit;
        }
        return "??";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Card card = (Card) o;

        if (rank != card.rank) return false;
        return suit == card.suit;
    }

    /**
     * Act - do whatever the Card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mousePressed(this)){
            show();
        }
        // Add your action code here.
    }
}
