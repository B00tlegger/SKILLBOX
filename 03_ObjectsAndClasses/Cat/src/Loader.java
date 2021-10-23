
public class Loader
{
    private static Cat getKitten(){
        System.out.println("Поздравляю! Ваша кошка родила котёнка! ");
        return new Cat(1100);
    }
    public static void main(String[] args) {
        Cat shurik = new Cat("Шурик");
        System.out.println(shurik.getName() + " весит " + shurik.getWeight());
        while (true){
            shurik.meow();
            if (shurik.getWeight() < 1000){
                System.out.println("Шурик " + shurik.getStatus());
                break;
            }
        }

        System.out.println();

        Cat marusia = new Cat("Маруся");
        marusia.setColor("Black");
        System.out.println("Цвет " + marusia.getColor());
        System.out.println(marusia.getName() + " весит " + marusia.getWeight());
        System.out.println(marusia.getName() + " " + marusia.getStatus());
        marusia.feed(150.0);
        marusia.feed(100.0);
        System.out.println("После еды " + marusia.getName() + " весит " + marusia.getWeight());
        marusia.pee();
        System.out.println(marusia.getName() + " всего съела: " + marusia.getAllFeedWaight() + " гр.");


        System.out.println();

        Cat vasia = new Cat("Вася");
        System.out.println(vasia.getName() + " весит " + vasia.getWeight());
        vasia.feed(vasia.getWeight());
        System.out.println("После еды " + vasia.getName() + " весит " + vasia.getWeight());

        System.out.println();

        Cat murka = new Cat("Мурка");
        murka.setColor("Smoky");
        System.out.println(murka.getName() + " весит " + murka.getWeight());
        murka.feed(murka.getWeight() / 50);
        System.out.println("После еды " + murka.getName() + " весит " + murka.getWeight());
        System.out.println(murka.isCatAlive());

        System.out.println();

        Cat tiphon = new Cat("Тифон");
        System.out.println(tiphon.getName() + " весит " + tiphon.getWeight());
        while (true){
            if (tiphon.getWeight() > 9000){
                System.out.println("Тифон " + tiphon.getStatus());
                break;
            }
            tiphon.feed(150.0);
        }
        tiphon.pee();
        System.out.println(tiphon.isCatAlive());

        System.out.println();

        Cat tosha = getKitten();
        System.out.println("Вес котёнка: " + tosha.getWeight());
        Cat boria = getKitten();
        System.out.println("Вес котёнка: " + boria.getWeight());
        Cat zibulon = getKitten();
        System.out.println("Вес котёнка: " + zibulon.getWeight());

        System.out.println();

        Cat gerald = new Cat("Геральд" , 3400 , "SCOTLAND_BROWN");
        System.out.println(gerald.getName());
        System.out.println(gerald.getWeight());
        System.out.println(gerald.getColor());

        Cat copyGerald = new Cat(gerald);
        System.out.println(copyGerald.getName());
        System.out.println(copyGerald.getWeight());
        System.out.println(copyGerald.getColor());

        System.out.println();

        System.out.println("Всего кошек: " + Cat.getCount());
    }
}