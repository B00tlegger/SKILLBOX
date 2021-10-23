import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
        String input = scanner.nextLine();
        searchAndReplaceDiamonds(input , "***");
        }
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        int diamondCount = 0;
        int reversDiamondCount = 0;
        char diamond = '<';
        char reversDiamond = '>';

        int diamondIndex = text.indexOf(diamond);
        int reverseDiamondIndex = text.indexOf(reversDiamond);


        for (int i = 0; i < text.length(); i++) {
            char charText = text.charAt(i);
            if (charText == diamond) {
                diamondCount++;
            }
            if (charText == reversDiamond) {
                reversDiamondCount++;
            }
        }
        
        if (reverseDiamondIndex == text.length() - 1 && diamondCount == 1 && reversDiamondCount == 1) {
            placeholder = "+++";
            String substring = text.substring(0, text.indexOf(diamond));
            String closeString = text.substring(diamondIndex, reverseDiamondIndex + 1);
            closeString = closeString.replace(closeString, placeholder);
            text = substring + closeString;
            System.out.println(text);
        }else if (diamondCount == 1 && reversDiamondCount == 1){
            placeholder = "***";
            String substring = text.substring(0, text.indexOf(diamond));
            String closeString = text.substring(diamondIndex , reverseDiamondIndex + 1);
            closeString = closeString.replace(closeString , placeholder);
            text = substring + closeString + text.substring(text.lastIndexOf(reversDiamond) + 1);
            System.out.println(text);
        } else if (diamondCount > 1 && reversDiamondCount > 1){
            placeholder = "***";
            String substring = text.substring(0, text.indexOf(diamond));
            int lastDiamondIndex = text.lastIndexOf(diamond);
            int lastReversDiamondIndex = text.lastIndexOf(reversDiamond);
            String closeStringOne = text.substring(diamondIndex , reverseDiamondIndex + 1);
            closeStringOne = closeStringOne.replace(closeStringOne , placeholder);
            String closeStringTwo = text.substring(lastDiamondIndex , lastReversDiamondIndex + 1);
            closeStringTwo = closeStringTwo.replace(closeStringTwo , placeholder);
            text = substring + closeStringOne + text.substring(reverseDiamondIndex + 1 , lastDiamondIndex) +
                    closeStringTwo +  text.substring(lastReversDiamondIndex + 1);
            System.out.println(text);
        }
             // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        return text;
    }

}