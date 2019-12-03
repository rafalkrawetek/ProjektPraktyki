import java.util.Scanner;
public class Menu {
    private Machine machine;
    private Scanner scan = new Scanner(System.in);

    public Menu(Machine machine) {
        this.machine=machine;
    }
    void start(){
     Log.info("Witaj kliencie! Aktualnie wplaciles: "+machine.getClientFunds()+" PLN.");
     Log.info("Wybierz opcje sposrod dostepnych ponizej:");
     Log.info("1. Wplac srodki.");
     Log.info("2. Zakup produkt.");
     Log.info("3. Anuluj transakcje (wyplac srodki).");
     switch(scan.nextInt()){
         case 1:
             Log.info("Podaj ilosc wplacanych srodkow: ");
             machine.addCLientFunds(scan.nextInt());
             start();
         case 2:
             //to do
             start();
         case 3:
             machine.returnClientFunds();
             start();
         default:
             Log.info("Wprowadzono bledna opcje. Sprobuj ponownie.");
             start();
     }
    }

}
