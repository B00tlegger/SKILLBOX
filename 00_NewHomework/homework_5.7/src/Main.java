public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator( 5, 54);
        arithmeticCalculator.calculate(Operation.SUBTRACT);
        System.out.println(ArithmeticCalculator.getC());

    }
}
