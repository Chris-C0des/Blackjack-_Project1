import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IslandForrest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends Actor
{
    public GifImage yay = new GifImage("StartScreen.gif");
    public void act()
    {
        setImage(yay.getCurrentImage());
        }
    }

