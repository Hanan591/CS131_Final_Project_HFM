class Enemy extends Character {
    public Enemy(String name, int health) {
        super(name, health);
    }

    @Override
    public void action() {
        // Enemy-specific action logic
        System.out.println(name + " attacks you!");
    }
}