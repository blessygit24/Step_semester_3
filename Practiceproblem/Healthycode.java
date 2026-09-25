package Practiceproblem;

class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Start at full health
    }

    // Damage the character
    public void takeDamage(int amount) {
        health -= amount;

        // Clamp to 0
        if (health < 0) {
            health = 0;
        }
    }

    // Heal the character
    public void heal(int amount) {
        health += amount;

        // Clamp to maxHealth
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    // Read-only access to current health
    public int getHealth() {
        return health;
    }

    // Optional: read-only access to max health
    public int getMaxHealth() {
        return maxHealth;
    }
}

public class Healthycode {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("Health: " + c.getHealth()); // 70

        c.heal(50);
        System.out.println("Health: " + c.getHealth()); // 100

        c.takeDamage(150);
        System.out.println("Health: " + c.getHealth()); // 0
    }
}
