
import java.util.ArrayList;
import java.util.Arrays;
class Machine {
    private Wallet wallet;
    private double clientFunds;
    private ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Double> coins = new ArrayList<>(Arrays.asList(0.01,0.02,0.05,0.1,0.2,0.5,1.0,2.0,5.0));

    Machine(){
        this.wallet = new Wallet(100.0);
        this.clientFunds=0.0;
        this.products.add(new Drink("Coca-Cola", 4.99, 10, 250));
        this.products.add(new Drink("Pepsi", 3.99, 10, 330));
        this.products.add(new Drink("Woda", 1.36, 20, 500));
        this.products.add(new Food("M&Ms", 7.98, 10, 45));
        this.products.add(new Food("Snickers", 2.99, 10, 50));
        this.products.add(new Food("Bounty", 2.99, 10, 57));
        this.products.add(new Food("Mars", 3.49, 10, 51));
        this.products.add(new Food("Twix", 3.99, 10, 50));
        this.products.add(new Food("Lion", 4.99, 10, 42));
        this.products.add(new Food("Lays", 6.99, 5, 140));
        this.products.add(new Food("Paluszki", 2.69, 10, 150));
        this.products.add(new Food("Precelki", 2.69, 10, 130));
        this.products.add(new Food("Slonecznik", 2.49, 10, 200));
    }

    double getClientFunds() {
        return clientFunds;
    }

    void addClientFunds(double money){
        if(coins.contains(money)) this.clientFunds+=money;
        else Log.info("Automat przyjmuje tylko nominaly polskich monet wplacane pojedynczo.");
    }

    void returnClientFunds(){
        Log.info("Zwrocono "+clientFunds+" PLN.");
        clientFunds=0.0;
    }

    private void giveChange(double cost){
        clientFunds=Math.round((clientFunds-cost)*100.0)/100.0;
        int id=coins.size()-1;
        System.out.print("Wydano reszte: ");
        while(clientFunds>=0.01) {
            while(clientFunds>=coins.get(id)){
            System.out.printf("%.2fPLN, ",coins.get(id));
            clientFunds=Math.round((clientFunds-coins.get(id))*100.0)/100.0;
            }
            id--;
        }
        Log.info();
    }

    ArrayList<Product> getProducts() {
        return products;
    }

    private boolean checkIfCanBuy(Product product){
        return product.getQuantity() > 1 && clientFunds - product.getPrice() >= 0;
    }

    void work(){
        Menu menu = new Menu(this);
        menu.start();
    }

    void printProducts(){
        int number=1;
        for(Product product : products){
            if(product instanceof Drink) Log.info(number++ +". "+product.getName()+" "+product.getPrice()+"PLN Wielkosc: "+product.getSize()+"ml Dostepnosc: "+product.getQuantity()+" sztuk");
            else Log.info(number++ +". "+product.getName()+" "+product.getPrice()+"PLN Wielkosc: "+product.getSize()+"g Dostepnosc: "+product.getQuantity()+" sztuk");
        }
    }

    void buyProduct(int id){
        Product product = products.get(--id);
        if(checkIfCanBuy(product)){
            Log.info("Zakupiono "+product.getName()+". Wydawanie produktu...");
            wallet.addCash(product.getPrice());
            giveChange(product.getPrice());
            product.changeQuantity(-1);
        }
        else Log.info("Wplacono za malo srodkow lub wybrany produkt jest aktualnie niedostepny.");
    }
}
