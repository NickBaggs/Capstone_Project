package cards;
import java.util.Scanner;

public class GameManager {
    private Deck deck;
    private PlayerHand playerHand;
    private DealerHand dealerHand;
    private int deckCount; // Number of decks to use

    // Constructor
    public GameManager(int deckCount) {
        this.deckCount = deckCount;
        deck = new Deck();
        deck.addDecks(deckCount); // Add the specified number of decks
        deck.shuffleDeck();

        // Initialize player and dealer hands with reference to the GameManager
        playerHand = new PlayerHand();
        dealerHand = new DealerHand();
    }

    
 // Method to start the game
    public void startGame() {
    	
        // Deal two cards to the player
        dealPlayerCard(playerHand);
        dealPlayerCard(playerHand);

        // Deal two cards to the dealer
        dealDealerCard(dealerHand);
        dealDealerCard(dealerHand);

        // Display hands (player's hand and one dealer card)
        System.out.println("Player's Hand: " + playerHand.getHand());
        System.out.println("Dealer's Hand: [Hidden], " + dealerHand.getHand().get(1));

        // Start player's turn
        playerTurn();

        // If player hasn't busted, start dealer's turn
        if (getPlayerHandValue() <= 21) {
            dealerTurn();
        }

        // Determine winner after both turns
        determineWinner();
    }

    // Method for player's turn (hit or stand)

    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);  // Create a scanner for user input
        boolean playerStands = false;

        while (!playerStands && getPlayerHandValue() < 21) {
            System.out.println("Your hand: " + playerHand.getHand());
            System.out.println("Would you like to (1) Hit or (2) Stand?");
            
            int choice = scanner.nextInt();  

            if (choice == 1) {
                dealPlayerCard(playerHand);  // Player hits
                if (getPlayerHandValue() > 21) {
                    System.out.println("Player busts! Hand value: " + getPlayerHandValue());
                    return;  // Player loses immediately if bust
                }
            } else if (choice == 2) {
                playerStands = true;  // Player chooses to stand
                System.out.println("Player stands with hand value: " + getPlayerHandValue());
            } else {
                System.out.println("Invalid choice. Please enter (1) Hit or (2) Stand.");
            }
        }
        
        scanner.close();  
    }


    // Method for dealer's turn (dealer hits until hand value is 17 or higher)
    private void dealerTurn() {
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
    private void determineWinner() {
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
            System.out.println("It's a tie with " + playerValue);
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
    
    
    
}
