import junit.framework.TestCase;

public class TransferTest extends TestCase {
    Bank bank;
    String acc1;
    String acc2;
    String acc3;
    boolean isFraud;

    @Override
    protected void setUp() throws Exception {
        bank = new Bank();
        acc1 = "1111 1111 1111 1111";
        acc3 = "2222 2222 2222 2222";
        bank.addAccount(acc1, 10000);
        bank.addAccount(acc2, 200000);
        bank.addAccount(acc3, 0);
        isFraud = true;
    }

    public void testOneTransfer() {
        bank.transfer(acc1, acc3, 5000);
        long actual = bank.getBalance(acc1);
        long expected = 5000;
        long actual2 = bank.getBalance(acc3);
        assertEquals(expected, actual);
        assertEquals(expected, actual2);
    }

    public void testTwoTransfersTwoThreads() {
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                bank.transfer(acc1, acc3, 10000);
                long actual = bank.getBalance(acc1);
                long expected = 10000;
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                bank.transfer(acc3, acc1, 10000);
                long actual = bank.getBalance(acc3);
                long expected = 0;
            }
        }).start();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
