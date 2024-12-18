package cards;

import java.util.ArrayList;

public class PlayerHand {
    private ArrayList<Card> hand;

    public PlayerHand() {
        hand = new ArrayList<>();
    }

    public boolean hit(Deck deck) {
    	
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            hand.add(drawnCard);
            return true;
            
        } else {
            System.out.println("The deck is empty.");
            return false;         
        }
        
    }
    
    public int getPlayerHandValue() {
        int totalValue = 0;
        int aceAmount = 0;
        ArrayList<Card> hand = getHand();  
        
        
        
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i); 
            totalValue += card.getValue();
            
            if(card.getRank().equals("Ace")) {
            ++aceAmount;	
            }
        }
        
        while (totalValue<11 && aceAmount>0) {
        	totalValue = totalValue+10;
        	--aceAmount;
        }

        return totalValue; 
    }

    public void clearHand() {
        hand.clear();  
    }

    

    
    public ArrayList<Card> getHand() {
        return hand;
    }
}
