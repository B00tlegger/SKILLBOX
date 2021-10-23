import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Loader {
    private static StringBuffer buffer;

    public static void main(String[] args) {
        String path = "res/numbers.txt";
        long start = System.currentTimeMillis();
        try {
            PrintWriter writer = new PrintWriter(path);
            buffer = new StringBuffer();
            Thread thread1 = new Thread(() ->
                    buffer.append(numWriter(1, 50)));
            Thread thread2 = new Thread(() ->
                    buffer.append(numWriter(500, 100)));
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            writer.write(buffer.toString());
            writer.flush();
            writer.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println((System.currentTimeMillis()-start)+" ms");
}

    private static String numWriter(int on, int off) {
        StringBuilder builder = null;
        for (int regionCode = 1; regionCode < 100; regionCode++) {
            char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
            builder = new StringBuilder();
            for (int number = on; number < off; number++) {
//            int regionCode = 199;
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append("\n");
                        }
                    }
                }
            }
        }
        return builder.toString();
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = String.valueOf(number);

        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr = "0" + numberStr;
        }
        return numberStr;
    }
}
