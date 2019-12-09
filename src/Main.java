public class Main {
    public static void main(String[] args){
        Machine machine = new Machine();
        while (true) {
            try {
                machine.work();
            } catch (java.util.InputMismatchException exception) {
                Log.info("Wprowadzono niepoprawny znak, sprobuj ponownie.");
            }
        }
    }
}
