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
        int aceAmount = 0;
        ArrayList<Card> hand = getHand();  
        
        
        //Iterate through hand and get the values of the cards
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i); 
            totalValue += card.getValue();
            
            if(card.getRank().equals("Ace")) {
            ++aceAmount;	
            }
        }
        //Adjust value of hand based on presence of an ace
        while (totalValue<11 && aceAmount>0) {
        	totalValue = totalValue+10;
        	--aceAmount;
        }

        return totalValue; 
    }


    
    public ArrayList<Card> getHand() {
        return hand;
    }
}
