class Food extends Product{
    private int weight;
    Food(String name, double price, int quantity, int weight){
        super(name, price, quantity);
        this.weight = weight;
    }
    int getSize(){
        return this.weight;
    }
}