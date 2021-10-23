import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
        Collections.reverse(Arrays.asList(strings));
        return strings;
    }
}
