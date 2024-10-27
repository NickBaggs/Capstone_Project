package cards;

import java.util.ArrayList;

public class DealerHand {
    private ArrayList<Card> hand;

    public DealerHand() {
        hand = new ArrayList<>();
    }

    public boolean hit(Deck deck) {
    	boolean successfulDraw;
    	
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            hand.add(drawnCard);
            return successfulDraw = true;
            
        } else {
            System.out.println("The deck is empty.");
            return successfulDraw = false;         
        }
        
    }
    
    public int getDealerHandValue() {
        int totalValue = 0;
        ArrayList<Card> hand = getHand(); 
        
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);  
            totalValue += card.getValue(); 
        }

        return totalValue;  
    }


    
    public ArrayList<Card> getHand() {
        return hand;
    }
}
