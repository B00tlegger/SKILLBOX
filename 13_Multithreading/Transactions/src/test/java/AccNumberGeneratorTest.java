import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;


@DisplayName("Проверка генерации номеров аккаунтов")
public class AccNumberGeneratorTest extends TestCase {
    Bank bank;
    long expected1;
    long actual1;
    long expected2;
    long actual2;

    @Override
    protected void setUp() {
        bank = new Bank();
        expected1 = 20000000;
        expected2 = 15;
        actual1 = 0;
        actual2 = 0;
    }


    public void testTwoTreadsTenObjects() {
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                String num = bank.accNumberGenerator();
                long money = (int) (10000000 * Math.random());
                System.out.println("счёт " + num + "\nсумма " + money);
                bank.addAccount(num, money);
            }
            actual1 += bank.getAccNumbers().size();
            assertEquals(expected1, actual1);
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                String num = bank.accNumberGenerator();
                long money = (int) (10000000 * Math.random());
                System.out.println("счёт " + num + "\nсумма " + money);
                bank.addAccount(num, money);
            }
            actual1 += bank.getAccNumbers().size();
            assertEquals(expected1, actual1);
        }).start();
    }

    public void testTwoTreadsFiveAndTenObjects() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String num = bank.accNumberGenerator();
                long money = (int) (10000000 * Math.random());
                System.out.println("счёт " + num + "\nсумма " + money);
                bank.addAccount(num, money);
            }
            actual2 +=bank.getAccNumbers().size();
            assertEquals(expected2, actual2);
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String num = bank.accNumberGenerator();
                long money = (int) (10000000 * Math.random());
                System.out.println("счёт " + num + "\nсумма " + money);
                bank.addAccount(num, money);
                actual2 += bank.getAccNumbers().size();
                assertEquals(expected2, actual2);
            }
        }).start();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}



