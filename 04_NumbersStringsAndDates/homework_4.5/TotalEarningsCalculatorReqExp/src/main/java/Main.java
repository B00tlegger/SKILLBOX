public class Main {

  public static void main(String[] args) {
   String text = "Текст = Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    calculateSalarySum(text);

  }

  public static int calculateSalarySum(String text){
      //TODO: реализуйте метод
      int totalMoney = 0;
      String[] split = text.split(",");
      for (int i = 0 ; i < split.length ; i++){
          String money = split[i].replaceAll("[^0-9]" , "");
          if (!money.equals("")) {
              int salary = Integer.parseInt(money);
              totalMoney = totalMoney + salary;
          }
      }
      if (totalMoney == 0){
          System.out.println("Никто ничего не заработал");
      }else {
          System.out.println(totalMoney);
      }
    return totalMoney;
  }

}