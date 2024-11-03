package cards;
import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private Deck deck;
    private PlayerHand playerHand;
    private DealerHand dealerHand;
    private int deckCount; 

    // Constructor
    public GameManager(int deckCount) {
        this.deckCount = deckCount;
        deck = new Deck();
        deck.addDecks(deckCount); 
        deck.shuffleDeck();

        // Initialize player and dealer hands objects
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
    }

    

    public void startGame() {
    	
        // Deal two cards to the player and dealer
        dealPlayerCard(playerHand);
        dealPlayerCard(playerHand);

        
        dealDealerCard(dealerHand);
        dealDealerCard(dealerHand);

        // Display hands 
        System.out.println("Player's Hand: " + playerHand.getHand() + " " + playerHand.getPlayerHandValue());
        System.out.println("Dealer's Hand: [Hidden], " + dealerHand.getHand().get(1));

      
        playerTurn();

      
        if (getPlayerHandValue() <= 21) {
            dealerTurn();
        }

        
        determineWinner();
    }

  

    public void playerTurn() {
        Scanner scanner = new Scanner(System.in);  
        boolean playerStands = false;

        while (!playerStands && getPlayerHandValue() < 21) {
            System.out.println("Your hand: " + playerHand.getHand() + " " + playerHand.getPlayerHandValue());
            System.out.println("Would you like to (1) Hit or (2) Stand?");
            
            int choice = scanner.nextInt();  

            if (choice == 1) {
                dealPlayerCard(playerHand);  
                if (getPlayerHandValue() > 21) {
                    System.out.println("Player busts! Hand value: " + getPlayerHandValue());
                    return;  
                }
            } else if (choice == 2) {
                playerStands = true;  
                System.out.println("Player stands with hand value: " + getPlayerHandValue());
            } else {
                System.out.println("Invalid choice. Please enter (1) Hit or (2) Stand.");
            }
        }
        
        scanner.close();  
    }


    // Method for dealer's turn (dealer hits until hand value is 17 or higher)
    public void dealerTurn() {
        System.out.println("Dealer's turn.");
        System.out.println("Dealer's hand: " + dealerHand.getHand());

        while (getDealerHandValue() < 17) {
            System.out.println("Dealer hits.");
            dealDealerCard(dealerHand);
            System.out.println("Dealer's hand: " + dealerHand.getHand());
        }

        if (getDealerHandValue() > 21) {
            System.out.println("Dealer busts! Hand value: " + getDealerHandValue());
        } else {
            System.out.println("Dealer stands with hand value: " + getDealerHandValue());
        }
    }

    // Method to determine the winner
    public void determineWinner() {
        int playerValue = getPlayerHandValue();
        int dealerValue = getDealerHandValue();

        if (playerValue > 21) {
            System.out.println("Player busted. Dealer wins.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busted. Player wins.");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins with " + playerValue + " against Dealer's " + dealerValue);
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins with " + dealerValue + " against Player's " + playerValue);
        } else {
            System.out.println("It's a push " + playerValue);
        }
    }

    
    public void reshuffleDeck() {
        deck.reShuffleDeck(); // Calls the method in Deck to reshuffle
        
    }
    
    public void dealPlayerCard(PlayerHand playerHand) {
    	if(playerHand.hit(deck)== false) {
    		reshuffleDeck();
    		playerHand.hit(deck);
    	}
    }
    public void dealDealerCard(DealerHand dealerHand) {
    	if(dealerHand.hit(deck)== false) {
    		reshuffleDeck();
    		dealerHand.hit(deck);
    	}
    }
    
 
    public int getPlayerHandValue() {
        return playerHand.getPlayerHandValue();
    }

    
    public int getDealerHandValue() {
        return dealerHand.getDealerHandValue();
    }
    
    public ArrayList<Card> getPlayerHand() {
    	return playerHand.getHand();
    	
    }
    
    public ArrayList<Card> getDealerHand() {
    	return dealerHand.getHand();
    	
    }
    
    
    
}
