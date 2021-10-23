public class ArithmeticCalculator {
    private int a;
    private int b;
    private static int c;

    public ArithmeticCalculator(int a , int b){
        this.a = a;
        this.b = b;
    }

    public int calculate(Operation operation){
        if (operation.equals(Operation.ADD)){
            c = a + b;
        }
        if (operation.equals(Operation.SUBTRACT)){
            c = a - b;
        }
        if (operation.equals(Operation.MULTIPLY)){
            c = a * b;
        }
        return c;
    }
    public static int getC(){
        return c;
    }
}
