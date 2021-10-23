public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    int spaceIndex = text.indexOf(" " , text.indexOf(" ") + 1);
    int rIndex = text.indexOf("р", text.indexOf("р") + 1);
    int lastRIndex = text.lastIndexOf("р");
    int halfRIndex = text.lastIndexOf("р", lastRIndex -1);
    int hyphenIndex = text.indexOf("-");
    int lastHyphenIndex = text.lastIndexOf("-");

    String fiveThousandText = text.substring(spaceIndex , rIndex);
    String sevenFiveSixThreeText = text.substring(hyphenIndex + 1 , halfRIndex);
    String thirtyThousandText = text.substring(lastHyphenIndex + 1 , lastRIndex);

    int fiveThousand = Integer.parseInt(fiveThousandText.trim());
    int sevenFiveSixThree = Integer.parseInt(sevenFiveSixThreeText.trim());
    int thirtyThousand = Integer.parseInt(thirtyThousandText.trim());

    System.out.println(fiveThousand + sevenFiveSixThree + thirtyThousand);


  }

}