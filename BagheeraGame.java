import java.util.Scanner;

/**
 * The BagheeraGame class represents the main class for starting the game.
 * It prompts the user to enter their player name and starts the game by creating a player and a game scene.
 * 
 * Author: Hanan Mohamed
 */
public class BagheeraGame {

    /**
     * The main method is the entry point of the game.
     * It initializes the player, displays the welcome message, and starts the game scene.
     *
     * @param args Command-line arguments (not used in this game).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get player's name
        System.out.print("Enter your player's name: ");
        String playerName = scanner.nextLine();

        // Create player and start the game
        Player player = new Player(playerName);  // This creates the player with the name
        System.out.println("Welcome to Bagheera!");
        System.out.println("Player Name: " + player.getName());
        System.out.println("Health: " + player.getHealth());

        GameScene gameScene = new GameScene(player);  // Create the game scene with the player
        gameScene.start();  // Start the game
    }
}