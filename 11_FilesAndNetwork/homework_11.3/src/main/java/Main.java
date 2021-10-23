
public class Main {
    public static void main(String[] args) {
        Movements movements = new Movements("data/movementList.csv");
        System.out.println();
        System.out.println("Всего потрачено: " + movements.getExpenseSum());
        System.out.println("Всего получено: " + movements.getIncomeSum());
        System.out.println();
        movements.getReport();
    }

}
