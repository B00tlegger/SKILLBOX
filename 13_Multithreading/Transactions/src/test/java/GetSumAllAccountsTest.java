import junit.framework.TestCase;

public class GetSumAllAccountsTest extends TestCase {
    Bank bank;
    long expected;

    @Override
    protected void setUp() throws Exception {
        bank = new Bank();
        expected = 1300000;
        bank.addAccount("1111 1111 1111 1111", 10000);
        bank.addAccount("2222 2222 2222 2222", 1000000);
        bank.addAccount("3333 3333 3333 3333", 290000);
    }

    public void testWithoutTransfers() {
        long actual = bank.getSumAllAccounts();
        assertEquals(expected, actual);

    }

    public void testWithTransfersOneThread() {
        bank.transfer("1111 1111 1111 1111", "2222 2222 2222 2222", 10000);
        long actual = bank.getSumAllAccounts();
        assertEquals(expected, actual);

    }

    public void testWithTransferManyThreads() {
        new Thread(() -> {
            for (int i = 2; i < 4; i++) {
                String acc = "" + i + i + i + i + " " + i + i + i + i + " " + i + i + i + i + " " + i + i + i + i;
                bank.transfer("1111 1111 1111 1111", acc, 3000);
            }
            long actual = bank.getSumAllAccounts();
                assertEquals(expected, actual);
        }).start();
        new Thread(() -> {
            bank.transfer("2222 2222 2222 2222", "1111 1111 1111 1111", 100000);
            bank.transfer("2222 2222 2222 2222", "3333 3333 3333 3333", -10000);
            long actual = bank.getSumAllAccounts();
            assertEquals(expected, actual);
        }).start();
        new Thread(() -> {
            for (int i = 1; i < 3; i++) {
                String acc = "" + i + i + i + i + " " + i + i + i + i + " " + i + i + i + i + " " + i + i + i + i;
                bank.transfer("3333 3333 3333 3333", acc, 3000);
            }
            long actual = bank.getSumAllAccounts();
            assertEquals(expected, actual);
        }).start();

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
