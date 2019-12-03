import java.util.ArrayList;
public class Machine {
    private Wallet wallet;
    private double clientFunds;
    private ArrayList<Product> products = new ArrayList<>();

    public Machine(){
        this.wallet = new Wallet(100.0);
        this.clientFunds=0.0;
        this.products.add(new Product("Coca-Cola", 4.99, 10));
        this.products.add(new Product("Pepsi", 3.99, 10));
        this.products.add(new Product("Woda", 1.36, 20));
        this.products.add(new Product("M&Ms", 7.98, 10));
        this.products.add(new Product("Snickers", 2.99, 10));
        this.products.add(new Product("Bounty", 2.99, 10));
        this.products.add(new Product("Mars", 3.49, 10));
        this.products.add(new Product("Twix", 3.99, 10));
        this.products.add(new Product("Lion", 4.99, 10));
        this.products.add(new Product("Lays", 6.99, 5));
        this.products.add(new Product("Paluszki", 2.69, 10));
        this.products.add(new Product("Precelki", 2.69, 10));
        this.products.add(new Product("Slonecznik", 2.49, 10));
    }

    double getClientFunds() {
        return clientFunds;
    }

    void addCLientFunds(double money){
        this.clientFunds+=money;
    }

    void returnClientFunds(){
        Log.info("Zwrocono "+clientFunds+" PLN.");
        clientFunds=0.0;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean checkIfCanBuy(Product product){
        if(product.getQuantity()>1&&clientFunds-product.getPrice()>=0) return true;
        else return false;
    }

    void work(){
        Menu menu = new Menu(this);
        menu.start();
    }

}
