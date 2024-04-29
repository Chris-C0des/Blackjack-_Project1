import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class BlackJackGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackjackGame extends CardGame
{
    private BlackjackHand[] hands;
    public BlackjackHand dealer;
    public BlackjackHand player = new BlackjackHand("player");
    int numberOfHands;
    
    public BlackjackGame(int numberOfDecks, int maxNumberOfHands)
    {
        super(numberOfDecks);    
        hands = new BlackjackHand[maxNumberOfHands];
        dealer = new BlackjackHand("Dealer");
        numberOfHands = 0;
    }
    
    public void join(String name)
    {
        if (numberOfHands < hands.length){
            hands[numberOfHands] = new BlackjackHand(name);
            numberOfHands++;
        }
    }
    
    public void leave(String name)
    {
        boolean isFound = true;
        for(int index=0; index < numberOfHands; index++){
            if (!isFound){
                if (hands[index].getName().equals(name)){
                    isFound = true;
                } 
            } else {
                hands[index-1] = hands[index];
            }
        }
        if (isFound) {
            numberOfHands--;
            hands[numberOfHands] = null;
        }
    }
    
    public void deal(){
       Random rand = new Random();
       player.add(gameDeck.cards.get(rand.nextInt(gameDeck.cards.size()-1)));
       player.cards.get(0).show();
       gameDeck.shuffle();
       player.add(gameDeck.cards.get(rand.nextInt(gameDeck.cards.size()-1)));
       player.cards.get(1).show();
       gameDeck.shuffle();
       dealer.add(gameDeck.cards.get(rand.nextInt(gameDeck.cards.size()-1)));
       gameDeck.shuffle();
       dealer.add(gameDeck.cards.get(rand.nextInt(gameDeck.cards.size()-1)));
       dealer.cards.get(0).show();
    

    }
    
    /**
     * Act - do whatever the BlackJackGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
