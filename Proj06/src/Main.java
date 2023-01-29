public class Main {
    public static void main(String[] args) {
        FractalCalc fractalEngine = new FractalCalc();
        new FractalDisplay(fractalEngine);
        new FractalGui(fractalEngine);
    }
}
