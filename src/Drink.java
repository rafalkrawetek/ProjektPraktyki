class Drink extends Product{
    private int capacity;
    Drink(String name, double price, int quantity, int capacity){
        super(name, price, quantity);
        this.capacity = capacity;
    }
    int getSize(){
        return this.capacity;
    }
}
