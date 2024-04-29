import greenfoot.*;
/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    public GifImage bro = new GifImage("Titles.gif");
    public void act()
    {
        setImage(bro.getCurrentImage());
        }
}
