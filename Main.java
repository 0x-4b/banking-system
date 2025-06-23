

public class Main {
    public static void main(String[] args) {
        
        Inventory inventory = new Inventory();

        Fruit fruit = new Fruit("apples" , 30, "fiji");
        Item item = new Item("sword" , 3);
        Weapon weapon = new Weapon("Gun" , 2, "AK-47", 50);
        
        inventory.addItem(fruit);
        inventory.addItem(item);
        inventory.addItem(weapon);
        
        inventory.displayItems();
    }
}