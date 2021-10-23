import java.util.Scanner;

public class Main {

    private static final int MAX_CONTEINERS = 12;
    private static final int MAX_BOXES = 27;
    public static int trucksQuantity;
    public static int boxesQuantity;
    public static int conteinersQuantity;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        boxesQuantity = Integer.parseInt(boxes);
        if(boxesQuantity % MAX_BOXES == 0 ) {
            conteinersQuantity = Math.round(boxesQuantity / MAX_BOXES);
        } else {
            conteinersQuantity = Math.round(boxesQuantity / MAX_BOXES) + 1;
        }
        if(conteinersQuantity % MAX_CONTEINERS == 0) {
            trucksQuantity = Math.round(conteinersQuantity / MAX_CONTEINERS);
        } else {
            trucksQuantity = Math.round(conteinersQuantity / MAX_CONTEINERS) + 1;
        }

        for (int truckNomber = 1; truckNomber <= trucksQuantity; truckNomber++) {
            System.out.println("Грузовик: " + truckNomber);
            for (int conteinerNomber = 1; conteinerNomber <= conteinersQuantity; conteinerNomber++) {
                if (conteinerNomber > truckNomber * MAX_CONTEINERS - MAX_CONTEINERS && conteinerNomber <= truckNomber * MAX_CONTEINERS) {
                    System.out.println("\tКонтейнер: " + conteinerNomber);
                    for (int boxesNomber = 1; boxesNomber <= boxesQuantity; boxesNomber++) {
                        if (boxesNomber > conteinerNomber * MAX_BOXES - MAX_BOXES && boxesNomber <= conteinerNomber * MAX_BOXES) {
                            System.out.println("\t\tЯщик: " + boxesNomber);
                        }
                    }
                }
            }
        }
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + trucksQuantity + " шт.");
        System.out.println("контейнеров - " + conteinersQuantity + " шт.");


            // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
            // пример вывода при вводе 2
            // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }
}
