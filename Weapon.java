public class Weapon extends Item {
    private String model;
    private int damage;
    
    public Weapon(String name, int quantity, String model, int damage) {
        super(name, quantity);
        this.model = model;
        this.damage = damage;

    }
    
    public String getModel() {
        return model;
    }
    public int getDamage() {
        return damage;
    }
    @Override
    public String toString() {
        return "Weapon: " + getName() + ", Quantity: " + getQuantity() + 
               ", Model: " + getModel() + ", Damage: " + getDamage();
    }
}