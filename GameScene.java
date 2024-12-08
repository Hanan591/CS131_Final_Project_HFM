import java.util.Scanner;

public class GameScene {
    private Player player;
    private Enemy enemy;

    public GameScene(Player player) {
        this.player = player;
        this.enemy = new Enemy("Mafia Boss", 100);  // Example enemy
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        // Car Scene
        System.out.println("You are in a high-speed car chase!");
        System.out.println("1. Try to lose the tail.");
        System.out.println("2. Call for backup.");
        int carChoice = scanner.nextInt();

        if (carChoice == 1) {
            System.out.println("You successfully lost them but took some damage.");
            player.takeDamage(20);
        } else if (carChoice == 2) {
            System.out.println("Your mafia allies came to help!");
            player.addItem("Backup Signal", 1);
        } else {
            System.out.println("Invalid choice. You crashed!");
            player.takeDamage(50);
        }

        System.out.println("Health after Car Scene: " + player.getHealth());
        player.showInventory();

        // Hacking Scene
        System.out.println("You are hacking into the enemy's database.");
        System.out.println("1. Use brute force.");
        System.out.println("2. Look for vulnerabilities.");
        int hackingChoice = scanner.nextInt();

        if (hackingChoice == 1) {
            System.out.println("You successfully hacked in but triggered an alarm!");
            player.takeDamage(10);
        } else if (hackingChoice == 2) {
            System.out.println("You found a vulnerability and hacked in undetected!");
            player.addItem("Encrypted File", 1);
        } else {
            System.out.println("Invalid choice. The system locked you out!");
        }

        System.out.println("Health after Hacking Scene: " + player.getHealth());
        player.showInventory();

        // Rescue Scene
        System.out.println("You have reached the enemy hideout to rescue your girlfriend.");
        System.out.println("1. Sneak in silently.");
        System.out.println("2. Charge in with weapons blazing.");
        int rescueChoice = scanner.nextInt();

        if (rescueChoice == 1) {
            System.out.println("You successfully sneak in but encounter a locked door.");
            System.out.println("1. Use a Lockpick (if available).");
            System.out.println("2. Search for another entrance.");
            int subChoice = scanner.nextInt();

            if (subChoice == 1 && player.useItem("Lockpick")) {
                System.out.println("You pick the lock and continue silently!");
            } else if (subChoice == 2) {
                System.out.println("You find a vent and squeeze through, though it takes time.");
                player.takeDamage(10);
            } else {
                System.out.println("You struggle with the lock and alert the guards!");
                player.takeDamage(30);
            }
        } else if (rescueChoice == 2) {
            System.out.println("You charged in and fought fiercely, taking down enemies but losing health.");
            player.takeDamage(30);
        } else {
            System.out.println("Invalid choice. You got caught in the crossfire!");
            player.takeDamage(40);
        }

        if (player.getHealth() > 0) {
            System.out.println("You reach the final room. The boss confronts you.");
            System.out.println("1. Fight the boss.");
            System.out.println("2. Negotiate using evidence from hacking.");
            int bossChoice = scanner.nextInt();

            if (bossChoice == 1) {
                System.out.println("You defeat the boss after a tough fight!");
                player.takeDamage(20);
            } else if (bossChoice == 2 && player.useItem("Encrypted File")) {
                System.out.println("You reveal incriminating evidence and the boss surrenders!");
            } else {
                System.out.println("Your negotiation fails, and you are forced to fight!");
                player.takeDamage(40);
            }

            if (player.getHealth() > 0) {
                System.out.println("You rescue your girlfriend and escape!");
            } else {
                System.out.println("You die due to your injuries. Game over.");
            }
        } else {
            System.out.println("You couldn't make it to the final room. Game over.");
        }
    }
}