import greenfoot.*;
/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class StartButton
     */
    public StartButton()
    {
        setImage("Smarty.png");
    }
    
    public void act()
    {
        if(Greenfoot.mousePressed(this)){
            removeTouching(null);
        }
    }

  
}
