import java.util.Scanner;
class Menu {
    private Machine machine;
    private Scanner scan = new Scanner(System.in);

    Menu(Machine machine) {
        this.machine=machine;
    }
    void start() {
     Log.info();
     Log.info("Witaj kliencie! Aktualnie wplaciles: "+machine.getClientFunds()+" PLN.");
     Log.info("Wybierz opcje sposrod dostepnych ponizej:");
     Log.info("1. Wplac srodki.");
     Log.info("2. Zakup produkt.");
     Log.info("3. Anuluj transakcje (wyplac srodki).");
     switch(scan.nextInt()){
         case 1:
             Log.info("Podaj ilosc wplacanych srodkow: ");
             machine.addClientFunds(scan.nextDouble());
             start();
             break;
         case 2:
             Log.info(String.valueOf(machine.getProducts().size()));
             Log.info("Wybierz produkt z ponizszej listy wpisujac jego numer. Podanie innego numeru skutkuje powrotem do poprzedniego menu.");
             machine.printProducts();
             int choice = scan.nextInt();
             if(choice>0&&choice<=machine.getProducts().size()) machine.buyProduct(choice);
             else Log.info("Nie ma produktu o wprowadzonym numerze. Powrot do poprzedniego menu.");
             start();
             break;
         case 3:
             machine.returnClientFunds();
             start();
             break;
         default:
             Log.info("Wprowadzono bledna opcje. Sprobuj ponownie.");
             start();
     }
    }

}
