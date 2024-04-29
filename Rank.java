/**
 * Write a description of class Rank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum Rank  
{
    JOKER(0,"\u2605"), ACE(1,"A"), TWO(2,"2"), THREE(3,"3"),
    FOUR(4,"4"), FIVE(5,"5"), SIX(6,"6"), SEVEN(7,"7"),
    EIGHT(4,"8"), NINE(9,"9"),TEN(10,"10"), 
    JACK(11,"J"), QUEEN(12,"Q"), KING(13,"K");

    private int rank;
    private String rep;

    private Rank(int rank, String representation){
        this.rank = rank;
        rep = representation;
    }
    public int getRank(){
        return rank;
    }
    public String toString() {
        return rep;
    }
}
