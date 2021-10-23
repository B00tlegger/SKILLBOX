public class Main {

  public static void main(String[] args) {
    String text = "They were ready to land in Australia, at the end of a 14-hour international flight, when the 270 passengers"
            + "of an Air Canada flight were suddenly thrown into a high-seas search-and-rescue operation."
            + "Flight AC033 diverted after pilot Andrew Robertson got a call from the Australian Maritime Safety Authority"
            + "on Tuesday to help search for a yachtsman who had sailed from Sydney two weeks earlier."
            + "If we have the fuel, could we investigate an emergency beacon that had just gone off, came the question"
            + "from maritime officials, Robertson told CNN Canadian affiliate CBC News."
            + "Down below, Glenn Ey of Queensland, Australia, was being tossed about in his crippled 36-foot yacht -- out"
            + "of fuel and with a broken mast after a storm."
            + "I thought I had a very good chance of getting back to Sydney without assistance, Ey said after nine days adrift."
            + "I couldn't see any evidence of Sydney, and I had no idea of my exact position, and it was at that point I set off"
            + "the emergency position indicator radio beacon.";
    splitTextInToWords(text);
  }


  public static String splitTextInToWords(String text) {
    //TODO реализуйте метод

    StringBuilder word = new StringBuilder();

    String[] split = text.replaceAll("[^a-zA-z\\’\\']" , " ").split(" +");

    for (String s : split) {
      word.append(s).append(System.lineSeparator());
    }

    String formatText = word.toString().trim();
    System.out.println(formatText);

    return formatText;
  }

}