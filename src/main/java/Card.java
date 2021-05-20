package main.java;

public class Card {

    public Card() {
    }

    public enum Suit{
    SPADES, HEARTS, DIAMONDS, CLUBS
}
    public enum Number{
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    public enum Color{
        RED, BLACK
    }

    private Suit suit;
    private Color color;
    private Number number;

    public Card(Suit s, Number num){
        suit = s;
        number = num;
        switch(s){
            case CLUBS:
                color = Color.BLACK;
                break;
            case SPADES:
                color = Color.BLACK;
                break;
            case HEARTS:
                color = Color.RED;
                break;
            case DIAMONDS:
                color = Color.RED;
                break;
        }
    }

    public Color getColor(){
        return color;
    }

    public Suit getSuit(){
        return suit;
    }

    public Number getNumber(){
        return number;
    }

    public String toString(){
        return number + " of " + suit + " (" + color + ")";
    }
}
