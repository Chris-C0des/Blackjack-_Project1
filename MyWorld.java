import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public Random rnd;
    public StartButton start = new StartButton();
    public StartScreen load = new StartScreen();
    public Leprechuan lucky = new Leprechuan();
    GifImage yay = new GifImage("StartScreen.gif");
    public Title Clove = new Title();
    public Rainbow rain = new Rainbow();
    public BlackjackGame game = new BlackjackGame(3,2);
    public Background b = new Background();
    public BlackjackHand dealer;
    public BlackjackHand player = new BlackjackHand("player");
    private GameStatey statey = GameStatey.START;
    public HitButton hitter = new HitButton();
    public standButton stand = new standButton();
    private int landReader = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        super(1200,650,1,false);
        addObject(load,600,300);
        addObject(rain,600,430);
        addObject(start,600,500);
        addObject(lucky,930,560);
        addObject(Clove,600,190);
        setBackground("blackjackTable.gif");
        String sound = "./sounds/BackgroundMusic.mp3";
        Greenfoot.playSound(sound);

    }

    public void act(){
        if(statey == GameStatey.START){
            if(Greenfoot.mousePressed(start)){
                removeObject(load);
                removeObject(rain);
                removeObject(lucky);
                removeObject(start);
                removeObject(Clove);
                statey = GameStatey.PLAY;
                addObject(game,500,300);
                addObject(b,600,300);
                addObject(hitter,420,140);
                addObject(stand,770,140);
                game.newGame();

            }
        }

        if(statey == GameStatey.PLAY){
            if(this.numberOfObjects() < 4){
                game.gameDeck.shuffle();
                game.deal();
                addObject(game.player,590,530);
                addObject(game.dealer,590,170);
                

            }
            if (hitter.hits > 0){
                List<Card> c = getObjectsAt(610+landReader,520+landReader,Card.class);
                game.player.add(c.get(0));
                landReader += 15;
            }

            if(game.player.switchy == 1){
                List<Card> c = getObjectsAt(610+landReader,520+landReader,Card.class);

                removeObject(c.get(0));
                
                addObject(new Loser(),600,300);

                statey = GameStatey.END;

            }
            
            if(Greenfoot.mouseClicked(stand)){
                statey = GameStatey.DPLAY;
            }
        }

        if(statey == GameStatey.DPLAY){
            if(game.player.cards.size()==2 && game.dealer.getWeight()<17){   
                dealer.add(game.gameDeck.cards.get(rnd.nextInt(game.gameDeck.cards.size()-1)));

            }
            else if(game.dealer.getWeight()>=17){
                statey = GameStatey.CHECK;
            }
        
        
        
        }
        
        if(statey == GameStatey.CHECK){
            
            if(game.dealer.getWeight()>game.player.getWeight()){
                addObject(new Loser(),600,300);
            
            } else if(game.dealer.getWeight()<game.player.getWeight()){
                addObject(new Winner(),600,300);
                
            }
        
        }

        if(statey == GameStatey.END){
            removeObject(game);
            removeObject(b);
            removeObject(hitter);
            removeObject(game.player);
            removeObject(game.dealer);
            statey = GameStatey.START;

        }

    }
}

