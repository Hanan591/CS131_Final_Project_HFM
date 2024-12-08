import java.util.HashMap;
import java.util.Map;

class Player extends Character {
    private Map<String, Integer> inventory;

    public Player(String name) {
        
        super(name, 100);  // Player starts with 100 health
        this.inventory = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public boolean useItem(String item) {
        if (inventory.containsKey(item) && inventory.get(item) > 0) {
            inventory.put(item, inventory.get(item) - 1);
            if (inventory.get(item) == 0) inventory.remove(item);
            return true;
        }
        return false;
    }

    public void showInventory() {
        System.out.println("Inventory:");
        inventory.forEach((item, quantity) -> System.out.println("- " + item + " (x" + quantity + ")"));
    }

    @Override
    public void action() {
        // Player-specific action logic (e.g., attack, defend)
        System.out.println(name + " is ready to take action!");
    }
}