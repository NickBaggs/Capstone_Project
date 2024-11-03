package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    int deckCount;
    
    public Deck() {
        cards = new ArrayList<>();
    }
    
    
    //Runs the addSingleDeck method the amount of times of the received int
    public void addDecks(int deckCount) {
        for (int i = 0; i < deckCount; i++) {
            addSingleDeck();
        }
    }

    //Adds one full deck of cards to the deck
    private void addSingleDeck() {
        cards.add(new Card("Hearts", "2", 2, 1));
        cards.add(new Card("Hearts", "3", 3, 2));
        cards.add(new Card("Hearts", "4", 4, 3));
        cards.add(new Card("Hearts", "5", 5, 4));
        cards.add(new Card("Hearts", "6", 6, 5));
        cards.add(new Card("Hearts", "7", 7, 6));
        cards.add(new Card("Hearts", "8", 8, 7));
        cards.add(new Card("Hearts", "9", 9, 8));
        cards.add(new Card("Hearts", "10", 10, 9));
        cards.add(new Card("Hearts", "Jack", 10, 10));
        cards.add(new Card("Hearts", "Queen", 10, 11));
        cards.add(new Card("Hearts", "King", 10, 12));
        cards.add(new Card("Hearts", "Ace", 1, 13));

        cards.add(new Card("Diamonds", "2", 2, 14));
        cards.add(new Card("Diamonds", "3", 3, 15));
        cards.add(new Card("Diamonds", "4", 4, 16));
        cards.add(new Card("Diamonds", "5", 5, 17));
        cards.add(new Card("Diamonds", "6", 6, 18));
        cards.add(new Card("Diamonds", "7", 7, 19));
        cards.add(new Card("Diamonds", "8", 8, 20));
        cards.add(new Card("Diamonds", "9", 9, 21));
        cards.add(new Card("Diamonds", "10", 10, 22));
        cards.add(new Card("Diamonds", "Jack", 10, 23));
        cards.add(new Card("Diamonds", "Queen", 10, 24));
        cards.add(new Card("Diamonds", "King", 10, 25));
        cards.add(new Card("Diamonds", "Ace", 1, 26));

        cards.add(new Card("Clubs", "2", 2, 27));
        cards.add(new Card("Clubs", "3", 3, 28));
        cards.add(new Card("Clubs", "4", 4, 29));
        cards.add(new Card("Clubs", "5", 5, 30));
        cards.add(new Card("Clubs", "6", 6, 31));
        cards.add(new Card("Clubs", "7", 7, 32));
        cards.add(new Card("Clubs", "8", 8, 33));
        cards.add(new Card("Clubs", "9", 9, 34));
        cards.add(new Card("Clubs", "10", 10, 35));
        cards.add(new Card("Clubs", "Jack", 10, 36));
        cards.add(new Card("Clubs", "Queen", 10, 37));
        cards.add(new Card("Clubs", "King", 10, 38));
        cards.add(new Card("Clubs", "Ace", 1, 39));

        cards.add(new Card("Spades", "2", 2, 40));
        cards.add(new Card("Spades", "3", 3, 41));
        cards.add(new Card("Spades", "4", 4, 42));
        cards.add(new Card("Spades", "5", 5, 43));
        cards.add(new Card("Spades", "6", 6, 44));
        cards.add(new Card("Spades", "7", 7, 45));
        cards.add(new Card("Spades", "8", 8, 46));
        cards.add(new Card("Spades", "9", 9, 47));
        cards.add(new Card("Spades", "10", 10, 48));
        cards.add(new Card("Spades", "Jack", 10, 49));
        cards.add(new Card("Spades", "Queen", 10, 50));
        cards.add(new Card("Spades", "King", 10, 51));
        cards.add(new Card("Spades", "Ace", 1, 52));
    }


    // Method to get all cards
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public Card draw() {
        if (!cards.isEmpty()) {
            return cards.remove(0);  // Removes and returns the card on top of the deck
        } else {
            return null;  // returns null if the deck is empty
        }
    }
    
    //Clear the Deck.
    public void clearDeck() {
        cards.clear();
    }
    
    //Shuffle the deck
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
    
    public void reShuffleDeck() {
    	addDecks(deckCount);
    	shuffleDeck();
    }

    
    
}
